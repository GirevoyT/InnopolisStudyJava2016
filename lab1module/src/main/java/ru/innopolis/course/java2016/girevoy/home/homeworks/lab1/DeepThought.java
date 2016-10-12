package ru.innopolis.course.java2016.girevoy.home.homeworks.lab1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.innopolis.course.java2016.girevoy.home.homeworks.lab1.logica.Logica;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by Arxan on 08.10.2016.
 */
public class DeepThought<T>{
	private Queue<T> queue = new PriorityQueue<>();
	private Logica<T> logica;
	private static Logger logger= LoggerFactory.getLogger(DeepThought.class);


	public DeepThought(Logica<T> logica,ThreadGroup threadGroup) {
		this.logica = logica;
		new Thread(threadGroup,"Поток думателя №1") {
			public void run () {
				while(!isInterrupted()) {
					try {
						T tmpT = null;
						while (true) {
							synchronized (DeepThought.this) {
								synchronized (queue) {
									if (!queue.isEmpty()) {
										tmpT = queue.poll();
										break;
									}
								}
								DeepThought.this.wait();
							}
						}
						logica.logica(tmpT);
					} catch (InterruptedException e) {
						e.getStackTrace().toString();
					}
				}
			}
		}.start();
	}


	public void addData(T data) {
		logger.debug("Запущен addData думателя, далее блокировка с queue: {}",queue.hashCode());
		synchronized (queue) {
			logger.debug("addData захватил блокировку от queue: {}",queue.hashCode());
			queue.add((T)data);
		}
		logger.debug("Освобождена блокировка queue: {}  и закончено добавление данных в очередь",queue.hashCode());
	}

}
