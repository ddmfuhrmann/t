package vendas.test.controller;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Collection;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import vendas.controller.ClienteController;
import vendas.model.Cliente;

@TestInstance(Lifecycle.PER_CLASS)
public class ClienteControllerTest {
	private ClienteController controller;
	
	@BeforeAll
	void set() {
		controller = new ClienteController();
	}
	
	@DisplayName("Testa a listagem de clientes")
	@Test
	void testList() throws Exception {
		Collection<Cliente> list = controller.listarClientes();
		assertNotNull(list);
	}		
	
	@DisplayName("Testa a inserção de um cliente")
	@Test
	void testeInsert() throws Exception {
		controller.inserirCliente(new Cliente());
	}
}
