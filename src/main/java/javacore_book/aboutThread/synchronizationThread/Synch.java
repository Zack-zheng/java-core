package javacore_book.aboutThread.synchronizationThread;

/**
 * 同步的关键是管程（也叫信号量semaphore）的概念。管程是一个互斥独占锁定的对象，
 * 或称互斥体（mutex）。在给定的时间，仅有一个线程可以获得管程。当一个线程需要锁定，
 * 它必须进入管程。所有其他的试图进入已经锁定的管程的线程必须挂起直到第一个线程退
 * 出管程。这些其他的线程被称为等待管程。一个拥有管程的线程如果愿意的话可以再次进 入相同的管程。
 * 
 * @author Zach_zheng
 * 
 */
// This program is not synchronized.
class Callme {
	/**
	 * 在不加synchronized的时候，线程是没有管程控制的，所以会打印出下面的效果： [Synchronized[World[Hello] ] ]
	 * 
	 * @param msg
	 */
	synchronized void call(String msg) {
		System.out.print("[" + msg);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			System.out.println("Interrupted");
		}
		System.out.println("]");
	}
}

class Caller implements Runnable {
	String msg;
	Callme target;
	Thread t;

	public Caller(Callme targ, String s) {
		target = targ;
		msg = s;
		t = new Thread(this);
		t.start();
	}

	public void run() {
		target.call(msg);
	}
}

class Synch {
	public static void main(String args[]) {
		Callme target = new Callme();
		Caller ob1 = new Caller(target, "Hello");
		Caller ob2 = new Caller(target, "Synchronized");
		Caller ob3 = new Caller(target, "World");
		// wait for threads to end
		try {
			//join等待线程结束
			ob1.t.join();
			ob2.t.join();
			ob3.t.join();
		} catch (InterruptedException e) {
			System.out.println("Interrupted");
		}
	}
}
