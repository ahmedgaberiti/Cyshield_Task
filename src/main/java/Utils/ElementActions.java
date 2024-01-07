package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ElementActions {

    public WebDriver driver;
    WebDriverWait wait;

    WebElement element = null;

    public ElementActions(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver,Duration.ofSeconds(10));
    }

    public boolean checkIfElementDisplayed(By locator) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(locator));
            element = driver.findElement(locator);
            System.out.println(locator + " displayed");
            return true;
        } catch (Exception exception) {
            System.out.println(locator + " is not displayed");
        }
        return false;
    }

    public void clickOnElement(By locator) {
        try {
            if (checkIfElementDisplayed(locator))
                element.click();
            System.out.println(locator + " clicked");
        } catch (Exception exception) {
            System.out.println(locator + " is not clicked");
        }
    }

    public void addTextToField(By locator, String text) {
        try {
            if (checkIfElementDisplayed(locator)) {
                element.clear();
                element.sendKeys(text);
                System.out.println(text + " added successfully");
            }
        } catch (Exception exception) {
            System.out.println(text + "  not added");
        }
    }

    public void scrollToElement(By locator) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement element = driver.findElement(locator);
        js.executeScript("arguments[0].scrollIntoView();", element);
    }
}
