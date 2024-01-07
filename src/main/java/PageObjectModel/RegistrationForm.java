package PageObjectModel;

import Utils.ElementActions;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegistrationForm {
    public WebDriver driver;
    WebDriverWait wait;
    ElementActions actions;

    public RegistrationForm(WebDriver driver) {
        this.driver = driver;
        actions = new ElementActions(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private final By userIdField = By.xpath("//input[@name='userid']");
    private final By passIdField = By.xpath("//input[@name='passid']");
    private final By usernameField = By.xpath("//input[@name='username']");
    private final By addressField = By.xpath("//input[@name='address']");
    private final By zipField = By.xpath("//input[@name='zip']");

    private final By emailField = By.xpath("//li//input[@name='email']");
    private final By maleField = By.xpath("//input[@value='Male']");
    private final By femaleField = By.xpath("//input[@value='Female']");
    private final By registerBtn = By.xpath("//input[@value='REGISTER']");

    public void selectFromCountryDropDown(String country) {
        Select countryDropDown = new Select(driver.findElement(By.name("country")));
        countryDropDown.selectByVisibleText(country);
    }

    public void addToUserIdField(String text) {
        actions.scrollToElement(userIdField);
        actions.addTextToField(userIdField, text);
    }

    public void addToPassIdField(String text) {
        actions.addTextToField(passIdField, text);
    }

    public void addToUserNameField(String text) {
        actions.addTextToField(usernameField, text);
    }

    public void addToAddressField(String text) {
        actions.addTextToField(addressField, text);
    }

    public void addToZipField(String text) {
        actions.addTextToField(zipField, text);
    }

    public void addToEmailField(String text) {
        actions.addTextToField(emailField, text);
    }

    public void clickOnMaleRadioBtn() {
        actions.clickOnElement(maleField);
    }

    public void clickOnFemaleRadioBtn() {
        actions.clickOnElement(femaleField);
    }

    public void clickOnRegisterBtn() {
        actions.clickOnElement(registerBtn);
    }

    public String getURL() {
        return driver.getCurrentUrl();
    }

    public String getTextOfAlert() {
        Alert alert=driver.switchTo().alert();
        return alert.getText();
    }

    public void dismissAlert(){
        Alert alert=driver.switchTo().alert();
        alert.dismiss();
    }


}
