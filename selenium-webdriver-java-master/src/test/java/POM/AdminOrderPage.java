package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AdminOrderPage {
    WebDriver driver;

    By orderIdInputLocator = By.id("sales_order_grid_filter_real_order_id");
    By fromDateInputLocator = By.name("created_at[from]");
    By toDateInputLocator = By.name("created_at[to]");
    By searchButton = By.xpath("(//span[contains(text(),'Search')])[1]");
    By closePopupButton = By.xpath("(//a[@title='close'])[1]");
    By salesLink = By.xpath("(//span[normalize-space()='Sales'])[1]");
    By ordersLink = By.xpath("(//span[normalize-space()='Orders'])[1]");

    public AdminOrderPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterOrderId(String orderId){
        WebElement orderIdElement = driver.findElement(orderIdInputLocator);
        orderIdElement.clear();
        orderIdElement.sendKeys(orderId);
    }

    public void enterFromDate(String fromDate){
        WebElement fromDateElement = driver.findElement(fromDateInputLocator);
        fromDateElement.clear();
        fromDateElement.sendKeys(fromDate);
    }

    public void enterToDate(String toDate){
        WebElement toDateElement = driver.findElement(toDateInputLocator);
        toDateElement.clear();
        toDateElement.sendKeys(toDate);
    }

    public void clickSearchButton() {
        driver.findElement(searchButton).click();
    }
    public void clickCloseButton(){
        driver.findElement(closePopupButton).click();
    }
    public void clickSalesLink(){
        driver.findElement(salesLink).click();
    }
    public void clickOrdersLink(){
        driver.findElement(ordersLink).click();
    }
}