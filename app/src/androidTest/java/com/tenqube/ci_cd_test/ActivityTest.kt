package com.tenqube.ci_cd_test

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.*
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.*
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ActivityTest {
    private lateinit var viewModel: MainViewModel

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setUp() {
        viewModel = MainViewModel()
    }

    @Test
    fun `초기화_후_숫자_증가_버튼_클릭__0에서_1로_변경`() {
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)

        onView(withId(R.id.tv_number_main)).check(matches(withText("0")))
        onView(withId(R.id.btn_plus_main)).perform(click())

        onView(withId(R.id.tv_number_main)).check(matches(withText("1")))

        activityScenario.close()
    }
}