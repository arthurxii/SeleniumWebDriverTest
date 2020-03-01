package br.com.Conductor.Front.End.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.Conductor.Front.End.Support.Selenium;
import br.com.Conductor.Front.End.Util.Utils;

public class CadastrarClientePage {
	private static WebDriver driver;
	private static WebDriverWait wait;
	
	static {
		driver = Selenium.getDriver();
		wait = new WebDriverWait (driver, 15);
	}
	
	public CadastrarClientePage(){
		this.driver = driver;
	}
	
	public void cadastrarCliente(String nome, String cpf, String saldo, String status){
		try{
			driver.findElement(By.id("nome")).sendKeys(nome);;
			driver.findElement(By.id("cpf")).sendKeys(cpf);
			driver.findElement(By.id("saldoCliente")).clear();
			driver.findElement(By.id("saldoCliente")).sendKeys(saldo);
			
			Select dropdown = new Select(driver.findElement(By.id("status")));
			if(status.equals("Inativo")) {
				dropdown.selectByVisibleText("Inativo");
			} else {
				dropdown.selectByVisibleText("Ativo");
			}
			
			driver.findElement(By.id("botaoSalvar")).click();
		} catch (Exception e){
			Utils.tirarPrintDaTela("Cadastro do cliente");
		}
	}
	
	public boolean campoNomeVazio(){
		return driver.findElement(By.xpath("//*[@id=\"formIncluirAlterarCliente\"]/div/div/fieldset[1]/div/div/div/small")).isDisplayed();
	}
	
	public boolean campoCpfVazio(){
		return driver.findElement(By.xpath("//*[@id=\"formIncluirAlterarCliente\"]/div/div/fieldset[2]/div/div/div/small")).isEnabled();
	}
}
