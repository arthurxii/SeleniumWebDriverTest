package br.com.Conductor.Front.End.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.Conductor.Front.End.Support.Selenium;
import br.com.Conductor.Front.End.Util.Utils;

public class ClientePage {
	private static WebDriver driver;
	private static WebDriverWait wait;
	
	static{
		driver = Selenium.getDriver();
		wait = new WebDriverWait(driver, 15);
	}
	
	public ClientePage(){
		this.driver = driver;
	}
	
	public void alterarCliente(){
		try{
		driver.findElement(By.xpath("//*[@id=\"formIncluirAlterarCliente\"]/div/div/div/div/div/a[1]"));	
	} catch (Exception e){
		Utils.tirarPrintDaTela("alterar cliente");
	}
		}
	
	public boolean mensagemConfirmacao(){
		try{
		return driver.findElement(By.xpath("//*[@id=\"alertMessage\"]/strong")).isDisplayed();
	} catch (Exception e){
		Utils.tirarPrintDaTela("cliente cadastrado");
	}
		return false;
	}
}
