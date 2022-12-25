package com.example.a5monthhomework2.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.a5monthhomework2.OnBoardAdapter
import com.example.a5monthhomework2.R
import com.example.a5monthhomework2.databinding.FragmentOnBoardBinding
import com.example.a5monthhomework2.model.MainFragmentViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OnBoardFragment : Fragment(), OnBoardAdapter.StartListener {
    private lateinit var adapter: OnBoardAdapter
    private lateinit var binding: FragmentOnBoardBinding
    private val model: MainFragmentViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentOnBoardBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = OnBoardAdapter(this)
        binding.onBoardPager.adapter = adapter
    }

    override fun start() {
         model.saveBoardState()
         findNavController().navigate(R.id.startFragment)

    }
}