package threading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreeThread {
	private static Lock lock = new ReentrantLock();
	private static int count = 1;
	private static final int MAX_COUNT = 10;
	private static int turn = 1;

	public static void main(String[] args) {
		Thread t1 = new Thread(() -> extracted(1));
		Thread t2 = new Thread(() -> extracted(2));
		Thread t3 = new Thread(() -> extracted(3));
		t1.start();
		t2.start();
		t3.start();
	}

	private static void extracted(int threadId) {
		while (MAX_COUNT >= count) {
			lock.lock();
			try {
				if (MAX_COUNT >= count && threadId == turn) {
					System.out.println(threadId + " : " + count);
					turn = count % 3 + 1;
					count++;
				}
			} finally {
				lock.unlock();  
			}
		}
	}
}
