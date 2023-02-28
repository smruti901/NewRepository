package org.tyss.genericUtility;

import org.openqa.selenium.remote.RemoteWebDriver;

public class ThreadSafeClass {
	
	private static ThreadLocal<RemoteWebDriver> driver= new ThreadLocal<>();

	public static RemoteWebDriver getDriver() {
		return driver.get();
	}

	public static void setDriver(RemoteWebDriver actdriver) {
		driver.set(actdriver);
	}
	
	

}
