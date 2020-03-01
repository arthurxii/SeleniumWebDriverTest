package br.com.Conductor.Front.End.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.Conductor.Front.End.Support.Selenium;

public class PesquisarClientePage {
	private static WebDriver driver;
	private static WebDriverWait wait;
	
	static {
		driver = Selenium.getDriver();
		wait = new WebDriverWait(driver, 15);
	}
	
	public PesquisarClientePage(){
		this.driver = driver;
	}
	
	public void pesquisarCliente(String nome, String data){
		driver.findElement(By.xpath("//*[@id=\"left-panel\"]/nav/ul[2]/li/a")).click(); //botão QA
		driver.findElement(By.xpath("//*[@id=\"left-panel\"]/nav/ul[2]/li/ul/li[1]/a")).click(); // botão Clientes
		driver.findElement(By.xpath("//*[@id=\"left-panel\"]/nav/ul[2]/li/ul/li[1]/ul/li[2]/a")).click(); // botão Pesquisar Clientes
		
		driver.findElement(By.name("j_idt17")).sendKeys(nome); //Campo Nome
		driver.findElement(By.xpath("//*[@id=\"calendario_input\"]")).sendKeys(data);; // Calendário para pesquisa
		driver.findElement(By.xpath("//*[@id=\"formListarCliente\"]/div/fieldset/div/div/div[3]/input")).click(); //botão Pesquisar
	}
	
	public void verificarDadosCliente(){
		driver.findElement(By.xpath("//*[@id=\"formListarCliente\"]/div/div/table/tbody/tr/td[5]/a[1]")).click(); //botão Verificar dados do cliente
	}
	
	public void limparBase(){
		driver.findElement(By.xpath("//*[@id=\"formListarCliente\"]/div/fieldset/div/div/div[4]/input")).click(); //botão Limpar base
		driver.findElement(By.xpath("//*[@id=\"alertMessage\"]/strong")).isDisplayed(); //mensagem Base Limpa com Sucesso
	}
	
	public boolean listarClientes(){
		return driver.findElement(By.xpath("//*[@id=\"formListarCliente\"]/div/div/table/tbody/tr/td[1]")).isDisplayed();
	}
}
