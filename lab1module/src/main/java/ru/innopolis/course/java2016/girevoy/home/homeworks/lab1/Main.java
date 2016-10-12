package ru.innopolis.course.java2016.girevoy.home.homeworks.lab1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.innopolis.course.java2016.girevoy.home.homeworks.lab1.devourers.Devourer;
import ru.innopolis.course.java2016.girevoy.home.homeworks.lab1.logica.Logica;
import ru.innopolis.course.java2016.girevoy.home.homeworks.lab1.logica.MyTaskIntegerLogica;
import ru.innopolis.course.java2016.girevoy.home.homeworks.lab1.resource.Resource;
import ru.innopolis.course.java2016.girevoy.home.homeworks.lab1.resource.SafetyFileResource;

/**
 * Created by Arxan on 08.10.2016.
 */
public class Main {
	private static Logger logger = LoggerFactory.getLogger(Main.class);
	public static void main(String[] args){
		logger.info("Старт приложения");
		ThreadGroup threadGroup = new ThreadGroup("Group1");
		Resource<Integer> resource1 = new SafetyFileResource("./src/main/resources/Resource1",threadGroup);
		Resource<Integer> resource2 = new SafetyFileResource("./src/main/resources/Resource2",threadGroup);
		Logica<Integer> myLogica1 = new MyTaskIntegerLogica();
		Logica<Integer> myLogica2 = new MyTaskIntegerLogica();
		DeepThought deepThought1 = new DeepThought(myLogica1,threadGroup);
		DeepThought deepThought2 = new DeepThought(myLogica2,threadGroup);
		Devourer devourer1 = new Devourer(resource1,deepThought1,threadGroup);
		Devourer devourer2 = new Devourer(resource2,deepThought1,threadGroup);
		Devourer devourer3 = new Devourer(resource2,deepThought2,threadGroup);
		logger.info("Все объекты созданы и запущенны");
	}
}
