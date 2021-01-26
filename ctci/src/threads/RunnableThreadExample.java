package threads;

public class RunnableThreadExample implements Runnable{

	public int count = 0;
	
	@Override
	public void run() {

		System.out.println("Runnable Thread starting.");
		while(count < 5) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				System.out.println("Interrupted .." + e);
			}
			count++;
		}
		System.out.println("Runnable Thread terminating.");
	}
	
	public static void main(String[] args) {
		RunnableThreadExample example = new RunnableThreadExample();
		Thread thread = new Thread(example);
		thread.start();
		
		while(example.count != 5) {
			try {
				Thread.sleep(250);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
