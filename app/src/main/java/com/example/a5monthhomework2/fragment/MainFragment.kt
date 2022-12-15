package com.example.a5monthhomework2.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.a5monthhomework2.R
import com.example.a5monthhomework2.databinding.FragmentMainragmentBinding

class MainFragment : Fragment() {
private lateinit var binding:FragmentMainragmentBinding
    private var _controller: NavController? = null
    protected val controller get() = _controller!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

         binding = FragmentMainragmentBinding.inflate(inflater)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnRequest.setOnClickListener {
            val directions = MainFragmentDirections.actionMainFragmentToSecondFragment(binding.etYou
                .text.toString(),binding.etMe.text.toString())
            view.findNavController().navigate(directions)
        }
             } }




