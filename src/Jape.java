import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.firefox.FirefoxDriver;

import java.nio.file.Paths;

public class Jape {
    private WebDriver browser;
    private String workingDirectory;

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
    
    /*
     *  WebElement Email = driver.findElement(By.cssSelector("input[id=email]"));
     *  Email.SendKeys("hello@sampleemail.com");
     *  WebElement ele3 = driver.findElement(By.cssSelector(".submit.primary-btn"));
     *  
     *  It will find input tag which contains 'id' attribute containing 'mai' text. Email contains 'mai'
     *  css=input[id*='mai']
     *  
     *  First it will find Form tag following remaining path to locate child node.
     *  css=form>label>input[id=PersistentCookie] 
     *  
     *  It will try to locate "input" tag where another "input" tag is present on page. the below example will select third input adjacent tag.
     *  css=input + input + input
     */

}
