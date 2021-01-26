package threads;

public class MyClass extends Thread{

	private String name;
	private MyObject myObj;
	
	public MyClass(String name, MyObject myObj) {
		super();
		this.name = name;
		this.myObj = myObj;
	}
	
	public void run() {
		if(name.equals("1")) MyObject.foo(name);
		else if (name.equals("2")) MyObject.bar(name);
	}
	
	public static void main(String[] args) {
		MyObject obj1 = new MyObject();
		MyObject obj2 = new MyObject();
		MyClass thread1 = new MyClass("1", obj1);
		MyClass thread2 = new MyClass("2", obj2);
		thread1.start();
		thread2.start();
	}
}

class MyObject {
	public static synchronized void foo(String name) {
		System.out.println("Thread " + name + ".foo(): starting");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			System.out.println("Thread " + name + "interrupted.");
		}
		System.out.println("Thread " + name + ".foo(): ending");
	}
	
	public static synchronized void bar(String name) {
		System.out.println("Thread " + name + ".bar(): starting");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			System.out.println("Thread " + name + "interrupted.");
		}
		System.out.println("Thread " + name + ".bar(): ending");
	}
}