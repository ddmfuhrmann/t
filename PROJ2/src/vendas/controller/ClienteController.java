package vendas.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import vendas.model.Cliente;

public class ClienteController {
	private HashMap<Integer, Cliente> clientes = new HashMap<>();
	
	public List<Cliente> listCliente(String nome) {
		List<Cliente> resultado = new ArrayList<>();
		for (Entry<Integer, Cliente> entry : clientes.entrySet()) {
			if (entry.getValue().getNome().equals(nome)) {
				resultado.add(entry.getValue());
			}
		}
		return resultado;
	} 
	
	public void inserirCliente(Cliente cliente) throws Exception {
		if (clientes.containsKey(cliente.getId())) {			
			throw new Exception("Já existe um cliente com esse código.");
		}
		if (cliente.getNome() == null ||
				cliente.getNome().trim().equals("")) {
			throw new Exception("Não é possível inserir clientes sem nome.");
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
