package Itens;
import Usuarios.Usuario;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public abstract class Item {
	protected Usuario retiradoPor;
	protected Date dtEmprestimo;
	protected Date dtDevolucao;
	protected String titulo;
	protected String state;
	
	public Item (String nome) {
		this.titulo = nome;
	}
	public String getTitulo() {
		return this.titulo;
	}
	
	public Usuario getDono() {
		return this.retiradoPor;
	}
	
	public boolean empresta(Usuario u, int prazo) {// ação de retirar o item
		GregorianCalendar cal = new GregorianCalendar();
		if (this.isDisponivel()) {// se o item estiver disponivel
			this.retiradoPor = u;// atribui o usuario que retirou o item
			this.dtEmprestimo = cal.getTime();// registra a data de emprestimo do item
			cal.add(Calendar.DATE, prazo);// estipula um prazo, dado pelo metodo presente na classe usuario ou predeterminado
			this.dtDevolucao = cal.getTime();
			return true;
		}
		return false;// retorna 'false' se o item nao estiver disponivel
	}

	public boolean retorna(Usuario u) {// coloca o item de volta na estante
		if (u == this.retiradoPor) {// se o usuario for quem retirou o item
			this.retiradoPor = null;// atribui null ao atributo 'retiradopor'
			return true;
		}
		return false;
	}

	public boolean isDisponivel() {// verifica se o mapa esta disponivel
		return this.retiradoPor == null;

		// se o mapa nao foi emprestado vai retornar 'true', se não vai retornar 'false'
	}
	
	public boolean isEmprestado() {// verifica se o livro foi emprestado
		return !(this.retiradoPor == null);// !(true) == false;; !false == true;;
		// retorna 'false' se nenhum usuario tiver retirado. retorna 'true' se um
		// usuario tiver retirado
	}
	
	public boolean isEmAtraso() {
		Date hoje = new Date();
		if ((this.dtDevolucao.before(hoje) && (this.retiradoPor != null))) {
			return true;

			// se o Item tiver data de devolução anterior a hoje, e o livro não tiver sido
			// devolvido(se o campo 'retiradoPor' for diferente de null)
		}
		return false;
	}
	

	public String toString() {
		if (this.isDisponivel()) {//se o item estiver disponivel
			return this.titulo + " (disponivel)";//retornar uma string que diz 'disponivel'
		}
		state = this.titulo + " (retirado por " + this.retiradoPor + " em " + dma(this.dtEmprestimo) + " ate "
				+ dma(this.dtDevolucao) + ")";
		return state;
	
}
	protected String dma(Date dt) {//string para formato dia/mes/ano, pois gregoriancalendar usa mes/dia/ano
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(dt);
		return cal.get(Calendar.DATE) + "/" + (cal.get(Calendar.MONTH) + 1) + "/" + cal.get(Calendar.YEAR);
	}
	
	
	
}
