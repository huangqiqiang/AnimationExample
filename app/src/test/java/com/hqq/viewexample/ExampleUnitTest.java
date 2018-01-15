package com.hqq.viewexample;

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
        assertEquals(4, 2 + 2);

        LogUtils.e(new A().getA());

    }



    class A {
        int  a;

        public int getA() {
            return a;
        }

        public void setA(int a) {
            this.a = a;
        }
    }

}