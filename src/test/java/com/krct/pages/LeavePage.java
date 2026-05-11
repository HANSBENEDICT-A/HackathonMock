package com.krct.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LeavePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public LeavePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }
    private final By leaveMenu = By.xpath("//span[text()='Leave']");

    private final By applyButton = By.xpath("//a[text()='Apply']");

    private final By fromDate = By.xpath("(//input[@placeholder='yyyy-dd-mm'])[1]");

    private final By toDate = By.xpath("(//input[@placeholder='yyyy-dd-mm'])[2]");

    private final By applySubmitButton = By.xpath("//button[@type='submit']");

    private final By successMessage = By.xpath("//p[contains(text(),'Success')]");

    public void openLeavePage() {
        wait.until(ExpectedConditions.elementToBeClickable(leaveMenu)).click();
    }
    public void clickApplyButton() {
        wait.until(ExpectedConditions.elementToBeClickable(applyButton)).click();
    }
    public void enterFromDate(String date) {

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(fromDate)
        ).sendKeys(date);
    }

    public void enterToDate(String date) {

        wait.until(ExpectedConditions.visibilityOfElementLocated(toDate)).sendKeys(date);
    }
    public void clickApplySubmitButton() {

        wait.until(ExpectedConditions.elementToBeClickable(applySubmitButton)).click();
    }
    public void applyLeave(String from, String to)
    {
        openLeavePage();
        clickApplyButton();
        enterFromDate(from);
        enterToDate(to);
        clickApplySubmitButton();
    }
    public boolean isLeaveApplied() {

        return wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage)).isDisplayed();
    }
}

