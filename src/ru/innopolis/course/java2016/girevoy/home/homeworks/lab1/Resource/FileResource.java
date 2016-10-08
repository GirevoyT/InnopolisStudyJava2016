package ru.innopolis.course.java2016.girevoy.home.homeworks.lab1.Resource;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by Arxan on 08.10.2016.
 */
public class FileResource extends Resource<Integer> {

	private Queue<Integer> queue = new PriorityQueue<>();


	/**
	 * Конструктор который открывает файл fileName и заполняет очередь всеми int из него
	 * @param fileName
	 * @throws FileNotFoundException
	 */
	public FileResource(String fileName) throws FileNotFoundException {
		new Thread(){						//WARNING! Как ведут себя анонимные классы со сборщиком мусора
			public void run() {
				try (FileInputStream fileInputStream = new FileInputStream(fileName)) {
					Scanner scanner = new Scanner(fileInputStream);
					if (scanner.hasNextInt()) {
						Integer tmpInt = new Integer(scanner.nextInt());
						synchronized (queue) {
							queue.add(tmpInt);			//WARNING! Где красивше проверять на чётность и положительность! (или вообще считавать всё а уже потом проверять ещё и на то что это int
						}
					}
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					compliteResource();
				}
			}
		};

	}

	@Override
	/**
	 * Просто проверяем пуста ли очередь
	 */
	public boolean hasNext() {
		synchronized (queue) {
			return !queue.isEmpty();
		}
	}

	@Override
	/**
	 * Просто возвращаем следующий объект из очереди
	 */
	public Integer next() {
		synchronized (queue) {
			return queue.poll();
		}
	}
}
