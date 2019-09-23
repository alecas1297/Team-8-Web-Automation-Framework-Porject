package Common;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class CommonAPI {

    public static WebDriver driver = null;

    @BeforeMethod
    public void setUP(URL moduleName) {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\aleja\\OneDrive\\Desktop\\Web Automation Framework Project\\Generic\\Browser-Driver\\Chrome\\77.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(25,TimeUnit.SECONDS);
        driver.manage().window().maximize();

        switch(moduleName){

        }
    }
    @AfterMethod
    public void cleanUp() {
        driver.quit();
    }

    //Helper Methods
    public void clickOnElement(String locator){
        try {
            driver.findElement(By.cssSelector(locator)).click();
        }catch (Exception ex){
            try {
                driver.findElement(By.className(locator)).click();
            }catch (Exception ex2) {
                try {
                    driver.findElement(By.id(locator)).click();
                } catch (Exception ex3) {
                    driver.findElement(By.xpath(locator)).click();
                }
            }
        }
    }
    public void typeOnElement(String locator, String value){
        try {
            driver.findElement(By.cssSelector(locator)).sendKeys(value);
        }catch (Exception ex){
            driver.findElement(By.id(locator)).sendKeys(value);
        }
    }
    public static void typeOnElementNEnter(String locator, String value) {
        try {
            driver.findElement(By.cssSelector(locator)).sendKeys(value, Keys.ENTER);
        } catch (Exception ex1) {
            try {
                System.out.println("First Attempt was not successful");
                driver.findElement(By.name(locator)).sendKeys(value, Keys.ENTER);
            } catch (Exception ex2) {
                try {
                    System.out.println("Second Attempt was not successful");
                    driver.findElement(By.xpath(locator)).sendKeys(value, Keys.ENTER);
                } catch (Exception ex3) {
                    System.out.println("Third Attempt was not successful");
                    driver.findElement(By.id(locator)).sendKeys(value, Keys.ENTER);
                }
            }
        }
    }



}
