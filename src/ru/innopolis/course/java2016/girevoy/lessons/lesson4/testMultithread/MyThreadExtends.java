package ru.innopolis.course.java2016.girevoy.lessons.lesson4.testMultithread;

/**
 * Created by masterlomaster on 06.10.16.
 */
public class MyThreadExtends extends Thread {
	private final String name;

	public MyThreadExtends(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		for (int i=0;i <10;i++) {
			System.out.println(this.name);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
