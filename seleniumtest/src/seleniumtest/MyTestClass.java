package seleniumtest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MyTestClass {
	public static void main(String[] args){
		WebDriver driver = new FirefoxDriver();
		driver.get("http://google.de");
		driver.findElement(By.name("q")).sendKeys("cute kittens");
		driver.findElement(By.name("btnG")).click();
		String i = driver.getCurrentUrl();
		System.out.println(i);
		//driver.close();
	}

}
