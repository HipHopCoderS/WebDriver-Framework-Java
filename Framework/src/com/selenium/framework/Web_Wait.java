package com.selenium.framework;

import java.util.concurrent.TimeUnit;


/*
 * 等待操作
 * */
public class Web_Wait extends Web_DriverStart {

	
	// 全局设置等待时间
	public static void waitGlobal(int s) {
		 driver.manage().timeouts().implicitlyWait(s, TimeUnit.SECONDS);
	}
	
	// 线程控制特殊等待
	public static void waitMs(int ms){
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
