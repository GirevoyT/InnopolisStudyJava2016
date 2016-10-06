package ru.innopolis.course.java2016.girevoy.lessons.lesson4.testMultithread;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by masterlomaster on 06.10.16.
 */
public class TestMultithread {
	public static void main(String[] args) {
		Set<Thread> threadSet = new HashSet<>();
		Box box = new Box(0);
		threadSet.add(new MyThreadExtends("Thread One", box));
		threadSet.add(new MyThreadExtends("Thread Two", box));
		threadSet.add(new MyThreadExtends("Thread Three", box));

		for (Thread thread : threadSet) {
			thread.start();
		}
	}
}
