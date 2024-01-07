package Base;

import PageObjectModel.HomePage;
import PageObjectModel.RegistrationForm;
import Utils.FilePaths;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseAppiumTest {

    public AndroidDriver androidDriver;
    protected HomePage homePage;
    protected RegistrationForm registrationForm;

    @BeforeTest
    @Parameters("Mobile")
    public void configureAppium() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("Gaberphone");
        options.setChromedriverExecutable("target/chromedriver.exe");
        options.setCapability("browserName", "Chrome");
        androidDriver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
        homePage = new HomePage(androidDriver);
        registrationForm = new RegistrationForm(androidDriver);
        androidDriver.get(FilePaths.websiteURl);

    }


    @AfterTest
    public void tearDownAppium() {
        androidDriver.quit();
    }


}
