package com.krct.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminPage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public AdminPage(WebDriver driver,
                     WebDriverWait wait)
    {
        this.driver = driver;
        this.wait = wait;
    }
    private final By adminMenu = By.xpath("//span[text()='Admin']");

    private final By addButton = By.xpath("//button[normalize-space()='Add']");

    private final By usernameField = By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]");

    private final By passwordField = By.xpath("(//input[@type='password'])[1]");

    private final By confirmPasswordField = By.xpath("(//input[@type='password'])[2]");

    private final By saveButton = By.xpath("//button[@type='submit']");

    private final By systemUsersHeader = By.xpath("//h5[text()='System Users']");

}
