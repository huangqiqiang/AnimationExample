package com.hqq.viewexample.activity.animate

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.view.animation.ScaleAnimation
import com.hqq.viewexample.R
import kotlinx.android.synthetic.main.activity_xml_attributes.*

/**
 * http://blog.csdn.net/harvic880925/article/details/40049763
 */
class XmlAttributesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_xml_attributes)


        /**
         * 参考
         * http://blog.csdn.net/harvic880925/article/details/39996643
         * android:fromXScale    起始的X方向上相对自身的缩放比例，浮点值，比如1.0代表自身无变化，0.5代表起始时缩小一倍，2.0代表放大一倍；
         * android:fromYScale    起始的Y方向上相对自身的缩放比例，浮点值，
         * android:toXScale        结尾的X方向上相对自身的缩放比例，浮点值；
         * android:toYScale        结尾的Y方向上相对自身的缩放比例，浮点值；
         * android:pivotY           缩放起点Y轴坐标，取值及意义跟android:pivotX一样。
         * android:pivotX 缩放起点X轴坐标，可以是数值、百分数、百分数p 三种样式，比如 50、50%、50%p，当为数值时，表示在当前View的左上角，即原点处加上50px，做为起始缩放点；如果是50%，表示在当前控件的左上角加上自己宽度的50%做为起始点；如果是50%p，那么就是表示在当前的左上角加上父控件宽度的50%做为起始点x轴坐标。
         */
        btn_scale1.setOnClickListener {
            // 放大 1.4  50% 的位置  700  毫秒
            btn_scale1.startAnimation(AnimationUtils.loadAnimation(this, R.anim.scale_1))
        //    var scale = ScaleAnimation(0f, 0f, 1.4f, 1.4f);


        }
        /**  Animation类继承的属性
         *android:duration     动画持续时间，以毫秒为单位
         * android:fillAfter   如果设置为true，控件动画结束时，将保持动画最后时的状态
         * android:fillBefore  如果设置为true,控件动画结束时，还原到开始动画前的状态
         * android:repeatCount 重复次数
         * android:repeatMode 重复类型，有reverse和restart两个值，reverse表示倒序回放，restart表示重新放一遍，必须与repeatCount一起使用才能看到效果。因为这里的意义是重复的类型，即回放时的动作
         * android:interpolator  设定插值器，其实就是指定的动作效果，比如弹跳效果等，不在这小节中讲解，后面会单独列出一单讲解。
         * repeatMode 重复类型有两个值，reverse表示倒序回放，restart表示从头播放
         * android:repeatCount 重复次数
         */
        btn_scale2.setOnClickListener {
            btn_scale2.startAnimation(AnimationUtils.loadAnimation(this, R.anim.scale_2))
        }
        /**
         * android:fromAlpha   动画开始的透明度，从0.0 --1.0 ，0.0表示全透明，1.0表示完全不透明
         * android:toAlpha       动画结束时的透明度，也是从0.0 --1.0 ，0.0表示全透明，1.0表示完全不透明
         */
        btn_alpha.setOnClickListener {
            btn_alpha.startAnimation(AnimationUtils.loadAnimation(this, R.anim.alpha_1))
        }
        /**
         * android:fromDegrees     开始旋转的角度位置，正值代表顺时针方向度数，负值代码逆时针方向度数
         * android:toDegrees         结束时旋转到的角度位置，正值代表顺时针方向度数，负值代码逆时针方向度数
         * android:pivotX               缩放起点X轴坐标，可以是数值、百分数、百分数p 三种样式，比如 50、50%、50%p，具体意义已在scale标签中讲述，这里就不再重讲
         * android:pivotY               缩放起点Y轴坐标，可以是数值、百分数、百分数p 三种样式，比如 50、50%、50%p
         */
        btn_rotate.setOnClickListener {
            btn_rotate.startAnimation(AnimationUtils.loadAnimation(this, R.anim.roate_1))
        }
        /**
         * android:fromXDelta     起始点X轴坐标，可以是数值、百分数、百分数p 三种样式，比如 50、50%、50%p，具体意义已在scale标签中讲述，这里就不再重讲
         * android:fromYDelta    起始点Y轴从标，可以是数值、百分数、百分数p 三种样式；
         * android:toXDelta         结束点X轴坐标
         * android:toYDelta        结束点Y轴坐标
         */
        btn_translate.setOnClickListener {
            btn_translate.startAnimation(AnimationUtils.loadAnimation(this, R.anim.translate_1))
        }
        btn_set.setOnClickListener {
            btn_set.startAnimation(AnimationUtils.loadAnimation(this, R.anim.set_1))
        }

    }

}
