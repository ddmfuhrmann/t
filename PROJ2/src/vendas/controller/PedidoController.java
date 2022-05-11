package vendas.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PedidoController {
	/**
	 * Recebe uma data no formado dd/mm/yyyy em String
	 * e retorna uma instacia de Date
	 * @param data
	 * @return
	 */
	public Date stringToDate(String data) {
		try {
			return new SimpleDateFormat("dd/MM/yyyy").parse(data);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
}
