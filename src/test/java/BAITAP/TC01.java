/*
Test Steps

Step 1. Go to http://live.techpanda.org/
Step 2. Verify Title of the page
Step 3. Click on -> MOBILE -> menu
Step 4. In the list of all mobile, select SORT BY -> dropdown as name
Step 5. Verify all products are sorted by name
*/

package BAITAP;

import driver.driverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TC01 {
    private WebDriver driver;

    @BeforeTest
    public void setup() {
        driver = driverFactory.getChromeDriver();
        driver.get("http://live.techpanda.org/");
    }

    @Test(priority = 1)
    public void verifyTitle() {
        // Step 2. Verify Title of the page
        String expectedTitle = "Home page";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle, "Title verification failed");
    }

    @Test(priority = 2)
    public void clickMobileMenu() {
        // Step 3. Click on -> MOBILE -> menu
        WebElement mobileMenu = driver.findElement(By.linkText("MOBILE"));
        mobileMenu.click();
    }

    @Test(priority = 3)
    public void selectSortByName() {
        // Step 4. In the list of all mobile, select SORT BY -> dropdown as name
        WebElement sortByDropdown = driver.findElement(By.cssSelector("select[title='Sort By']"));
        Select select = new Select(sortByDropdown);
        select.selectByVisibleText("Name");
    }

    @Test(priority = 4)
    public void verifyProductsSortedByName() {
        // Step 5. Verify all products are sorted by name
        WebElement productList = driver.findElement(By.className("products-grid"));
        Assert.assertTrue(isSorted(productList, "h2"), "Products are not sorted by name");
    }

    @AfterTest
    public void cleanup() {
        driver.quit();
    }

    private boolean isSorted(WebElement element, String tag) {
        java.util.List<WebElement> elements = element.findElements(By.tagName(tag));
        String[] arr = new String[elements.size()];
        for (int i = 0; i < elements.size(); i++) {
            arr[i] = elements.get(i).getText();
        }
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1].compareTo(arr[i]) > 0) {
                return false;
            }
        }
        return true;
    }
}
