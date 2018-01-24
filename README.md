# 动画 学习Demo与自定义View:  ViewExample
- http://blog.csdn.net/harvic880925/article/details/50995268
- https://www.jianshu.com/p/9ad3aaae0c63      
- http://blog.51cto.com/mikewang/871765
## 帧动画  View  Animation (Frame Animation(逐帧动画))
  比较有针对性，只是图片的替换
## 补间动画 View Animation（Tween Animation）
  支持简单的缩放、平移、旋转、透明度基本的动画
 补间动画给出两个关键帧，通过一些算法将给定属性值在给定的时间内在两个关键帧间渐变  --> 使用插值器 开控制 动画速度 频率  
- Scale  移动
    - fromXScale 起始的X方向上相对自身的缩放比例，浮点值，比如1.0代表自身无变化，0.5代表起始时缩小一倍，2.0代表放大一倍
    - toXScale        结尾的X方向上相对自身的缩放比例，浮点值
    - fromYScale    起始的Y方向上相对自身的缩放比例，浮点值
    - toYScale        结尾的Y方向上相对自身的缩放比例，浮点值
    - pivotX            缩放起点X轴坐标，可以是数值、百分数、百分数p 三种样式，比如 50、50%、50%p，当为数值时，表示在当前View的左上角，即原点处加上50px，做为起始缩放点；如果是50%，表示在当前控件的左上角加上自己宽度的50%做为起始点；如果是50%p，那么就是表示在当前的左上角加上父控件宽度的50%做为起始点x轴坐标。
    - pivotY           缩放起点Y轴坐标，取值及意义跟android:pivotX一样
- Alpha 透明 
    - android:fromAlpha   动画开始的透明度，从0.0 --1.0 ，0.0表示全透明，1.0表示完全不透明
    -  android:toAlpha       动画结束时的透明度，也是从0.0 --1.0 ，0.0表示全透明，1.0表示完全不透明

- Roate 缩放
    - android:fromDegrees     开始旋转的角度位置，正值代表顺时针方向度数，负值代码逆时针方向度数
    - android:toDegrees         结束时旋转到的角度位置，正值代表顺时针方向度数，负值代码逆时针方向度数
    - android:pivotX               缩放起点X轴坐标，可以是数值、百分数、百分数p 三种样式，比如 50、50%、50%p
    - android:pivotY               缩放起点Y轴坐标，可以是数值、百分数、百分数p 三种样式，比如 50、50%、50%p

- Translate  旋转
    - android:fromXDelta     起始点X轴坐标，可以是数值、百分数、百分数p 三种样式，比如 50、50%、50%p，
    - android:fromYDelta    起始点Y轴从标，可以是数值、百分数、百分数p 三种样式；
    - android:toXDelta         结束点X轴坐标
    - android:toYDelta        结束点Y轴坐标
- Set 集合 共有属性
    - android:duration        动画持续时间，以毫秒为单位 
    - android:fillAfter          如果设置为true，控件动画结束时，将保持动画最后时的状态
    - android:fillBefore       如果设置为true,控件动画结束时，还原到开始动画前的状态
    - android:fillEnabled    与android:fillBefore 效果相同，都是在动画结束时，将控件还原到初始化状态
    - android:repeatCount 重复次数
    - android:repeatMode	重复类型，有reverse和restart两个值，reverse表示倒序回放，restart表示重新放一遍，必须与repeatCount一起使用才能看到效果。因为这里的意义是重复的类型，即回放时的动作。
    - android:interpolator  设定插值器，其实就是指定的动作效果，比如弹跳效果等，不在这小节中讲解，后面会单独列出一单讲解。
- Interpolator 插值器
    - AccelerateDecelerateInterpolator   在动画开始与介绍的地方速率改变比较慢，在中间的时候加速
    - AccelerateInterpolator                     在动画开始的地方速率改变比较慢，然后开始加速
    - AnticipateInterpolator                      开始的时候向后然后向前甩
    - AnticipateOvershootInterpolator     开始的时候向后然后向前甩一定值后返回最后的值
    - BounceInterpolator                          动画结束的时候弹起
    - CycleInterpolator                             动画循环播放特定的次数，速率改变沿着正弦曲线
    - DecelerateInterpolator                    在动画开始的地方快然后慢
    - LinearInterpolator                            以常量速率改变
    - OvershootInterpolator                      向前甩一定值后再回到原来位置
## 属性动画 Property Animation   包含 ValueAnimator和ObjectAnimation
  通过动画的方式来改变View的属性。
- ValueAnimator   动画 ofInt ofObject 设置 属性 区间
- ObjectAnimation
- Interpolator  插值器/加速器
- Evaluator 将插值器返回的数字进度转成对应的值

## View 的基本属性

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
        
        
        
              
- Paint 
  - paint.setAntiAlias(true);//抗锯齿功能
  - paint.setColor(Color.RED);  //设置画笔颜色    
  - paint.setStrokeWidth(30);//设置画笔宽度
  - paint.setTextSize(12);//设置文字大小  
  - paint.setStyle(Style.FILL);//设置填充样式
       - Paint.Style.FILL    :填充内部
       -  Paint.Style.FILL_AND_STROKE  ：填充内部和描边
       -  Paint.Style.STROKE  ：仅描边
  - paint.setShadowLayer (float radius, float dx, float dy, int color)    添加阴影
     - radius:阴影的倾斜度
     - dx:水平位移
     - dy:垂直位移
  - setStrokeCap(Paint.Cap cap)
     - BUTT 无线帽
     - SQUARE 方形线帽
     - ROUND 圆形线帽
  - paint.setFakeBoldText(true);//设置是否为粗体文字  
  -  paint.setUnderlineText(true);//设置下划线  
  -  paint.setTextSkewX((float) -0.25);//设置字体水平倾斜度，普通斜体字是-0.25  
  -  paint.setStrikeThruText(true);//设置带有删除线效果  
  - paint.setTextAlign(Paint.Align.XXX);
    - LEFT
    - CENTER
    - RIGHT
    原点(x,y)在矩形的 左 居中 右 
  - paint.setStrokeJoin(Paint.Join.MITER);  
        - Join.MITER（结合处为锐角）
        -  Join.Round(结合处为圆弧)
        -  Join.BEVEL(结合处为直线)
  - paint.setTextScaleX(2);//只会将水平方向拉伸，高度不会变  
  - paint.setTypeface(typeface); 字体样式设置（Typeface）
     -  Typeface	create(String familyName, int style) //直接通过指定字体名来加载系统中自带的文字样式
     -  Typeface	create(Typeface family, int style)     //通过其它Typeface变量来构建文字样式
     - Typeface	createFromAsset(AssetManager mgr, String path) //通过从Asset中获取外部字体来显示字体样式
     -   Typeface	createFromFile(String path)//直接从路径创建
     -  Typeface	createFromFile(File path)//从外部路径来创建字体样式
     -   Typeface	defaultFromStyle(int style)//创建默认字体
     上面的各个参数都会用到Style变量,Style的枚举值如下:
     Typeface.NORMAL  //正常体
     Typeface.BOLD	 //粗体
     Typeface.ITALIC	 //斜体
     Typeface.BOLD_ITALIC //粗斜体
     - 使用系统中的字体
        - Typeface	defaultFromStyle(int style)//创建默认字体
        -   Typeface	create(String familyName, int style) //直接通过指定字体名来加载系统中自带的文字样式
     - 自字义字体
        -  Typeface	createFromAsset(AssetManager mgr, String path) //通过从Asset中获取外部字体来显示字体样式
        -  Typeface	createFromFile(String path)//直接从路径创建
        -  Typeface	createFromFile(File path)//从外部路径来创建字体样式  
  - FontMetrics   文字的 5 条 线   
      - 基准点是baseline
      - Ascent是baseline之上至字符最高处的距离
      - Descent是baseline之下至字符最低处的距离
      - Leading文档说的很含糊，其实是上一行字符的descent到下一行的ascent之间的距离
      - Top指的是指的是最高字符到baseline的值，即ascent的最大值
      - 同上，bottom指的是最下字符到baseline的值，即descent的最大值  
      - 高度
      ```Paint.FontMetricsInt fm = paint.getFontMetricsInt();  
         int top = baseLineY + fm.top;  
         int bottom = baseLineY + fm.bottom;  
         //所占高度  
         int height = bottom - top;  
      -  宽度
        ```int width = paint.measureText(String text);  
      - 最小矩形 public void getTextBounds(String text, int start, int end, Rect bounds);  
         获取指定字符串所对应的最小矩形，以（0，0）点所在位置为基线 
         - text  要测量最小矩形的字符串 
         -  start 要测量起始字符在字符串中的索引 
         - end   所要测量的字符的长度 
         - bounds 接收测量结果 
        
- Path 将多种复合路径（多个轮廓，如直线段、二次曲线、立方曲线）封装在其内部的几何路径 (BaseView)
    -   paint.setPathEffect();
         - CornerPathEffect——圆形拐角效果  public CornerPathEffect(float radius)  
         - DashPathEffect——虚线效果  
            public DashPathEffect(float intervals[], float phase) 
          intervals  长度必须大于等于2；因为必须有一个实线段和一个空线段来组成虚线。
            个数必须为偶数，如果是基数，最后一个数字将被忽略；这个很好理解，因为一组虚线的组成必然是一个实线和一个空线成对组成的
            phase：开始绘制的偏移值 
         - DiscretePathEffect——离散路径效果   
            public DiscretePathEffect(float segmentLength, float deviation)  
            第一个参数segmentLength：表示将原来的路径切成多长的线段。如果值为2，那么这个路径就会被切成一段段由长度为2的小线段。所以这个值越小，所切成的小线段越多；这个值越大，所切成的小线段越少。 
            第二参数deviation：表示被切成的每个小线段的可偏移距离。值越大，就表示每个线段的可偏移距离就越大，就显得越凌乱，值越小，每个线段的可偏移原位置的距离就越小
          - PathDashPathEffect——印章路径效果 
            public PathDashPathEffect(Path shape, float advance, float phase,Style style)   
            Path shape:表示印章路径，比如我们下面示例中的三角形加右上角一个点；
            float advance：表示两个印章路径间的距离,很容易理解，印章间距离越大，间距就越大。
            float phase：路径绘制偏移距离，与上面DashPathEffect中的float phase参数意义相同
            Style style：表示在遇到转角时，如何操作印章以使转角平滑过渡，取值有：Style.ROTATE，Style.MORPH，Style.TRANSLATE;Style.ROTATE表示通过旋转印章来过渡转角；Style.MORPH表示通过变形印章来过渡转角；Style.TRANSLATE表示通过位移来过渡转角。这三个效果的具体意义，上面会通过具体示例来分别讲解。
    - 直线路径
        - void moveTo (float x1, float y1):直线的开始点；即将直线路径的绘制点定在（x1,y1）的位置
        - void lineTo (float x2, float y2)：直线的结束点，又是下一次绘制直线路径的开始点；lineTo（）可以一直用
        - void close ():如果连续画了几条直线，但没有形成闭环，调用Close()会将路径首尾点连接起来，形成闭环
    - 矩形路径
        - void addRect (float left, float top, float right, float bottom, Path.Direction dir)
        - void addRect (RectF rect, Path.Direction dir) 
        这里Path类创建矩形路径的参数与上篇canvas绘制矩形差不多，唯一不同的一点是增加了Path.Direction参数；
        Path.Direction有两个值：
        Path.Direction.CCW：是counter-clockwise缩写，指创建逆时针方向的矩形路径；
        Path.Direction.CW：是clockwise的缩写，指创建顺时针方向的矩形路径
    - 圆角矩形路径    
        - void addRoundRect (RectF rect, float[] radii, Path.Direction dir)
        - void addRoundRect (RectF rect, float rx, float ry, Path.Direction dir)
        第一个构造函数：可以定制每个角的圆角大小：
        float[] radii：必须传入8个数值，分四组，分别对应每个角所使用的椭圆的横轴半径和纵轴半径，如｛x1,y1,x2,y2,x3,y3,x4,y4｝，其中，x1,y1对应第一个角的（左上角）用来产生圆角的椭圆的横轴半径和纵轴半径，其它类推……
        第二个构造函数：只能构建统一圆角大小
        float rx：所产生圆角的椭圆的横轴半径；
        float ry：所产生圆角的椭圆的纵轴半径
    - 圆形路径 
        -  void addCircle (float x, float y, float radius, Path.Direction dir)
            参数说明：
            float x：圆心X轴坐标 
            float y：圆心Y轴坐标
            float radius：圆半径   
    - 椭圆路径    
        - void addOval (RectF oval, Path.Direction dir)
        参数说明：
        RectF oval：生成椭圆所对应的矩形
        Path.Direction :生成方式，与矩形一样，分为顺时针与逆时针，意义完全相同，不再重复
    - 弧形路径   
        -  void addArc (RectF oval, float startAngle, float sweepAngle)
        参数：
        RectF oval：弧是椭圆的一部分，这个参数就是生成椭圆所对应的矩形；
        float startAngle：开始的角度，X轴正方向为0度
        float sweepAngel：持续的度数；
    - 线段轨迹
        - void quadTo (float x1, float y1, float x2, float y2)
    - canvas变换与操作
        - 平移（translate） void translate(float dx, float dy)
        参数说明：
        float dx：水平方向平移的距离，正数指向正方向（向右）平移的量，负数为向负方向（向左）平移的量
        flaot dy：垂直方向平移的距离，正数指向正方向（向下）平移的量，负数为向负方向（向上）平移的量
    - 旋转（Rotate）
        - void rotate(float degrees)
        - void rotate (float degrees, float px, float py)
        第一个构造函数直接输入旋转的度数，正数是顺时针旋转，负数指逆时针旋转，它的旋转中心点是原点（0，0）
        第二个构造函数除了度数以外，还可以指定旋转的中心点坐标（px,py）
    - 缩放（scale ）
        - public void scale (float sx, float sy) 
        - public final void scale (float sx, float sy, float px, float py)
        float sx:水平方向伸缩的比例，假设原坐标轴的比例为n,不变时为1，在变更的X轴密度为n*sx;所以，sx为小数为缩小，sx为整数为放大
        float sy:垂直方向伸缩的比例，同样，小数为缩小，整数为放大
    - 扭曲（skew）   
        - void skew (float sx, float sy)
        参数说明：
        float sx:将画布在x方向上倾斜相应的角度，sx倾斜角度的tan值，
        float sy:将画布在y轴方向上倾斜相应的角度，sy为倾斜角度的tan值，
    - 裁剪画布（clip系列函数）   
        - boolean	clipPath(Path path)
        -  boolean	clipPath(Path path, Region.Op op)
        -  boolean	clipRect(Rect rect, Region.Op op)
         - boolean	clipRect(RectF rect, Region.Op op)
         - boolean	clipRect(int left, int top, int right, int bottom)
        -  boolean	clipRect(float left, float top, float right, float bottom)
        -  boolean	clipRect(RectF rect)
        -  boolean	clipRect(float left, float top, float right, float bottom, Region.Op op)
         - boolean	clipRect(Rect rect)
         - boolean	clipRegion(Region region)
         - boolean	clipRegion(Region region, Region.Op op)
    - 画布的保存与恢复（save()、restore()）     
       - int save ()
       -  void	restore()  
- 区域（Range）
   - 基本构造函数     
       -  public Region()  //创建一个空的区域  
       -   public Region(Region region) //拷贝一个region的范围  
       -  public Region(Rect r)  //创建一个矩形的区域  
       -   public Region(int left, int top, int right, int bottom) //创建一个矩形的区域       
       第二个构造函数是通过其它的Region来复制一个同样的Region变量
       第三个，第四个才是正规常的，根据一个矩形或矩形的左上角和右下角点构造出一个矩形区域
   - 间接构造
       - public void setEmpty()  //置空
       -  public boolean set(Region region)   
       -  public boolean set(Rect r)   
       -  public boolean set(int left, int top, int right, int bottom)   
       -  public boolean setPath(Path path, Region clip)
       这是Region所具有的一系列Set方法，我这里全部列了出来，下面一一对其讲解：
       注意：无论调用Set系列函数的Region是不是有区域值，当调用Set系列函数后，原来的区域值就会被替换成Set函数里的区域。
       SetEmpty（）：从某种意义上讲置空也是一个构造函数，即将原来的一个区域变量变成了一个空变量，要再利用其它的Set方法重新构造区域。
       set(Region region)：利用新的区域值来替换原来的区域
       set(Rect r)：利用矩形所代表的区域替换原来的区域
       set(int left, int top, int right, int bottom)：同样，根据矩形的两个点构造出矩形区域来替换原来的区域值
       setPath(Path path, Region clip)：根据路径的区域与某区域的交集，构造出新区域，这个后面具体讲解
   -  使用SetPath（）构造不规则区域
        -  boolean setPath (Path path, Region clip)
        Path path：用来构造的区域的路径
        Region clip：与前面的path所构成的路径取交集，并将两交集设置为最终的区域
        由于路径有很多种构造方法，而且可以轻意构造出非矩形的路径，这就摆脱了前面的构造函数只能构造矩形区域的限制。但这里有个问题是要指定另一个区域来取共同的交集，当然如果想显示路径构造的区域，Region clip参数可以传一个比Path范围大的多的区域，取完交集之后，当然是Path参数所对应的区域喽。机智的孩子     
   -  矩形集枚举区域——RegionIterator类
        - RegionIterator(Region region) //根据区域构建对应的矩形集
        -  boolean	next(Rect r) //获取下一个矩形，结果保存在参数Rect r 中
   - 区域的合并、交叉等操作
        - public final boolean union(Rect r)   
        - public boolean op(Rect r, Op op) {  
        - public boolean op(int left, int top, int right, int bottom, Op op)   
        - public boolean op(Region region, Op op)   
        - public boolean op(Rect rect, Region region, Op op)    
          ```
            public enum Op {    
                   DIFFERENCE(0), //最终区域为region1 与 region2不同的区域    
                   INTERSECT(1), // 最终区域为region1 与 region2相交的区域    
                   UNION(2),      //最终区域为region1 与 region2组合一起的区域    
                   XOR(3),        //最终区域为region1 与 region2相交之外的区域    
                   REVERSE_DIFFERENCE(4), //最终区域为region2 与 region1不同的区域    
                   REPLACE(5); //最终区域为为region2的区域    
     
   - 其它一些方法
         /**几个判断方法*/    
           public native boolean isEmpty();//判断该区域是否为空    
           public native boolean isRect(); //是否是一个矩阵    
           public native boolean isComplex();//是否是多个矩阵组合    
           /**一系列的getBound方法，返回一个Region的边界*/    
           public Rect getBounds()     
           public boolean getBounds(Rect r)     
           public Path getBoundaryPath()     
           public boolean getBoundaryPath(Path path)   
            
           /**一系列的判断是否包含某点 和是否相交*/    
           public native boolean contains(int x, int y);//是否包含某点    
           public boolean quickContains(Rect r)   //是否包含某矩形  
           public native boolean quickContains(int left, int top, int right,    
                                                   int bottom) //是否没有包含某矩阵形   
            public boolean quickReject(Rect r) //是否没和该矩形相交    
            public native boolean quickReject(int left, int top, int right, int bottom); //是否没和该矩形相交    
            public native boolean quickReject(Region rgn);  //是否没和该矩形相交    
               
           /**几个平移变换的方法*/    
           public void translate(int dx, int dy)     
           public native void translate(int dx, int dy, Region dst);    
         


##  属性动画自定义View  Demo
- 贝塞尔波浪 HandwritingViewo 
    - 贝塞尔绘制
    - 动画 移动
- 手写画板 WaveView
    - 手势监听  与 贝塞尔 绘制 
- 圆形加载进度条 CircleProgressView
    -  两个 drawArc 一个绘制背景 一个绘制进度   sweepAngle
    -  drawText 绘制 文字    FontMetricsInt 计算文字大小 
- 自定义控件 温度旋转按钮 TempControlView
    - canvas 的应用 保存 取出  旋转 移动  
    - 手势 屏幕 角度的判断 