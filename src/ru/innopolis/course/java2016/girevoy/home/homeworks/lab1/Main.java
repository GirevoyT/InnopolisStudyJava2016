package ru.innopolis.course.java2016.girevoy.home.homeworks.lab1;

import ru.innopolis.course.java2016.girevoy.home.homeworks.lab1.devourers.Devourer;
import ru.innopolis.course.java2016.girevoy.home.homeworks.lab1.resource.Resource;
import ru.innopolis.course.java2016.girevoy.home.homeworks.lab1.resource.SafetyFileResource;

import java.io.IOException;

/**
 * Created by Arxan on 08.10.2016.
 */
public class Main {
	public static void main(String[] args) throws InterruptedException {
		System.out.println("Start!");
		SafetyFileResource resource1 = new SafetyFileResource(".\\src\\Resource1");
		Resource<Integer> resource2 = new SafetyFileResource(".\\src\\Resource2");
		DeepThought deepThought = new DeepThought();
		Devourer devourer1 = new Devourer(resource1,deepThought);
		Devourer devourer2 = new Devourer(resource2,deepThought);
	}
}
