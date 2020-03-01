package br.com.Conductor.Front.End.Tests;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import br.com.Conductor.Front.End.Pages.CadastrarClientePage;
import br.com.Conductor.Front.End.Pages.ClientePage;
import br.com.Conductor.Front.End.Pages.HomePage;
import br.com.Conductor.Front.End.Pages.IncluirTransacaoPage;
import br.com.Conductor.Front.End.Pages.LoginPage;
import br.com.Conductor.Front.End.Pages.PesquisarClientePage;
import br.com.Conductor.Front.End.Pages.PesquisarTransacaoPage;
import br.com.Conductor.Front.End.Pages.TransacaoPage;
import br.com.Conductor.Front.End.Support.Property;
import br.com.Conductor.Front.End.Support.Selenium;
import br.com.Conductor.Front.End.Test.Suite.AllTests;
import br.com.Conductor.Front.End.Util.ExtentReportsManager;

public class BaseTestcase {
	public static WebDriver driver;
	protected static LoginPage paginaLogin = new LoginPage();
	protected static HomePage paginaInicial = new HomePage();
	protected static CadastrarClientePage paginaCadastroCliente = new CadastrarClientePage();
	protected static ClientePage paginaCliente = new ClientePage();
	protected static PesquisarClientePage paginaPesquisaCliente = new PesquisarClientePage();
	protected static IncluirTransacaoPage paginaInclusaoTransacao = new IncluirTransacaoPage();
	protected static PesquisarTransacaoPage paginaPesquisaTransacao = new PesquisarTransacaoPage();
	protected static TransacaoPage paginaTransacao = new TransacaoPage();
	private static WebDriverWait wait;
	public static ExtentReports extentReport = ExtentReportsManager.abrirExtentReport();
	public ExtentTest teste;
	
	@BeforeClass
	public static void beforeClass() throws Exception{
		if(!AllTests.isAllTestsExecution){
			driver = Selenium.getDriver();
			driver.navigate().to(Property.SITE_ADDRESS);
			driver.manage().window().maximize();
		} else {
			
		}
	}
	
	@AfterClass
	public static void afterClass() throws Exception{
		if(!AllTests.isAllTestsExecution){
			extentReport.flush();
			driver.get(System.getProperty("user.dir")+"/src/test/resources/ExtentReportIndividual");
		}
			
	
	}
}
