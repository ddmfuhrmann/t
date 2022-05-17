package br.com.fuhr.mysql;

import java.sql.Timestamp;
import java.util.List;

import br.com.fuhr.mysql.controller.ActorController;
import br.com.fuhr.mysql.model.Actor;
import br.com.fuhr.mysql.ui.ActorPrinter;

/**
 * Projeto para estudo de jdbc/mysql
 *
 */
public class App {
    public static void main(String[] args)  {
        ActorController controller = new ActorController();
        ActorPrinter printer = new ActorPrinter();
        try {
        	printer.exibeActor(controller.getActor(100));
        	
        	Actor actor = new Actor();
        	actor.setFirstName("JHON");
        	actor.setLastName("LENNON");
        	actor.setLastUpdate(new Timestamp(System.currentTimeMillis()));
        	controller.insertActor(actor);
        	
			List<Actor> list = controller.listActors();
			printer.exibeLista(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
        
    }
}
