package poo.gestaodeconta;

public class Cliente {

	private String cpf;
	private String nome;

	public Cliente(String cpf, String nome) {
		this.cpf = cpf;
		this.nome = nome;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return this.cpf;
	}

	public String toString() {
		return "Nome: " + this.nome + "\nCPF: " + this.cpf;
	}

}
