package com.hqq.viewexample.activity

import android.animation.ValueAnimator
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.animation.Animation
import android.view.animation.TranslateAnimation
import android.widget.Toast
import com.hqq.viewexample.R
import com.hqq.viewexample.Utils.LogUtils
import kotlinx.android.synthetic.main.activity_value_animator.*

/**
 * @Author : huangqiqiang
 * @Package :
 * @FileName :   ValueAnimatorActivity.kt
 * @Date  : 17/12/26  上午4:40
 * @Descrive : TODO
 * @Email :
 * @version V1.0 <描述当前版本功能>
 *     参考
 *     http://blog.csdn.net/harvic880925/article/details/50525521
 */
class ValueAnimatorActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_value_animator)

        /**
         * 补间动画虽能对控件做动画，但并没有改变控件内部的属性值
         */
        btn_TranslateAnimation.setOnClickListener {
            var translateAnimation = TranslateAnimation(Animation.ABSOLUTE, 0f, Animation.ABSOLUTE, 400f, Animation.ABSOLUTE, 0f, Animation.ABSOLUTE, 400f);
            translateAnimation.fillAfter = true
            translateAnimation.duration = 1000
            btn_TranslateAnimation.startAnimation(translateAnimation)
        }



        btn_ValueAnimator.setOnClickListener {
            doAnimation()
            Toast.makeText(this, "Click me", Toast.LENGTH_SHORT).show()
        }

    }

    private fun doAnimation() {
        var animation = ValueAnimator.ofInt(0, 400)
        animation.duration = 1400
        animation.addUpdateListener {

            var curValue = animation.getAnimatedValue();
            LogUtils.e(curValue)
            btn_ValueAnimator.layout(curValue as Int, curValue as Int,
                    curValue + btn_ValueAnimator.width,curValue + btn_ValueAnimator.height)
        }
        animation.start()

    }
}
