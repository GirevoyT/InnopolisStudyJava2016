package ru.innopolis.course.java2016.girevoy.home.testWorks.testHello;

import org.omg.CORBA.Object;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by Arxan on 05.10.2016.
 */
public class HelloWorld {
	public static void main(String[] args) {
		new Thread() {
			public void run() {
				System.out.println("123");
			}
		}.start();
		Integer tmp  = 5;
		synchronized (tmp) {
			tmp.notify();
		}
	}
}
