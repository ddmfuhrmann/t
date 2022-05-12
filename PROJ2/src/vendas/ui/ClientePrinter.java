package vendas.ui;

import java.util.Collection;
import java.util.Scanner;

import vendas.app.VendasApp;
import vendas.model.Cliente;

public class ClientePrinter {
	public Cliente capturarCliente(Cliente cliente) {
		//armazena o estado do cliente quando entrar no metodo
		boolean isNew = cliente.isNew();
		
		//faz referencia a scanner
		Scanner sc = VendasApp.getScanner();
		
		//se o cliente nao for novo exibe o codigo, senao exibe mensagem de novo cliente
		if (!isNew) {
			System.out.println("Alterando cliente código: "+cliente.getId());
		}
		else {
			System.out.println("Inserindo novo cliente");
		}
		
		System.out.println();
		
		//se for um novo cliente, pergunta o codigo
		if (isNew) {
			System.out.println("Informe o código: ");
			cliente.setId(sc.nextInt());
			sc.nextLine();
		}
		
		//solicita o nome
		//se o cliente nao for novo, exibe o nome anterior
		System.out.print("Informe o nome");
		if (!isNew) {
			System.out.print(" [nome anterior = "+cliente.getNome()+"]");
		}
		System.out.println(":");
		//se o cliente for novo, passa qualquer valor
		//se o cliente nao for novo, passa o novo valor somente 
		//se o valor capturado nao for vazio ""
		//funcao trim remove os espaços do final da string
		String nome = sc.nextLine();
		if (isNew || 
				(!isNew && !nome.trim().equals(""))) {
			cliente.setNome(nome);
		}
		
		System.out.println();
		
		//solicita o cpf
		//se o cliente nao for novo, exibe o cpf anterior
		System.out.print("Informe o cpf");
		if (!isNew) {
			System.out.print(" [cpf anterior = "+cliente.getCpf()+"]");
		}
		System.out.println(":");
		cliente.setCpf(sc.nextLine());
		
		return cliente;
	}
	
	public void exibirLista(Collection<Cliente> clientes) {
		for (Cliente cliente : clientes) {
			exibirCliente(cliente);
		}
	}
	
	public void exibirCliente(Cliente cliente) {
		System.out.println(cliente);
	}
}
