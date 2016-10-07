package ru.innopolis.course.java2016.girevoy.home.testHappensBefour;

import ru.innopolis.course.java2016.girevoy.home.testHappensBefour.threads.BigChronoCheckThread;
import ru.innopolis.course.java2016.girevoy.home.testHappensBefour.threads.ChronoThread;
import ru.innopolis.course.java2016.girevoy.home.testHappensBefour.threads.ControllThread;

/**
 * Created by masterlomaster on 07.10.16.
 */
public class TestHappensBefour {
	public static void main(String[] args) {
		ChronoThread chronoThread = new ChronoThread(0);
		chronoThread.start();
		ControllThread controllThread = new ControllThread(chronoThread);

		BigChronoCheckThread thread1 = new BigChronoCheckThread(5);
		BigChronoCheckThread thread2 = new BigChronoCheckThread(7);

		controllThread.addNewBigChronoThread(thread1);
		controllThread.addNewBigChronoThread(thread2);

		chronoThread.start();
	}
}
