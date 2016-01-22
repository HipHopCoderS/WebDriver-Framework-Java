package com.selenium.framework;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Web_ScreenShot extends Web_DriverStart {
	
	//设置保存截图路径,保存的名字
	public static void takeScreenShot(String path,String name) {
		
		File scrFile = ((TakesScreenshot) driver)
				.getScreenshotAs(OutputType.FILE);

		try {

			FileUtils.copyFile(scrFile, new File(path,name + "-" + getCurrentDateTime()+".png"));

		} catch (IOException e) {

			e.printStackTrace();

		}
	}

	//获取当前的时间日期，日期格式可以根据需要进行更改
	public static String getCurrentDateTime(){

		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式

		//System.out.println(df.format(new Date()));

		return df.format(new Date());

		}
	
}
