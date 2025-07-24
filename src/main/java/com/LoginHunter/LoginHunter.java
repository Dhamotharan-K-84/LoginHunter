package com.LoginHunter;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginHunter {

    /**
     * @param args
     */
    /**
     * @param args
     */
    @SuppressWarnings("resource")
	public static void main(String[] args) {

    	Scanner scan = new Scanner(System.in);
    	
    	System.out.println("Enter Login Details......\nEmail \nPassword");
        
        String email = scan.nextLine();
        String pass = scan.nextLine();
        
    	System.setProperty("webdriver.chrome.driver", "S:\\.eclipse\\Selenium\\LoginHunter\\Webdrivers\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        try {
            driver.get("https://practicetestautomation.com/practice-test-login/");
            
            driver.findElement(By.id("username")).sendKeys(email);
            driver.findElement(By.id("password")).sendKeys(pass);
            driver.findElement(By.id("submit")).click();

            String expectedURL = "https://practicetestautomation.com/logged-in-successfully/";
            if (driver.getCurrentUrl().equals(expectedURL)) {
                System.out.println("✔️ Login Successful!");
            } else {
                System.out.println("❌ Login Failed!");
                driver.quit();
                return;
            }

            WebElement heading = driver.findElement(By.tagName("h1"));
            if (heading.getText().contains("Logged In Successfully")) {
                System.out.println("🔍 Search Simulated: Found heading - " + heading.getText());
            } else {
                System.out.println("❌ Search Validation Failed");
            }

            driver.findElement(By.linkText("Log out")).click();
            System.out.println("👋 Logged Out");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
        scan.close();
    }
}
