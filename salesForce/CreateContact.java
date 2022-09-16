package salesForce;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContact {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions ch=new ChromeOptions();
		ch.addArguments("--disable-notifications");
		ChromeDriver driver=new ChromeDriver(ch);
		driver.get("https://login.salesforce.com/?locale=in");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//enter username
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("ramkumar.ramaiah@testleaf.com");
		//enter password
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Password#123");
		//click login button
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		//Click on toggle menu button from the left corner
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		//Click view All and click Sales from App Launcher
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		//Click view All and click Sales from App Launcher
		driver.findElement(By.xpath("//p[text()='Sales']")).click();
		//Click on Account tab 
		WebElement clc= driver.findElement(By.xpath("//a[@title='Accounts']//span[1]"));
		driver.executeScript("arguments[0].click();",clc);
		
		//Click on New button
		driver.findElement(By.xpath("//div[text()='New']")).click();
		
		
		//Enter 'your name' as account name
		driver.findElement(By.xpath("(//input[@class='slds-input'])[2]")).sendKeys("Shobha");
		//Select Ow1=new Select(Ownership);
		
		WebElement Public = driver.findElement(By.xpath("(//button[@data-value='--None--'])[3]"));
		driver.executeScript("arguments[0].click();",Public);
		driver.findElement(By.xpath("//span[text()='Public']")).click();
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		Thread.sleep(3000);
		String attribute = driver.findElement(By.xpath("//span[contains(@class,'toastMessage')]/a")).getAttribute("title");
        System.out.println(attribute);
      if (attribute.contains("Shobha")) {
           System.out.println("verfied");
           }else {
       System.out.println("not verfied"); }
		
		
		
		
	}
    




}
