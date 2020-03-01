package br.com.Conductor.Front.End.Util;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

import br.com.Conductor.Front.End.Test.Suite.AllTests;

public class ExtentReportsManager {
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extentReport;
	
	public static ExtentReports abrirExtentReport(){
		if(!AllTests.isAllTestsExecution)
			htmlReporter = new ExtentHtmlReporter("./src/test/resources/ExtentReportIndividual.html");
		else
			htmlReporter = new ExtentHtmlReporter("./src/test/resources/ExtentReportTestSuite.html");
		htmlReporter.config().setChartVisibilityOnOpen(true);
		htmlReporter.config().setDocumentTitle("AutomationTesting.in Demo Report");
		htmlReporter.config().setReportName("Testes");
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReporter.config().setTheme(Theme.DARK);
		extentReport = new ExtentReports();
		extentReport.attachReporter(htmlReporter);
		return extentReport;
	}
}

