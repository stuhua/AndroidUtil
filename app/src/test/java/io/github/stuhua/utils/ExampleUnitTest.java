package io.github.stuhua.utils;

import org.junit.Test;

import convert.ByteUtils;

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
    public void test(){
        byte[] buffer={0x12,0x12,0x12,0x12,0x12,0x12};
        System.out.print(ByteUtils.byte2Long(buffer));
    }
}