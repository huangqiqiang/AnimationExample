package com.hqq.viewexample.activity.animate

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.hqq.viewexample.R
import kotlinx.android.synthetic.main.activity_property_values_holder.*
import android.view.animation.AccelerateInterpolator
import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.animation.TypeEvaluator
import android.animation.Keyframe
import android.R.attr.start
import android.animation.Animator






class PropertyValuesHolderActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_property_values_holder)
        btn_PropertyValuesHolder.setOnClickListener {
            val rotationHolder = PropertyValuesHolder.ofFloat("Rotation", 60f, -60f, 40f, -40f, -20f, 20f, 10f, -10f, 0f)
            val colorHolder = PropertyValuesHolder.ofInt("BackgroundColor", -0x1, -0xff01, -0x100, -0x1)
            val animator = ObjectAnimator.ofPropertyValuesHolder(btn_PropertyValuesHolder, rotationHolder, colorHolder)
            animator.duration = 3000
            animator.interpolator = AccelerateInterpolator()
            animator.start()
        }


        tv_CharEvaluator.setOnClickListener {
            val charHolder = PropertyValuesHolder.ofObject("CharText", CharEvaluator(), 'A', 'Z')
            val animator = ObjectAnimator.ofPropertyValuesHolder(tv_CharEvaluator, charHolder)
            animator.duration = 3000
            animator.interpolator = AccelerateInterpolator()
            animator.start()
        }

        iv_phone.setOnClickListener {

            /**
             * 左右震动效果
             */
            val frame0 = Keyframe.ofFloat(0f, 0f)
            val frame1 = Keyframe.ofFloat(0.1f, -20f)
            val frame2 = Keyframe.ofFloat(0.2f, 20f)
            val frame3 = Keyframe.ofFloat(0.3f, -20f)
            val frame4 = Keyframe.ofFloat(0.4f, 20f)
            val frame5 = Keyframe.ofFloat(0.5f, -20f)
            val frame6 = Keyframe.ofFloat(0.6f, 20f)
            val frame7 = Keyframe.ofFloat(0.7f, -20f)
            val frame8 = Keyframe.ofFloat(0.8f, 20f)
            val frame9 = Keyframe.ofFloat(0.9f, -20f)
            val frame10 = Keyframe.ofFloat(1f, 0f)
            val frameHolder1 = PropertyValuesHolder.ofKeyframe("rotation", frame0, frame1, frame2, frame3, frame4, frame5, frame6, frame7, frame8, frame9, frame10)


            /**
             * scaleX放大1.1倍
             */
            val scaleXframe0 = Keyframe.ofFloat(0f, 1f)
            val scaleXframe1 = Keyframe.ofFloat(0.1f, 1.1f)
            val scaleXframe2 = Keyframe.ofFloat(0.2f, 1.1f)
            val scaleXframe3 = Keyframe.ofFloat(0.3f, 1.1f)
            val scaleXframe4 = Keyframe.ofFloat(0.4f, 1.1f)
            val scaleXframe5 = Keyframe.ofFloat(0.5f, 1.1f)
            val scaleXframe6 = Keyframe.ofFloat(0.6f, 1.1f)
            val scaleXframe7 = Keyframe.ofFloat(0.7f, 1.1f)
            val scaleXframe8 = Keyframe.ofFloat(0.8f, 1.1f)
            val scaleXframe9 = Keyframe.ofFloat(0.9f, 1.1f)
            val scaleXframe10 = Keyframe.ofFloat(1f, 1f)
            val frameHolder2 = PropertyValuesHolder.ofKeyframe("ScaleX", scaleXframe0, scaleXframe1, scaleXframe2, scaleXframe3, scaleXframe4, scaleXframe5, scaleXframe6, scaleXframe7, scaleXframe8, scaleXframe9, scaleXframe10)


            /**
             * scaleY放大1.1倍
             */
            val scaleYframe0 = Keyframe.ofFloat(0f, 1f)
            val scaleYframe1 = Keyframe.ofFloat(0.1f, 1.1f)
            val scaleYframe2 = Keyframe.ofFloat(0.2f, 1.1f)
            val scaleYframe3 = Keyframe.ofFloat(0.3f, 1.1f)
            val scaleYframe4 = Keyframe.ofFloat(0.4f, 1.1f)
            val scaleYframe5 = Keyframe.ofFloat(0.5f, 1.1f)
            val scaleYframe6 = Keyframe.ofFloat(0.6f, 1.1f)
            val scaleYframe7 = Keyframe.ofFloat(0.7f, 1.1f)
            val scaleYframe8 = Keyframe.ofFloat(0.8f, 1.1f)
            val scaleYframe9 = Keyframe.ofFloat(0.9f, 1.1f)
            val scaleYframe10 = Keyframe.ofFloat(1f, 1f)
            val frameHolder3 = PropertyValuesHolder.ofKeyframe("ScaleY", scaleYframe0, scaleYframe1, scaleYframe2, scaleYframe3, scaleYframe4, scaleYframe5, scaleYframe6, scaleYframe7, scaleYframe8, scaleYframe9, scaleYframe10)

            /**
             * 构建动画
             */
            val animator = ObjectAnimator.ofPropertyValuesHolder(iv_phone, frameHolder1, frameHolder2, frameHolder3)
            animator.duration = 1000
            animator.start()
        }

    }


    inner class CharEvaluator : TypeEvaluator<Char> {
        override fun evaluate(fraction: Float, startValue: Char?, endValue: Char?): Char? {
            val startInt = startValue!!.toInt()
            val endInt = endValue !!.toInt()
            val curInt = (startInt + fraction * (endInt - startInt)).toInt()
            return curInt.toChar()
        }
    }
}
