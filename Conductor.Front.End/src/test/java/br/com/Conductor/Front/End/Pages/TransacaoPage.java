package br.com.Conductor.Front.End.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.Conductor.Front.End.Support.Selenium;

public class TransacaoPage {
	private static WebDriver driver;
	private static WebDriverWait wait;
	
	static{
		driver = Selenium.getDriver();
		wait = new WebDriverWait(driver, 15);
	}
	
	public TransacaoPage (){
		this.driver = driver;
	}
	
	public boolean transacaoCadastrada(){
		return driver.findElement(By.xpath("//*[@id=\"alertMessage\"]/strong")).isDisplayed();
	}
	

}
