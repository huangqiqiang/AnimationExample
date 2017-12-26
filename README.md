# 动画 学习Demo与自定义View:  ViewExample
学习参考: http://blog.csdn.net/harvic880925/article/details/50995268
## 帧动画  Drawable Animation 
  比较有针对性，只是图片的替换
## 补间动画 View Animation（Tween Animation）
   支持简单的缩放、平移、旋转、透明度基本的动画
 补间动画给出两个关键帧，通过一些算法将给定属性值在给定的时间内在两个关键帧间渐变。
* Scale  移动
* Alpha 透明 
* Roate 缩放
* Translate  旋转
* set 集合
## 属性动画 Property Animation 
是通过动画的方式来改变View的属性。
* ValueAnimator   动画 ofInt ofObject 设置 属性 区间
* Interpolator  插值器/加速器
* Evaluator 就是将从加速器返回的数字进度转成对应的数字值


## 
* 手写画板
* 贝塞尔波浪