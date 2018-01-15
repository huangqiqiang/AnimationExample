package com.hqq.viewexample.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * @Author : huangqiqiang
 * @Package : com.hqq.viewexample.view
 * @FileName :   BaseTextView
 * @Date : 2018/1/15  14:41
 * @Descrive : TODO
 * @Email :
 */

public class BaseTextView extends View  {


    public BaseTextView(Context context) {
        super(context);
    }

    public BaseTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public BaseTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int baseLineY = 200;
        int baseLineX = 0 ;

        //画基线
        Paint paint = new Paint();
        paint.setColor(Color.RED);

        canvas.drawLine(baseLineX, baseLineY, 3000, baseLineY, paint);

        //写文字
        paint.setColor(Color.GREEN);
        paint.setTextSize(120); //以px为单位
        paint.setTextAlign(Paint.Align.CENTER);
        canvas.drawText("harvic\'s blog", baseLineX, baseLineY, paint);

    }
}
