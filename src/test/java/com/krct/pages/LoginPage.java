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
    private final By errorMessage = By.cssSelector(".oxd-alert-content-text");
    private final By profileMenu = By.cssSelector(".oxd-userdropdown-name");
    public final By logout = By.xpath("//a[text()='Logout']");
    private final By requiredMessage = By.xpath("//span[text()='Required']");

    public void enterUsername(String user) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(this.username));
        element.sendKeys(user);
    }

    public void enterPassword(String pass) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(this.password));
        element.sendKeys(pass);
    }

    public void clickLoginButton() {
        wait.until(ExpectedConditions.elementToBeClickable(LoginButton)).click();
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

        return driver.getCurrentUrl().contains("dashboard");
    }

    public String isErrorMessageDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage)).getText();
    }

    public void logoutButtonClick() {

        WebElement menu =
                wait.until(ExpectedConditions.visibilityOfElementLocated(profileMenu));

        menu.click();

        WebElement logoutButton = wait.until(ExpectedConditions.visibilityOfElementLocated(logout));

        logoutButton.click();
    }
    public boolean isLoginPageDisplayed() {

        return driver.getCurrentUrl()
                .contains("login");
    }
    public String getRequiredMessage() {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(requiredMessage)).getText();
    }
}
