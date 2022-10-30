package week6;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Salesforce1 {
	
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
		
		//To Enter Opportunity name as 'Salesforce Automation by Your Name,Get the text and Store it
		driver.findElement(By.xpath("//label[text()='Opportunity Name']/following::input")).sendKeys("Salesforce Automation by Uma", Keys.ENTER);
		String Name = "Salesforce Automation by Uma";
		System.out.println(Name);
		
		//To Choose close date as Today
		driver.findElement(By.xpath("(//input[@class='slds-input'])[3]")).click();
		driver.findElement(By.xpath("//button[contains(@class,'slds-button slds-align_absolute-center')]")).click();
		
		//To Select 'Stage' as Need Analysis
		driver.findElement(By.xpath("//button[contains(@class,'slds-combobox__input slds-input_faux')]")).click();
		driver.findElement(By.xpath("//span[@title='Needs Analysis']")).click();
		
		//To click Save and VerifyOppurtunity Name"
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		String Name1 = driver.findElement(By.xpath("//lightning-formatted-text[text()='Salesforce Automation by Uma']")).getText();
		System.out.println(Name1);
		if ("Name" != Name1) {
			System.out.println("Name verified");
		}
		else {
			System.out.println("Not Verified");
		}
		
		
	}

	
		
	}


