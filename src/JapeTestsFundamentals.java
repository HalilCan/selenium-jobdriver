import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.firefox.FirefoxDriver;

class JapeTestsFundamentals {

    //@Test
    void siteHeaderIsOnHomePage() {
        WebDriver driver;
        // Firefox's geckodriver requires this:
        System.setProperty("webdriver.gecko.driver",
                "\\Users\\HCM\\eclipse-workspace\\selenium-jobscraper\\geckodriver-v0.21.0-win64\\geckodriver.exe");

        driver = new FirefoxDriver();
        driver.get("http://saucelabs.com");
        WebElement header = driver.findElement(By.id("site-header"));
        Assertions.assertTrue(header.isDisplayed());
        driver.close();
    }

    //@Test
    void JapeSiteHeaderIsOnHomePage() {
        Jape jape = new Jape();
        Assertions.assertTrue(jape.isElementDisplayedByID("navwrapper"));
        jape.closeDriver();
    }

    //@Test
    void JapeAirbnbBase() {
        SourceReader sr = new SourceReader(
                "\\Users\\HCM\\eclipse-workspace\\selenium-jobscraper\\sources\\uni-sources.csv");
        ArrayList<String> sourceList = sr.getSourceList();
        String link = sourceList.get(1);

        Jape jape = new Jape();
        jape.get(link);
        
        Assertions.assertTrue(jape.isElementDisplayedByID("header"));
        //interestingly, Airbnb has an invisible header with id "smart-banner" that jape couldn't find.
        jape.closeDriver();
    }
    
    @Test
    void JapeAirbnbFull() {
        String sourcepath = "\\Users\\HCM\\eclipse-workspace\\selenium-jobscraper\\sources\\uni-sources.csv";
        Jape jape = new Jape();
        
        boolean result = jape.scrapeFromSource(sourcepath);
        Assertions.assertTrue(result);
        
        jape.closeDriver();
    }
    

}
