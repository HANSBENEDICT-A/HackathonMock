package com.krct.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    protected final WebDriver driver;
    protected final WebDriverWait wait;
    public LoginPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }


    private final By username = By.name("username");
    private final By password = By.name("password");
    private final By LoginButton = By.cssSelector("button[type='submit']");
    private final By Dashboard = By.xpath("//h6[(text()='Dashboard')]");
    private final By errorMessage = By.xpath("//p[contains(text(),'Invalid credentials')]");
    public void enterUsername(String username) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
        element.sendKeys(username);
    }

    public void enterPassword(String password) {
        WebElement element = driver.findElement(By.name("password"));
        element.sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(LoginButton).click();
    }

    public void Login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
    }
    public void NavigatePage(){
        driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    public boolean isUserLoggedIn() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(Dashboard)).isDisplayed();
    }

    public String isErrorMessageDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage)).getText();
    }
}
