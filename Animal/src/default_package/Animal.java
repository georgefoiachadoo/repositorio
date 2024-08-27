package default_package;

public class Animal {
	private String nome;
	private String cor;
	private String ambiente;
	private int comprimento;
	private float velocidade;
	private int patas;

	public Animal(String nome, String cor, String ambiente, int comprimento, float velocidade, int patas) {
		this.nome = nome;
		this.cor = cor;
		this.ambiente = ambiente;
		this.comprimento = comprimento;
		this.velocidade = velocidade;
		this.patas = patas;
	}

	public void alteraNome(String nome) {
		this.nome = nome;
	}

	public void alteraComprimento(int comprimento) {
		this.comprimento = comprimento;
	}

	public void alteraPatas(int patas) {
		this.patas = patas;
	}

	public void alteraCor(String cor) {
		this.cor = cor;
	}

	public void alteraAmbiente(String ambiente) {
		this.ambiente = ambiente;
	}

	public void alteraVelocidade(float velocidade) {
		this.velocidade = velocidade;
	}

	public String toString() {
		return "\n----------------" + "\n" + "Animal: " + this.nome + "\n" + "Comprimento: " + this.comprimento + "cm"
				+ "\n" + "Patas: " + this.patas + "\n" + "Cor: " + this.cor + "\n" + "Ambiente: " + this.ambiente + "\n"
				+ "Velocidade: " + this.velocidade + " m/s";
	}

}
