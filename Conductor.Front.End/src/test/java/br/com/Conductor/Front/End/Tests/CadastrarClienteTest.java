package br.com.Conductor.Front.End.Tests;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import br.com.Conductor.Front.End.Util.Utils;

public class CadastrarClienteTest extends BaseTestcase {
	protected String nome;
	protected String cpf;
	protected String saldo;
	protected String status;

	@Before
	public void logar(){
		try{
			paginaLogin.logarValidaApp("admin", "admin");
			paginaInicial.cadastrarClientes();
		} catch (Exception e) {
			paginaInicial.cadastrarClientes();
		}
	}
	
	//CASO DE TESTE UC[002] – [CT001] – Cadastrar cliente ativo
	@Test
	public void cadastrarClienteAtivo(){
		teste = extentReport.createTest("cadastrarClienteAtivo", "Veriicar se o sistema cadastar cliente ativo");
		nome = "Arthur";
		cpf = "10215206401";
		status = "Ativo";
		saldo = "150.00";
		paginaCadastroCliente.cadastrarCliente(nome, cpf, saldo, status);
		assertTrue(paginaCliente.mensagemConfirmacao());
		teste.log(Status.PASS, MarkupHelper.createLabel("Teste passou", ExtentColor.GREEN));
	}
	
	//CASO DE TESTE UC[002] – [CT002] – Cadastrar cliente inativo
	@Test
	public void cadastrarClienteInativo(){
		teste = extentReport.createTest("cadastrarClienteInativo", "Verificar se o sistema cadastra cliente inativo");
		nome = "Mike";
		cpf = "14725836912";
		status = "Inativo";
		saldo = "200.00";
		paginaCadastroCliente.cadastrarCliente(nome, cpf, saldo, status);
		assertTrue(paginaCliente.mensagemConfirmacao());
		teste.log(Status.PASS, MarkupHelper.createLabel("Teste passou", ExtentColor.GREEN));
	}
	
	//CASO DE TESTE UC[002] – [CT003] – Cadastrar cliente sem nome
	@Test
	public void cadastrarClienteSemNome(){
		teste = extentReport.createTest("cadastrarClienteSemNome", "Verificar se o sistema cadastra cliente sem nome");
		nome = "";
		cpf = "12345678923";
		status = "Ativo";
		saldo = "50.00";
		paginaCadastroCliente.cadastrarCliente(nome, cpf, saldo, status);
		assertTrue(paginaCadastroCliente.campoNomeVazio());
		teste.log(Status.PASS, MarkupHelper.createLabel("Teste passou", ExtentColor.GREEN));
	}
	
	//CASO DE TESTE UC[002] – [CT004] – Cadastrar cliente sem CPF
	@Test
	public void cadastrarClienteSemCpf(){
		teste = extentReport.createTest("cadastrarClienteSemCpf", "Verificar se o sistema cadastra cliente sem cpf");
		nome = "Chester";
		cpf = "";
		status = "Ativo";
		saldo = "100.00";
		paginaCadastroCliente.cadastrarCliente(nome, cpf, saldo, status);
		assertTrue(paginaCadastroCliente.campoCpfVazio());
		teste.log(Status.PASS, MarkupHelper.createLabel("Teste passou", ExtentColor.GREEN));
	}
	
	//CASO DE TESTE UC[002] – [CT005] – Cadastrar cliente sem saldo
	@Test
	public void cadastrarClienteSemSaldo(){
		teste = extentReport.createTest("cadastrarClienteSemSaldo", "Verificar se o sistema cadastrar cliente sem saldo");
		nome = "Noah";
		cpf = "14536987412";
		status = "Inativo";
		saldo = "";
		paginaCadastroCliente.cadastrarCliente(nome, cpf, saldo, status);
		teste.log(Status.FAIL, MarkupHelper.createLabel("Teste falhou", ExtentColor.RED));
		teste.fail("Sistema salvou cliente sem saldo, porém, não deveria, pois saldo é um campo obrigatório");
		assertFalse(Utils.tirarPrintDaTela("cliente sem saldo"), paginaCliente.mensagemConfirmacao());
	}
}	
