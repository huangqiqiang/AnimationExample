package com.hqq.viewexample.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * @Author : huangqiqiang
 * @Package : com.hqq.viewexample.view
 * @FileName :   BaseView
 * @Date : 2018/1/15  13:45
 * @Descrive : TODO
 * @Email :
 */

public class BaseView extends View {
    public BaseView(Context context) {
        super(context);
    }

    public BaseView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public BaseView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint paint=new Paint();
        paint.setColor(Color.RED);  //设置画笔颜色
        paint.setStyle(Paint.Style.STROKE);//填充样式改为描边
        paint.setStrokeWidth(5);//设置画笔宽度
//
//        Path path = new Path();
//
//        path.moveTo(10, 10); //设定起始点
//        path.lineTo(10, 100);//第一条直线的终点，也是第二条直线的起点
//        path.lineTo(300, 100);//画第二条直线
//        path.lineTo(500, 100);//第三条直线
//        path.close();
//        canvas.drawPath(path, paint);

        //先创建两个大小一样的路径
//第一个逆向生成
//        Path CCWRectpath = new Path();
//        RectF rect1 =  new RectF(50, 50, 240, 200);
//        CCWRectpath.addRect(rect1, Path.Direction.CCW);
//
////第二个顺向生成
//        Path CWRectpath = new Path();
//        RectF rect2 =  new RectF(290, 50, 480, 200);
//        CWRectpath.addRect(rect2, Path.Direction.CW);
//
////先画出这两个路径
//        canvas.drawPath(CCWRectpath, paint);
//        canvas.drawPath(CWRectpath, paint);
//
//        //依据路径写出文字
//        String text="风萧萧兮易水寒，壮士一去兮不复返";
//        paint.setColor(Color.GRAY);
//        paint.setTextSize(35);
//        canvas.drawTextOnPath(text, CCWRectpath, 0, 18, paint);//逆时针生成
//        canvas.drawTextOnPath(text, CWRectpath, 0, 18, paint);//顺时针生成


//        Path path = new Path();
//        RectF rect1 =  new RectF(50, 50, 240, 200);
//        path.addRoundRect(rect1, 10, 15 , Path.Direction.CCW);
//
//        RectF rect2 =  new RectF(290, 50, 480, 200);
//        float radii[] ={10,15,20,25,30,35,40,45};
//        path.addRoundRect(rect2, radii, Path.Direction.CCW);
//
//        canvas.drawPath(path, paint);


//        Path path = new Path();
//        path.addCircle(200, 200, 100, Path.Direction.CCW);
//        canvas.drawPath(path, paint);


//        Path path = new Path();
//        RectF rect =  new RectF(50, 50, 240, 200);
//        path.addOval(rect, Path.Direction.CCW);
//        canvas.drawPath(path, paint);


        Path path = new Path();
        RectF rect =  new RectF(50, 50, 240, 200);
        path.addArc(rect, 0, 100);

        canvas.drawPath(path, paint);//画出路径

    }
}
