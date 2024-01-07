package Base;

import PageObjectModel.HomePage;
import PageObjectModel.RegistrationForm;
import Utils.ElementActions;
import Utils.FilePaths;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.*;

public class BaseWebTest {

    WebDriver driver;

    protected HomePage homePage;
    protected RegistrationForm registrationForm;


    @Parameters("Browser")
    @BeforeTest()
    public void setUPBrowsers(String Browser) {
        if (Browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            System.out.println("chrome is launched");
        } else if (Browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
            System.out.println("firefox is launched");
        }
        homePage=new HomePage(driver);
        registrationForm=new RegistrationForm(driver);
        driver.get(FilePaths.websiteURl);
    }

    @AfterTest
    public void tearDownBrowsers(){
        driver.quit();
    }


}
