package com.hqq.viewexample.activity.view

import android.animation.ValueAnimator
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.LinearInterpolator
import com.hqq.viewexample.R
import kotlinx.android.synthetic.main.activity_circle_progress.*

/**
 *
 * https://www.jianshu.com/p/be71f6ffe512
 */
class CircleProgressActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_circle_progress)


        val animator = ValueAnimator.ofFloat(0f, 100f)
        animator.duration = 4000
        animator.setInterpolator(LinearInterpolator())
        animator.addUpdateListener {
            var current = animator.getAnimatedValue() as Float
            cpv_CircleProgressView.setmCurrent(current.toInt())
        }
        animator.start()

        mdv_MyDashView.startAnim()
    }
}
