package threading.adderSubstractor;

import java.util.concurrent.locks.Lock;

public class Adder {
	 
	public static void addToCounter(Counter counter,Lock lock) {
		lock.lock();
		for (int i = 0; i < 10; i++) {
			counter.setC(counter.getC() + 1);
		}
		lock.unlock();
	}
}
