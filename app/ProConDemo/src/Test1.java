import java.util.ArrayList;
import java.util.List;

public class Test1 {
	private static List<Object> mList = new ArrayList<Object>();

	public static void main(String[] args) {
		for (int i = 0; i < 30; i++) {
			mList.add(new Object());
		}
		for (int i = 0; i < 20; i++) {
			mList.remove(i);
		}
	}

}
