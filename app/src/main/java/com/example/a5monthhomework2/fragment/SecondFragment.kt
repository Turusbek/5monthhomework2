package com.example.a5monthhomework2.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavArgs
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.example.a5monthhomework2.R
import com.example.a5monthhomework2.app.App
import com.example.a5monthhomework2.databinding.FragmentMainragmentBinding
import com.example.a5monthhomework2.databinding.FragmentSecondBinding
import com.example.a5monthhomework2.model.CalculateModel
import retrofit2.Call
import retrofit2.Response


class SecondFragment : Fragment() {
    private val args by navArgs <SecondFragmentArgs>()
    private val firstName by lazy { args.etYou }
    private val secondName by lazy { args.etMe }
    private lateinit var binding : FragmentSecondBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSecondBinding.inflate(inflater)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            tvYou.text = firstName
            tvMe.text = secondName
        }
     App.api.getPercentage(firstName, secondName)
         .enqueue(
             object : retrofit2.Callback<CalculateModel>{
                 override fun onResponse(
                     call: Call<CalculateModel>,
                     response: Response<CalculateModel>
                 ) {
                     binding.tvPercentage.text = response.body()?.percentage + "%"
                 }

                 override fun onFailure(call: Call<CalculateModel>, t: Throwable) {


                 }
             }
         )
        binding.btnTryAgain.setOnClickListener {
            view.findNavController().navigate(R.id.mainFragment)
        }
    }


}