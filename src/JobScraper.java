import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.firefox.FirefoxDriver;

import java.nio.file.Paths;

public class JobScraper {
    WebDriver browser;
    String workingDirectory;

    public JobScraper() {
        // TODO: REMEMBER THE NEWS READER!
        this("http://sciencedaily.com");
    }

    public JobScraper(String address) {
        this.workingDirectory = Paths.get(".").toAbsolutePath().normalize().toString();
        // Firefox's geckodriver requires this:
        System.setProperty("webdriver.gecko.driver", this.workingDirectory + "\\geckodriver.exe");
        
        this.browser = new FirefoxDriver();
        browser.get(address);
    }
    
    boolean isElementDisplayed(String elementId) {
        WebElement header = browser.findElement(By.id("elementId"));
        return header.isDisplayed();
    }
    
    void closeBrowser() {
        browser.close();        
    }

}
