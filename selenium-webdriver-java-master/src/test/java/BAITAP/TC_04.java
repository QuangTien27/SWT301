/*

Test Steps:

1. Go to http://live.techpanda.org/

2. Click on -> MOBILE -> menu

3. In mobile products list , click on -> Add To Compare -> for 2 mobiles (Sony Xperia & Iphone)

4. Click on -> COMPARE -> button. A popup window opens

5. Verify the pop-up window and check that the products are reflected in it Heading "COMPARE PRODUCTS" with selected products in it.

6. Close the Popup Windows

*/
package BAITAP;

import driver.driverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import java.io.File;

public class TC_04 {
    @Test
    public static void testTC04(){
        StringBuffer verificationErrors = new StringBuffer();
        WebDriver driver = driverFactory.getChromeDriver();
        try{
            //1. Go to http://live.techpanda.org/
            driver.get("http://live.techpanda.org/");
            //2. Click on -> MOBILE -> menu
            driver.findElement(By.linkText("MOBILE")).click();
            Thread.sleep(2000);
            //3. In mobile products list , click on -> Add To Compare -> for 2 mobiles (Sony Xperia & Iphone)
            driver.findElement(By.xpath("(//a[@class='link-compare'][normalize-space()='Add to Compare'])[2]")).click();
            String compare1 = driver.findElement(By.linkText("SONY XPERIA")).getText();
            driver.findElement(By.xpath("(//a[@class='link-compare'][normalize-space()='Add to Compare'])[3]")).click();
            String compare2 = driver.findElement(By.linkText("IPHONE")).getText();
            System.out.println("Compare phone1: " + compare1);
            System.out.println("Compare phone2: " + compare2);
            //4. Click on -> COMPARE -> button. A popup window opens
            driver.findElement(By.xpath("(//button[@title='Compare'])[1]")).click();
            Thread.sleep(2000);
            //5. Verify the pop-up window and check that the products are reflected in it Heading "COMPARE PRODUCTS" with selected products in it.
            // Switch to the new window.
            for (String handle : driver.getWindowHandles()) {
                driver.switchTo().window(handle);
            }
            String demoSite = driver.findElement(By.cssSelector("h1")).getText();
            System.out.println("Header: " + demoSite);
            try{
                AssertJUnit.assertEquals("COMPARE PRODUCTS",demoSite);
            } catch (Exception e) {
                verificationErrors.append(e.toString());
            }
            Thread.sleep(2000);
            String popup1 = driver.findElement(By.xpath("//h2/a[@title='Sony Xperia']")).getText();
            String popup2 = driver.findElement(By.xpath("//h2/a[@title='IPhone']")).getText();
            System.out.println("Popup phone1: " + popup1);
            System.out.println("Popup phone2: " + popup2);
            AssertJUnit.assertEquals(compare1,popup1);
            AssertJUnit.assertEquals(compare2,popup2);
            //6. Close the Popup Windows
            driver.close();
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        driver.quit();
    }
}
