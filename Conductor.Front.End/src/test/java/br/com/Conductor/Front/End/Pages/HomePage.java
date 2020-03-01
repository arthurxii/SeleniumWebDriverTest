package br.com.Conductor.Front.End.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.Conductor.Front.End.Support.Selenium;
import br.com.Conductor.Front.End.Util.Utils;

public class HomePage {
	private static WebDriver driver;
	private static WebDriverWait wait;
	
	static{
		driver = Selenium.getDriver();
		wait = new WebDriverWait(driver, 15);
	}
	
	public HomePage(){
		this.driver = driver;
	}
	
	public void pesquisarClientes(){
		try{
			driver.findElement(By.xpath("//*[@id=\"left-panel\"]/nav/ul[2]/li/a")).click(); //botão QA
			driver.findElement(By.xpath("//*[@id=\"left-panel\"]/nav/ul[2]/li/ul/li[1]/a")).click(); // botão Clientes
			driver.findElement(By.xpath("//*[@id=\"left-panel\"]/nav/ul[2]/li/ul/li[1]/ul/li[2]/a")).click(); // botão Pesquisar Clientes
		} catch (Exception e){
			Utils.tirarPrintDaTela("pesquisar cliente");
		}
	}
	
	public void cadastrarClientes(){
		try{
			driver.findElement(By.xpath("//*[@id=\"left-panel\"]/nav/ul[2]/li/a")).click(); //botão QA
			driver.findElement(By.xpath("//*[@id=\"left-panel\"]/nav/ul[2]/li/ul/li[1]/a")).click(); // botão Clientes
			driver.findElement(By.xpath("//*[@id=\"left-panel\"]/nav/ul[2]/li/ul/li[1]/ul/li[1]/a")).click(); //botão Cadastrar Clientes
		} catch (Exception e){
			Utils.tirarPrintDaTela("cadastrar cliente");
		}
	}
	
	public void pesquisarTransacao(){
		try{
			driver.findElement(By.xpath("//*[@id=\"left-panel\"]/nav/ul[2]/li/a")).click(); //botão QA
			driver.findElement(By.xpath("//*[@id=\"left-panel\"]/nav/ul[2]/li/ul/li[2]/a")).click(); //botão Vendas
			driver.findElement(By.xpath("//*[@id=\"left-panel\"]/nav/ul[2]/li/ul/li[2]/ul/li[2]/a")).click(); //botão Pesquisar Vendas
		} catch (Exception e){
			Utils.tirarPrintDaTela("pesquisar vendas");
		}
	}
	
	public void cadastrarTransacao(){
		try{
		driver.findElement(By.xpath("//*[@id=\"left-panel\"]/nav/ul[2]/li/a")).click(); //botão QA
		driver.findElement(By.xpath("//*[@id=\"left-panel\"]/nav/ul[2]/li/ul/li[2]/a")).click(); //botão Vendas
		driver.findElement(By.xpath("//*[@id=\"left-panel\"]/nav/ul[2]/li/ul/li[2]/ul/li[1]/a")).click(); //botão Cadastrar Vendas
	} catch (Exception e){
		Utils.tirarPrintDaTela("cadastrar vendas");
		}
	}
	
	public void sair(){
		driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/form/input[1]")).click(); //botão Sair
	}
}
