package com.example.a5monthhomework2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.a5monthhomework2.databinding.BoardItemBinding

class OnBoardAdapter(private val listener: StartListener) :
    RecyclerView.Adapter<OnBoardAdapter.OnBoardViewHolder>() {
    val textView1 = listOf("Have a good time", "Cherishing love", "Have a breakup")
    val textView2 = listOf(
        "You should take the time to help those \n who need you",
        "It is now no longer possible for \n you to cherish love",
        "We have made the correction for you \n don't worry \n Maybe someone is waiting for you!"
    )
    val imgList = listOf(
        R.drawable.img,
        R.drawable.image2,
        R.drawable.image3
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnBoardViewHolder {
        val binding =
            BoardItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return OnBoardViewHolder(binding)
    }

    override fun onBindViewHolder(holder: OnBoardViewHolder, position: Int) {
        holder.onBind(position)
        holder.binding.btnNext.setOnClickListener {
            listener.start()
        }

    }

    override fun getItemCount(): Int {
        return imgList.size
    }

    inner class OnBoardViewHolder(val binding: BoardItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(position: Int) {
            binding.imageView.setBackgroundResource(imgList[position])
            binding.textView1.text = textView1[position]
            binding.textView2.text = textView2[position]
            if (position == 2) {
                binding.btnNext.visibility = View.VISIBLE
            } else {
                binding.btnNext.visibility = View.GONE
            }
        }
    }

    interface StartListener {
        fun start()
    }

}