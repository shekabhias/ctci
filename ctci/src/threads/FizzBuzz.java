package threads;

public class FizzBuzz extends Thread{

	Object lock = new Object();
	int n = 100;
	static int i = 1;
	boolean by3,by5;
	String toPrint;
	
	public FizzBuzz(int i2) {
		
	}

	public FizzBuzz(boolean b, boolean c, String string) {
		this.by3 = b;
		this.by5 = c;
		this.toPrint = string;
	}

	@Override
	public void run() {
		while (i < n) {
			synchronized (lock) {
				if((i % 3 == 0) == by3 && (i % 5 == 0) == by5) {
					print();
					i++;
				}
			}
		}
	}
	
	public void print() {
		System.out.println(toPrint);
	}
	
	public static void main(String[] args) {
		FizzBuzz fizzBuzz = new FizzBuzz(true,true,"FizzBuzz");
		FizzBuzz fizz = new FizzBuzz(true,false,"Fizz");
		FizzBuzz buzz = new FizzBuzz(false,true,"Buzz");
		FizzBuzz number = new NumberThread(false,false,null);
		fizzBuzz.start();
		fizz.start();
		buzz.start();
		number.start();
	}
}

class NumberThread extends FizzBuzz{

	public NumberThread(boolean b, boolean c, String string) {
		super(b, c, string);
	}
	
	public void print() {
		System.out.println(i);
	}
	
}
