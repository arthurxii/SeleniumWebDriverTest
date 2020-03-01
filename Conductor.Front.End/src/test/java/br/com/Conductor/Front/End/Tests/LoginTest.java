package br.com.Conductor.Front.End.Tests;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class LoginTest extends BaseTestcase {
	protected String login;
	protected String senha;

	@Before
	public void antes(){
		
	}
	
	//CASO DE TESTE UC[001] – [CT001] – Autenticar no sistema sem dados
	@Test
	public void logarSemDados(){
		teste = extentReport.createTest("logarSemDados", "Verificar se o sistema loga sem informar nenhum dado");
		login = "";
		senha = "";
		paginaLogin.logarValidaApp(login, senha);
		assertTrue(paginaLogin.msgCredenciaisInvalidas());
		teste.log(Status.PASS, MarkupHelper.createLabel("Teste passou", ExtentColor.GREEN));
	}
	
	//CASO DE TESTE UC[001] – [CT002] – Autenticar no sistema com dados inválidos
	@Test
	public void logarErrado(){
		teste = extentReport.createTest("logarErrado", "Verificar se o sistema impede de logar com dados incorretos");
		login = "arthur";
		senha = "123";
		paginaLogin.logarValidaApp(login, senha);
		assertTrue(paginaLogin.msgCredenciaisInvalidas());
		teste.log(Status.PASS, MarkupHelper.createLabel("Teste passou", ExtentColor.GREEN));
	}
	
	//CASO DE TESTE UC[001] – [CT003] – Autenticar no sistema com senha inválida
	@Test
	public void logarComSenhaErrada(){
		teste = extentReport.createTest("logarComSenhaErrada", "Verificar se o sistema impede de logar com senha incorreta");
		login = "admin";
		senha = "123";
		paginaLogin.logarValidaApp(login, senha);
		assertTrue(paginaLogin.msgCredenciaisInvalidas());
		teste.log(Status.PASS, MarkupHelper.createLabel("Teste passou", ExtentColor.GREEN));
	}
	
	//CASO DE TESTE UC[001] – [CT004] – Autenticar no sistema com login inválido
	@Test
	public void logarComLoginErrado(){
		teste = extentReport.createTest("logarComLoginErrado", "Verificar se o sistema impede de logar com login incorreto");
		login = "arthur";
		senha = "admin";
		paginaLogin.logarValidaApp(login, senha);
		assertTrue(paginaLogin.msgCredenciaisInvalidas());
		teste.log(Status.PASS, MarkupHelper.createLabel("Teste passou", ExtentColor.GREEN));
	}
	
	//CASO DE TESTE UC[001] – [CT005] – Autenticar no sistema
	@Test
	public void logarSistema(){
		teste = extentReport.createTest("logarSistema", "Fazer o login no sistema com dados corretos");
		login = "admin";
		senha = "admin";
		paginaLogin.logarValidaApp(login, senha);
		paginaInicial.sair();
		assertFalse(paginaLogin.msgCredenciaisInvalidas());
		teste.log(Status.PASS, MarkupHelper.createLabel("Teste passou", ExtentColor.GREEN));
	}
}	