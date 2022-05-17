package br.com.fuhr.mysql.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import br.com.fuhr.mysql.model.Actor;

public class ActorController {
	private Connection getConnection() throws Exception {
		//primeiro parametro = url, segundo parametro = usuario, terceiro parametro = senha;
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila", "root", "fjsistemas");
		return con;
	}
	
	/**
	 * Metodo para buscar um ator do banco de dados
	 * @param actorId codigo do ator
	 * @return ator
	 * @throws Exception em problemas sql ou caso nao encontre
	 */
	public Actor getActor(int actorId) throws Exception {
		//abre a conexao
		Connection con = getConnection();
		
		try {
			//instancia um ator vazio
			Actor actor = null;
			
			//instrucao sql para consultar
			String sql = "SELECT actor_id, first_name, last_name, last_update FROM actor WHERE actor_id = ?";
			//prepara a statement para passar parametros
			PreparedStatement ps = con.prepareStatement(sql);
			//recebe o parametro id
			ps.setInt(1, actorId);
			//executa a instrucao sql e armazena o resultado
			//* sempre utilizar executeQuery quando retornar dados
			ResultSet rs = ps.executeQuery();
			//caso tenha resultado entra no while, na posicao referente
			while (rs.next()) {
				//busca campos 
				actorId = rs.getInt("actor_id");
				String firstName = rs.getString("first_name");
				String lastName = rs.getString("last_name");
				Timestamp lastUpdate = rs.getTimestamp("last_update");
				
				//instancia e atribui a um novo Actor
				actor = new Actor();
				actor.setActorId(actorId);
				actor.setFirstName(firstName);
				actor.setLastName(lastName);
				actor.setLastUpdate(lastUpdate);
			}
			
			//fecha resultset e preparedstatement
			rs.close();
			ps.close();
			
			
			//caso for nulo, dispara uma excecao
			if (actor == null) {
				throw new Exception("Actor not found.");
			}
			
			//retorna a instancia
			return actor;
		} catch (Exception e) {
			//caso encontre uma excessao, dispara ela
			throw e;
		}
		finally {
			//caso tenha uma conexao aberta, encerra
			if (con != null) {
				con.close();
			}
		}
	}
	
	
	/**
	 * Metodo para inserir um novo Actor
	 * @param actor
	 * @throws Exception
	 */
	public void insertActor(Actor actor) throws Exception {
		//abre conexao
		Connection con = getConnection();
		
		try {
			//define a instrucao sql 
			String sql = "INSERT INTO actor (first_name, last_name, last_update) VALUES (?, ?, ?)";
			//prepara statement para receber parametros
			PreparedStatement ps = con.prepareStatement(sql);
			//passa os parametros
			ps.setString(1, actor.getFirstName());
			ps.setString(2, actor.getLastName());
			ps.setTimestamp(3, actor.getLastUpdate());
			//executa a instrucao no banco
			//* utilizar executeUpdate sempre que for alterar dados no banco (insert, update, delete)
			ps.executeUpdate();
		} catch (Exception e) {
			//caso encontre uma excessao, dispara ela
			throw e;
		}
		finally {
			//caso tenha uma conexao aberta, encerra
			if (con != null) {
				con.close();
			}
		}
	}
	
	/**
	 * Metodo para retornar uma lista de Actors
	 * @return
	 * @throws Exception
	 */
	public List<Actor> listActors() throws Exception {
		//abre conexao
		Connection con = getConnection();
		
		try {
			//instancia uma lista vazia
			List<Actor> list = new ArrayList<Actor>();
			
			//define a instrucao sql
			String sql = "SELECT actor_id, first_name, last_name, last_update FROM actor ORDER BY first_name, last_name";
			//cria statement
			Statement st = con.createStatement();
			//executa a sql e armazena o resultado
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				//busca campos
				int actorId = rs.getInt("actor_id");
				String firstName = rs.getString("first_name");
				String lastName = rs.getString("last_name");
				Timestamp lastUpdate = rs.getTimestamp("last_update");
				
				//instancia novo actor para armazenar na lista
				Actor actor = new Actor();
				actor.setActorId(actorId);
				actor.setFirstName(firstName);
				actor.setLastName(lastName);
				actor.setLastUpdate(lastUpdate);
				
				//adiciona a lista
				list.add(actor);
			}
			
			//fecha resultset e statement para desalocar memoria
			rs.close();
			st.close();
			
			//retorna lista
			return list;
		} catch (Exception e) {
			//caso encontre uma excessao, dispara ela
			throw e;
		}
		finally {
			//caso tenha uma conexao aberta, encerra
			if (con != null) {
				con.close();
			}
		}
	}
	
	public void listPrintActors() throws Exception {
		Connection con = getConnection();
		
		try {
			SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
			
			String sql = "SELECT actor_id, first_name, last_update FROM actor";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				int actorId = rs.getInt("actor_id");
				String firstName = rs.getString("first_name");
				Timestamp lastUpdate = rs.getTimestamp("last_update");
				String dataFormatada = formatador.format(lastUpdate);
				
				System.out.println("id: "+actorId+", first name: "+firstName+", last update: "+dataFormatada);
			}
			rs.close();
			st.close();
		} catch (Exception e) {
			//caso encontre uma excessao, dispara ela
			throw e;
		}
		finally {
			//caso tenha uma conexao aberta, encerra
			if (con != null) {
				con.close();
			}
		}
	}
}
