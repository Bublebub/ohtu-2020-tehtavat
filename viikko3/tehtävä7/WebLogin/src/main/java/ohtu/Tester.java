package ohtu;

import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Tester {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("http://localhost:4567");
        
        sleep(2);
        
        //Creating a new account
        WebElement element = driver.findElement(By.linkText("register new user"));
        element.click();
        
        sleep(2);
        
        Random r = new Random();
        element = driver.findElement(By.name("username"));
        element.sendKeys("nimi"+r.nextInt(100000));
        element = driver.findElement(By.name("password"));
        element.sendKeys("test");
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys("test");
        
        sleep(2);
        
        WebElement sign = driver.findElement(By.name("signup"));
        sign.click();
        
        sleep(2);
        
        //Logout after a new signup
        WebElement linkToApp = driver.findElement(By.linkText("continue to application mainpage"));
        linkToApp.click();
        
        sleep(2);
        
        WebElement logout = driver.findElement(By.linkText("logout"));
        logout.click();
        
        /*
        //-------------------------------------------------------------
        
        //Failed login: Correct username, wrong password
        WebElement element = driver.findElement(By.linkText("login"));
        element.click();
        
        sleep(2);
        
        element = driver.findElement(By.name("username"));
        element.sendKeys("pekka");
        element = driver.findElement(By.name("password"));
        element.sendKeys("akke");
        element = driver.findElement(By.name("login"));
        
        sleep(2);
        element.submit();
        
        //-------------------------------------------------------------
        
        //Original code
        WebElement element = driver.findElement(By.linkText("login"));
        element.click();

        sleep(2);

        element = driver.findElement(By.name("username"));
        element.sendKeys("pekka");
        element = driver.findElement(By.name("password"));
        element.sendKeys("akkep");
        element = driver.findElement(By.name("login"));
        
        sleep(2);
        element.submit();

        */
        
        sleep(3);
        
        driver.quit();
    }
    
    private static void sleep(int n){
        try{
            Thread.sleep(n*1000);
        } catch(Exception e){}
    }
}
