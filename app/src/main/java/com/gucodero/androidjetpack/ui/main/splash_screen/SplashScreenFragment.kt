package com.gucodero.androidjetpack.ui.main.splash_screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import com.gucodero.androidjetpack.databinding.FragmentSplashScreenBinding
import com.gucodero.androidjetpack.ui.base.BaseFragment

class SplashScreenFragment: BaseFragment() {

    private lateinit var binding: FragmentSplashScreenBinding
    private val viewModel by viewModels<SplashScreenViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSplashScreenBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel
        binding.executePendingBindings()
        return binding.root
    }

    private fun initObservables(){
        viewModel.colorLiveData.observe(viewLifecycleOwner, {
            it?.let { color ->
                binding.button.setBackgroundColor(ContextCompat.getColor(requireContext(), color))
            }
        })
        viewModel.countLiveData.observe(viewLifecycleOwner, {
            binding.count.text = it?.toString()
        })
    }
}