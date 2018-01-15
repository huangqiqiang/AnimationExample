package com.hqq.viewexample.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.hqq.viewexample.R;

/**
 * @Author : huangqiqiang
 * @Package : com.hqq.viewexample.view
 * @FileName :   CircleProgressView
 * @Date : 2018/1/15  10:15
 * @Descrive : TODO
 * @Email  :
 * https://www.jianshu.com/p/be71f6ffe512
 */

public class CircleProgressView extends View {
    private Paint mPaintOut;
    private Paint mPaintCurrent;
    private int mCurrent;//当前进度
    private Paint mPaintText;

    public CircleProgressView(Context context) {
        super(context);
    }

    public CircleProgressView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        //画笔->背景圆弧
        mPaintOut = new Paint();
        mPaintOut.setAntiAlias(true);
        mPaintOut.setStrokeWidth(10);
        mPaintOut.setStyle(Paint.Style.STROKE);
        mPaintOut.setColor(Color.GRAY);
        mPaintOut.setStrokeCap(Paint.Cap.ROUND);
        //画笔->进度圆弧
        mPaintCurrent = new Paint();
        mPaintCurrent.setAntiAlias(true);
        mPaintCurrent.setStrokeWidth(10);
        mPaintCurrent.setStyle(Paint.Style.STROKE);
        mPaintCurrent.setColor(Color.RED);
        mPaintCurrent.setStrokeCap(Paint.Cap.ROUND);

        //画笔->绘制字体
        mPaintText = new Paint();
        mPaintText.setAntiAlias(true);
        mPaintText.setStyle(Paint.Style.FILL);
        mPaintText.setColor(Color.BLACK);
        mPaintText.setTextSize(24);

    }

    public CircleProgressView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //绘制背景圆弧,因为画笔有一定的宽度，所有画圆弧的范围要比View本身的大小稍微小一些，不然画笔画出来的东西会显示不完整
        RectF rectF = new RectF(10, 10, getWidth() - 10, getHeight() - 10);
        canvas.drawArc(rectF, 0, 360, false, mPaintOut);


        //绘制当前进度
        float sweepAngle = 360 * mCurrent / 100;
        canvas.drawArc(rectF, -180, sweepAngle, false, mPaintCurrent);

        //绘制进度数字
        String text = mCurrent + "%";
        //获取文字宽度
        float textWidth = mPaintText.measureText(text, 0, text.length());
        float dx = getWidth() / 2 - textWidth / 2;
        Paint.FontMetricsInt fontMetricsInt = mPaintText.getFontMetricsInt();
        float dy = (fontMetricsInt.bottom - fontMetricsInt.top) / 2 - fontMetricsInt.bottom;
        float baseLine = getHeight() / 2 + dy;
        canvas.drawText(text, dx, baseLine, mPaintText);

    }

    /**
     * 设置当前进度并重新绘制界面
     *
     * @param mCurrent
     */
    public void setmCurrent(int mCurrent) {
        this.mCurrent = mCurrent;
        invalidate();
    }
}
