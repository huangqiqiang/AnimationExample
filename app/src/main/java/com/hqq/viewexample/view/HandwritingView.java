package com.hqq.viewexample.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.hqq.viewexample.Utils.LogUtils;

/**
 * @Author : huangqiqiang
 * @Package : com.hqq.viewexample
 * @FileName :   QuadView
 * @Date : 2017/12/25  10:15
 * @Descrive : TODO
 * @Email :
 */

public class HandwritingView extends View {
    public HandwritingView(Context context) {
        super(context);
    }

    public HandwritingView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public HandwritingView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    Path mPath = new Path();
    Paint mPaint = new Paint();

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);


        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setColor(Color.BLACK);


//        Path path = new Path();
//        path.moveTo(100, 300);
//        path.quadTo(200, 200, 300, 300);
//        path.quadTo(500, 400, 500, 300);
//   canvas.drawPath(path, mPaint);
        canvas.drawPath(mPath, mPaint);


    }

    float mStartX, mStartY;

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                mPath.moveTo(event.getX(), event.getY());
                mStartX = event.getX();
                mStartY = event.getY();
                LogUtils.e("ACTION_DOWN  : " + event.getX() + "----" + event.getY());
                return true;
            case MotionEvent.ACTION_MOVE:
                float endX = (mStartX + event.getX()) / 2;
                float endY = (mStartY + event.getY()) / 2;

                mPath.quadTo(mStartX, mStartY, endX, endY);
                mStartY = event.getY();
                mStartX = event.getX();
                //mPath.lineTo(event.getX(), event.getY());
                postInvalidate();
                LogUtils.e("ACTION_MOVE  : " + event.getX() + "----" + event.getY());
                return true;

        }
        return super.onTouchEvent(event);
    }


    public void reset() {
        mPath.reset();
        postInvalidate();
    }
}
