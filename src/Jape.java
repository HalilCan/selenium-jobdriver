import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.gargoylesoftware.htmlunit.javascript.host.Console;

import java.awt.List;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Jape {
    private WebDriver _driver;
    private String workingDirectory;
    private WebDriverWait _wait;

    public Jape() {
        // TODO: REMEMBER THE NEWS READER!
        this("http://sciencedaily.com");
    }

    public Jape(String address) {
        this.workingDirectory = Paths.get(".").toAbsolutePath().normalize().toString();
        // Firefox's geckodriver requires this:
        System.setProperty("webdriver.gecko.driver",
                this.workingDirectory + "\\\\geckodriver-v0.21.0-win64\\geckodriver.exe");

        this._driver = new FirefoxDriver();
        _driver.get(address);

        // _wait = new WebDriverWait(_driver, new TimeSpan(0, 1, 0));
    }

    boolean isElementDisplayedByID(String elementId) {
        WebElement header = _driver.findElement(By.id(elementId));
        return header.isDisplayed();
    }

    void closeDriver() {
        _driver.close();
    }

    void get(String address) {
        _driver.get(address);
    }

    boolean scrapeFromSource(String sourcepath) {
        SourceReader sr = new SourceReader(
                "\\Users\\HCM\\eclipse-workspace\\selenium-jobscraper\\sources\\uni-sources.csv");
        ArrayList<String> sourceList = sr.getSourceList();

        ArrayList<String> totalMatches = new ArrayList<String>();
        ArrayList<String> currentMatches = new ArrayList<String>();
        String outputString = "";

        for (int i = 1; i < sourceList.size(); i += 2) {
            this.get(sourceList.get(i));
            ;
            if ((currentMatches = getLinksWithStrings("2019")).size() > 0) {
                totalMatches.addAll(currentMatches);
                currentMatches.clear();
            }
        }

        for (int j = 0; j < totalMatches.size(); j++) {
            String cur = totalMatches.get(j);
            System.out.println(cur);
            if (cur == "Domain:") {
                outputString += "\n Domain: ";
            } else {
                outPutString += cur;
                outPutString += ",";
            }

        }

        // TODO: SourceWriter should be implemented separately.

    }

    ArrayList<String> getLinksWithStrings(String filter) {
        ArrayList<String> matchList = new ArrayList<String>();
        java.util.List<WebElement> matches = _driver.findElements(
                By.xpath("//a[contains(text(),'Intern')] | //a[contains(text(), 'Internship')]"));
        if (matches != null) {
            try {
                matchList.add("Domain");
                matchList.add(getDomainName(_driver.getCurrentUrl()));
                matchList.addAll(filterElementsByString(matches, filter));
                return matchList;
            } catch (URISyntaxException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                return null;
            }
        } else {
            return null;
        }
    }

    ArrayList<String> filterElementsByString(java.util.List<WebElement> matches, String filter) {
        ArrayList<String> links = new ArrayList<String>();
        for (WebElement wb : matches) {
            if (wb.getText().contains(filter)) {
                links.add(wb.getText());

                String fullHref = _driver.getCurrentUrl();
                fullHref += wb.getAttribute("href");
                links.add(fullHref);
            }
        }
        return links;
    }

    String getDomainName(String url) throws URISyntaxException {
        URI uri = new URI(url);
        String domain = uri.getHost();
        return domain.startsWith("www.") ? domain.substring(4) : domain;
    }

    void outputMatches(Map<String, String> links) {

    }

    /*
     * WebElement Email = driver.findElement(By.cssSelector("input[id=email]"));
     * Email.SendKeys("hello@sampleemail.com"); WebElement ele3 =
     * driver.findElement(By.cssSelector(".submit.primary-btn"));
     * 
     * It will find input tag which contains 'id' attribute containing 'mai' text.
     * Email contains 'mai' css=input[id*='mai']
     * 
     * XPath contains xpath=//a[contains(text(),'Software Engineer, Intern 2019')]
     * 
     * First it will find Form tag following remaining path to locate child node.
     * css=form>label>input[id=PersistentCookie]
     * 
     * It will try to locate "input" tag where another "input" tag is present on
     * page. the below example will select third input adjacent tag. css=input +
     * input + input
     * 
     * I often use "contains", but there are more. Here are some examples:
     * 
     * multiple condition: //div[@class='bubble-title' and contains(text(),
     * 'Cover')]
     * 
     * partial match: //span[contains(text(), 'Assign Rate')]
     * 
     * starts-with: //input[starts-with(@id,'reportcombo')
     * 
     * value has spaces: //div[./div/div[normalize-space(.)='More Actions...']]
     * 
     * sibling: //td[.='LoadType']/following-sibling::td[1]/select"
     * 
     * more complex://td[contains(normalize-space(@class), 'actualcell
     * sajcell-row-lines saj-special x-grid-row-collapsed')]
     * 
     * 
     * The commands
     * 
     * The JavaScript command line provided by the Web Console offers a few built-in
     * helper functions that make certain tasks easier.
     * 
     * $() Looks up a CSS selector string, returning the first element that matches.
     * Equivalent to document.querySelector() or calls the $ function in the page,
     * if it exists.
     * 
     * $$() Looks up a CSS selector string, returning an array of DOM nodes that
     * match. This is like for document.querySelectorAll(), but returns an array
     * instead of a NodeList.
     * 
     * $0 The currently-inspected element in the page.
     * 
     * $_ Stores the result of the last expression executed in the console's command
     * line. For example, if you type "2+2 <enter>", then "$_ <enter>", the console
     * will print 4.
     * 
     * $x() Evaluates an XPath expression and returns an array of matching nodes.
     * 
     * keys() Given an object, returns a list of the keys (or property names) on
     * that object. This is a shortcut for Object.keys.
     * 
     * values() Given an object, returns a list of the values on that object; serves
     * as a companion to keys().
     * 
     * clear() Clears the console output area.
     * 
     * inspect() Given an object, opens the object inspector for that object.
     * 
     * pprint() Formats the specified value in a readable way; this is useful for
     * dumping the contents of objects and arrays.
     */

}
