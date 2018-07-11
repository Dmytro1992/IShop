package number_2;

import java.io.File;
import java.sql.Date;
import java.util.Scanner;

public class FindFile implements Runnable{
	public static int chek = 0;
	private static File file;
	private static String name;
	public static void main(String[] args) {
		Thread th = new Thread(new FindFileOll(), "FindFileOll");
		nameFind();
		
		try{
			th.start();
			find();
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}	
	public static void find() {
		synchronized (file){
		File[] dList = file.listFiles();
		if(dList == null){
			throw new NullPointerException("Директория "+file + " не существует");
		}
		for (int i = 0; i < dList.length/2; i++) {
			if (dList[i].getName().equalsIgnoreCase(name)) {
				print(dList[i]);
			}
			if (dList[i].isDirectory()) {
				directory(dList[i], name);
			}if(chek == 0 && i == dList.length-1){
				System.out.println("Файл не найден");
			}
		}
	}
	}
	private static void nameFind() {
		Scanner read = new Scanner(System.in);
		System.out.println("Введите директорию для поиска: ");
		file = new File(read.nextLine().toUpperCase()+":\\");
		System.out.println("Введите имя файла: ");
		name = read.nextLine();
	}

	private static void directory(File file, String name) {
		File[] dList;
		dList = file.listFiles();
		if (dList != null) {
			for (int i = 0; i < dList.length; i++) {
				if (dList[i].getName().equalsIgnoreCase(name)) {
					print(dList[i]);
				}
				if (dList[i].isDirectory()) {
					directory(dList[i], name);
				}
			} 
		}

	}
	private static void print (File dList){
		float a = (float) dList.length() / (1024 * 1024);
		String format = String.format("%.3f", a);
		System.out.println(dList + "   " + "\n" + format + " mb");
		System.out.println("lastModified: " + new Date(dList.lastModified()));
		System.out.println(System.nanoTime()/1e-9);
		System.out.println();
		chek++;
	}

	public void run() {
		synchronized (file){
		File[] dList = file.listFiles();
		if(dList == null){
			throw new NullPointerException("Директория "+file + " не существует");
		}
		for (int i = dList.length/2; i < dList.length; i++) {
			if (dList[i].getName().equalsIgnoreCase(name)) {
				print(dList[i]);
			}
			if (dList[i].isDirectory()) {
				directory(dList[i], name);
			}if(chek == 0 && i == dList.length-1){
				System.out.println("Файл не найден");
			}
		}
	}	
	}
}