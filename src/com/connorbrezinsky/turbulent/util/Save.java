package com.connorbrezinsky.turbulent.util;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.connorbrezinsky.codec.CodecUtil;

public class Save {
	private static String home = System.getProperty("user.home");
	private static File save = new File(home + File.separator + "turbulent" + File.separator + "save.txt");

	public static void write() {
		System.out.println(home + File.separator + "turbulent" + File.separator + "save.txt");
		if (!save.exists()) {
			try {
				FileUtils.writeStringToFile(save, CodecUtil.encode("nosave"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void delete() {
		if (save.exists()) {
			try {
				FileUtils.writeStringToFile(save, CodecUtil.encode("nosave"));
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

		return CodecUtil.decode(text.get(0));
	}

	public static void save(int level) {
		String stringToWrite = CodecUtil.encode(String.valueOf(level));
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
