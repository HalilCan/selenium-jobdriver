import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.firefox.FirefoxDriver;

class JapeTestsFundamentals {

    @Test
    void siteHeaderIsOnHomePage() {
        WebDriver driver;
        //Firefox's geckodriver requires this:
        System.setProperty("webdriver.gecko.driver","\\Users\\HCM\\eclipse-workspace\\selenium-jobscraper\\geckodriver-v0.21.0-win64\\geckodriver.exe");
        
        driver = new FirefoxDriver();
        driver.get("http://saucelabs.com");
        WebElement header = driver.findElement(By.id("site-header"));
        Assertions.assertTrue(header.isDisplayed());
        driver.close();
    }
    
    @Test
    void JapeSiteHeaderIsOnHomePage() {
        Jape jape = new Jape();
        Assertions.assertTrue(jape.isElementDisplayedByID("navwrapper"));
    }

}
