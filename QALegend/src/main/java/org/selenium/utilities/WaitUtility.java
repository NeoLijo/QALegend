package org.selenium.utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

public class WaitUtility {
public void waitUsingImplicitWait(WebDriver driver)
{
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
}
}
