package com.selenium.framework;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Web_SaveTxtFile {

	public static void SaveTxt(String SaveString,String SavePath) {
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;

		try {
			File file = new File(SavePath);
			if (!file.exists()) {
				file.createNewFile();
			}
			fos = new FileOutputStream(file);
			bos = new BufferedOutputStream(fos);
			bos.write(SaveString.getBytes());
			bos.flush();
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bos.close();
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
	
}
