- 几何图形 -> 位于 Canvas 下 
    - 画直线  void drawLine (float startX, float startY, float stopX, float stopY, Paint paint)
        - startX:开始点X坐标
        - startY:开始点Y坐标
        - stopX:结束点X坐标
        - stopY:结束点Y坐标
         - 多条直线
     void drawLines (float[] pts, Paint paint)
     void drawLines (float[] pts, int offset, int count, Paint paint)
     pts  两两连成一条直线
    - 点  void drawPoint (float x, float y, Paint paint)
         - float X：点的X坐标
         - float Y：点的Y坐标
    - 多个点
void drawPoints (float[] pts, Paint paint)
void drawPoints (float[] pts, int offset, int count, Paint paint)
      - int offset:集合中跳过的数值个数，注意不是点的个数！一个点是两个数值；
      - count:参与绘制的数值的个数，指pts[]里人数值个数，而不是点的个数，因为一个点是两个数值
      - offset与count的含义：（跳过第一个点，画出后面两个点，第四个点不画），注意一个点是两个数值！
    - 矩形工具类RectF与Rect
        - RectF RectF(float left, float top, float right, float bottom)  根据四个点构造出一个矩形
        - Rect  Rect(int left, int top, int right, int bottom) 
    - 矩形
        - void drawRect (float left, float top, float right, float bottom, Paint paint)
        - void drawRect (RectF rect, Paint paint)
        - void drawRect (Rect r, Paint paint)
    - 圆角矩形 void drawRoundRect (RectF rect, float rx, float ry, Paint paint)
        - RectF rect:要画的矩形
        - float rx:生成圆角的椭圆的X轴半径
        - float ry:生成圆角的椭圆的Y轴半径
    - 圆形 void drawCircle (float cx, float cy, float radius, Paint paint)
        - float cx：圆心点X轴坐标 
        -  float cy：圆心点Y轴坐标
        - float radius：圆的半径
    - 椭圆 void drawOval (RectF oval, Paint paint)

    - 弧 void drawArc (RectF oval, float startAngle, float sweepAngle, boolean useCenter, Paint paint)
        - RectF oval:生成椭圆的矩形
        -  float startAngle：弧开始的角度，以X轴正方向为0度
        -  float sweepAngle：弧持续的角度
        -  boolean useCenter:是否有弧的两边，True，还两边，False，只有一条弧
    - 普通水平绘制 
        - void drawText (String text, float x, float y, Paint paint)
        -  void drawText (CharSequence text, int start, int end, float x, float y, Paint paint)
        - void drawText (String text, int start, int end, float x, float y, Paint paint)
        -  void drawText (char[] text, int index, int count, float x, float y, Paint paint)
        第一个构造函数：最普通简单的构造函数；
        第三、四个构造函数：实现截取一部分字体给图；
        第二个构造函数：最强大，因为传入的可以是charSequence类型字体，所以可以实现绘制带图片的扩展文字（待续），而且还能截取一部分绘制
    - 指定个个文字位置
        - void drawPosText (char[] text, int index, int count, float[] pos, Paint paint)
        -  void drawPosText (String text, float[] pos, Paint paint)
         说明：
         第一个构造函数：实现截取一部分文字绘制；
         
         参数说明：
         char[] text：要绘制的文字数组
         int index:：第一个要绘制的文字的索引
         int count：要绘制的文字的个数，用来算最后一个文字的位置，从第一个绘制的文字开始算起
         float[] pos：每个字体的位置，同样两两一组，如｛x1,y1,x2,y2,x3,y3……｝
    - 沿路径绘制
        - void drawTextOnPath (String text, Path path, float hOffset, float vOffset, Paint paint)
        - void drawTextOnPath (char[] text, int index, int count, Path path, float hOffset, float vOffset, Paint paint)
        参数说明：
        
        有关截取部分字体绘制相关参数（index,count），没难度，就不再讲了，下面首重讲hOffset、vOffset
        float hOffset  : 与路径起始点的水平偏移距离
        float vOffset  : 与路径中心的垂直偏移量
        