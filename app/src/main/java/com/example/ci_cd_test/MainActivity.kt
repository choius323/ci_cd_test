package com.example.ci_cd_test

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.ci_cd_test.databinding.ActivityMainBinding
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private val viewModel by viewModels<MainViewModel>()
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnPlusMain.setOnClickListener {
            viewModel.plusNum()
        }

        binding.btnResetMain.setOnClickListener {
            viewModel.resetNum()
        }

        val numObserver = Observer<Int> { newNum ->
            binding.tvNumberMain.text = newNum.toString()
        }
        viewModel.num.observe(this, numObserver)
    }
}