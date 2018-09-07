import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.firefox.FirefoxDriver;

class CheckSauceLabsHomePage {

    @Test
    void site_header_is_on_home_page() {
        WebDriver browser;
        //Firefox's geckodriver requires this:
        System.setProperty("webdriver.gecko.driver","\\Users\\HCM\\eclipse-workspace\\selenium-jobscraper\\geckodriver-v0.21.0-win64\\geckodriver.exe");
        
        browser = new FirefoxDriver();
        browser.get("http://saucelabs.com");
        WebElement header = browser.findElement(By.id("site-header"));
        Assertions.assertTrue(header.isDisplayed());
        browser.close();
    }

}
