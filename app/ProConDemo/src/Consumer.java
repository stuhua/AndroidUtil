public class Consumer extends Thread {
	private Storage storage;
	private int num;

	public Storage getStorage() {
		return storage;
	}

	public void setStorage(Storage storage) {
		this.storage = storage;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public Consumer(Storage storage) {
		this.storage = storage;
	}

	@Override
	public void run() {
		super.run();
		consume(num);
	}

	public void consume(int num) {
		storage.consume(num);
	}

}
