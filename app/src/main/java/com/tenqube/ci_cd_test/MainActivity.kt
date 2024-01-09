package com.tenqube.ci_cd_test

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.tenqube.ci_cd_test.databinding.ActivityMainBinding

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