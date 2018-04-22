package test;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ESCLoginSpam {
		
	public static void main(String[] args) throws InterruptedException {	
		Random random = new Random();
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Yu Jin\\Desktop\\Assignments 2nd half\\Lib\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		String weblink = "https://sutd-chat.herokuapp.com/";
		driver.get(weblink);
		
		WebElement username = driver.findElement(By.name("user"));
		WebElement password = driver.findElement(By.name("password"));
		String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		while (true) {
		username.clear();
		password.clear();
//		StringBuilder a = new StringBuilder();
		
//		int ran1 =random.nextInt(10);
		
//		for (int i = 0; i < ran1 + 5; i++ ) {
//			a.append(chars.charAt(random.nextInt(62)));
//		}
//		String astring = a.toString();
		
		StringBuilder b = new StringBuilder();
		int ran2 =random.nextInt(12);
		for (int i = 0; i < ran2 + 8; i++ ) {
			b.append(chars.charAt(random.nextInt(62)));
		}
		String bstring = b.toString();
		
		username.sendKeys("TriEightz");
		password.sendKeys(bstring);
		password.submit();
		try {
		WebDriverWait wait = new WebDriverWait(driver, 3);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("item-list__main")));
		} catch (Exception e) {
			continue;
		}
		
		System.out.println("Logged In");
		}
		
	}
}
