package ru.innopolis.course.java2016.girevoy.lessons.lesson6.testProxy2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by masterlomaster on 10.10.16.
 */
public class MainTestProxy2 {
	public static void main(String[] args) {
		Human human = (Human)HumanImpl.createHuman();


		long timer = System.currentTimeMillis();
		for (int i = 0; i < 100_000_000;i++) {
			human.setAge(1);
			human.getAge();
			human.setName("Name");
			human.getName();
		}
		System.out.println( "Время " + (System.currentTimeMillis() - timer));

		human = new HumanImpl();
		timer = System.currentTimeMillis();
		for (int i = 0; i < 100_000_000;i++) {
			human.setAge(1);
			human.getAge();
			human.setName("Name");
			human.getName();
		}
		System.out.println("Время " + (System.currentTimeMillis() - timer));

	}

}
