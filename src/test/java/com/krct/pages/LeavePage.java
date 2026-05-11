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

    private final By leaveHeader = By.xpath("//h6[text()='Leave']");

    private final By applyPageHeader = By.xpath("//h6[text()='Apply Leave']");

    private final By myLeaveButton = By.xpath("//a[text()='My Leave']");

    private final By leaveListHeader = By.xpath("//h5[text()='Leave List']");

    private final By dateField = By.xpath("(//input[@placeholder='yyyy-dd-mm'])[1]");

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
    public void applyLeave()
    {
        openLeavePage();
    }
    public void applyLeave(String from, String to)
    {
        openLeavePage();
        clickApplyButton();
        enterFromDate(from);
        enterToDate(to);
    }
    public boolean isLeavePageOpened() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(leaveHeader)).isDisplayed();
    }

    public void openApplyPage() {

        openLeavePage();

        wait.until(ExpectedConditions.elementToBeClickable(applyButton)).click();
    }
    public boolean isApplyPageOpened() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(applyPageHeader)).isDisplayed();
    }

    public void openLeaveList() {
        openLeavePage();
        wait.until(ExpectedConditions.elementToBeClickable(myLeaveButton)).click();
    }

    public boolean isLeaveListOpened() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(leaveMenu)).isDisplayed();
    }

    public void enterInvalidDate()
    {
        openApplyPage();
        wait.until(ExpectedConditions.visibilityOfElementLocated(dateField)).sendKeys("invalid-date");
    }

}

