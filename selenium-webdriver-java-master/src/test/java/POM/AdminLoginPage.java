package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AdminLoginPage {
    WebDriver driver;
    By usernameInputLocator = By.id("username");
    By passwordInputLocator = By.id("login");
    By loginButton = By.xpath("(//input[@title='Login'])[1]");
    public AdminLoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterUsername(String username){
        WebElement usernameElement = driver.findElement(usernameInputLocator);
        usernameElement.clear();
        usernameElement.sendKeys(username);
    }

    public void enterPassword(String password){
        WebElement passwordElement = driver.findElement(passwordInputLocator);
        passwordElement.clear();
        passwordElement.sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

}