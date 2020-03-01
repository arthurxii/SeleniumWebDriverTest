package br.com.Conductor.Front.End.Util;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.Conductor.Front.End.Support.Selenium;

public abstract class Utils {

	private static final WebDriver driver;
	private static final WebDriverWait wait;

	static {
		driver = Selenium.getDriver();
		wait = new WebDriverWait(driver, 15);
	}

	public static void wait(int ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void waitElement(WebElement element) {
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String tirarPrintDaTela(String nome) {
		try {
			TakesScreenshot tirar = (TakesScreenshot) driver;
			File source = tirar.getScreenshotAs(OutputType.FILE);
			String destino = "./src/test/resources" + nome + ".png";
			File local = new File(destino);
			FileUtils.copyFile(source, local);
			System.out.println("Print da tela capturado com sucesso");

			return destino;
		} catch (Exception e) {
			System.out.println("Erro ao tirar print da tela" + e.getMessage());
			return e.getMessage();
		}
	}
}
