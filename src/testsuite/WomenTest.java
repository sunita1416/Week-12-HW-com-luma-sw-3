package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.Utility;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WomenTest extends Utility {
    String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyTheSortByProductNameFilter() {
//Navigate to website
        driver.get("https://magento.softwaretestingboard.com/");
        //Mouse Hover on Women Menu
        WebElement womenMenu = driver.findElement(By.xpath("//span[contains(text(),'Women')]"));
        WebElement Tops = driver.findElement(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[2]/nav[1]/ul[1]/li[2]/ul[1]/li[1]/a[1]/span[2]"));
        WebElement Jackets = driver.findElement(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[2]/nav[1]/ul[1]/li[2]/ul[1]/li[1]/ul[1]/li[1]/a[1]/span[1]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(womenMenu).moveToElement(Tops).moveToElement(Jackets).click().build().perform();
        WebElement productName = driver.findElement(By.xpath("//body/div[1]/main[1]/div[3]/div[1]/div[2]/div[3]/select[1]"));
        productName.click();

        // Verify the products name display in alphabetical order
        List<WebElement> products = driver.findElements(By.xpath("//h2[@class='product-name']/a"));
        List<String> productNames = new ArrayList<String>();
        for (WebElement product : products) {
            productNames.add(product.getText());
        }
        List<String> sortedProductNames = new ArrayList<String>(productNames);
        Collections.sort(sortedProductNames);
        if (productNames.equals(sortedProductNames)) {
            System.out.println("Products are sorted by Product Name filter.");
        } else {
            System.out.println("Products are NOT sorted by Product Name filter.");
        }
    }

    @Test
    public void verifyTheSortByPriceFilter() {
        driver.get("https://magento.softwaretestingboard.com/");
        WebElement womenMenu = driver.findElement(By.xpath("//span[contains(text(),'Women')]"));
        WebElement Tops = driver.findElement(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[2]/nav[1]/ul[1]/li[2]/ul[1]/li[1]/a[1]/span[2]"));
        WebElement Jackets = driver.findElement(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[2]/nav[1]/ul[1]/li[2]/ul[1]/li[1]/ul[1]/li[1]/a[1]/span[1]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(womenMenu).moveToElement(Tops).moveToElement(Jackets).click().build().perform();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        WebElement dropDown = driver.findElement(By.id("sorter"));
        Select select = new Select(dropDown);
        select.selectByVisibleText("Position ");
        selectByVisibleTextFromDropDown(By.id("sorter"), "price ");
        select.selectByValue("price");
        //To print the name of 12 price list in console
        List<WebElement> List2 = driver.findElements(By.xpath("//div[@class = 'price-box price-final_price']"));
        for (int i = 0; i < List2.size(); i++) {
            System.out.println(List2.get(i).getText());
            String exp = List2.get(i).getText();
            String actual = List2.get(i).getText();
            Assert.assertEquals("Price not ordered : Low to High  ", exp, actual);
        }
    }

    @After
    public void closeBrowser() {
        driver.close();
    }

    public void clickOnElement(By by) {
        driver.findElement(by).click();


    }
}

































