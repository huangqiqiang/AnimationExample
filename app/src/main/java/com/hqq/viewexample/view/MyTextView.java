package com.hqq.viewexample.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * @Author : huangqiqiang
 * @Package : com.hqq.viewexample.view
 * @FileName :   MyTextView
 * @Date : 2017/12/26  14:31
 * @Descrive : TODO
 * @Email :
 */

@SuppressLint("AppCompatCustomView")
public class MyTextView extends TextView {
    public MyTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    public void setCharText(Character character){
        setText(String.valueOf(character));
    }
}
