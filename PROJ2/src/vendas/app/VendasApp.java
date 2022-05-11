package vendas.app;

import vendas.controller.ClienteController;
import vendas.controller.PedidoController;
import vendas.model.Cliente;
import vendas.model.Pedido;

public class VendasApp {
	public static void main(String[] args) {
		//controlar os clientes
		ClienteController clienteController = new ClienteController();
		//instancia e grava clientes
		clienteController.inserirCliente(new Cliente(1, "012.345.789-66", "João da Silva"));
		clienteController.inserirCliente(new Cliente(2, "789.456.123-00", "Aline dos Santos"));
		clienteController.inserirCliente(new Cliente(3, "444.321.654.99", "José Lima"));
		
		//log
		System.out.println(clienteController.listarClientes());
		
		//alterar cliente
		//primeiro busca o cliente
		Cliente cliente = clienteController.carregarCliente(2);
		//altera o que for necessário
		cliente.setNome("Joana dos Santos");
		//faz o update
		clienteController.atualizarCliente(cliente);
		
		//log
		System.out.println(clienteController.listarClientes());
		
		//excluir cliente
		clienteController.excluirCliente(3);
		//log
		System.out.println(clienteController.listarClientes());
		
		PedidoController pedidoController = new PedidoController();
		
		//novo pedido
		Pedido pedido = new Pedido();
		pedido.setId(1);
		pedido.setData(pedidoController.stringToDate("10/05/2022"));
		pedido.setCliente(clienteController.carregarCliente(1));
		
		
	}
}
