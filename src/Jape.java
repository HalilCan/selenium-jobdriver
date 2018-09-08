import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.firefox.FirefoxDriver;

import java.nio.file.Paths;

public class Jape {
    WebDriver browser;
    String workingDirectory;

    public Jape() {
        // TODO: REMEMBER THE NEWS READER!
        this("http://sciencedaily.com");
    }

    public Jape(String address) {
        this.workingDirectory = Paths.get(".").toAbsolutePath().normalize().toString();
        // Firefox's geckodriver requires this:
        System.setProperty("webdriver.gecko.driver", this.workingDirectory + "\\\\geckodriver-v0.21.0-win64\\geckodriver.exe");
        
        this.browser = new FirefoxDriver();
        browser.get(address);
    }
    
    boolean isElementDisplayed(String elementId) {
        WebElement header = browser.findElement(By.id(elementId));
        return header.isDisplayed();
    }
    
    void closeBrowser() {
        browser.close();        
    }

}
