package ru.innopolis.course.java2016.girevoy.home.testWorks.testHello;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by Arxan on 05.10.2016.
 */
public class HelloWorld {
	public static void main(String[] args) {
		lala l1 = new lala();
		lala l2 = new lolo();
		lolo l3 = new lolo();
		System.out.println("" + l1.tt() + l2.tt() + l3.tt());
	}
}
class lala {
	int a = 5;
	public int getA() {
		return this.a;
	}
	public int tt() {
		return getA();
	}
}
class lolo extends lala {
	int a = 3;
	public int getA() {
		return this.a;
	}
}