package ru.innopolis.course.java2016.girevoy.lessons.lesson7.testConsole;

import java.util.Scanner;

/**
 * Created by masterlomaster on 11.10.16.
 */
public class Main {
	public static void main(String[] args) throws InterruptedException {
		Scanner scanner = new Scanner(System.in);
		while (true) {

			Thread thread = new Thread() {
				@Override
				public void run() {
					this.setDaemon(true);
					try {

					}finally {
						System.out.println("qweqwe");
					}
				}
			};
			Thread.sleep(1000);
			Thread qwe = Thread.currentThread();
			qwe.interrupt();

		}
	}
}
