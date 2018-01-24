package com.hqq.viewexample;

import android.graphics.Point;

import com.hqq.viewexample.Utils.LogUtils;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        //  assertEquals(4, 2 + 2);

        //   LogUtils.e(new A().getA());


        System.out.println("------ " + (Math.atan2(4, 1) * 180 / Math.PI));
        System.out.println("------ " + (Math.atan(4 / 1) * 180 / Math.PI));
        System.out.println("------------ " + Math.atan(Math .abs(4/1)) / Math.PI * 180);

        System.out.println(calcAngle(4,1));



    }

    private float calcAngle(float targetX, float targetY) {
        float x = targetX ;
        float y = targetY ;
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

}