package com.hqq.viewexample

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.hqq.viewexample.activity.HandwritingActivity
import com.hqq.viewexample.activity.WaveActivity
import com.hqq.viewexample.activity.animate.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    fun startActivity(cls: Class<*>) {
        startActivity(Intent(this, cls))
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_handWriting.setOnClickListener {
            startActivity(HandwritingActivity::class.java)
        }
        btn_wave.setOnClickListener {
            startActivity(WaveActivity::class.java)
        }
        btn_AnimatorSet.setOnClickListener {
            startActivity(AnimatorSetActivity::class.java)
        }
        btn_Interpolator.setOnClickListener {
            startActivity(InterpolatorActivity::class.java)
        }
        btn_ObjectAnimator.setOnClickListener {
            startActivity(ObjectAnimatorActivity::class.java)
        }
        btn_PropertyValuesHolder.setOnClickListener {
            startActivity(PropertyValuesHolderActivity::class.java)
        }
        btn_ValueAnimator.setOnClickListener {
            startActivity(ValueAnimatorActivity::class.java)
        }
        btn_XmlAttributes.setOnClickListener {
            startActivity(XmlAttributesActivity::class.java)
        }
    }


}
