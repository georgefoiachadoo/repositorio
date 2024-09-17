package Itens;

import java.util.Calendar;
import java.util.GregorianCalendar;
import Usuarios.Usuario;

public class MapaTematico extends Item {
	private int nivPriv;

	public MapaTematico(String nome, int nP) {
		super(nome);
		this.nivPriv = nP;

	}
	

	@Override
	public boolean empresta(Usuario u, int prazo) {
		GregorianCalendar cal = new GregorianCalendar();
		if ((this.isDisponivel()) && (u.getNivelPriv() >= this.nivPriv)) {// checa se o mapa esta disponivel e se o
																			// usuario possui privilegio
			this.retiradoPor = u;// adiciona o usuario q retirou o mapa
			this.dtEmprestimo = cal.getTime();
			cal.add(Calendar.DATE, 2);
			this.dtDevolucao = cal.getTime();
			return true;
		}
		return false;
	}


}
