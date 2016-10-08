package ru.innopolis.course.java2016.girevoy.home.homeworks.lab1.Resource;

/**
 * Created by Arxan on 08.10.2016.
 */
public abstract class Resource<T> {
	/**
	 * Этот мерод возвращает true если есть следующий объект для возврата методом next()
	 * @return
	 */
	public abstract boolean hasNext();

	/**
	 * Этот метод возвращает следующий объект из ресурса
	 * @return
	 */
	public abstract T next();
	private boolean isComplite;

	/**
	 * Этот метод возвращает статус: обработан ли реурс полностью
	 * @return
	 */
	public boolean isComplite() {
		return isComplite;
	}

	public void compliteResource() {
		isComplite = true;
	}
}
