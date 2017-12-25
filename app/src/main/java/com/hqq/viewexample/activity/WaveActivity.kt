package com.hqq.viewexample.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.hqq.viewexample.R
import kotlinx.android.synthetic.main.activity_wave.*

class WaveActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wave)
        wv_waveView.startAnim()
    }
}
