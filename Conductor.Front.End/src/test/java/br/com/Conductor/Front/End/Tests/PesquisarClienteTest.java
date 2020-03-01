package br.com.Conductor.Front.End.Tests;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class PesquisarClienteTest extends BaseTestcase {
	protected String nome;
	protected String data;
	
	@Before
	public void logar(){
		try{
			paginaLogin.logarValidaApp("admin", "admin");
			paginaInicial.cadastrarClientes();
		} catch (Exception e) {
			paginaInicial.cadastrarClientes();
		}
	}
	
	//CASO DE TESTE UC[003] – [CT001] – Pesquisar cliente sem informar parâmetros
	@Test
	public void pesquisarSemParametros(){
		teste = extentReport.createTest("pesquisarSemParametros", "Verificar se o sistema faz a busca sem informar nenhum dado de pesquisa");
		nome = "";
		data = "";
		paginaPesquisaCliente.pesquisarCliente(nome, data);
		assertTrue(paginaPesquisaCliente.listarClientes());
		teste.log(Status.PASS, MarkupHelper.createLabel("Teste passou", ExtentColor.GREEN));
	}
	
	//CASO DE TESTE UC[003] – [CT002] – Pesquisar cliente pelo nome
	@Test
	public void pesquisarClienteNome(){
		teste = extentReport.createTest("pesquisarClienteNome", "Verificar se o sistema pesquisa clientes apenas pelo nome");
		nome = "Arthur";
		data = "";
		paginaPesquisaCliente.pesquisarCliente(nome, data);
		assertTrue(paginaPesquisaCliente.listarClientes());
		teste.log(Status.PASS, MarkupHelper.createLabel("Teste passou", ExtentColor.GREEN));
	}
	
	//CASO DE TESTE UC[003] – [CT003] – Pesquisar cliente pela data
	@Test
	public void pesquisarClienteData(){
		teste = extentReport.createTest("pesquisarClienteData", "Verificar se o sistema pesquisa clientes só apenas pela data");
		nome = "";
		data = "03/2020";
		paginaPesquisaCliente.pesquisarCliente(nome, data);
		assertTrue(paginaPesquisaCliente.listarClientes());
		teste.log(Status.PASS, MarkupHelper.createLabel("Teste passou", ExtentColor.GREEN));
		
	}
	
	//CASO DE TESTE UC[003] – [CT004] – Pesquisar cliente com data inválida
	@Test
	public void pesquisarClienteDataInvalida(){
		teste = extentReport.createTest("pesquisarClienteDataInvalida", "Verificar se o sistema pesquisa clientes informando uma não cadastrada");
		nome = "";
		data = "04/2019";
		paginaPesquisaCliente.pesquisarCliente(nome, data);
		teste.log(Status.FAIL, MarkupHelper.createLabel("Teste falhou", ExtentColor.RED));
		teste.fail("O sistema retorna todos os clientes cadastrados mesmo informando uma data inválida");
	}
}
