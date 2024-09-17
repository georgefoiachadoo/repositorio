package Itens;
import Usuarios.Usuario;
public class Periodico extends Livro {
	public Periodico(String tit) {
		super(tit);
	}
	@Override
	public boolean empresta(Usuario u, int prazo) {
		if (u.isProfessor()) {//se usuario for professor
			return super.empresta(u, 7);//empresta com prazo de uma semana(7 dias)

		} else {
			return false;
		}
	}
}
