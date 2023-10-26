/*
Test Steps:

1. Go to the website http://live.techpanda.org/
2. Click on the "MOBILE" menu
3. In the list of all mobiles, read the cost of the Sony Xperia mobile (which is $100)
4. Click on the Sony Xperia mobile
5. Read the Sony Xperia mobile information from the detail page
6. Compare the product value in the list and the details page; they should be equal ($100).
*/

package BAITAP;

import driver.driverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TC02 {

    WebDriver driver;

    @BeforeTest
    public void setup() {
        // Initialize the WebDriver
        driver = driverFactory.getChromeDriver();
    }

    @Test
    public void testTC02() {
        // Step 1: Go to the website
        driver.get("http://live.techpanda.org/");

        // Step 2: Click on the "MOBILE" menu
        WebElement mobileMenu = driver.findElement(By.linkText("MOBILE"));
        mobileMenu.click();

        // Step 3: Read the cost of the Sony Xperia mobile
        WebElement costElement = driver.findElement(By.xpath("//span[contains(text(),'$100.00')]"));
        String cost = costElement.getText();
        System.out.println("Cost of Sony Xperia mobile is: " + cost);

        // Step 4: Click on the Sony Xperia mobile
        WebElement sonyXperiaLink = driver.findElement(By.xpath("//a[@title='Sony Xperia']"));
        sonyXperiaLink.click();

        // Step 5: Read the Sony Xperia mobile information from the detail page
        WebElement detailElement = driver.findElement(By.xpath("//span[@class='h1']"));
        String detailProName = detailElement.getText();
        System.out.println("Sony Xperia mobile from detail page is: " + detailProName);

        // Read the cost of Sony Xperia mobile from the detail page
        WebElement detailElementCost = driver.findElement(By.xpath("//span[@class='price']"));
        String detailcost = detailElementCost.getText();
        System.out.println("Cost of Sony Xperia mobile from detail page is: " + detailcost);

        // Step 6: Compare the product value in the list and detail page
        Assert.assertEquals(cost, detailcost, "Product value in the list and detail page are not equal.");
    }

    @AfterTest
    public void teardown() {
        // Close the WebDriver
        driver.quit();
    }
}
