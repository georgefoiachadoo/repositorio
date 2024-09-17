package Itens;

import Usuarios.*;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Date;

public class Livro extends Item {
	private UsuarioProfessor bloqueadoPor;
	private Date dtBloqueio;
	private Date dtDesbloqueio;
	private boolean isPeriodico;

	public Livro(String tit) {
		super(tit);
		this.titulo = tit;
	}
	
	public void setPer() {
		this.isPeriodico = true;
	}
	public boolean getPer() {
		return isPeriodico;
	}
	
	public UsuarioProfessor getBloqueador() {
		return this.bloqueadoPor;
	}

	@Override
	public boolean isDisponivel() {// verifica se o livro esta disponivel
		Date hoje = new Date();
		return this.retiradoPor == null && (this.bloqueadoPor == null || this.dtDesbloqueio.before(hoje));

		// se não houver usuario que retirou e se algum usuario tiver bloqueado, ou a
		// data de
		// desbloqueio for anterior ao dia atual
	}

	public boolean isBloqueado() {// verifica se o livro foi bloqueado
		Date hoje = new Date();
		return this.retiradoPor == null && !(this.bloqueadoPor == null) && !(this.dtDesbloqueio.before(hoje));

		// se não houver usuario que retirou e se algum usuario tiver bloqueado, ou a
		// data de
		// desbloqueio for anterior ao dia atual
	}

	public boolean bloqueia(UsuarioProfessor u, int prazo) {// bloqueia o livro
		GregorianCalendar cal = new GregorianCalendar();
		if (this.isDisponivel() && u.isProfessor()) {// se estiver disponivel e o usuario for um professor
			this.bloqueadoPor = u;// atualiza o atributo bloqueadoPor e atribui o usuario 'u' que fez o bloqueio
			this.dtBloqueio = cal.getTime();// calcula a data de bloqueio do livro
			cal.add(Calendar.DATE, (prazo > 20 ? 20 : prazo));// adiciona data ao calendario, se o prazo for maior que
																// 20, se o prazo for menor que 20
			this.dtDesbloqueio = cal.getTime();// atribui a data adicionada ao atributo 'data de desbloqueio'
			return true;// retorna verdadeiro após a operação ser concluida
		}
		return false;// se as condições 'está disponivel' ou 'usuário é professor' não forem
						// atendidos, retornar 'false'
	}

	public boolean desbloqueia(UsuarioProfessor u) {// desbloqueia o livro
		if (u == this.bloqueadoPor) {// se o usuario que tentar desbloquear for o mesmo que bloqueou
			this.bloqueadoPor = null;// atribui null ao atributo 'retirado por'
			return true;
		}
		return false;// se as condições não forem atendidas, retornar 'false'
	}

	@Override
	public String toString() {
		if (this.isDisponivel()) {// se o livro estiver disponivel
			if (this.isPeriodico == true) {
				return this.titulo + " (disponivel APENAS PARA PROFESSORES)";// retornar uma string que diz 'disponivel'
			} else {
				return this.titulo + " (disponivel)";// retornar uma string que diz 'disponivel'
			}
			
		}
		if (this.isEmprestado()) {// se o livro foi emprestado
			this.state = this.titulo + " retirado por " + this.retiradoPor + " em " + dma(this.dtEmprestimo) + " ate "
					+ dma(this.dtDevolucao);
		} else {// se o livro nao foi emprestado, mas não estiver disponivel, ele foi bloqueado
			this.state = this.titulo + " bloqueado por " + this.bloqueadoPor + " em " + dma(this.dtBloqueio) + " ate "
					+ dma(this.dtDesbloqueio);
		}
		return super.state;
	}

}