package mutex_lock;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

public class Mutex_Lock {
	public static void main(String[] args) {
		ReentrantLock m1 = new ReentrantLock();
		ReentrantLock m2 = new ReentrantLock();
		
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				System.out.println("Foo");
				m1.lock();
				m2.lock();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Bar");
				m2.unlock();
				m1.unlock();	
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			public void run() {
				System.out.println("Baz");
				m2.lock();
				m1.lock();
				System.out.println("Qux");
				m1.unlock();
				m2.unlock();	
			}
		});
		
		t1.start();
		t2.start();
	} 
}
