package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.Utility;

import java.time.Duration;

public class MenTest extends Utility {
    String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

    }

    @Test
    public void userShouldAddProductSuccessFullyToShoppingCart() {
        driver.get("https://magento.softwaretestingboard.com/");
        WebElement menMenu = driver.findElement(By.xpath("//span[contains(text(),'Men')]"));
        WebElement bottoms = driver.findElement(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[2]/nav[1]/ul[1]/li[3]/ul[1]/li[2]/a[1]/span[2]"));
        WebElement pants = driver.findElement(By.xpath("//a[@id='ui-id-23']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(menMenu).moveToElement(bottoms).moveToElement(pants).click().build().perform();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        WebElement label = driver.findElement(By.xpath(" //a[normalize-space()='Cronus Yoga Pant']"));
        WebElement pant = driver.findElement(By.xpath("//div[@id='option-label-size-143-item-175']"));
        actions.moveToElement(label).moveToElement(pant).click().perform();
        WebElement colour = driver.findElement(By.xpath("//div[@id='option-label-color-93-item-49']"));
        actions.click(colour).perform();
        WebElement addToCart = driver.findElement(By.xpath("//li[1]//div[1]//div[1]//div[3]//div[1]//div[1]//form[1]//button[1]//span[1]"));
        actions.click(addToCart).perform();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Assert.assertEquals("Not redirected to login page", "You added Cronus Yoga Pant to your shopping cart.", getTextFromElement(By.xpath("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']")));
        // Click on ‘shopping cart’ Link into message
        WebElement shop = driver.findElement(By.xpath("//a[normalize-space()='shopping cart']"));
        actions.click(shop).perform();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        ///** Verify the text ‘Shopping Cart.’*/
        Assert.assertEquals("Label does not match", "Shopping Cart", getTextFromElement(By.xpath("//span[@class='base']")));
        //**Verify the product name ‘Cronus Yoga Pant’*/
        Assert.assertEquals("name doesn't match", "Cronus Yoga Pant", getTextFromElement(By.xpath("//td[@class='col item']//a[normalize-space()='Cronus Yoga Pant']")));
        //**Verify the product colour ‘Black’*/
        Assert.assertEquals("Colour is not matched", "Black", getTextFromElement(By.xpath("//dd[contains(text(),'Black ')]")));
        //**Verify the product size ‘32’*/
        Assert.assertEquals("Size is not correct", "32", getTextFromElement(By.xpath("//dd[contains(text(),'32 ')]")));
    }

    @After
    public void closeBrowser() {
        driver.close();
    }
}






