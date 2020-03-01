package br.com.Conductor.Front.End.Tests;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import br.com.Conductor.Front.End.Util.Utils;

public class IncluirTransacaoTest extends BaseTestcase {
	protected String cliente;
	protected String valor;
	
	@Before
	public void logar(){
		try{
			paginaLogin.logarValidaApp("admin", "admin");
			paginaInicial.cadastrarTransacao();
		} catch (Exception e) {
			paginaInicial.cadastrarTransacao();
		}
	}
	
	//CASO DE TESTE UC[004] – [CT001] – Incluir Transação
	@Test
	public void incluirTransacaoCorreta(){
		teste = extentReport.createTest("incluirTransacaoCorreta", "Verificar se o sistema inclui uma transação com os dados corretos");
		cliente = "Arthur";
		valor = "10.00";
		paginaInclusaoTransacao.incluirTransacao(cliente, valor);
		Utils.wait(1000);
		assertTrue(paginaTransacao.transacaoCadastrada());
		teste.log(Status.PASS, MarkupHelper.createLabel("Teste passou", ExtentColor.GREEN));
	}
	
	//CASO DE TESTE UC[004] – [CT002] – Incluir Transação sem valor
	@Test		
	public void incluirTransacaoDadosCliente(){
		teste = extentReport.createTest("incluirTransacaoDadosCliente", "Verificar se o sistema inclui uma transação apenas selecionando o cliente");
		cliente = "Arthurs";
		valor = "";
		paginaInclusaoTransacao.incluirTransacao(cliente, valor);
		assertFalse(paginaInclusaoTransacao.botaoSalvar());
		teste.log(Status.PASS, MarkupHelper.createLabel("Teste passou", ExtentColor.GREEN));
	}
	
	//CASO DE TESTE UC[004] – [CT003] – Incluir Transação sem cliente
	@Test
	public void incluirTransacaoValor(){
		teste = extentReport.createTest("incluirTransacaoValor", "Verificar se o sistema inclui uma transação informando apenas o valor");
		cliente = "";
		valor = "100.00";
		paginaInclusaoTransacao.incluirTransacao(cliente, valor);
		assertFalse(paginaInclusaoTransacao.botaoSalvar());
		teste.log(Status.PASS, MarkupHelper.createLabel("Teste passou", ExtentColor.GREEN));
	}
	

}
