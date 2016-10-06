package ru.innopolis.course.java2016.girevoy.lessons.lesson4.testMultithread;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by masterlomaster on 06.10.16.
 */
public class TestMultithread {
	public static void main(String[] args) {
		Set<Thread> threadSet = new HashSet<>();
		threadSet.add(new MyThreadExtends("Thread One"));
		threadSet.add(new MyThreadExtends("Thread Two"));
		threadSet.add(new MyThreadExtends("Thread Three"));

		for (Thread thread : threadSet) {
			thread.start();
		}
	}
}
