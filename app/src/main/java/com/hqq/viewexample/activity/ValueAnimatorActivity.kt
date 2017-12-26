package com.hqq.viewexample.activity

import android.animation.ObjectAnimator
import android.animation.TimeInterpolator
import android.animation.TypeEvaluator
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
        //  属性 动画
        btn_ValueAnimator.setOnClickListener {
            doAnimationOfInt()
            Toast.makeText(this, "Click me", Toast.LENGTH_SHORT).show()
        }

        btn_ofChar.setOnClickListener {
            var animation =ValueAnimator.ofObject(CharEvaluator (),'A','Z')
            animation.addUpdateListener {
                btn_ofChar.setText(animation.getAnimatedValue().toString())
            }
            animation.setDuration(3400)
            animation.start()


    }


        pv_point.setOnClickListener{

            pv_point.doPointAnim()

        }


    }

    class CharEvaluator : TypeEvaluator<Char> {
        override fun evaluate(fraction: Float, startValue: Char?, endValue: Char?): Char {
          var valeue : Char = 'A';
            if (startValue != null) {
                if (endValue != null) {
                    valeue=    (startValue.toInt() + fraction * (endValue.toInt() - startValue .toInt() )).toChar()
                }
            }

            return valeue;
        }

    }

    private fun doAnimationOfInt() {
        //  动画  getAnimatedValue 的区间
        var animation = ValueAnimator.ofInt(0, 400)
        animation.duration = 1400
        animation.addUpdateListener {
            var curValue = animation.getAnimatedValue();
            LogUtils.e(curValue)
            btn_ValueAnimator.layout(btn_ValueAnimator.left, curValue as Int,
                    btn_ValueAnimator.right, curValue + btn_ValueAnimator.height)
        }
        animation.repeatMode = ValueAnimator.REVERSE
        animation.repeatCount = ValueAnimator.INFINITE

        /**
         * 理解为 从adapter 中获取 数据
         * ofInt   相当于  是map
         * LinearInterpolator  类似 于key
         * MyIntEvaluator  类似 于 valeu
         * getAnimatedValue  根据 这些 去获取   执行  属性 动画
         */

        animation.interpolator = LinearInterpolator();
        animation.setEvaluator(MyIntEvaluator())
        animation.start()

    }

    class LinearInterpolator : TimeInterpolator {
        override fun getInterpolation(input: Float): Float {
            /**
             * 参数input:input参数是一个float类型，它取值范围是0到1，表示当前动画的进度，取0时表示动画刚开始，取1时表示动画结束，取0.5时表示动画中间的位置，其它类推。
            返回值：表示当前实际想要显示的进度。取值可以超过1也可以小于0，超过1表示已经超过目标值，小于0表示小于开始位置。
             */
            LogUtils.e("getInterpolation" + input)
            return 1 - input

        }
    }

    class MyIntEvaluator : TypeEvaluator<Int> {
        override fun evaluate(fraction: Float, startValue: Int?, endValue: Int?): Int? {
            val startInt = startValue!!
            LogUtils.e("MyIntEvaluator" + (startInt + fraction * (endValue!! - startInt)).toInt())
            return (startInt + fraction * (endValue!! - startInt)).toInt()
        }
    }
}
