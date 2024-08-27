package default_package;

public class Mamifero extends Animal {
	private String alimento;

	public Mamifero(String nome, String cor, String ambiente, String alimento, int comprimento, float velocidade,
			int patas) {
		super(nome, cor, ambiente, comprimento, velocidade, patas);
		this.alimento = alimento;
	}

	public String getAlimento() {
		return this.alimento;
	}

	public void alteraAlimento(String alimento) {
		this.alimento = alimento;
	}

	public String toString() {
		return super.toString() + "\n" + "Alimento: " + this.alimento;
	}
}
