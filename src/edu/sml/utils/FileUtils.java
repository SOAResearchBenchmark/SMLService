package edu.sml.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import edu.sml.service.SMLService;

public class FileUtils {
	
	public static String stringToFile(String input, String fileType) {
		String filePath = SMLService.LOCAL_FILES_PATH+"input."+fileType;
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter(new File(filePath)));
			out.write(input);
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return filePath;
	}

}
