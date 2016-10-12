package ru.innopolis.course.java2016.girevoy.lessons.lesson8.HelloWorld;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by masterlomaster on 12.10.16.
 */
public class HelloWorld {
	private static Logger logger = LoggerFactory.getLogger(HelloWorld.class);
	public static void main(String[] args) {
		logger.info("Тестовое сообщене для логера");
	}
}
