package com.hqq.viewexample.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * http://www.bijishequ.com/detail/240361?p=
 * @Author : huangqiqiang
 * @Package : com.hqq.viewexample.view
 * @FileName :   DegreeSeekBar
 * @Date : 2018/1/24  16:40
 * @Descrive : TODO
 * @Email :
 */

public class DegreeSeekBar extends View {
    public DegreeSeekBar(Context context) {
        super(context);
    }

    public DegreeSeekBar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private final Rect mCanvasClipBounds = new Rect();
    private int mPointCount = 180;
    private float mPointMargin;
    private Paint mPointPaint;
    private int mPointColor = Color.WHITE;
    private int mTextColor = Color.WHITE;
    private Paint mTextPaint;

    int mMin = -180;
    int mMax = 180;

    private void init() {
        mPointPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPointPaint.setStyle(Paint.Style.STROKE);
        mPointPaint.setColor(mPointColor);
        mPointPaint.setStrokeWidth(2);

        mTextPaint = new Paint();
        mTextPaint.setColor(mTextColor);
        mTextPaint.setStyle(Paint.Style.STROKE);
        mTextPaint.setAntiAlias(true);
        mTextPaint.setTextSize(24f);
        mTextPaint.setTextAlign(Paint.Align.LEFT);
        mTextPaint.setAlpha(100);
    }


    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mPointMargin = (float) w / mPointCount;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        drawPoint(canvas);
        drawDegreeText(-45, canvas, true);
        drawDegreeText(-30, canvas, true);
        drawDegreeText(-15, canvas, true);
        drawDegreeText(0, canvas, true);
        drawDegreeText(15, canvas, true);
        drawDegreeText(30, canvas, true);
        drawDegreeText(45, canvas, true);


    }

    private void drawPoint(Canvas canvas) {
        for (int i = 0; i < mPointCount; i++) {
            canvas.getClipBounds(mCanvasClipBounds);
            canvas.drawPoint(
                    getWidth()/2- (i - mPointCount / 2) * mPointMargin, getHeight()/2, mPointPaint);
        }

    }

    private void drawDegreeText(int degrees, Canvas canvas, boolean b) {
//        canvas.drawText(degrees + "°",
//                getWidth() / 2 + mPointMargin * degrees / 2 - mTextWidths[0] / 2 * 3 - mCurrentDegrees / 2 * mPointMargin,
//                getHeight() / 2 - 10,
//                mTextPaint);
        canvas.drawText(degrees + "°", getWidth() / 2 + mPointMargin * degrees / 2, getHeight() / 2 - 10, mTextPaint);
    }
}
