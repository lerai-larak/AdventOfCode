package org.pesi.despatt.utils.tooling;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class FileManager {


	public static String getFileContents(String fileName){
		Properties properties = new Properties();
		InputStream inputStream = null;
		String contents  = null;

		try{
			inputStream = new FileInputStream("config.properties");
			properties.load(inputStream);
			String directory = properties.getProperty("filesDir");
			BufferedReader file = new BufferedReader(new FileReader(new File(directory + fileName)));
			contents = file.readLine();
		}catch (IOException exception){
			System.out.println("Error reading properties file: "+exception);
		} finally {
			if(inputStream != null){
				try{
					inputStream.close();
				}
				catch (IOException exception){
					exception.printStackTrace();
				}
			}
		}
		return contents;
	}

}
