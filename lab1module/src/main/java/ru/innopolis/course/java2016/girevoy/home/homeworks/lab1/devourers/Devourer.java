package ru.innopolis.course.java2016.girevoy.home.homeworks.lab1.devourers;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.innopolis.course.java2016.girevoy.home.homeworks.lab1.DeepThought;
import ru.innopolis.course.java2016.girevoy.home.homeworks.lab1.resource.Resource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * Created by Arxan on 08.10.2016.
 */
public class Devourer<T> extends Thread{
	private Resource<T> resource;
	private DeepThought deepThought;
	private static Logger logger= LoggerFactory.getLogger(Devourer.class);

	public Devourer(Resource<T> resource, DeepThought deepThought,ThreadGroup threadGroup) {
		super(threadGroup,"Поток пожирателя");
		logger.debug("Запущен конструктор пожирателя: {}",this.hashCode());
		this.resource = resource;
		this.deepThought = deepThought;
		this.start();
		logger.debug("Пожиратель: {} сконфигурирован и запущен",this.hashCode());
	}


	@Override
	public void run() {
		while (!isInterrupted()) {
			logger.debug("Начал работать поток Devourer: ",this.hashCode());
			T tmpObject;
			synchronized (resource) {
				logger.debug("Пожиратель: {} захватил блокировку resource: {}",this.hashCode(),resource.hashCode());
				if (resource.hasNext()) {
					tmpObject = resource.next();
					synchronized (deepThought) {
						deepThought.addData(tmpObject);
						deepThought.notify();
					}
				} else if (!resource.isComplite()) {
					try {
						resource.addListener();
						resource.wait();
					} catch (InterruptedException e) {
						this.interrupt();
						if (logger.isWarnEnabled()) {
							ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
							PrintStream printStream = new PrintStream(byteArrayOutputStream);
							e.printStackTrace(printStream);
							logger.warn(byteArrayOutputStream.toString());
						}
					}
				} else {
					this.interrupt();
				}
			}
		}
	}
}
