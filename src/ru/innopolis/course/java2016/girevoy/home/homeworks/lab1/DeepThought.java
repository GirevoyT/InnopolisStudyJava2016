package ru.innopolis.course.java2016.girevoy.home.homeworks.lab1;

import org.omg.CORBA.Object;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by Arxan on 08.10.2016.
 */
public class DeepThought {
	private Queue<Integer> queue = new PriorityQueue<>();
	private Integer sum = 0;
	private DeepThought thisDeepThought = this;

	public DeepThought() {
		new Thread() {
			public void run () {
				while(!isInterrupted()) {
					try {   //WARNING! Даёт ли нагрузку try!
						Integer tmpInteger = null;
						while (true) {
							synchronized (queue) {
								if (!queue.isEmpty()) {
									tmpInteger = queue.poll();
									break;
								}
							}
							synchronized (thisDeepThought) {
								thisDeepThought.wait();
							}
						}
						if ((tmpInteger.intValue() > 0) && ((tmpInteger.intValue() % 2) == 0)) {
							sum = sum.intValue() + tmpInteger.intValue();
							System.out.println("Текущее значение равно " + sum);
						}
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}.start();
	}

	public <T> void addData(T data) {
		if (data.getClass().equals(Integer.class)) {
			Integer tmpInteger = (Integer)data;
			synchronized (queue) {
				queue.add((Integer)data);
			}
		} else {
			throw new RuntimeException("Пожиратель передал объект неподходящего класса (не Integer)!");
		}
	}

}
