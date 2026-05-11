package com.krct.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EmployeePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    public EmployeePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }
    private final By personal = By.xpath("//span[text()='PIM']");
    private final By addButton = By.xpath("//a[text()='Add Employee']");
    private final By firstName = By.name("firstName");
    private final By middleName = By.name("middleName");
    private final By lastName = By.name("lastName");
    private final By employeeId = By.xpath("//input[contains(@class,'oxd-input oxd-input--active')]");
    private final By submitButton = By.cssSelector("button[type='submit']");
    private final By personalDetails = By.xpath("//h6[text()='Personal Details']");
    private final By employeeList = By.xpath("//a[text()='Employee List']");
    private final By employeeSearchBox = By.xpath("//input[contains(@placeholder,'Type for hints...')]");
    private final By searchButton = By.cssSelector("button[type='submit']");
    private final By employeeNameResult = By.xpath("//div[@role='rowgroup']");
    private final By employeeRow = By.xpath("(//div[@class='oxd-table-card'])[1]");
    private final By personalDetailsName = By.name("firstName");
    private final By noRecordsFound = By.xpath("//span[text()='No Records Found']");


    public void openPIM() {
        wait.until(ExpectedConditions.elementToBeClickable(personal)).click();
    }

    public void clickAddButton() {
        wait.until(ExpectedConditions.elementToBeClickable(addButton)).click();
    }

    public void enterFirstName(String fname) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstName)).sendKeys(fname);
    }
    public void enterMiddleName(String mname) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(middleName)).sendKeys(mname);
    }
    public void enterLastName(String lname) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(lastName)).sendKeys(lname);
    }
    public void enterEmployeeId(String empId) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(employeeId)).sendKeys(empId);
    }
    public void clickSaveButton() {
        wait.until(ExpectedConditions.elementToBeClickable(submitButton)).click();
    }
    public void addEmployee(String fname, String mname, String lname, String empId) {
        openPIM();
        clickAddButton();
        enterFirstName(fname);
        enterMiddleName(mname);
        enterLastName(lname);
        enterEmployeeId(empId);
        clickSaveButton();
    }
    public boolean isEmployeeAdded() {

        return wait.until(ExpectedConditions.visibilityOfElementLocated(personalDetails)).isDisplayed();
    }

    public void openEmployeeList() {

        wait.until(ExpectedConditions.elementToBeClickable(employeeList)).click();
    }

    public void searchEmployee(String employeeName)
    {
        openPIM();
        openEmployeeList();
        wait.until(ExpectedConditions.visibilityOfElementLocated(employeeSearchBox)).sendKeys(employeeName);
        wait.until(ExpectedConditions.elementToBeClickable(searchButton)).click();
    }
    public boolean isEmployeeFound() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(employeeNameResult)).isDisplayed();
    }
    public void openEmployeeRecord() {

        wait.until(ExpectedConditions.elementToBeClickable(employeeRow)).click();
    }
    public String getEmployeeName() {

        return wait.until(ExpectedConditions.visibilityOfElementLocated(personalDetailsName)).getAttribute("value");
    }
    public boolean isNoRecordsFoundDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(noRecordsFound)).isDisplayed();
    }
}
