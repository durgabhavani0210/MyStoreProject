package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import actionDriver.Action;
import io.github.bonigarcia.wdm.WebDriverManager;
import utility.ExtentManager;

public class BaseClass  {
	public static WebDriver driver;
    public static Properties prop;

    @BeforeTest
    public void loadConfig()
    {

        try {
            prop = new Properties();
            FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "\\Configuration\\Config.properties");
            prop.load(ip);

        }
        catch(FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static void launchApp()
    {

        WebDriverManager.chromedriver().setup();

         String browserName = prop.getProperty("browser");
        if (browserName.equalsIgnoreCase("Chrome"))
        {
            WebDriverManager.chromedriver().setup();

             driver=new ChromeDriver();


        }
        else if (browserName.equalsIgnoreCase("FireFox"))
        {
            WebDriverManager.firefoxdriver().setup();

            driver=new FirefoxDriver();


        }
        else if(browserName.contains("edge"))
        {
            WebDriverManager.edgedriver().setup();

            driver=new EdgeDriver();


        }
        else
        {
                System.out.println("The browser is not there");
        }
        driver.manage().window().maximize();

        driver.get(prop.getProperty("url"));

        driver.manage().deleteAllCookies();



        driver.manage().timeouts().implicitlyWait
        (Integer.parseInt(prop.getProperty("implicitWait")),TimeUnit.SECONDS);

        //PageLoad TimeOuts

        driver.manage().timeouts().pageLoadTimeout
        (Integer.parseInt(prop.getProperty("pageLoadTimeOut")),TimeUnit.SECONDS);
    }

}