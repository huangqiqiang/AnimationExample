package com.hqq.viewexample.activity.animate

import android.animation.ObjectAnimator
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.hqq.viewexample.R
import kotlinx.android.synthetic.main.activity_object_animator.*

/**
 * http://blog.csdn.net/harvic880925/article/details/50598322
 */
class ObjectAnimatorActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_object_animator)

        btn_alpha.setOnClickListener {

            var animator = ObjectAnimator.ofFloat(btn_alpha, "alpha", 1f, 0f, 1f);
            animator.setDuration(1400)
            animator.start()
        }
        btn_rotation.setOnClickListener {

            var animator = ObjectAnimator.ofFloat(btn_rotation, "rotation", 0f, 180f, 0f);
            animator.setDuration(1400)
            animator.start()
        }
        btn_rotationX.setOnClickListener {

            var animator = ObjectAnimator.ofFloat(btn_rotationX, "rotationX", 0f, 270f, 0f);
            animator.setDuration(1400)
            animator.start()
        }
        btn_rotationY.setOnClickListener {

            var animator = ObjectAnimator.ofFloat(btn_rotationY, "rotationY", 0f, 180f, 0f);
            animator.setDuration(1400)
            animator.start()
        }
        btn_translationX.setOnClickListener {
            var animator = ObjectAnimator.ofFloat(btn_translationX, "translationX", 0f, 180f, 0f,200f);
            animator.setDuration(1400)
            animator.start()
        }
        btn_scaleX.setOnClickListener {
            var animator = ObjectAnimator.ofFloat(btn_scaleX, "scaleX", 1f, 3f, 1f);
            animator.setDuration(1400)
            animator.start()
        }

        // 调用 set 方法  设置 值   get 使用 初始值
        var animator =ObjectAnimator.ofInt(pv_point,"pointRadius",0,300,10)
        animator.duration=1400;
        animator.start()

    }
}
