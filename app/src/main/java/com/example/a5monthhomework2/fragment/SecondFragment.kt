package com.example.a5monthhomework2.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.a5monthhomework2.databinding.FragmentSecondBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SecondFragment : Fragment() {
    private val args by navArgs<SecondFragmentArgs>()
    private val firstName by lazy { args.etYou }
    private val percentage by lazy { args.percentage }
    private val secondName by lazy { args.etMe }


    private lateinit var binding: FragmentSecondBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSecondBinding.inflate(inflater)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tvYou.text = firstName
        binding.tvPercentage.text = percentage
        binding.tvMe.text = secondName


        binding.btnTryAgain.setOnClickListener {
            findNavController().navigateUp()
        }
    }
}