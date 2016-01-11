package com.connorbrezinsky.turbulent.util;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

import org.apache.commons.io.FileUtils;

public class Save {
	
	static File save = new File("save.txt");
	
	
	
	public static void writeSave() {
		if (!save.exists()) {
			try {
				FileUtils.writeStringToFile(save, "nosave");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void deleteSave() {
		if (save.exists()) {
			try {
				FileUtils.forceDelete(save);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static String getSave() {

		
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
			writeSave();
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
