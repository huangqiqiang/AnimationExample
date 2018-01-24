package com.hqq.viewexample.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;

import com.hqq.viewexample.Utils.LogUtils;

/**
 * https://www.jianshu.com/p/2f7bfe1d7345
 *
 * @Author : huangqiqiang
 * @Package : com.hqq.viewexample.activity.view
 * @FileName :   TempControlView
 * @Date : 2018/1/23  15:13
 * @Descrive : TODO
 * @Email :
 */

public class TempControlView extends View {
    public TempControlView(Context context) {
        super(context);
    }

    public TempControlView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }


    public TempControlView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    // 控件宽
    private int width;
    // 控件高
    private int height;
    // 刻度盘半径
    private int dialRadius;
    // 圆弧半径
    private int arcRadius;
    // 刻度盘画笔
    private Paint dialPaint;
    // 圆的画笔
    private Paint raoudPaint;
    // 最低温度
    private int minTemp = 15;
    // 最高温度
    private int maxTemp = 30;
    // 刻度高
    private int scaleHeight = dp2px(10);
    // 温度
    private int temperature;
    // 四格（每格4.5度，共18度）代表温度1度
    private int angleRate = 4;
    // 圆弧画笔
    private Paint arcPaint;
    // 标题画笔
    private Paint titlePaint;
    // 文本提示
    private String title = "最高温度设置";
    // 温度显示画笔
    private Paint tempPaint;
    // 温度标识画笔
    private Paint tempFlagPaint;
    // 每格的角度
    private float angleOne = (float) 270 / (maxTemp - minTemp) / angleRate;

    // 以下为旋转按钮相关

    // 当前按钮旋转的角度
    private float rotateAngle;
    // 当前的角度
    private float currentAngle;

    private void init() {
        dialPaint = new Paint();
        dialPaint.setAntiAlias(true);
        dialPaint.setStrokeWidth(dp2px(2));
        dialPaint.setStyle(Paint.Style.STROKE);


        arcPaint = new Paint();
        arcPaint.setAntiAlias(true);
        arcPaint.setColor(Color.parseColor("#3CB7EA"));
        arcPaint.setStrokeWidth(dp2px(2));
        arcPaint.setStyle(Paint.Style.STROKE);

        titlePaint = new Paint();
        titlePaint.setAntiAlias(true);
        titlePaint.setTextSize(sp2px(15));
        titlePaint.setColor(Color.parseColor("#3B434E"));
        titlePaint.setStyle(Paint.Style.STROKE);

        raoudPaint = new Paint();
        raoudPaint.setAntiAlias(true);
        raoudPaint.setTextSize(sp2px(15));
        raoudPaint.setColor(Color.parseColor("#3B434E"));
        raoudPaint.setStyle(Paint.Style.FILL);


        tempFlagPaint = new Paint();
        tempFlagPaint.setAntiAlias(true);
        tempFlagPaint.setTextSize(sp2px(25));
        tempFlagPaint.setColor(Color.parseColor("#E4A07E"));
        tempFlagPaint.setStyle(Paint.Style.STROKE);

        tempPaint = new Paint();
        tempPaint.setAntiAlias(true);
        tempPaint.setTextSize(sp2px(60));
        tempPaint.setColor(Color.parseColor("#E27A3F"));
        tempPaint.setTextAlign(Paint.Align.CENTER);
        tempPaint.setStyle(Paint.Style.STROKE);

    }


    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
// 控件宽、高
        width = height = Math.min(h, w);
// 刻度盘半径
        dialRadius = width / 2 - dp2px(20);
        // 圆弧半径
        arcRadius = dialRadius - dp2px(20);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        drawScale(canvas);
        drawArc(canvas);
        drawText(canvas);
        drawRound(canvas);
        drawButton(canvas);
        drawTemp(canvas);

    }

    private void drawTemp(Canvas canvas) {
        canvas.save();
        canvas.translate(getWidth() / 2, getHeight() / 2);
        float tempHeighe = (-tempPaint.ascent() - tempPaint.descent()) / 2;
        canvas.drawText(minTemp + "°", 0, tempHeighe, tempPaint);
        canvas.restore();

    }

    /**
     * 绘制三角形 按钮
     *
     * @param canvas
     */
    private void drawButton(Canvas canvas) {
        canvas.save();
        canvas.translate(getWidth() / 2, getHeight() / 2);
        LogUtils.e("angle   " + currentAngle);

        float rorate= -135;
        if (currentAngle != 0){
            rorate= currentAngle +90;
        }

        canvas.rotate( rorate);
        Path path = new Path();
        path.moveTo(getX() / 2, -arcRadius + dp2px(5));
        path.lineTo(getX() / 2 - arcRadius + dp2px(20) * 2, 0);
        path.lineTo(getX() / 2 + arcRadius - dp2px(20) * 2, 0);
        canvas.drawPath(path, raoudPaint);
        canvas.restore();
    }

    /**
     * 绘制圆形
     *
     * @param canvas
     */
    private void drawRound(Canvas canvas) {
        canvas.save();
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, arcRadius - dp2px(20), raoudPaint);
        canvas.restore();

    }

    /**
     * 绘制文字
     *
     * @param canvas
     */
    private void drawText(Canvas canvas) {
        canvas.save();
        // 绘制标题
        float titleWidth = titlePaint.measureText(title);
        canvas.drawText(title, (width - titleWidth) / 2, getHeight() / 2 + dialRadius - dp2px(10), titlePaint);
        // 绘制最小温度标识
        // 最小温度如果小于10，显示为0x
        String minTempFlag = minTemp < 10 ? "0" + minTemp : minTemp + "";
        float tempFlagWidth = titlePaint.measureText(maxTemp + "");
        canvas.translate(getWidth() / 2, getHeight() / 2);
        canvas.rotate(55, 0, 0);
        canvas.drawText(minTempFlag, 0, dialRadius + (scaleHeight * 2) + dp2px(10), tempFlagPaint);
        // 绘制最大温度标识
        canvas.rotate(-100, 0, 0);
        canvas.drawText(maxTemp + "", 0, dialRadius + (scaleHeight * 2) + dp2px(10), tempFlagPaint);
        canvas.restore();
    }

    /**
     * 绘制外圆
     *
     * @param canvas
     */
    private void drawArc(Canvas canvas) {
        canvas.save();
        canvas.translate(getWidth() / 2, getHeight() / 2);
        canvas.rotate(135 + 2);
        RectF rectF = new RectF(-arcRadius, -arcRadius, arcRadius, arcRadius);
        canvas.drawArc(rectF, 0, 265, false, arcPaint);
        canvas.restore();
    }

    /**
     * 绘制刻度
     *
     * @param canvas
     */
    private void drawScale(Canvas canvas) {
        canvas.save();
        canvas.translate(getWidth() / 2, getHeight() / 2);
        // 逆时针旋转135-2度
        canvas.rotate(-133);
        dialPaint.setColor(Color.parseColor("#3CB7EA"));
        for (int i = 0; i < 60; i++) {
            canvas.drawLine(0, -dialRadius, 0, -dialRadius + scaleHeight, dialPaint);
            canvas.rotate(4.5f);
        }
        canvas.rotate(90);


        dialPaint.setColor(Color.parseColor("#E37364"));
        for (int i = 0; i < (temperature - minTemp) * angleRate; i++) {
            canvas.drawLine(0, -dialRadius, 0, -dialRadius + scaleHeight, dialPaint);
            canvas.rotate(4.5f);
        }
        canvas.restore();
    }

    private boolean isDown;
    private boolean isMove;

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                isDown = true;
                float downX = event.getX();
                float downY = event.getY();

                break;

            case MotionEvent.ACTION_MOVE:
                isMove = true;
                float targetX;
                float targetY;
                downX = targetX = event.getX();
                downY = targetY = event.getY();
                float angle = calcAngle(targetX, targetY);

                // 滑过的角度增量
                float angleIncreased = angle - currentAngle;
                // 防止越界
                if (angleIncreased < -270) {
                    angleIncreased = angleIncreased + 360;
                } else if (angleIncreased > 270) {
                    angleIncreased = angleIncreased - 360;
                }
                LogUtils.e(" x = " + targetX + " y = " + targetY);
                IncreaseAngle(angleIncreased);
                currentAngle = angle;
                invalidate();
                break;
            case MotionEvent.ACTION_CANCEL:
            case MotionEvent.ACTION_UP:
                if (isDown && isMove) {
                    // 纠正指针位置
                    rotateAngle = (float) ((temperature - minTemp) * angleRate * 4.5);
                    invalidate();
                    isDown = false;
                    isMove = false;
                }
                break;
        }


        return true;
    }

    /**
     * 以按钮圆心为坐标圆点，建立坐标系，求出(targetX, targetY)坐标与x轴的夹角
     *
     * @param targetX x坐标
     * @param targetY y坐标
     * @return (targetX, targetY)坐标与x轴的夹角
     */
    private float calcAngle(float targetX, float targetY) {
        float x = targetX - getWidth() / 2;
        float y = targetY - getHeight() / 2;
        double radian;
        if (x != 0) {
            float tan = Math.abs(y / x);
            if (x > 0) {
                if (y >= 0) {
                    radian = Math.atan(tan);
                } else {
                    radian = 2 * Math.PI - Math.atan(tan);
                }
            } else {
                if (y >= 0) {
                    radian = Math.PI - Math.atan(tan);
                } else {
                    radian = Math.PI + Math.atan(tan);
                }
            }
        } else {
            if (y > 0) {
                radian = Math.PI / 2;
            } else {
                radian = -Math.PI / 2;
            }
        }
        return (float) ((radian * 180) / Math.PI);
    }


    /**
     * 增加旋转角度
     *
     * @param angle 增加的角度
     */
    private void IncreaseAngle(float angle) {
        rotateAngle += angle;
        if (rotateAngle < 0) {
            rotateAngle = 0;
        } else if (rotateAngle > 270) {
            rotateAngle = 270;
        }
        // 加上0.5是为了取整时四舍五入
        temperature = (int) ((rotateAngle / angleOne) / angleRate + 0.5) + minTemp;
    }

    public int dp2px(float dp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp,
                getResources().getDisplayMetrics());
    }

    private int sp2px(float sp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, sp,
                getResources().getDisplayMetrics());
    }
}
