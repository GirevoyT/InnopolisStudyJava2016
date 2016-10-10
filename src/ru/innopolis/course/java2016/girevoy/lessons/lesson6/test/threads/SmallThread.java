package ru.innopolis.course.java2016.girevoy.lessons.lesson6.test.threads;

import java.util.Random;

/**
 * Created by masterlomaster on 10.10.16.
 */
public class SmallThread extends Thread{
	private Random random = new Random();
	private BigThread bigThread;

	public SmallThread(BigThread bigThread) {
		this.bigThread = bigThread;
		this.setDaemon(true);
		this.start();
	}

	public void run() {
		while (!isInterrupted()) {
			try {
				Thread.sleep(10);
				int tmpValue = random.nextInt(101);
				bigThread.addValue(tmpValue);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
