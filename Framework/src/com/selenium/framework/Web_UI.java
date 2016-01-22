package com.selenium.framework;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


/*
 * 对浏览器控件的操作
 * 
 * */


public class Web_UI extends Web_DriverStart {

	
	//元素的操作
	// 获取某个元素
	public static WebElement getEle(By by) {

		WebElement ele;
		ele = driver.findElement(by);
		return ele;

	}

	//获取元素list
	public static List<WebElement> getWebEleList(By by) {

		List<WebElement> eleList = driver.findElements(by);
	
		return eleList;
	}
	
	
	// 判断某个元素是否存在
	public static boolean isExist(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}

	}

	// 等待某元素被找到
	public static WebElement waitEle(int s, By by) {
		WebElement ele;
		ele = new WebDriverWait(driver, s).until(ExpectedConditions
				.presenceOfElementLocated(by));
		return ele;
	}

	
	
	// 获取当前方法名
	public static String runName() {
		String s = new Throwable().getStackTrace()[1].getMethodName();
		return s;
	}

	// 输出自己的方法名
	public static void runOUt() {
		System.out.println(new Throwable().getStackTrace()[1].getMethodName()
				+ "已经运行");

	}

	// 在文本框输入文本
	public static void inputBox(By by, String value) {
		driver.findElement(by).sendKeys(value);
	}

	public static void inputBox(WebElement ele, String value) {
		ele.sendKeys(value);
	}

	// 在文本框清空输入
	public static void clearInput(By by, String value) {
		WebElement ele = driver.findElement(by);
		ele.clear();
		ele.sendKeys(value);

	}

	public static void clearIput(WebElement ele, String value) {
		ele.clear();
		ele.sendKeys(value);
	}

	// 清空文本框
	public static void clearBox(By by) {
		driver.findElement(by).clear();
	}

	// 复选框的选择判断
	// 选中复选框
	public static void checkBoxSelect(By by) {
		WebElement checkbox = driver.findElement(by);
		while (checkbox.isSelected()) {
			checkbox.click();
		}
	}

	public static void checkBoxSelect(WebElement ele) {
		while (ele.isSelected()) {
			ele.click();
		}

	}

	// 取消复选框
	public static void checkBoxCancel(By by) {
		WebElement checkbox = driver.findElement(by);
		while (checkbox.isEnabled()) {
			checkbox.click();
		}
	}

	public static void checkBoxCancel(WebElement ele) {
		while (ele.isEnabled()) {
			ele.click();
		}

	}

	// 点击选择
	public static void clickButton(By by) {
		driver.findElement(by).click();
	}

	// 获取组件文本
	public static String lableString(By by) {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String s = driver.findElement(by).getText();
		return s;
	}

	public static String lableString(WebElement ele) {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String s = ele.getText();
		return s;
	}

	// 比较获取的文本是否包含指定文本 或者是否和指定文本相等
	public static boolean stringEquals(By by, String s1) {
		String s2 = driver.findElement(by).getText();
		if (s2.indexOf(s1) >= 0) {
			return true;
		} else {
			return false;
		}

	}

	public static boolean stringEquals(String s2, String s1) {

		// s2包含s1,或者相等
		if (s2.indexOf(s1) >= 0) {
			return true;
		} else {
			return false;
		}

	}

	public static boolean stringEquals(WebElement ele, String s1) {

		String s2 = ele.getText();
		if (s2.indexOf(s1) >= 0) {
			return true;
		} else {
			return false;
		}
	}

	// 上传文件的操作
	public static void uploadFile(By by, String path) {
		WebElement ele = driver.findElement(by);
		ele.sendKeys(path);
	}

}
