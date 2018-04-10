package io.github.stuhua.utils;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void test() {
        int gap = 1;
        int len = 10;
        while (gap < len / 3) {          //动态定义间隔序列
            gap = gap * 3 + 1;
        }
        System.out.println("gap = " + gap+", "+Math.floor(1));
    }
}