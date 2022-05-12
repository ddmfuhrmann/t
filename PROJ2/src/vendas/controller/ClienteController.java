package vendas.controller;

import java.util.Collection;
import java.util.HashMap;

import vendas.model.Cliente;

public class ClienteController {
	private HashMap<Integer, Cliente> clientes = new HashMap<>();
	
	public void inserirCliente(Cliente cliente) throws Exception {
		if (clientes.containsKey(cliente.getId())) {			
			throw new Exception("J� existe um cliente com esse c�digo.");
		}
		if (cliente.getNome().trim().equals("")) {
			throw new Exception("N�o � poss�vel inserir clientes sem nome.");
		}
		
		clientes.put(cliente.getId(), cliente);
	}
	
	public void atualizarCliente(Cliente cliente) {
		clientes.replace(cliente.getId(), cliente);
	}
	
	public void excluirCliente(int id) {
		clientes.remove(id);
	}
	
	public Collection<Cliente> listarClientes() {
		return clientes.values();
	}
	
	public Cliente carregarCliente(int id) {
		return clientes.get(id);
	}
}
