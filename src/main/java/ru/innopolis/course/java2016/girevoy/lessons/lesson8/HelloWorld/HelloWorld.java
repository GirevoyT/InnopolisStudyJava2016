package ru.innopolis.course.java2016.girevoy.lessons.lesson8.HelloWorld;

import org.jcp.xml.dsig.internal.MacOutputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by masterlomaster on 12.10.16.
 */
public class HelloWorld {
	private static Logger logger = LoggerFactory.getLogger(HelloWorld.class);
	public static void main(String[] args) {
		if (logger.isInfoEnabled()) {
			Integer i = (int)(Math.random() * 1000);
			logger.info("Тестовое сообщене для логера. Число {}",i);
		}
		logger.debug("Тестовое сообщение для логгера. Дебаг");


		logger.error("error Test");
		logger.info("info Test");
		logger.debug("debugg Test");
		logger.trace("trace Test");
	}
}
