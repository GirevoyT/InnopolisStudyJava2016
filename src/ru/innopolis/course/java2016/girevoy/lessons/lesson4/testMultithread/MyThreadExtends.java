package ru.innopolis.course.java2016.girevoy.lessons.lesson4.testMultithread;

/**
 * Created by masterlomaster on 06.10.16.
 */
public class MyThreadExtends extends Thread {
	private final String name;

	public MyThreadExtends(String name) {
		this.name = name;
		setDaemon(true);
	}

	@Override
	public void run() {
		if ("Thread One".equals(this.name)) {
			throw new RuntimeException("Должен вылететь первый поток!");
		}
		for (int i=0;i <10;i++) {
			System.out.println(this.name + " counter = " + i);
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
