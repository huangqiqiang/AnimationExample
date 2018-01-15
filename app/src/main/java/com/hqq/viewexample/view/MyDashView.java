package com.hqq.viewexample.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;

/**
 * @Author : huangqiqiang
 * @Package : com.hqq.viewexample.view
 * @FileName :   MyDashView
 * @Date : 2018/1/15  15:29
 * @Descrive : TODO
 * @Email :
 */

public class MyDashView extends View {
    public MyDashView(Context context) {
        super(context);
    }

    public MyDashView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyDashView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    private int dashDx=0;
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint paint = getPaint();
        Path path =new Path();
        path.moveTo(100,600);
        path.lineTo(400,100);
        path.lineTo(700,900);

        paint.setColor(Color.RED);




        //使用DashPathEffect画线段
        paint.setPathEffect(new DashPathEffect(new float[]{10,20,50,100},0));
        canvas.drawPath(path,paint);

    }

    private Paint getPaint() {
        Paint paint = new Paint();
        paint.setStrokeWidth(4);
        paint.setColor(Color.GREEN);
        paint.setStyle(Paint.Style.STROKE);
        paint.setAntiAlias(true);

        return paint;
    }
    public void startAnim(){
        ValueAnimator valueAnimator = ValueAnimator.ofInt(0,500);
        valueAnimator.setInterpolator(new LinearInterpolator());
        valueAnimator.setDuration(1000);
        valueAnimator.setRepeatCount(ValueAnimator.INFINITE);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                dashDx = (int)animation.getAnimatedValue();
                postInvalidate();
            }
        });
        valueAnimator.start();
    }

}
