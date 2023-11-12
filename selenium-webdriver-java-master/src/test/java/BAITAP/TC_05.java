/*
Test Steps:

1. Go to http://live.techpanda.org/

2. Click on my account link

3. Click Create an Account link and fill New User information excluding the registered Email ID.

4. Click Register

5. Verify Registration is done. Expected account registration done.

6. Go to TV menu

7. Add product in your wish list - use product - LG LCD

8. Click SHARE WISHLIST

9. In next page enter Email and a message and click SHARE WISHLIST

10.Check wishlist is shared. Expected wishlist shared successfully.

 */
package BAITAP;

import POM.RegisterPage;
import driver.driverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import java.io.File;
import java.util.Random;

public class TC_05 {
    @Test
    public static void testTC05() {
        int scc=0;
        String firstName = "nhan";
        String lastName = "tran";
        String email_address = "nhantran12@gmail.com";
        String password = "nhan1234";
        String confirmPassword = password;
        WebDriver driver = driverFactory.getChromeDriver();
        RegisterPage registerPage = new RegisterPage(driver);
        try{
            //1. Go to http://live.techpanda.org/
            driver.get("http://live.techpanda.org/");
            //2. Click on my account link
            registerPage.clickMyAccount();
            //3. Click Create an Account link and fill New User information excluding the registered Email ID.
            registerPage.clickCreateAccountLink();

            registerPage.enterFirstName(firstName);
            registerPage.enterLastName(lastName);
            registerPage.enterEmail(email_address);
            registerPage.enterPassword(password);
            registerPage.enterConfirmation(confirmPassword);
            //4. Click Register
            registerPage.clickRegisterButton();
            //5. Verify Registration is done. Expected account registration done.
            String welcome1 = firstName.toUpperCase();
            String welcome2 = lastName.toUpperCase();
            String expectedWelcome = ("WELCOME, " + welcome1 +" "+ welcome2 +"!");
            String actualWelcome = driver.findElement(By.xpath("(//p[@class='welcome-msg'])[1]")).getText();
            System.out.println(actualWelcome);
            AssertJUnit.assertEquals(expectedWelcome, actualWelcome);
            //6. Go to TV menu
            driver.findElement(By.linkText("TV")).click();
            Thread.sleep(2000);
            //7. Add product in your wish list - use product - LG LCD
            driver.findElement(By.xpath("(//a[@class='link-wishlist'][normalize-space()='Add to Wishlist'])[1]")).click();
            Thread.sleep(2000);
            //8. Click SHARE WISHLIST
            driver.findElement(By.xpath("(//button[@title='Share Wishlist'])[1]")).click();
            //9. In next page enter Email and a message and click SHARE WISHLIST
            String wishListEmail = "cus@gmail.com";
            String wishListMsg = "Hello!";
            driver.findElement(By.xpath("(//textarea[@id='email_address'])[1]")).clear();
            driver.findElement(By.xpath("(//textarea[@id='email_address'])[1]")).sendKeys(wishListEmail);
            driver.findElement(By.xpath("(//textarea[@id='message'])[1]")).clear();
            driver.findElement(By.xpath("(//textarea[@id='message'])[1]")).sendKeys(wishListMsg);
            Thread.sleep(2000);
            driver.findElement(By.xpath("(//button[@title='Share Wishlist'])[1]")).click();;
            //10.Check wishlist is shared. Expected wishlist shared successfully.
            String wishListText = driver.findElement(By.xpath("(//li)[20]")).getText();
            System.out.println(wishListText);
            String expectedText = ("Your Wishlist has been shared.");
            AssertJUnit.assertEquals(expectedText,wishListText);
            scc = (scc+1);
            TakesScreenshot screenshot =((TakesScreenshot)driver);
            File srcFile= screenshot.getScreenshotAs(OutputType.FILE);
            String png =("D:\\IdeaProjects\\selenium-webdriver-java-master-nhantdse161743\\src\\test\\resources\\png/TC05_" + scc +".png");
            FileHandler.copy(srcFile, new File(png));
        }catch(Exception e){
            e.printStackTrace();
        }
        driver.quit();
    }
}
