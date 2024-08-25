package com.io1.motionlayout

import android.animation.ObjectAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.constraintlayout.motion.widget.MotionLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val motionLayout = findViewById<MotionLayout>(R.id.motionLayout)
        var isfinished = false

        motionLayout.setTransitionListener(object : MotionLayout.TransitionListener{
            override fun onTransitionStarted(
                motionLayout: MotionLayout?,
                startId: Int,
                endId: Int
            ) {
                val textview = findViewById<TextView>(R.id.textView3)
                val progressbar = findViewById<ProgressBar>(R.id.progressBar)

                if(endId == R.id.end){
                    textview.setText("sağ")
                    ObjectAnimator.ofInt(progressbar,"progress",40)
                        .setDuration(2000)
                        .start()

                }
                if(endId == R.id.endL){
                    textview.setText("sol")
                    ObjectAnimator.ofInt(progressbar,"progress",20)
                        .setDuration(2000)
                        .start()
                }

            }

            override fun onTransitionChange(
                motionLayout: MotionLayout?,
                startId: Int,
                endId: Int,
                progress: Float
            ) {
            }

            override fun onTransitionCompleted(motionLayout: MotionLayout?, currentId: Int) {
                isfinished = true

            }

            override fun onTransitionTrigger(
                motionLayout: MotionLayout?,
                triggerId: Int,
                positive: Boolean,
                progress: Float
            ) {

            }

        })
    }
}