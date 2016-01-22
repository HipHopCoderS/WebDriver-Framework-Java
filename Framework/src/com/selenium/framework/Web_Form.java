package com.selenium.framework;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/*
 * 对窗体页面的操作
 * 
 * */

public class Web_Form extends Web_DriverStart{


	
	// 锁定Iframe
	public static void gotoIframeID(String s) {
		driver.switchTo().frame(s);// ID
	}

	
	public static void gotoIframeIndex(int i) {
		driver.switchTo().frame(i);// Index
	}

	
	public static void gotoIframeEle(WebElement ele) {
		driver.switchTo().frame(ele);// Element
	}

	
	// 从Iframe回到主窗体
	public static void returnIframe() {
		driver.switchTo().defaultContent();
	}

	
	
	// 锁定浏览器打开的新页面
	public static void popupPage() {
		// 获取当前页面的 句柄
		String currentWindow = driver.getWindowHandle();
		// 获取所有页面的句柄
		Set<String> handles = driver.getWindowHandles();

		Iterator<String> it = handles.iterator();
		while (it.hasNext()) {
			String nextHandle = it.next();
			if (currentWindow.equals(nextHandle))
				driver = driver.switchTo().window(nextHandle);

		}
	}

	
	// 获取table中要查询的文本
	private static WebElement getTable(WebElement Row, int cell) {
		List<WebElement> cells;
		WebElement target = null;
		// 列里面有"<th>"、"<td>"两种标签，所以分开处理。
		if (Row.findElements(By.tagName("th")).size() > 0) {
			cells = Row.findElements(By.tagName("th"));
			target = cells.get(cell);
		}
		if (Row.findElements(By.tagName("td")).size() > 0) {
			cells = Row.findElements(By.tagName("td"));
			target = cells.get(cell);
		}
		return target;
	}

	
	public static String getTableText(By by, String tableCellAddress) {
		// 得到table元素对象
		WebElement table = driver.findElement(by);
		// 对所要查找的单元格位置字符串进行分解，得到其对应行、列。
		int index = tableCellAddress.trim().indexOf('.');
		int row = Integer.parseInt(tableCellAddress.substring(0, index));
		int cell = Integer.parseInt(tableCellAddress.substring(index + 1));
		// 得到table表中所有行对象，并得到所要查询的行对象。
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		WebElement theRow = rows.get(row);
		// 调用getCell方法得到对应的列对象，然后得到要查询的文本。
		String text = getTable(theRow, cell).getText();
		return text;

	}

	
}
