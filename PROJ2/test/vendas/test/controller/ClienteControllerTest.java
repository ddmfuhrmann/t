package vendas.test.controller;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
	void setup() {
		controller = new ClienteController();
	}
	
	@DisplayName("Testa a listagem de clientes")
	@Test
	void testList() throws Exception {
		Collection<Cliente> list = controller.listarClientes();
		assertNotNull(list);
	}		
	
	/**
	 * Quando tentar inserir sem nome, deve lançar uma exception
	 * @throws Exception
	 */
	@DisplayName("Testa a validação de nome")
	@Test
	void testeExceptionNome() {
		assertThrows(Exception.class, () -> controller.inserirCliente(new Cliente()));
	}
	
	@DisplayName("Testa a inserção de um cliente")
	@Test
	void testeInsert() throws Exception {
		controller.inserirCliente(new Cliente(0, "123456789-00", "Daniel"));
	}
}
