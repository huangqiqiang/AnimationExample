package com.hqq.viewexample.activity.animate

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.hqq.viewexample.R
import android.animation.ObjectAnimator
import android.R.attr.start
import android.animation.Animator
import android.animation.AnimatorSet
import android.animation.ValueAnimator
import kotlinx.android.synthetic.main.activity_animator_set.*
import android.view.animation.BounceInterpolator
import android.view.animation.AccelerateDecelerateInterpolator
import android.R.animator
import android.animation.AnimatorInflater
import android.annotation.SuppressLint


class AnimatorSetActivity : AppCompatActivity() {

    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animator_set)
        button2.setOnClickListener {
            doPlaySequentiallyAnimator();
        }

        button4.setOnClickListener {

            val valueAnimator = AnimatorInflater.loadAnimator(AnimatorSetActivity@this, R.anim.set_2) as AnimatorSet

            valueAnimator.start()
        }
    }

    private fun doPlaySequentiallyAnimator() {

        val tv1BgAnimator = ObjectAnimator.ofInt(button2, "BackgroundColor", -0xff01, -0x100, -0xff01)
        val tv1TranslateY = ObjectAnimator.ofFloat(button2, "translationY", 0f, 300f, 0f)
        tv1TranslateY.interpolator = BounceInterpolator()
        // tv1TranslateY.setRepeatCount(ValueAnimator.INFINITE); // 无限循环

        val tv2TranslateY = ObjectAnimator.ofFloat(button3, "translationY", 0f, 400f, 0f)
        //  tv2TranslateY.setStartDelay(2000); // 延迟 启动
        tv2TranslateY.interpolator = AccelerateDecelerateInterpolator()

        val animatorSet = AnimatorSet()
        //playSequentially只有控件的上一个做完动画以后，才会激活控件的下一个动画，如果控件的上一动画是无限循环，那控件的下一个动画甚至下一个控件的动画就别再指望了。
        //animatorSet.playSequentially(tv1BgAnimator, tv1TranslateY, tv2TranslateY)
        //表示所有动画一起开始
        //       animatorSet.playTogether(tv1BgAnimator, tv1TranslateY, tv2TranslateY)


        val builder = animatorSet.play(tv1BgAnimator)
        builder.with(tv1TranslateY)
        builder.with(tv2TranslateY)

        //before  执行前面的动画后才执行该动画
//执行先执行这个动画再执行前面动画
//        public Builder after(Animator anim)
//延迟n毫秒之后执行动画
//        public Builder after(long delay)
        animatorSet.duration = 1000
        animatorSet.start()

    }
}
