package org.pesi.despatt.utils.tooling;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class FileManager {

	/**
	 * Read a content file from filesystem
	 * @param fileName name of file to use
	 * @return a string of the file contents
	 */
	public static String getFileContents(String fileName) {
		Properties properties = new Properties();
		InputStream inputStream = null;
		StringBuilder contents = new StringBuilder();
		String line = null;
		BufferedReader bufferedReader = null;

		try {
			inputStream = new FileInputStream("config.properties");
			properties.load(inputStream);
			String directory = properties.getProperty("filesDir");
			bufferedReader = new BufferedReader(new FileReader(new File(directory + fileName)));
			while ((line = bufferedReader.readLine()) != null) {
				contents.append(line);
			}
		}
		catch (IOException exception) {
			System.out.println("Error reading properties file: " + exception);
		}
		finally {
			if (inputStream != null && bufferedReader != null) {
				try {
					inputStream.close();
					bufferedReader.close();

				}
				catch (IOException exception) {
					exception.printStackTrace();
				}
			}
		}
		return contents.toString();
	}
}
