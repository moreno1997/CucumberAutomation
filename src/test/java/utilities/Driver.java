package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class Driver {

    //because it's universal, it will be static
    private static WebDriver driver; //declare this globally,  need to check if it's null, because default value of this is null
    private static String browser = Config.getValue("browser"); //or it can be changed to "firefox"
    //int i; //all global variables have default values.

    public static WebDriver getDriver() { //getter
        if (driver == null) { //if there is any other session, don't open again. (is this the first time it is getting created)
            if (browser.equalsIgnoreCase("chrome")) {
                ChromeOptions co = new ChromeOptions();
                co.addArguments("--remote-allow-origins=*");
                driver = new ChromeDriver(co); //initialize
                driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                driver.manage().window().maximize();
                return driver;
            } else if (browser.equalsIgnoreCase("firefox")) { //checks if it's equal, ignoring the case (chrome => Chrome)
                driver = new FirefoxDriver(); //initialize
                driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                driver.manage().window().maximize();
                return driver;
            } else { //if it's not created, it's already created already, so it will not go back to if statement
                System.out.println("Invalid Browser Type. Launching default browser.");
                driver = new ChromeDriver(); //initialize
                driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                driver.manage().window().maximize();
                return driver;
            }
        } else { //checking if it's null or not
            return driver;
        }
    }

    public static void quitBrowser(){
        // driver.quit(); cannot do this because calling this method without launching it, null pointer exception because no object was created.
        if(driver != null){
            driver.quit();
            driver = null; //to clean up as new, next time C call it, it will launch a new browser
        }
    }
}

