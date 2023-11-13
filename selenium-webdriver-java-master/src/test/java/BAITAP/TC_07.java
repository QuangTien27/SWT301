/*
1. Go to http://live.techpanda.org/

2. Click on My Account link

3. Login in application using previously created credential

4. Click on 'My Orders'

5. Click on 'View Order'

6. Click on 'Print Order' link
 */
package BAITAP;

import POM.LoginPage;
import driver.driverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

import java.io.File;

public class TC_07 {
    @Test
    public void testTC07(){
        String email = "tiennguyen123@gmail.com";
        String password = "123456";
        int scc = 0;
        WebDriver driver = driverFactory.getChromeDriver();
        LoginPage loginPage = new LoginPage(driver);
        try {
            //1. Go to http://live.techpanda.org/
            driver.get("http://live.techpanda.org/");
            //2. Click on my account link
            loginPage.clickMyAccountLink();
            //3. Login in application using previously created credential
            loginPage.enterEmail(email);
            loginPage.enterPassword(password);
            Thread.sleep(2000);
            loginPage.clickLoginButton();
            Thread.sleep(2000);
            //4. Click on 'My Orders'
            driver.findElement(By.linkText("MY ORDERS")).click();
            Thread.sleep(2000);
            //5. Click on 'View Order'
            driver.findElement(By.xpath("(//a[contains(text(),'View Order')])[1]")).click();
            Thread.sleep(2000);
            //6. Click on 'Print Order' link
            driver.findElement(By.xpath("(//a[normalize-space()='Print Order'])[1]")).click();
            Thread.sleep(2000);
            for (String handle : driver.getWindowHandles()) {
                driver.switchTo().window(handle);
            }
            Thread.sleep(200);
            scc = (scc+1);
            TakesScreenshot screenshot =((TakesScreenshot)driver);
            File srcFile= screenshot.getScreenshotAs(OutputType.FILE);
            String png =("C:\\Users\\Admin\\Documents\\GitHub\\SWT301\\selenium-webdriver-java-master\\src\\test\\resources\\png\\TC07_" + scc +".png");
            FileHandler.copy(srcFile, new File(png));
        } catch (Exception e) {
            e.printStackTrace();
        }
        driver.quit();
    }
}
