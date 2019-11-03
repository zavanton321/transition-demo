package com.example.transitiondemo

import android.os.Bundle
import android.transition.Fade
import android.transition.Slide
import android.transition.TransitionInflater
import android.view.Window
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        window.requestFeature(Window.FEATURE_CONTENT_TRANSITIONS)
        window.requestFeature(Window.FEATURE_ACTIVITY_TRANSITIONS)
        setContentView(R.layout.activity_detail)

        // setupTransitionViaResource()
        setupTransitionProgrammatically()
    }

    private fun setupTransitionViaResource() {
        val transition = TransitionInflater.from(this)
            .inflateTransition(R.transition.fade)
        window.enterTransition = transition
    }

    private fun setupTransitionProgrammatically() {
        val fade = Fade()
        fade.duration = 500
        window.enterTransition = fade

        val slide = Slide()
        slide.duration = 500
        window.returnTransition = slide
    }
}
