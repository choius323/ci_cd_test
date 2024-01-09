package com.tenqube.ci_cd_test

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test

class MainViewModelTest {
    private lateinit var viewModel: MainViewModel

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Test
    fun `ViewModel 초기화 후 숫자 1 증가`() {
        viewModel = MainViewModel()

        val observer = Observer<Int> {}
        try {
            viewModel.num.observeForever(observer)

            viewModel.resetNum()
            viewModel.plusNum()

            val value = viewModel.num.value
            assertEquals(value, 1)
        } finally {
            viewModel.num.removeObserver(observer)
        }
    }
}