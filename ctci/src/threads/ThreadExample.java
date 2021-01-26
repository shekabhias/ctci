package threads;

public class ThreadExample extends Thread{

	int count = 0;
	
	@Override
	public void run() {
		System.out.println("Thread starting.");
		while(count < 5) {
			try {
				Thread.sleep(500);
				System.out.println("Count is " + count);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			count++;
		}
		System.out.println("Thread terminating.");

	}
	
	public static void main(String[] args) {
		ThreadExample example = new ThreadExample();
		example.start();
		
	}
}
