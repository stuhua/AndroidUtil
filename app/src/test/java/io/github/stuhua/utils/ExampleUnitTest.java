package io.github.stuhua.utils;

import org.junit.Test;

import java.io.File;

import file.FileUtils;

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
        File file =new File("D:/Liulh/Coding/AS/AndroidUtil/app/src/test/java/io/github/stuhua/utils/12.txt");
        FileUtils.getFileLines(file);
    }
}