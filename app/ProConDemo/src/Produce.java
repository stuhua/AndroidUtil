public class Produce extends Thread {
	private int num;
	private Storage storage;

	public Produce(Storage storage) {
		this.storage = storage;
	}

	@Override
	public void run() {
		super.run();
		produce(num);
	}

	public void produce(int num) {
		storage.produce(num);
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public Storage getStorage() {
		return storage;
	}

	public void setStorage(Storage storage) {
		this.storage = storage;
	}

}
