package threads;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DiningPhilosophers {

	public static void main(String[] args) {
		Chopstick c1 = new Chopstick();
		Chopstick c2 = new Chopstick();
		Chopstick c3 = new Chopstick();
		Philosopher p1 = new Philosopher(c1, c3);
		Philosopher p2 = new Philosopher(c2, c1);
		Philosopher p3 = new Philosopher(c3, c2);
		p1.start();
		p2.start();
		p3.start();
	}
}

class Chopstick{
	private Lock lock;

	public Chopstick() {
		lock = new ReentrantLock();
	}
		
	public boolean pickUp() {
		return lock.tryLock();
	}
	
	public void putDown() {
		lock.unlock();
	}
}

class Philosopher extends Thread{
	private int bites = 10;
	private Chopstick left, right;
	
	public Philosopher(Chopstick left, Chopstick right) {
		this.left = left;
		this.right = right;
	}
	
	public void eat() {
		if(pickUp()) {
			chew();
			putDown();
		}
	}
	
	public boolean pickUp() {
		if(!left.pickUp()) {
			return false;
		}
		if(!right.pickUp()) {
			left.putDown();
			return false;
		}
		return true;
	}
	
	public void chew() {
		
	}
	
	public void putDown() {
		left.putDown();
		right.putDown();
	}
	
	@Override
	public void run() {
		for (int i = 0; i < bites; i++) {
			eat();
			System.out.println(i);
		}
	}
}