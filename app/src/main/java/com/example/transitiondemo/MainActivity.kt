package com.example.transitiondemo

import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.transition.Fade
import android.transition.Slide
import android.transition.TransitionInflater
import android.view.Window
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        window.requestFeature(Window.FEATURE_CONTENT_TRANSITIONS)
        window.requestFeature(Window.FEATURE_ACTIVITY_TRANSITIONS)
        setContentView(R.layout.activity_main)

        setupTextLabel()
        // setupExitTransitionViaResource()
        setupExitTransitionProgrammatically()
    }

    private fun setupTextLabel() {
        tvDemo.setOnClickListener {

            Intent(this, DetailActivity::class.java).also {
                val bundle = ActivityOptions.makeSceneTransitionAnimation(this).toBundle()
                startActivity(it, bundle)
            }
        }
    }

    private fun setupExitTransitionViaResource() {
        val slide = TransitionInflater.from(this)
            .inflateTransition(R.transition.slide)
        window.exitTransition = slide

        val fade = TransitionInflater.from(this)
            .inflateTransition(R.transition.fade)
        window.reenterTransition = fade
    }

    private fun setupExitTransitionProgrammatically() {
        val slide = Slide()
        slide.duration = 500
        window.exitTransition = slide

        val fade = Fade()
        fade.duration = 500
        window.reenterTransition = fade
    }
}
