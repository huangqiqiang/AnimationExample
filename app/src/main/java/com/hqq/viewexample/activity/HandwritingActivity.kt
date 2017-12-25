package com.hqq.viewexample.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.hqq.viewexample.R
import kotlinx.android.synthetic.main.activity_handwriting.*

/**
 * @Author : huangqiqiang
 * @Package :
 * @FileName :   HandwritingActivity.kt
 * @Date  : 17/12/26  上午4:37
 * @Descrive : TODO
 * @Email :
 * @version V1.0 <描述当前版本功能>
 */
class HandwritingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_handwriting)
        btn_reset.setOnClickListener {
            hv_handwriting.reset()
        }
    }


}
