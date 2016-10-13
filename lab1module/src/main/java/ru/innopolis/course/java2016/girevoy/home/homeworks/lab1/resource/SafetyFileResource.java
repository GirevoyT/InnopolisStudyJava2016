package ru.innopolis.course.java2016.girevoy.home.homeworks.lab1.resource;

import ru.innopolis.course.java2016.girevoy.home.homeworks.lab1.exeptions.NotIntegerExeption;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by Arxan on 08.10.2016.
 */
public class SafetyFileResource extends Resource<Integer> {

	private final Queue<Integer> queue = new PriorityQueue<>();
	private String fileName;

	/**
	 * Конструктор который открывает файл fileName и заполняет очередь всеми int из него
	 * @param fileName
	 * @param threadGroup
	 */

	public SafetyFileResource(String fileName,ThreadGroup threadGroup) {
		super(threadGroup,"Поток ресурса");
		this.fileName = fileName;
	}

	public void run() {
		try (FileInputStream fileInputStream = new FileInputStream(this.fileName);
			 Scanner scannerString = new Scanner(fileInputStream)) {
			int stringCount = 0;
			stringWhile:
			while (scannerString.hasNextLine()) {
				Scanner scannerInt = new Scanner(scannerString.nextLine());
				stringCount++;
				intWhile:
				while (!this.isInterrupted() && scannerInt.hasNextInt()) {
					Integer tmpInt = scannerInt.nextInt();
					synchronized (queue) {
						queue.add(tmpInt);
					}
					synchronized (this) {
						if (getCountOfListeners() > 0) {
							this.notify();
							takeTheListener();
						}
					}
				}
				if (!this.isInterrupted() && scannerInt.hasNext()) {
					this.getThreadGroup().interrupt();
					new NotIntegerExeption("Ошибка при разборе ресурса (встретилось не число).",stringCount,fileName).printStackTrace();
					break stringWhile;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
			this.getThreadGroup().interrupt();
		} finally {
			compliteResource();
			synchronized (this) {
				if (getCountOfListeners() > 0) {
					this.notifyAll();
				}
			}
		}
	}

	@Override
	/**
	 * Просто проверяем пуста ли очередь
	 */
	public boolean hasNext() {
		synchronized (queue) {          //WARNING! Поподробней про синхронайз. 1. Синхронайз объекта и его поля и их взаимодействие 2. Какую память переносит синхронайз (зависит или нет от монитора)
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
