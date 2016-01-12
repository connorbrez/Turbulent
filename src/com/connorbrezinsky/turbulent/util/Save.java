package com.connorbrezinsky.turbulent.util;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

import org.apache.commons.io.FileUtils;

public class Save {
	
	static File save = new File("turbulent" + File.separator + "save.txt");
	
	//TODO make a save directory instead of saving to the current running directory
	
	public static void write() {
		if (!save.exists()) {
			try {
				FileUtils.writeStringToFile(save, "nosave");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void delete() {
		if (save.exists()) {
			try {
				FileUtils.writeStringToFile(save, "nosave");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static String get() {

		
		List<String> text;

		try {
			text = FileUtils.readLines(save, StandardCharsets.UTF_8);
		} catch (IOException e) {
			text = null;
			e.printStackTrace();
		}

		return text.get(0);
	}

	public static void save(int level) {
		String stringToWrite = String.valueOf(level);
		if (!save.exists()) {
			System.err.print("No save file found, will create one");
			write();
			try {
				FileUtils.writeStringToFile(save, stringToWrite);
				System.out.println("Saving Complete");
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("Save file found, saving..");
			try {
				FileUtils.writeStringToFile(save, stringToWrite);
				System.out.println("Saving Complete");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
