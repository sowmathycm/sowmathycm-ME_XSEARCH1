
package apTests;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
//Selenium Imports
import java.util.logging.Level;
import javax.lang.model.util.ElementScanner6;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.SourceType;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.BrowserType;
///
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class TestCases {
    RemoteWebDriver driver;

    public TestCases() throws MalformedURLException {
        System.out.println("Constructor: TestCases");

        final DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName(BrowserType.CHROME);
        driver = new RemoteWebDriver(new URL("http://localhost:8082/wd/hub"), capabilities);


        // Set browser to maximize and wait
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    public void endTest() {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    public void testCase01() {
        System.out.println("Start Test case: testCase01");
        driver.get("https://www.amazon.in/");
        String currentURL = driver.getCurrentUrl();
        String expectedTitle = "amazon";
        if(currentURL.contains(expectedTitle)){
            System.out.println("The URL contains the expected title" + " " +expectedTitle);
        }
        else{
            System.out.println("The URL does not contain the expected title" + " " +expectedTitle);
        }
        System.out.println("end Test case: testCase01");
        }
        
    public void testCase02(){
        System.out.println("Start Test case: testCase02");
        driver.get("https://www.amazon.in/");
        WebElement searchbox = driver.findElement(By.id("twotabsearchtextbox"));
        String searchterm = "laptop";
        searchbox.sendKeys(searchterm);
        searchbox.submit();

        List<WebElement> producttitle = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
        List<WebElement> productdesc = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));

        boolean issearchtermfound = false;
        for(int i=0;i<producttitle.size();i++){
            String title = producttitle.get(i).getText();
            String description = productdesc.get(i).getText();

            if(title.toLowerCase().contains("laptop") || description.toLowerCase().contains("laptop")){
                issearchtermfound = true;
                break;
            }
        }
          if(issearchtermfound){
            System.out.println("The search term 'Laptopn was found in search title or descriptions");
          }
          else{
            System.out.println("The search term 'Laptop was not found in search title or descriptions");

          }
          System.out.println("end Test case: testCase02");
        }

        // System.out.println("Searched for the searchterm" + " " +searchterm);
        // String pageSource = driver.getPageSource();
        // boolean issearchtext = pageSource.toLowerCase().contains("Laptop");
        // if(searchtext){
        //     System.out.println("The search term is found " + " " +searchterm);
        // }
        // else{
        //     System.out.println("The search term is not found" + " " +searchterm);
        // }

        // System.out.println("end Test case: testCase02");

        // Assert.assertTrue(issearchtext, "The search term was not found in the page source");
    
     public void testcase03(){
        System.out.println("Start Test case: testCase03");
        driver.get("https://www.amazon.in/");
        String categorylink = "Electronics";
        WebElement category = driver.findElement(By.linkText(categorylink));
        category.click();
        System.out.println("Clicked on the category" + " " +category);
        String currentURL = driver.getCurrentUrl();
        boolean isCategory = currentURL.toLowerCase().contains(categorylink.toLowerCase());
        System.out.println("Current URL " + " " +currentURL);


     }
    }
        
    



