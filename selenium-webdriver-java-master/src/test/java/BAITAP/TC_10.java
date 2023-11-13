package BAITAP;

import POM.AdminLoginPage;
import POM.AdminOrderPage;
import driver.driverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

import javax.swing.*;
import java.io.File;

public class TC_10 {
    @Test
    public void testTC10(){
        String username = "user01";
        String password = "guru99com";
        String orderId = "100021255";
        String fromDate = "11/8/2023";
        String toDate = "11/10/2023";
        WebDriver driver = driverFactory.getChromeDriver();
        try {
            //1. Go to http://live.techpanda.org/
            driver.get("http://live.techpanda.org/index.php/backendlogin");

            //2.  Login the credentials provided
            AdminLoginPage arg = new AdminLoginPage(driver);
            arg.enterUsername(username);
            arg.enterPassword(password);
            arg.clickLoginButton();
            Thread.sleep(4000);

            //3. Go to Sales-> Orders menu
            AdminOrderPage op = new AdminOrderPage(driver);
            for (String handle : driver.getWindowHandles()) {
                driver.switchTo().window(handle);
            }
            op.clickCloseButton();
            Thread.sleep(2000);
            op.clickSalesLink();
            op.clickOrdersLink();
            //4. Input OrderId and FromDate -> ToDate
            op.enterOrderId(orderId);
            Thread.sleep(2000);
            op.enterFromDate(fromDate);
            op.enterToDate(toDate);

            //5. Click Search button
            op.clickSearchButton();
            Thread.sleep(2000);

            //6. Screenshot capture.
            int scc = 0;
            scc = (scc + 1);
            TakesScreenshot screenshot =((TakesScreenshot)driver);
            File srcFile= screenshot.getScreenshotAs(OutputType.FILE);
            String png =("C:\\Users\\Admin\\Documents\\GitHub\\SWT301\\selenium-webdriver-java-master\\src\\test\\resources\\png\\TC10_" + scc +".png");
            FileHandler.copy(srcFile, new File(png));

        } catch (Exception e) {
            e.printStackTrace();
        }
        driver.quit();
    }
}