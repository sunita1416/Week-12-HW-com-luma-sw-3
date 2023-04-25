package testsuite;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utilities.Utility;

public class GearTest extends Utility {
    String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
       // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @Test
    public void userShouldAddProductSuccessFullyToShoppingCart() throws InterruptedException {
        //Mouse Hover on Gear Menu

        mouseHoverOnElement(By.xpath("//a[@id='ui-id-6']"));

        clickOnMouseHoverOnElement(By.xpath("//span[contains(text(),'Bags')]"));

        clickOnMouseHoverOnElement(By.xpath("//a[normalize-space()='Overnight Duffle']"));

        verifyActualAndExpectedText(By.xpath("//span[contains(text(),'Overnight Duffle')]"), "Overnight Duffle");

        driver.findElement(By.xpath("//input[@id='qty']")).clear();

        sendTextToElement(By.xpath("//input[@id='qty']"), "3");

        clickOnMouseHoverOnElement(By.xpath("//span[contains(text(),'Add to Cart')]"));

        verifyActualAndExpectedText(By.xpath("//body/div[1]/main[1]/div[1]/div[2]/div[1]/div[1]/div[1]"),"You added Overnight Duffle to your shopping cart.");

        clickOnMouseHoverOnElement(By.xpath("//header/div[2]/div[1]/a[1]"));

        driver.findElement(By.xpath("//a[normalize-space()='shopping cart']")).click();

        Thread.sleep(2000);
        sendTextToElement(By.cssSelector("td[class='col qty'] input[class*='input-text qty']"), Keys.DELETE + "5");

        clickOnMouseHoverOnElement(By.xpath("//span[contains(text(),'Update Shopping Cart')]"));

    }
    public void closeBrowser(){
        driver.close();



    }


    }
