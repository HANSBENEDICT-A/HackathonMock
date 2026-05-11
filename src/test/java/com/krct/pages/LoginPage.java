package com.krct.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    private final WebDriver driver;
    private final WebDriverWait wait;
    public LoginPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }


    private final By username = By.name("username");
    private final By password = By.name("password");
    private final By LoginButton = By.cssSelector("button[type='submit']");
    private final By FlashMessageField = By.cssSelector("div#flash");
    public void enterUsername(String username) {
        WebElement element = driver.findElement(By.name("username"));
        element.sendKeys(username);
    }

    public void enterPassword(String password) {
        WebElement element = driver.findElement(By.name("password"));
        element.sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(LoginButton).click();
    }

    public String enterFlashMessage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(FlashMessageField));
        return driver.findElement(FlashMessageField).getText();
    }

    public String Login(){
        enterUsername("Admin");
        enterPassword("admin123");
        clickLoginButton();
        return enterFlashMessage();
    }
    public void NavigatePage(){
        driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }
}
