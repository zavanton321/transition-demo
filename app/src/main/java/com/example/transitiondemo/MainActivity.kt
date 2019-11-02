package com.example.transitiondemo

import android.content.Intent
import android.os.Bundle
import android.transition.Fade
import android.transition.Slide
import android.transition.TransitionInflater
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupTextLabel()
        // setupExitTransitionViaResource()
        setupExitTransitionProgrammatically()
    }

    private fun setupTextLabel() {
        tvDemo.setOnClickListener {
            Intent(this, DetailActivity::class.java).apply {
                startActivity(this)
            }
        }
    }

    private fun setupExitTransitionViaResource() {
        val transition = TransitionInflater.from(this)
            .inflateTransition(R.transition.activity_slide)
        window.exitTransition = transition
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
