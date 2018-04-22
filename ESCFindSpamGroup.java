package test;

import java.util.List;
import java.lang.Thread;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ESCFindSpamGroup {
		
	public static void main(String[] args) throws InterruptedException {		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Yu Jin\\Desktop\\Assignments 2nd half\\Lib\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		String weblink = "https://sutd-chat.herokuapp.com/";
		driver.get(weblink);
		
		WebElement username = driver.findElement(By.name("user"));
		WebElement password = driver.findElement(By.name("password"));
		
		username.sendKeys("yujin_goh@gmail.com");
		password.sendKeys("Sutd1234");
		password.submit();
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("item")));
		
		WebElement creategroup = driver.findElement(By.className("item-list")).findElement(By.className("item"));
		creategroup.click();
		
		WebElement messages = driver.findElement(By.name("messages"));
		messages.click();
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("chat-area__footer")));
		
		WebElement text = driver.findElement(By.className("chat-area__footer")).findElement(By.className("chat-area__footer-form"));
		
		
		Actions actions = new Actions(driver);
		actions.moveToElement(text);
		actions.click();
		actions.sendKeys("SOME DATA2");
		actions.build().perform();
		for (int i = 0; i<100000; i++) {
		text.submit();
		}
		
	}
}
