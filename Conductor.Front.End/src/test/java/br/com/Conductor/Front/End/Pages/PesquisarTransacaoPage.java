package br.com.Conductor.Front.End.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.Conductor.Front.End.Support.Selenium;

public class PesquisarTransacaoPage {
	private static WebDriver driver;
	private static WebDriverWait wait;
	
	static {
		driver = Selenium.getDriver();
		wait = new WebDriverWait(driver, 15);
	}
	
	public PesquisarTransacaoPage(){
		this.driver = driver;
	}
	
	public void pesquisarTransacao(String cliente){
		Select dropdown = new Select(driver.findElement(By.id("cliente"))); // selecionar cliente
		try{
			dropdown.selectByVisibleText(cliente);
		} catch (Exception e){
			
		}
		driver.findElement(By.xpath("//*[@id=\"formListarTransacao\"]/div/div/fieldset[2]/div/div/div/input")).click(); // botão Pesquisar
	}
	
	public boolean listarTransacao(){
		return driver.findElement(By.xpath("//*[@id=\"formListarTransacao\"]/div/div/div/table/tbody/tr[1]/td[1]")).isDisplayed();
	}
	
	public void botaoVisualizarTransacao(){
		driver.findElement(By.xpath("//*[@id=\"formListarTransacao\"]/div/div/div/table/tbody/tr/td[5]/a")).click(); // botão Visualizar Transação
	}
	
	public void pesquisar(){
		driver.findElement(By.xpath("//*[@id=\"formListarTransacao\"]/div/div/div/table/tbody/tr/td[5]/a")).click(); // botão Pesquisar
	}
	
	public void botaoPesquisarTudo(){
		driver.findElement(By.xpath("//*[@id=\"formListarTransacao\"]/div/div/fieldset[2]/div/div/div/input")).click(); // botão Pesquisar
	}
}
