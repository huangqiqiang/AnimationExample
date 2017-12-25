package com.hqq.viewexample.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.TranslateAnimation
import android.widget.Toast
import com.hqq.viewexample.R
import kotlinx.android.synthetic.main.activity_value_animator.*

/**
 *http://blog.csdn.net/harvic880925/article/details/50525521
 */
class ValueAnimatorActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_value_animator)

        /**
         * 补间动画虽能对控件做动画，但并没有改变控件内部的属性值
         */
        btn_TranslateAnimation.setOnClickListener {
            var translateAnimation =TranslateAnimation(Animation.ABSOLUTE,0f,Animation.ABSOLUTE,400f,Animation.ABSOLUTE,0f,Animation.ABSOLUTE,400f);
            translateAnimation.fillAfter=true
            translateAnimation.duration=1000
            btn_TranslateAnimation.startAnimation(translateAnimation)
        }



        btn_ValueAnimator.setOnClickListener {
            doAnimation()
        }

    }

    private fun doAnimation() {


    }
}
