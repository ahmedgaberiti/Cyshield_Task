package Tests;

import Base.BaseAppiumTest;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Random;

public class MobileTests extends BaseAppiumTest {
    Random random = new Random();
    String userID = "userID" + random.nextInt(100);
    String password = "password" + random.nextInt(100);
    String username = "usernameABC";
    String address = "addressAlex";
    String country = "Canada";
    String zip = "12345";
    String email = "email" + random.nextInt(100) + "@gmail.com";

    @Test(priority = 1)
    public void userRegisterSuccessfullyMobile(){
        homePage.clickMenuMobileBtn();
        homePage.clicktestScenarioLinkMobile();
        homePage.clickRegisterLink();
        registrationForm.addToUserIdField(userID);
        registrationForm.addToPassIdField(password);
        registrationForm.addToUserNameField(username);
        registrationForm.addToAddressField(address);
        registrationForm.selectFromCountryDropDown(country);
        registrationForm.addToZipField(zip);
        registrationForm.addToEmailField(email);
        registrationForm.clickOnMaleRadioBtn();
        registrationForm.clickOnRegisterBtn();
        String registerURL = registrationForm.getURL();
        System.out.println(registerURL);
        Assert.assertTrue(registerURL.contains(userID));

    }





}
