package utilities;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Utility extends BaseTest {

    public void clickOnElement(By by) {
        driver.findElement(by).click(); // this method click on element
    }

    public void sendTextToElement(By by, String text) {
        driver.findElement(by).sendKeys(text); // this method send element to string
    }


    public String getTextElement(By by) {
        return driver.findElement(by).getText(); //get actual message form console
    }
    public void mouseHoverOnElement(By by){
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).perform();
    }
    public void clickOnMouseHoverOnElement(By by) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).click().perform();
    }

    public void selectByVisibleTextFromDropDown(By by, String text) {
        WebElement dropDown = driver.findElement(by);


    }
    public void selectByValueFromDropDown(By by, String text) {
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByValue(text);
    }
    public void selectByIndexFromDropDown(By by, int a) {
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByIndex(a);
    }

    //This method will switch to the alert
    public void switchToAlert() {
        driver.switchTo().alert();
    }

    //This method will accept the alert
    public void acceptAlert() {
        driver.switchTo().alert().accept();
    }

    public void dismissAlert() {
        driver.switchTo().alert().dismiss();
    }

    public void sendKeysToAlert(String text) {
        driver.switchTo().alert().sendKeys(text);
    }
    public String getTextFromElement(By by){
        return driver.findElement(by).getText();
    }

    public void verifyActualAndExpectedText(By by, String expectedText){
        String actualText = getTextFromElement(by);
        Assert.assertEquals(expectedText, actualText);
    }



}








