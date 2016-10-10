package ru.innopolis.course.java2016.girevoy.lessons.lesson6.savelyev;

import java.util.Iterator;
import java.util.Map;
import java.util.Random;

import java.util.concurrent.ConcurrentHashMap;

/**
 * 2 вариант
 * Поток A (ThreadA) - каждую секунду гшенерирует от 0-100
 * помещает значение в словать частоты значений
 * изменяет значение таймера,
 * 1 раз в пять секунд будит потокБ
 * условие окончания работы
 * Поток Б (ThraedB)- каждые 5 сек выводит информацию - какое число - сколько раз встретилось
 * Поток Б - выводит если разбужен правильно список значений с их частой
 * Программа останавливается в момент когда какое-то из чисел встретилось не менее 5 раз
 *
 * */
public class Test1Start {
	public static void main(String[] args) {
		HashMapRate <Integer> dictOfIntegers = new HashMapRate<>();
		MyInt timer = new MyInt();
		ThreadA threadA = new ThreadA(dictOfIntegers, timer);
		threadA.start();
		ThreadB threadB = new ThreadB(dictOfIntegers, timer);
		threadB.setDaemon(true);
		threadB.start();
	}
}

class ThreadA extends Thread {
	MyInt timer;
	final static Random random = new Random();

	public ThreadA(HashMapRate<Integer> dictOfIntegers, MyInt timer) {
		this.timer=timer;
		this.dictOfIntegers = dictOfIntegers;
	}

	private HashMapRate <Integer> dictOfIntegers;
	public void run(){
		while (dictOfIntegers.getMaxRate()<5 && !isInterrupted()) {
			dictOfIntegers.put((Integer)random.nextInt(100) );
			try {
				this.sleep (1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			this.timer.setValue(this.timer.getValue()+1);
			if (timer.getValue() %5==0) synchronized (timer){	timer.notifyAll();}
		}
	}
}

class ThreadB extends Thread {
	MyInt timer;
	private HashMapRate <Integer> dictOfIntegers;

	public ThreadB(HashMapRate<Integer> dictOfIntegers,MyInt timer) {
		this.timer = timer;
		this.dictOfIntegers = dictOfIntegers;
		setDaemon(true);
	}

	public void run(){
		while (!isInterrupted()){
			synchronized (timer) {
				while (timer.getValue() %5!=0) {
					try {
						timer.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println();
				System.out.println("Прошло секунд : "+ timer.getValue() +" рандомные числа: ");
				dictOfIntegers.list();
			}
		}
	}
}

/**
 * Map - ключ - частота объекта с данным значением
 * метод put (ключ) - помещает ключ+частота значений, если ключ есть - увеличиваем на 1
 * getMaxRate - возвращает максимальную частоту в map
 */

class HashMapRate <KeyClass> {
	private Map<KeyClass, Integer> worhause = new ConcurrentHashMap<KeyClass, Integer>();

	public int getMaxRate() {
		return maxRate;
	}

	private int maxRate;

	public void put (KeyClass keyObject){
		int rate;
		synchronized (worhause) {
			if (worhause.containsKey(keyObject)) rate = worhause.get(keyObject).intValue();
			else rate = 0;
			rate=rate+1;
			worhause.put(keyObject, (Integer) (rate));
		}
		if (rate>maxRate) maxRate=rate;
	}
	public int get (KeyClass keyObject) {// использовать int или Integer ?
		return worhause.get (keyObject).intValue();
	}

	public void list () {
		Iterator entries = worhause.entrySet().iterator();
		while (entries.hasNext()) {
			Map.Entry thisEntry = (Map.Entry) entries.next();
			Object key = thisEntry.getKey();
			Object value = thisEntry.getValue();
			System.out.println(key.toString()+" встречается "+ value + " раз");
		}
	}

}
class MyInt {

	private int value;

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

}