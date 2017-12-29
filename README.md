# 动画 学习Demo与自定义View:  ViewExample
学习参考: http://blog.csdn.net/harvic880925/article/details/50995268
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
- set 集合 共有属性
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
* ValueAnimator   动画 ofInt ofObject 设置 属性 区间
* ObjectAnimation
* Interpolator  插值器/加速器
* Evaluator 就是将从加速器返回的数字进度转成对应的数字值


##  属性动画的Demo 
* 手写画板
* 贝塞尔波浪