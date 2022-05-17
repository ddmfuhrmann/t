package br.com.fuhr.mysql.ui;

import java.util.List;

import br.com.fuhr.mysql.model.Actor;

public class ActorPrinter {
	public void exibeLista(List<Actor> list) {
		for (Actor actor : list) {
			exibeActor(actor);
		}
	}
	
	public void exibeActor(Actor actor) {
		System.out.println(actor);
	}
}
