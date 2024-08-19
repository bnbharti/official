package threading.adderSubstractor;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AdderSubstractor {
	public static void main(String[] args) throws InterruptedException {
		Lock lock = new ReentrantLock();
		Counter counter = new Counter(0);
		Thread adder = new Thread(() -> Adder.addToCounter(counter, lock));
		Thread substractor = new Thread(() -> Substractor.substractor(counter, lock));
		adder.start();
		substractor.start();
		adder.join();
		substractor.join();
		System.out.println(counter.getC());
	}
}
