package com.hqq.viewexample.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.hqq.viewexample.R
import kotlinx.android.synthetic.main.activity_wave.*

/**
 * 贝塞尔 波浪
 */
class WaveActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wave)
        wv_waveView.startAnim()
    }
}
