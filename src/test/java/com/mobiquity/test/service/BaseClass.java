package com.mobiquity.test.service;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.mobiquity.test.utils.ExcelDataProvider;
import com.mobiquity.test.utils.Helper;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

public class BaseClass {
    public int id;
    public ExcelDataProvider excel;
    public ExtentReports report;
    public ExtentTest logger;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    @BeforeSuite(alwaysRun = true)
    public void setupSuite() {
        Reporter.log("Setting up reports and Tests are getting ready", true);
        ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter("C://Komal//dev//mobiquity-assignment//src//reports//mobiquity_" + Helper.getCurrentDateAndTime() + ".html");
        report = new ExtentReports();
        report.attachReporter(extentSparkReporter);
        Reporter.log("Test can be Started", true);
    }

    @BeforeClass
    public void getUserId(){
        this.setId(Helper.getUserId());
        Reporter.log("Running before class and fetching user id");
    }
}
