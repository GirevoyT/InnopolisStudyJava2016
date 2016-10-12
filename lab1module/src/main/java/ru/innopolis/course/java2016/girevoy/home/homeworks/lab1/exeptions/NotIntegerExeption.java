package ru.innopolis.course.java2016.girevoy.home.homeworks.lab1.exeptions;

/**
 * Created by Arxan on 12.10.2016.
 */
public class NotIntegerExeption extends Exception {
	private int fileString;
	private String fileName;

	public NotIntegerExeption(String message, int fileString, String fileName) {
		super(message);
		this.fileString = fileString;
		this.fileName = fileName;
	}

	@Override
	public void printStackTrace() {
		System.err.println("Ошибка в файле " + fileName + ", строке " + fileString);
		super.printStackTrace();
	}
}
