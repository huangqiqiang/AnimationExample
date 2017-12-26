package com.hqq.viewexample.view;

import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.BounceInterpolator;

import com.hqq.viewexample.Utils.LogUtils;
import com.hqq.viewexample.bean.Point;

/**
 * @Author : huangqiqiang
 * @Package : com.hqq.viewexample.view
 * @FileName :   PointView
 * @Date : 2017/12/26  11:38
 * @Descrive : TODO
 * @Email :
 */

public class PointView extends View {
    public PointView(Context context) {
        super(context);
    }

    public PointView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public PointView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

    }

    private Point mCurPoint=new Point(10);
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (mCurPoint != null) {
            Paint paint = new Paint();
            paint.setColor(Color.RED);
            paint.setAntiAlias(true);
            paint.setStyle(Paint.Style.FILL);
            canvas.drawCircle(300, 300, mCurPoint.getRadius(), paint);

        }
    }
    public void doPointAnim() {
        ValueAnimator valueAnimator = ValueAnimator.ofObject(new PointEvaluator(), new Point(10), new Point(200));
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                mCurPoint = (Point) animation.getAnimatedValue();
                LogUtils.e("doPointAnim"+ mCurPoint.getRadius());
                invalidate();
            }
        });
        valueAnimator.setDuration(1000);
        valueAnimator.setInterpolator(new BounceInterpolator());
        valueAnimator.start();

    }

    void setPointRadius(int radius){
        mCurPoint.setRadius(radius);
        invalidate();
    }


    public class PointEvaluator implements TypeEvaluator<Point> {
        @Override
        public Point evaluate(float fraction, Point startValue, Point endValue) {
            int curValue = (int) (startValue.getRadius() + fraction * (endValue.getRadius() - startValue.getRadius()));
            return new Point(curValue);
        }
    }
}
