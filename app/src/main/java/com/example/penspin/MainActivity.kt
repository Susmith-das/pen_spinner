package com.example.penspin

import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.Animation.AnimationListener
import android.view.animation.RotateAnimation
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class MainActivity: AppCompatActivity()
{
    private var pen: ImageView? = null
    private val random = Random()
    private var lastAngle = 0
    private var spinning = false

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        pen = findViewById(R.id.pen)
    }

    fun spinPen(v: View?)
    {
        if (!spinning)
        {
            val newAngle = random.nextInt(1800)
            val x: Float = (pen!!.getWidth()/2).toFloat()
            val y: Float = (pen!!.getHeight()/2).toFloat()
            val rotate: Animation = RotateAnimation(lastAngle.toFloat(),newAngle.toFloat(),x,y)
            rotate.duration  = 2500
            rotate.fillAfter = true
            rotate.setAnimationListener(object:AnimationListener
            {
                override fun onAnimationStart(animation: Animation?)
                {
                    spinning = true
                }

                override fun onAnimationEnd(animation: Animation?)
                {
                    spinning = false
                }

                override fun onAnimationRepeat(animation: Animation?) {}
            } )
            lastAngle = newAngle
            pen?.startAnimation(rotate)
        }
    }
}