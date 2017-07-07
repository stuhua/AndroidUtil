import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Storage {
	private final int MAX_SIZE = 100;
	private List<Object> mList = new ArrayList<Object>();
	private Lock mLock = new ReentrantLock();
	private final Condition mFull = mLock.newCondition();
	private final Condition mEmpty = mLock.newCondition();

	public void produce(int num) {
		mLock.lock();
		while (mList.size() + num > MAX_SIZE) {
			try {
				System.out.println("[要生成的产品数]：" + num + "\t[库存量]："
						+ mList.size() + "\t暂时不能执行任务！");
				mFull.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		for (int i = 0; i < num; i++) {
			mList.add(new Object());
		}
		System.out.println("[已经生产产品数]：" + num + "\t[库存量]：" + mList.size());
		mFull.signalAll();
		mEmpty.signalAll();
		mLock.unlock();
	}

	public void consume(int num) {
		mLock.lock();
		while (mList.size() < num) {
			try {
				System.out.println("[要消费的产品数]：" + num + "\t[库存量]："
						+ mList.size() + "\t暂时不能执行任务！");
				mEmpty.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	
		for (int i = 0; i < num; i++) {
			mList.remove(0);
		}
		System.out.println("[已经消费产品数]：" + num + "\t[库存量]：" + mList.size());
		mFull.signalAll();
		mEmpty.signalAll();
		mLock.unlock();
	}
}
