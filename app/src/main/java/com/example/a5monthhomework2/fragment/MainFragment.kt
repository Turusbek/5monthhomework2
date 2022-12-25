package com.example.a5monthhomework2.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.a5monthhomework2.databinding.FragmentMainragmentBinding
import com.example.a5monthhomework2.model.MainFragmentViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment() {
    private val viewModel: MainFragmentViewModel by viewModels()
    private lateinit var binding: FragmentMainragmentBinding
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
            getRequest()
        }
    }

    private fun getRequest() {
        viewModel.getRequest(binding.etYou.text.toString(), binding.etMe.text.toString())
            .observe(viewLifecycleOwner) {
                findNavController().navigate(
                    MainFragmentDirections
                        .actionMainFragmentToSecondFragment(
                            binding.etYou.text.toString(),
                            it.percentage, binding.etMe.text.toString()
                        )
                )
            }
    }
}




