package default_package;

public class Peixe extends Animal {
	private String caracteristica;

	Peixe(String nome, String caracteristica, String ambiente, int comprimento, float velocidade, String cor) {
		super(nome, cor, ambiente, comprimento, velocidade, 0);
		this.caracteristica = caracteristica;
	}

	public void alteraCaracteristica(String caracteristica) {
		this.caracteristica = caracteristica;
	}

	public String getCaracteristica() {
		return this.caracteristica;
	}

	public String toString() {
		return super.toString() + "\n" + "Caracteristica: " + this.caracteristica;

	}
}
