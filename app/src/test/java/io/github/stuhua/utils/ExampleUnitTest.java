package io.github.stuhua.utils;

import org.junit.Test;

import Algorithm.Algorithm;
import reflect.ReflectTest;

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
    public void test() throws Exception {
        int [] _array={80,90,60,12,42,30,68,85,10};

//       int[] array =  Algorithm.quick_sort(_array,0,8);
        int[] array =  Algorithm.shellSort(_array);
        for(int i=0;i<array.length;i++){
            System.out.println(array[i]);
        }
        System.out.println(Algorithm.binarySearch(array,80));
    }

    @Test
    public void test1(){
        ReflectTest.getClassMethod1();
    }
}