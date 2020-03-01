package br.com.Conductor.Front.End.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.Conductor.Front.End.Support.Selenium;

public class LoginPage {
	private static WebDriver driver;
	private static WebDriverWait wait;
	
	static{
		driver = Selenium.getDriver();
		wait = new WebDriverWait(driver, 15);
	}
	
	public LoginPage(){
		this.driver = driver;
	}
	
	public void logarValidaApp(String login, String senha){
		driver.findElement(By.name("username")).sendKeys(login);;
		driver.findElement(By.name("password")).sendKeys(senha);
		driver.findElement(By.xpath("//*[@id=\"login-form\"]/footer/button")).submit();;
	}
	
	public void clicarLogin(){
		driver.findElement(By.xpath("//*[@id=\"login-form\"]/footer/button")).click();
	}
	
	public void LoginCorreto(String login){
		driver.findElement(By.name("username")).sendKeys("admin");
	}
	
	public void SenhaCorreta(String senha){
		driver.findElement(By.name("password")).sendKeys("admin");
	}
	public void LoginErrado(String login){
		driver.findElement(By.name("username")).sendKeys("arthur");
	}

	public void SenhaErrada(String senha){
		driver.findElement(By.name("password")).sendKeys("123");
	}
		
	public boolean msgCredenciaisInvalidas(){
		return driver.findElement(By.xpath("//*[@id=\"login-form\"]/fieldset/section[1]/font/label")).isDisplayed();
	}
}
