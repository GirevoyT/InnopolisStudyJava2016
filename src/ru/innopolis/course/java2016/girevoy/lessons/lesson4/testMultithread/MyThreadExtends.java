package ru.innopolis.course.java2016.girevoy.lessons.lesson4.testMultithread;

/**
 * Created by masterlomaster on 06.10.16.
 */
public class MyThreadExtends extends Thread {
	private final String name;
	private Box counter;

	public MyThreadExtends(String name, Box counter) {
		this.name = name;
		this.counter = counter;
		//setDaemon(true);
	}

	@Override
	public void run() {
		for (int i=0;i <10000;i++) {

			synchronized (this.counter) {
				int count = this.counter.getValue();
				this.counter.setValue(count + 1);
			}


//			System.out.println(this.name + " counter = " + i);
//			try {
//				Thread.sleep(1);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}

			System.out.println("Box counter " + this.counter.getValue());
		}
	}
}
