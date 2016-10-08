package ru.innopolis.course.java2016.girevoy.home.testWorks.testHello;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by Arxan on 05.10.2016.
 */
public class HelloWorld {
	public static void main(String[] args) {
		System.out.println("Hello world!");
		Integer tmp = new Integer(5);
		Queue<Integer> queue= new PriorityQueue<>();
		queue.add(123);
		queue.add(234);
		System.out.println(queue.peek());
		System.out.println(queue.poll());
	}
}
