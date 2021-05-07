package com.sample.test.demo.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import com.sample.test.demo.TestBase;
import com.sample.test.demo.TestData;

import junit.framework.Assert;


public class DemoTest extends TestData {
	
     
	
	WebDriver driver = new ChromeDriver();
	
	public static void main(String[] args) throws InterruptedException {
		
		DemoTest DM = new DemoTest();
		
//		DM.demoTest();
		DM.Navigate();
		DM.PositiveTestCase();
	
	}

    @Test
    public void demoTest() {
        System.out.println("HELLO WORLD");
    }
    
    
    public void Navigate() throws InterruptedException {
    	driver.navigate().to(url);
    	Thread.sleep(5000);
    }
    
    public void PositiveTestCase() {
    	WebElement ele = driver.findElement(By.id("pizza1Pizza"));
    	Select Pizza1 = new Select(ele);
    	Pizza1.selectByVisibleText(firstPizza);
    
    	WebElement ele2 = driver.findElement(By.xpath("//div[@id='pizza1']//select[@class='toppings1']"));
    	Select pizza1Toppings1 = new Select(ele2);
    	pizza1Toppings1.selectByValue(Tooping1);
    	
    	WebElement ele3 = driver.findElement(By.xpath("//div[@id='pizza1']//select[@class='toppings2']"));
    	Select pizza1Toppings2 = new Select(ele3);
    	pizza1Toppings2.selectByValue(Tooping2);
    	
    	driver.findElement(By.id("pizza1Qty")).sendKeys(Qty);
       	driver.findElement(By.id("name")).sendKeys(Name);
    	driver.findElement(By.id("email")).sendKeys(Emailid);
    	driver.findElement(By.id("phone")).sendKeys(phoneno);
    	
    	driver.findElement(By.id("ccpayment")).click();
    	driver.findElement(By.id("placeOrder")).click();
    	
    	String str= driver.findElement(By.xpath("//div[@id='dialog']/p") ).getText();
    	
        if (str.contains(firstPizza) && str.contains("successfull")){
        	
        	System.out.println("order is placed successfully");
        } 
        else {
        	
        	System.out.println("order is not placed successfully");
        }
    }
        
        public void NegativeTestCase() {
        	WebElement ele = driver.findElement(By.id("pizza1Pizza"));
        	Select Pizza1 = new Select(ele);
        	Pizza1.selectByVisibleText(firstPizza);
        
        	WebElement ele2 = driver.findElement(By.xpath("//div[@id='pizza1']//select[@class='toppings1']"));
        	Select pizza1Toppings1 = new Select(ele2);
        	pizza1Toppings1.selectByValue(Tooping1);
        	
        	WebElement ele3 = driver.findElement(By.xpath("//div[@id='pizza1']//select[@class='toppings2']"));
        	Select pizza1Toppings2 = new Select(ele3);
        	pizza1Toppings2.selectByValue(Tooping2);
        	
        	driver.findElement(By.id("pizza1Qty")).sendKeys(Qty);
           	driver.findElement(By.id("name")).sendKeys(Name);
        	driver.findElement(By.id("email")).sendKeys(Emailid);
        	driver.findElement(By.id("phone")).sendKeys(phoneno);
        	
        	driver.findElement(By.id("ccpayment")).click();
        	driver.findElement(By.id("cashpayment")).click();
        	boolean flag1 = driver.findElement(By.id("ccpayment")).isSelected();
        	boolean flag2 = driver.findElement(By.id("cashpayment")).isSelected();
        	if(flag1==true && flag2==true) {
        		 System.out.println("Should not be select both the payments");
        	}
        	else {
        		System.out.println("Should be able to select the payment");
        	}
        	
            
   
    }
    
    
    
    
    
    
    
    
    
    
    
    
    

}
