/*  Verify Discount Coupon works correctly

Test Case Description:

1. Go to http://live.techpanda.org/

2. Go to Mobile and add IPHONE to cart

3. Enter Coupon Code

4. Verify the discount generated

TestData:  Coupon Code: GURU50

Expected result:

1) Price is discounted by 5%

*/
package BAITAP;

import POM.CartPage;
import driver.driverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class TC_09 {
    @Test
    public void testTC09() {
        String country = "United States";
        String region = "Alabama";
        String zip = "100000";
        String coupon = "GURU50";
        WebDriver driver = driverFactory.getChromeDriver();
        CartPage cartPage = new CartPage(driver);
        try {
            //1. Go to http://live.techpanda.org/
            driver.get("http://live.techpanda.org/");
            //2. Go to Mobile and add IPHONE to cart
            driver.findElement(By.linkText("MOBILE")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("(//button[@title='Add to Cart'])[2]")).click();
            String grandTotal = driver.findElement(By.xpath("(//td[@class='a-right'])[2]")).getText();
            //3. Enter Coupon Code
            cartPage.enterCoupon(coupon);
            cartPage.clickApplyCouponButton();
            Thread.sleep(2000);
            //4. Verify the discount generated
            String couponMsg = driver.findElement(By.xpath("(//li)[13]")).getText();
            System.out.println(couponMsg);
            cartPage.verifyGrandTotal(grandTotal);
        } catch(Exception e) {
            e.printStackTrace();
        }
        driver.quit();
    }
}
