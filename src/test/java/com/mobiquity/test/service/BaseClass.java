package com.mobiquity.test.service;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.mobiquity.test.client.RestAssuredClient;
import com.mobiquity.test.utils.ExcelDataProvider;
import com.mobiquity.test.utils.Helper;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class BaseClass {
    public int id;
    public ExcelDataProvider excel;
    public ExtentReports report;
    public ExtentTest logger;
    private RestAssuredClient restAssuredClient;


    @BeforeClass(alwaysRun = true)
    public void setupSuite() {
        Reporter.log("Setting up reports and Tests are getting ready", true);
        ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter("C://Komal//dev//Mobiquity//mobiquity-round2//reports//mobiquity_" + Helper.getCurrentDateAndTime() + ".html");
        report = new ExtentReports();
        report.attachReporter(extentSparkReporter);
        Reporter.log("Test can be Started", true);
    }

    @AfterMethod
    public void tearDown() {
        report.flush();
    }
}
