package br.com.Conductor.Front.End.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.Conductor.Front.End.Support.Selenium;

public class IncluirTransacaoPage {
	private static WebDriver driver;
	private static WebDriverWait wait;
	
	static {
		driver = Selenium.getDriver();
		wait = new WebDriverWait(driver, 15);
	}
	
	public IncluirTransacaoPage(){
		this.driver = driver;
	}
	
	public void incluirTransacao(String cliente, String valor){
		Select dropdown = new Select(driver.findElement(By.id("cliente"))); // escolher o Cliente
		try{
			dropdown.selectByVisibleText(cliente);
		} catch (Exception e){
			
		}
		
		driver.findElement(By.xpath("//*[@id=\"valorTransacao\"]")).clear();
		driver.findElement(By.xpath("//*[@id=\"valorTransacao\"]")).sendKeys(valor); //campo Valor
		driver.findElement(By.id("botaoSalvar")).click(); // botão Salvar
	}
	
	public boolean botaoSalvar(){
		return driver.findElement(By.id("botaoSalvar")).isEnabled();
	}
	
	public boolean mensagemSucesso(){
		return driver.findElement(By.xpath("//*[@id=\"alertMessage\"]/strong")).isDisplayed();
	}
}


