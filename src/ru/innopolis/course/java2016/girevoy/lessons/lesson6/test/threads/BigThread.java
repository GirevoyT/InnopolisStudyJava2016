package ru.innopolis.course.java2016.girevoy.lessons.lesson6.test.threads;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by masterlomaster on 10.10.16.
 */
public class BigThread extends Thread{
	private Set<Integer> set = new HashSet<>();
	public synchronized void addValue(int tmpValue) {
		set.add(new Integer(tmpValue));
		System.out.println("Сгенерированно значение " + tmpValue);
	}

	public BigThread() {
		this.start();
	}

	public void run() {
		while (!isInterrupted()) {
			try {
				Thread.sleep(5000);
				synchronized (this) {
					System.out.println("Колличество уникальных значений " + set.size());
					if (set.size() == 101) {
						System.out.println("Программа завершает работу");
						this.interrupt();
					}
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
