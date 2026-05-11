package com.krct;

import com.krct.pages.EmployeePage;
import com.krct.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EmployeeTest extends BaseTest {

    @Test
    public void employeeTest() {
        LoginPage loginPage = new LoginPage(driver,wait);
        EmployeePage employeePage = new EmployeePage(driver,wait);
        loginPage.NavigatePage();
        loginPage.Login("Admin", "admin123");

        employeePage.addEmployee(
                "John",
                "A",
                "David",
                "1234"
        );
        Assert.assertTrue(employeePage.isEmployeeAdded());
    }
    @Test
    public void searchEmployeeTest()
    {
        LoginPage loginPage = new LoginPage(driver, wait);
        EmployeePage employeePage = new EmployeePage(driver, wait);
        loginPage.NavigatePage();
        loginPage.Login("Admin", "admin123");
        employeePage.searchEmployee("John");
        Assert.assertTrue(employeePage.isEmployeeFound()
        );
    }
}
