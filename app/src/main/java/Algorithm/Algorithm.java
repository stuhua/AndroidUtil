package Algorithm;

import java.util.Arrays;

/**
 * Created by liulh on 2018/4/10.
 */

public class Algorithm {

    /**
     * 标号1-n的n个人首尾相接，1到3报数，报到3的退出，求最后一个人的标号
     *
     * @param n 人数量
     * @return 剩下最后一个的人
     */
    public static int lastPerson(int n) {
        if (n <= 1) {
            return n;
        }
        int lastPerson = 0;
        boolean[] personList = new boolean[n];
        for (int i = 0; i < n; i++) {
            personList[i] = true;
        }
        int startPos = 0;
        int count = 0;
        int remainPerson = n;
        while (true) {
            if (personList[startPos]) {
                count++;
            }
            if (count == 3) {
                personList[startPos] = false;
                count = 0;
                remainPerson--;
            }
            if (remainPerson == 1) {
                break;
            }
            startPos++;
            if (startPos == n) {
                startPos = 0;
            }
        }
        //找出这一人
        for (int i = 0; i < n; i++) {
            if (personList[i] == true) {
                lastPerson = i + 1;
            }
        }
        return lastPerson;
    }

    /**
     * TODO 给定一个字符串，求第一个不重复的字符 abbcad -> c
     * 设计思路与 标号1-n的n个人首尾相接，1到3报数，报到3的退出，求最后一个人的标号 相同
     * 声明一个标记数组存放字符串的信息
     */

    /**
     * 快速排序,挖坑填数+分治法：
     */
    public static int[] quick_sort(int s[], int _left, int _right) {
        if (_left < _right) {
            //Swap(s[l], s[(l + r) / 2]); //将中间的这个数和第一个数交换 参见注1
            int left = _left, right = _right, temp = s[_left];
            while (left < right) {
                while (left < right && s[right] >= temp) // 从右向左找第一个小于x的数
                    right--;
                if (left < right)
                    s[left++] = s[right];

                while (left < right && s[left] < temp) // 从左向右找第一个大于等于x的数
                    left++;
                if (left < right)
                    s[right--] = s[left];
            }
            s[left] = temp;
            quick_sort(s, _left, left - 1); // 递归调用
            quick_sort(s, left + 1, _right);
        }
        return s;
    }

    /**
     * 希尔排序
     */
    public static int[] shellSort(int[] sourceArray) throws Exception {
        // 对 arr 进行拷贝，不改变参数内容
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);

        int gap = 1;
        while (gap < arr.length / 3) {
            gap = gap * 3 + 1;
        }

        while (gap > 0) {
            for (int i = gap; i < arr.length; i++) {
                int tmp = arr[i];
                int j = i - gap;
                while (j >= 0 && arr[j] > tmp) {
                    arr[j + gap] = arr[j];
                    j -= gap;
                }
                arr[j + gap] = tmp;
            }
            gap = (int) Math.floor(gap / 3);
        }
        return arr;
    }
    //--------------------查找

    public static int binarySearch(int[] array, int key) {
        int left = 0, right = array.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (array[mid] == key) {
                return mid;
            } else if (array[mid] > key) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
