package Usuarios;
import Itens.Item;
import Itens.Livro;
import Itens.MapaTematico;
public class UsuarioProfessor extends Usuario {

	public UsuarioProfessor(String nome) {
		super(nome);
		this.nivelDePrivilegio = 3;
	}
	
	@Override
	public boolean retiraItem(Item it) {

		if (it.isDisponivel()) {//checa se o livro esta disponivel
			it.empresta(this, getPrazoMaximo());//chama o metodo empresta da classe ite,m
			this.itensRetirados.add(it);
			return true;
		}
		return false;
	}
	@Override
	public boolean devolveItem(Item it) {
		this.itensRetirados.remove(it);
		return true;
	}

	
	public boolean bloqueiaLivro(Livro livro, int prazo) {//bloqueia um livro
		return livro.bloqueia(this, prazo); // chama o método bloqueia da classe Livro
	}

	
	public boolean desbloqueiaLivro(Livro livro) {//desbloqueia o livro
		return livro.desbloqueia(this); // chama o método desbloqueia da classe Livro
	}

	@Override
	public int getCotaMaxima() {//define quantidade maxima de livros que o usuario pode retirar
		return 5; // Professores retiram até 5 livros
	}
	
	@Override
	public int getPrazoMaximo() {//define prazo maximo
		return 14; // Professores têm 14 dias para devolver
	}

	@Override
	public String toString() {
		return "Prof. " + super.getNome();
	}
	@Override
	public boolean isProfessor() {
		return true;
	}
}
