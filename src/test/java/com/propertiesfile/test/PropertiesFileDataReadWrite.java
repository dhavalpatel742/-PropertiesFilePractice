package com.propertiesfile.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class PropertiesFileDataReadWrite {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		Properties prop = new Properties();
		FileInputStream f = new FileInputStream("C:\\Selenium_Workspace\\PropertiesFilePractice\\src\\"
												+"test\\java\\config.properties");
		prop.load(f);
		WebDriver driver = null;
		
		System.out.println("Browser is : "+prop.getProperty("browser"));
		String browsername = prop.getProperty("browser");
		
		if(browsername.equals("firefox")) {
			
			System.setProperty("webdriver.gecko.driver", "C:\\SeleniumJars\\geckodriver.exe");
			driver = new FirefoxDriver();
			
		}
		else {
			System.out.println("Browser selection error");
		}
		
		driver.get(prop.getProperty("url"));
		driver.findElement(By.id(prop.getProperty("login_id"))).sendKeys(prop.getProperty("username"));
		driver.findElement(By.xpath(prop.getProperty("password_xpath"))).sendKeys(prop.getProperty("password"));
		driver.findElement(By.xpath(prop.getProperty("login_button_xpath"))).click();
		
		prop.setProperty("close_message", "all done");
		
		FileOutputStream fo = new FileOutputStream("C:\\Selenium_Workspace\\PropertiesFilePractice\\src\\"
												+"test\\java\\config.properties");
		prop.store(fo, "close message added");
		

	}

}
