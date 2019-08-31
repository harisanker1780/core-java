package concurrency.sharing_resources;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MutexEvenGenerator extends IntGenerator {

	private int evenValue = 0;

	private Lock lock = new ReentrantLock();
	
	@Override
	public int next() {
		lock.lock();
		try{
			evenValue++;
			evenValue++;
			return evenValue;
		} finally{
			lock.unlock();
		}
	}
	
	public static void main(String[] args) {
		EvenChecker.test(new MutexEvenGenerator());
	}

}
