package br.com.Conductor.Front.End.Test.Suite;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;

import br.com.Conductor.Front.End.Support.Property;
import br.com.Conductor.Front.End.Support.Selenium;
import br.com.Conductor.Front.End.Tests.CadastrarClienteTest;
import br.com.Conductor.Front.End.Tests.IncluirTransacaoTest;
import br.com.Conductor.Front.End.Tests.LoginTest;
import br.com.Conductor.Front.End.Tests.PesquisarClienteTest;
import br.com.Conductor.Front.End.Tests.PesquisarTransacaoTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	LoginTest.class,
	CadastrarClienteTest.class,
	PesquisarClienteTest.class,
	IncluirTransacaoTest.class,
	PesquisarTransacaoTest.class
})

public class AllTests {
	protected static WebDriver driver;
	static ExtentReports extentReport;
	public static Boolean isAllTestsExecution = false;
	
	@BeforeClass
	public static void beforeClass() throws Exception{
		isAllTestsExecution = true;
		driver = Selenium.getDriver();
		driver.navigate().to(Property.SITE_ADDRESS);
		driver.manage().window().maximize();
	}
	
	@AfterClass
	public static void afterClass() throws Exception{
		extentReport = PesquisarTransacaoTest.extentReport;
		extentReport.flush();
		driver.get(System.getProperty("user.dir") +"./src/test/resources/ExtentReportTestSuite.html");
	}
	
	@BeforeTest
	public void startExtent(){
		
	}
	
}
