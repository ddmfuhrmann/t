package vendas.test.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import vendas.controller.ClienteController;
import vendas.model.Cliente;

public class FirstTest {
	
	@DisplayName("Meu primeiro teste, deve retornar verdadeiro")
	@Test
	void primeiroTeste() {
		assertTrue(true);
	}
	
	/**
	 * Este teste insere um cliente
	 * os dados obrigatórios sao: nome
	 * @throws Exception
	 */
	@DisplayName("Teste com controller")
	@Test
	void testeController() throws Exception {
		ClienteController controller = new ClienteController();
		Cliente cliente = new Cliente();
		cliente.setNome("Daniel");
		controller.inserirCliente(cliente);
	}
	
	/**
	 * Este método deve encontrar clientes com o nome
	 * recebido por parametro e retornar a lista
	 */
	@Test
	@DisplayName("Listar clientes por nome")
	void testListClientesNome() throws Exception {
		String nome = "Daniel";
		ClienteController controller = new ClienteController();
		controller.inserirCliente(new Cliente(0, "", nome));
		List<Cliente> retorno = controller.listCliente(nome);
		assertNotNull(retorno);
		assertEquals(1, retorno.size());
	}
}
