package week6;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Salesforce2 {
	
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		//disable notifications
		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://login.salesforce.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.id("username")).sendKeys("ramkumar.ramaiah@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Password#123");
		driver.findElement(By.id("Login")).click();
		
		//To Click on toggle menu button from the left corner
		driver.findElement(By.className("slds-r8")).click();
				
	    //To Click view All and click Sales from App Launcher
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		driver.findElement(By.xpath("//p[text()='Manage your sales process with accounts, leads, opportunities, and more']")).click();
				
		//To Click on Opportunity tab 
	    WebElement opportunity =driver.findElement(By.xpath("//a[@title='Opportunities']"));
		driver.executeScript("arguments[0].click();", opportunity);
				
		//To Click on New button
		driver.findElement(By.xpath("//div[@title='New']")).click();
		
		//To Choose Close date as Tomorrow Date
		driver.findElement(By.xpath("(//input[@class='slds-input'])[3]")).sendKeys("10/31/2022", Keys.ENTER);
		
		//To Click on save
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		
		//To Verify the Alert message (Complete this field) displayed for Name and Stage"
		String text = driver.findElement(By.xpath("//div[text()='Complete this field.']")).getText();
		System.out.println(text);
		
		if ("Completed this field" != text) {
			System.out.println("verified");
		}
		
		else {
			System.out.println("Not Verified");
		}
		
		
		
		
	}

	
		
	}


