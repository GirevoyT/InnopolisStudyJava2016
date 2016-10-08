package ru.innopolis.course.java2016.girevoy.home.homeworks.lab1.devourers;

import ru.innopolis.course.java2016.girevoy.home.homeworks.lab1.DeepThought;
import ru.innopolis.course.java2016.girevoy.home.homeworks.lab1.resource.Resource;

/**
 * Created by Arxan on 08.10.2016.
 */
public class Devourer extends Thread{
	private Resource resource;
	private DeepThought deepThought;

	public Devourer(Resource resource, DeepThought deepThought) {
		this.resource = resource;
		this.deepThought = deepThought;
	}


	@Override
	public void run() {
		while (!isInterrupted()) {
			if (resource.hasNext()) {

			}
		}
	}
}
