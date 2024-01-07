package PageObjectModel;

import Utils.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {


    public WebDriver driver;
    WebDriverWait wait;
    ElementActions actions;

    private final By testScenarioLink=By.xpath("//li[@id='menu-item-58']//a[@href='https://testing.todorvachev.com/category/test-scenarios/' ]");
    private final By testScenarioLinkMobile=By.xpath("(//a[@href='https://testing.todorvachev.com/category/test-scenarios/' ])[1]");

    private final By registerLink=By.xpath("//h3//a[@href='https://testing.todorvachev.com/register-form/' ]");

    private final By menuMobileBtn=By.xpath("//a[@class='slicknav_btn slicknav_collapsed']");


    public HomePage(WebDriver driver) {
        this.driver = driver;
        actions=new ElementActions(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void clickTestScenariosLink(){
        actions.clickOnElement(testScenarioLink);
    }
    public void clickRegisterLink(){
        actions.clickOnElement(registerLink);
    }

    public void clickMenuMobileBtn(){
        actions.clickOnElement(menuMobileBtn);
    }

    public void clicktestScenarioLinkMobile(){
        actions.clickOnElement(testScenarioLinkMobile);
    }





}
