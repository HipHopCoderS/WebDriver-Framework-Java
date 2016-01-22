package com.selenium.framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

/* 
 * webdriver 选择浏览器
 * */

public class Web_DriverStart {

	public static WebDriver driver;

	public static void selectBrowser(String browser) {
		// firefox驱动
		if (browser.equals("firefox")) {
			
			// Fire fox没有默认安装在C盘的时候,先设置Fire fox的安装路径,然后再驱动
			// System.setProperty("webdriver.firefox.bin", "firefox的安装路径");
			System.setProperty("webdriver.firefox.bin", "D:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
			
			// firefox默认安装在C盘的时候
			driver = new FirefoxDriver();
			
		} else if (browser.equals("chrome")) {
			// chrome驱动
			// 将Chromedriver.exe，放在目录下C:\WINDOWS\system32，然后直接驱动
			driver = new ChromeDriver();
			
		} else if (browser.equals("ie")) {
			// ie驱动
			// 将IEDriverServer.exe，放在目录C:\WINDOWS\system32，然后直接驱动
			driver = new InternetExplorerDriver();
			
		}

	}
}
