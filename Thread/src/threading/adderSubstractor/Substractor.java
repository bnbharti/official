package threading.adderSubstractor;

import java.util.concurrent.locks.Lock;

public class Substractor {
 

	public static void substractor(Counter counter, Lock lock) {
		lock.lock();
		for (int i = 0; i < 10; i++) {
			counter.setC(counter.getC() - 1);
		}
		lock.unlock();
	}
}
