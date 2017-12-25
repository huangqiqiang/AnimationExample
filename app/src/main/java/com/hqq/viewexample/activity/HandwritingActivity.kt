package com.hqq.viewexample.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

import com.hqq.viewexample.R
import kotlinx.android.synthetic.main.activity_handwriting.*
class HandwritingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_handwriting)
        btn_reset.setOnClickListener {
            hv_handwriting.reset()
        }
    }
}
