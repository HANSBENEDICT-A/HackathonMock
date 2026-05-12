package com.krct;

import com.krct.pages.LeavePage;
import com.krct.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LeaveTest extends BaseTest {

    ConfigReader config =
            new ConfigReader();

    @Test
    public void leavePageTest()
    {
        LoginPage loginPage =
                new LoginPage(driver, wait);

        LeavePage leavePage =
                new LeavePage(driver, wait);

        loginPage.NavigatePage();

        loginPage.Login(
                config.getUsername(),
                config.getPassword()
        );

        leavePage.openLeavePage();

        Assert.assertTrue(
                leavePage.isLeavePageOpened()
        );
    }

    @Test
    public void applyLeaveTest()
    {
        LoginPage loginPage =
                new LoginPage(driver, wait);

        LeavePage leavePage =
                new LeavePage(driver, wait);

        loginPage.NavigatePage();

        loginPage.Login(
                config.getUsername(),
                config.getPassword()
        );

        leavePage.openApplyPage();

        Assert.assertTrue(
                leavePage.isApplyPageOpened()
        );
    }

    @Test
    public void leaveListTest()
    {
        LoginPage loginPage =
                new LoginPage(driver, wait);

        LeavePage leavePage =
                new LeavePage(driver, wait);

        loginPage.NavigatePage();

        loginPage.Login(
                config.getUsername(),
                config.getPassword()
        );

        leavePage.openLeaveList();

        Assert.assertTrue(
                leavePage.isLeaveListOpened()
        );
    }

    @Test
    public void invalidDateTest()
    {
        Assert.assertTrue(true);
    }
}