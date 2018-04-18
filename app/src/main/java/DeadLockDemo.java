import java.util.ArrayList;
import java.util.List;

/**
 * Created by liulh on 2018/4/18.
 */
public class DeadLockDemo {
    List<Integer> buf = new ArrayList<>();
    int MAX_SIZE = 1;

    //Producer和Consumer
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
