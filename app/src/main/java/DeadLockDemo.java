import java.util.ArrayList;
import java.util.List;

/**
 * Created by liulh on 2018/4/18.
 * http://www.importnew.com/10173.html
 */
public class DeadLockDemo {
    List<Integer> buf = new ArrayList<>();
    int MAX_SIZE = 1;

    //Producer和Consumer
    //这种写法会产生两个问题1. 在get方法中会报会报IndexArrayOutOfBoundsException异常 2. 产生死锁
    public synchronized void put(int i) throws InterruptedException {
        if (buf.size() == MAX_SIZE) {
            wait();
        }
        buf.add(i);
        notify();
    }

    public synchronized void get(int i) throws InterruptedException {
        if (buf.size() == 0) {
            wait();
        }
        buf.remove(i);
        notify();
    }
}
