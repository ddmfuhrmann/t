package vendas.app;

import java.util.Collection;
import java.util.Scanner;

import vendas.controller.ClienteController;
import vendas.model.Cliente;
import vendas.ui.ClientePrinter;

public class VendasApp {
	//instancia singleton
	//variaveis estáticas sao variaveis instanciadas uma unica vez no sistema inteiro por classe
	//Sao acessiveis independente de instanciar a classe em questao
	//* pesquisar sobre o padrao de projeto singleton e variaveis static
	private static Scanner scanner = new Scanner(System.in);
	
	public static Scanner getScanner() {
		return scanner;
	}
	
	public static void main(String[] args) {
		//controlar os clientes
		System.out.println("Teste");
		ClienteController clienteController = new ClienteController();
		//instancia e grava clientes pré armazenados
		//caso queira armanezar outros tipos, executar aqui
		
		//* pesquisar sobre try catch em java
		try {
			clienteController.inserirCliente(new Cliente(1, "012.345.789-66", "João da Silva"));
			clienteController.inserirCliente(new Cliente(2, "789.456.123-00", "Aline dos Santos"));
			clienteController.inserirCliente(new Cliente(3, "444.321.654.99", "José Lima"));
		}
		catch (Exception e) {
			System.err.println(e.getLocalizedMessage());
		}
		
		//insere novo cliente
		ClientePrinter printer = new ClientePrinter();
		try {
			clienteController.inserirCliente(printer.capturarCliente(new Cliente()));	
		} 
		catch (Exception e) {
			System.err.println(e.getLocalizedMessage());
		}
		
		//Cliente cliente = printer.capturarCliente(new Cliente());
		//clienteController.inserirCliente(cliente);
		
		//listar
		Collection<Cliente> collection = clienteController.listarClientes();
		printer.exibirLista(collection);
		System.out.println("Total de "+collection.size()+" clientes.");
		
		//alterar cliente
		try {
			clienteController.atualizarCliente(printer.capturarCliente(clienteController.carregarCliente(2)));	
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getLocalizedMessage());
		}
		
		//listar
		collection = clienteController.listarClientes();
		printer.exibirLista(collection);
		System.out.println("Total de "+collection.size()+" clientes.");
		
//		//log
//		System.out.println(clienteController.listarClientes());
//		
//		//alterar cliente
//		//primeiro busca o cliente
//		Cliente cliente = clienteController.carregarCliente(2);
//		//altera o que for necessário
//		cliente.setNome("Joana dos Santos");
//		//faz o update
//		clienteController.atualizarCliente(cliente);
//		
//		//log
//		System.out.println(clienteController.listarClientes());
//		
//		//excluir cliente
//		clienteController.excluirCliente(3);
//		//log
//		System.out.println(clienteController.listarClientes());
//		
//		PedidoController pedidoController = new PedidoController();
//		
//		//novo pedido
//		Pedido pedido = new Pedido();
//		pedido.setId(1);
//		pedido.setData(pedidoController.stringToDate("10/05/2022"));
//		pedido.setCliente(clienteController.carregarCliente(1));
//		
		
	}
}
