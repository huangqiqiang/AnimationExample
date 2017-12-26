package com.hqq.viewexample.activity.animate

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.*
import com.hqq.viewexample.R
import kotlinx.android.synthetic.main.activity_interpolator.*

/**
 * 插值器
 * http://blog.csdn.net/harvic880925/article/details/40049763
 */
class InterpolatorActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_interpolator)
        /**
         * 在动画开始与介绍的地方速率改变比较慢，在中间的时候加速
         */
        btn_AccelerateDecelerateInterpolator.setOnClickListener {
            var animation = AnimationUtils.loadAnimation(this, R.anim.roate_1)
            animation.interpolator = AccelerateDecelerateInterpolator();
            btn_AccelerateDecelerateInterpolator.startAnimation(animation)
        }
        /**
         * 在动画开始的地方速率改变比较慢，然后开始加速
         */
        btn_AccelerateInterpolatorr.setOnClickListener {
            var animation = AnimationUtils.loadAnimation(this, R.anim.roate_1)
            animation.interpolator = AccelerateInterpolator();
            btn_AccelerateInterpolatorr.startAnimation(animation)
        }
        /**
         *  开始的时候向后然后向前甩
         */
        btn_AnticipateInterpolator.setOnClickListener {
            var animation = AnimationUtils.loadAnimation(this, R.anim.roate_1)
            animation.interpolator = AnticipateInterpolator();
            btn_AnticipateInterpolator.startAnimation(animation)
        }
        /**
         * 开始的时候向后然后向前甩一定值后返回最后的值
         */
        btn_AnticipateOvershootInterpolator.setOnClickListener {
            var animation = AnimationUtils.loadAnimation(this, R.anim.roate_1)
            animation.interpolator = AnticipateOvershootInterpolator();
            btn_AnticipateOvershootInterpolator.startAnimation(animation)
        }
        /**
         * 动画结束的时候弹起
         */
        btn_BounceInterpolator.setOnClickListener {
            var animation = AnimationUtils.loadAnimation(this, R.anim.roate_1)
            animation.interpolator = BounceInterpolator();
            btn_BounceInterpolator.startAnimation(animation)
        }
        /**
         *  动画循环播放特定的次数，速率改变沿着正弦曲线
         */
        btn_CycleInterpolator.setOnClickListener {
            var animation = AnimationUtils.loadAnimation(this, R.anim.roate_1)
            animation.interpolator = CycleInterpolator (2.0f);
            btn_CycleInterpolator.startAnimation(animation)
        }
        /**
         *  在动画开始的地方快然后慢
         */
        btn_DecelerateInterpolator.setOnClickListener {
            var animation = AnimationUtils.loadAnimation(this, R.anim.roate_1)
            animation.interpolator = DecelerateInterpolator ();
            btn_DecelerateInterpolator.startAnimation(animation)
        }
        /**
         *    以常量速率改变
         */
        btn_LinearInterpolator.setOnClickListener {
            var animation = AnimationUtils.loadAnimation(this, R.anim.roate_1)
            animation.interpolator = LinearInterpolator   ();
            btn_LinearInterpolator.startAnimation(animation)
        }
        /**
         *  向前甩一定值后再回到原来位
         */
        btn_OvershootInterpolator.setOnClickListener {
            var animation = AnimationUtils.loadAnimation(this, R.anim.roate_1)
            animation.interpolator = OvershootInterpolator                         ();
            btn_OvershootInterpolator.startAnimation(animation)
        }


    }
}
