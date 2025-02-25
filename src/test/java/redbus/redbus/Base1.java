package redbus.redbus;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base1 {
    public static String projectPath = System.getProperty("user.dir");
    public static WebDriver driver;
    public static File file;
    public static FileInputStream fis;
    public static Properties p;

    public static void init() throws Exception {
        file = new File(projectPath + "/src/test/resource/data.properties"); 
        fis = new FileInputStream(file);
        p = new Properties();
        p.load(fis);
        System.out.println("Loaded URL: " + p.getProperty("url"));
    }

    public static void launch(String browserKey) {
        String browser = p.getProperty(browserKey); // Get browser name from properties

        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else {
            driver = new EdgeDriver();
        }
    }

    public static void openurl(String url) {
        driver.get(url); // Use URL directly
    }

   /* public static void clandersmalltest(String id, String xpath ,String xpath1) throws InterruptedException {
        driver.findElement(By.id(id)).click();
        String month = driver.findElement(By.xpath(xpath)).getText(); // Directly use xpath
        if (month.contains("apr")) {
        	Thread.sleep(2000);
        	driver.findElement(By.xpath(xpath1)).click();
        	
        }
    }*/
    public static void clandersmalltest(String id, String xpath, String xpathNext) {
    	
        driver.findElement(By.id(id)).click();

        // Wait for the month element to be visible
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        while (true) {
            String month = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath))).getText();
            System.out.println("Current month: " + month);

            if (month.toLowerCase().contains("apr")) {
                
                break;  // Exit loop
            }

            // Click "Next Month" button
           wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathNext))).click();
        }
    

    }
    
   
    public static void main(String[] args) throws Exception {
        init();
        launch("chromebrowser"); // Ensure this key is correct in properties file
        openurl(p.getProperty("url")); // Get the correct key
       
        clandersmalltest("onwardCal", p.getProperty("xpathofmonth"),p.getProperty("xpathfornext"));
        driver.findElement(By.xpath(p.getProperty("xpathfornext"))).click();
       // driver.quit(); // Ensure WebDriver closes
        driver.quit();
    }
}
