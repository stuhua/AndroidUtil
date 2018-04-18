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
    //-------------------------------------------------------------
    //问题1
    /**
     * 至少需要C1,C2,P1三个线程
     * 1. C1，C2在wait前，C1被P1 notify，remove掉一个，C2再次remove会报IndexArrayOutOfBoundsException异常
     * 使用while循环代替if
     */

    //问题2
    /**
     *需要P1,P2,P3,C1,C2,C3 六个线程
     *
     * 使用notifyAll代替notify
     */

    // http://www.runoob.com/java/thread-deadlock.html
    // 死锁问题 P1占有P2的资源，P2占有P3的资源，P3占有P1的资源。这样就形成了一个等待环路。
   /* import java.util.Date;
    public class LockTest {
        public static String obj1 = "obj1";
        public static String obj2 = "obj2";
        public static void main(String[] args) {
            LockA la = new LockA();
            new Thread(la).start();
            LockB lb = new LockB();
            new Thread(lb).start();
        }
    }
    class LockA implements Runnable{
        public void run() {
            try {
                System.out.println(new Date().toString() + " LockA 开始执行");
                while(true){
                    synchronized (LockTest.obj1) {
                        System.out.println(new Date().toString() + " LockA 锁住 obj1");
                        Thread.sleep(3000); // 此处等待是给B能锁住机会
                        synchronized (LockTest.obj2) {
                            System.out.println(new Date().toString() + " LockA 锁住 obj2");
                            Thread.sleep(60 * 1000); // 为测试，占用了就不放
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    class LockB implements Runnable{
        public void run() {
            try {
                System.out.println(new Date().toString() + " LockB 开始执行");
                while(true){
                    synchronized (LockTest.obj2) {
                        System.out.println(new Date().toString() + " LockB 锁住 obj2");
                        Thread.sleep(3000); // 此处等待是给A能锁住机会
                        synchronized (LockTest.obj1) {
                            System.out.println(new Date().toString() + " LockB 锁住 obj1");
                            Thread.sleep(60 * 1000); // 为测试，占用了就不放
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }*/
    /**
     * Tue May 05 10:51:06 CST 2015 LockB 开始执行
      *Tue May 05 10:51:06 CST 2015 LockA 开始执行
      *Tue May 05 10:51:06 CST 2015 LockB 锁住 obj2
      *Tue May 05 10:51:06 CST 2015 LockA 锁住 obj1
     */
}
