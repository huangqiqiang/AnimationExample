# 动画 学习Demo与自定义View:  ViewExample
- http://blog.csdn.net/harvic880925/article/details/50995268
- https://www.jianshu.com/p/9ad3aaae0c63      
- http://blog.51cto.com/mikewang/871765
## 帧动画  View  Animation (Frame Animation(逐帧动画))
  比较有针对性，只是图片的替换
## 补间动画 View Animation（Tween Animation）
 支持简单的缩放、平移、旋转、透明度基本的动画
 补间动画给出两个关键帧，通过一些算法将给定属性值在给定的时间内在两个关键帧间渐变  --> 使用插值器 开控制 动画速度 频率  
 [MORE](https://github.com/huangqiqiang/ViewExample/blob/master/Tween.md)
## 属性动画 Property Animation   包含 ValueAnimator和ObjectAnimation
  通过动画的方式来改变View的属性。
- ValueAnimator   动画 ofInt ofObject 设置 属性 区间
- ObjectAnimation
- Interpolator  插值器/加速器
- Evaluator 将插值器返回的数字进度转成对应的值

## View 的基本属性

- 几何图形 -> 位于 Canvas 下 
[MORE](https://github.com/huangqiqiang/ViewExample/blob/master/Canvas.md)   
- Paint 
 [MORE](https://github.com/huangqiqiang/ViewExample/blob/master/Paint.md)
  - FontMetrics   文字的 5 条 线   
 [MORE](https://github.com/huangqiqiang/ViewExample/blob/master/FontMetrics.md)
- Path 将多种复合路径（多个轮廓，如直线段、二次曲线、立方曲线）封装在其内部的几何路径 (BaseView)
 [MORE](https://github.com/huangqiqiang/ViewExample/blob/master/Path.md)
- 区域（Range）
 [MORE](https://github.com/huangqiqiang/ViewExample/blob/master/Range.md)


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