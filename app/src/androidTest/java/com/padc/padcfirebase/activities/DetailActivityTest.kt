package com.padc.padcfirebase.activities

import android.content.Intent
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.rule.ActivityTestRule
import com.padc.padcfirebase.R
import com.padc.padcfirebase.viewholders.ArticleViewHolder
import org.junit.Before

import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class DetailActivityTest {

    var activityRule = ActivityTestRule<MainActivity>(MainActivity::class.java)

    @Before
    fun setUp() {
        activityRule.launchActivity(Intent())
    }

    @Test
    fun clap(){
        Thread.sleep(2000)

        onView(withId(R.id.recyclerArticles))
            .perform(
                RecyclerViewActions.actionOnItemAtPosition<ArticleViewHolder>(
                    0, click()
                )
            )

        Thread.sleep(3000)

        onView(withId(R.id.fab))
            .perform(ViewActions.click())


    }
}