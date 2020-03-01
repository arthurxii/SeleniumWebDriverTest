package br.com.Conductor.Front.End.Tests;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class PesquisarTransacaoTest extends BaseTestcase {
	protected String cliente;
	
	@Before
	public void logar(){
		try{
			paginaLogin.logarValidaApp("admin", "admin");
			paginaInicial.pesquisarTransacao();
		} catch (Exception e) {
			paginaInicial.pesquisarTransacao();
		}
	}
	
	//CASO DE TESTE UC[005] – [CT001] – Pesquisar transação no sistema
	@Test
	public void pesquisarTransacao(){
		teste = extentReport.createTest("pesquisarTransacao", "Verificar se o sistema pesquisa todas as transações cadastradas");
		paginaPesquisaTransacao.botaoPesquisarTudo();
		assertTrue(paginaPesquisaTransacao.listarTransacao());
		teste.log(Status.PASS, MarkupHelper.createLabel("Teste passou", ExtentColor.GREEN));
	}
	
	//CASO DE TESTE UC[005] – [CT002] – Pesquisar transação pelo cliente
	@Test
	public void pesquisarTransacaoCliente(){
		teste = extentReport.createTest("pesquisarTransacaoCliente", "Verifica se o sistema pesquisa transação escolhendo um cliente cadastrado");
		cliente = "Arthur";
		paginaPesquisaTransacao.pesquisarTransacao(cliente);
		teste.log(Status.FAIL, MarkupHelper.createLabel("Teste falhou", ExtentColor.RED));
		teste.fail("Quando é selecionado um cliente, o sistema não retornada nada");
	}
}
