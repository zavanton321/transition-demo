package com.example.transitiondemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.TransitionInflater

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        setupTransitionViaResource()
    }

    private fun setupTransitionViaResource() {
        val transition = TransitionInflater.from(this)
            .inflateTransition(R.transition.activity_fade)
        window.enterTransition = transition
    }
}
