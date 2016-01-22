package com.selenium.framework;



import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/*
 * 对键盘,鼠标的操作
 */



public class Web_Keyboard extends Web_DriverStart{

	

	
	public static Actions hardAction = new Actions(driver);

	// 键盘操作
	// 单独按键
	public static void pressKeyboard(Keys k) {
		hardAction.sendKeys(k);
	}
	
	
	public static void pressKeyboard(By by, Keys k) {
		WebElement ele = driver.findElement(by);
		hardAction.sendKeys(ele, k);
	}
	
	public static void pressKeyboard(WebElement ele, Keys k) {
		hardAction.sendKeys(ele, k).perform();
	}
	
	
	// 组合键的使用
	//ALT + F4
	public static void  alt_F4(){
		hardAction.keyDown(Keys.ALT).sendKeys(Keys.F4).keyUp(Keys.ALT).perform();	
	}

	
	
	
	
	
	// 鼠标操作
	//鼠标左键操作
	public static void mouseClick(By by){
		hardAction.click(driver.findElement(by)).perform();
	}
	
	public static void mouseClick(WebElement ele){
		hardAction.click(ele).perform();
	}
	
	//鼠标右键操作
	public static void mouseContextClick(By by){
		hardAction.contextClick(driver.findElement(by)).perform();
	}
	
	public static void mouseContextClick(WebElement ele){
		hardAction.contextClick(ele).perform();
	}
	
	
	//鼠标双击操作
	public static void mouseDoubleClick(By by){
		hardAction.doubleClick(driver.findElement(by)).perform();
	}
	
	public static void mouseDoubleClick(WebElement ele){
		hardAction.doubleClick(ele).perform();;
	}
	
	
	//鼠标拖拽
	public static void mouseDrag(By by1,By by2){
		hardAction.dragAndDrop(driver.findElement(by1), driver.findElement(by2)).perform();
	}
	
	public static void mouseDrag(WebElement ele1,WebElement ele2){
		hardAction.dragAndDrop(ele1,ele2).perform();
	}
	
	
	// 鼠标移动操作
	public static void mouseMove(By by){
		hardAction.moveToElement(driver.findElement(by)).perform();
	}
	
	public static void mouseMove(WebElement ele) {
		hardAction.moveToElement(ele).perform();
	}
	
}
	
