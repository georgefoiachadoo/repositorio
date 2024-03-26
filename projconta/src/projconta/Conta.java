package projconta;

public class Conta {
		private int numero;
		private Cartao cartao;
		private int senha;
		private double saldo;
	public Conta(int numConta, int numCartao, Cliente titular, int senha, double saldo) {
			this.numero = numConta;
			this.cartao = new Cartao(numCartao, titular);
			this.senha = senha;
			this.saldo = saldo;
			}
	
			public Conta(int numConta, int numCartao, Cliente titular, int senha) {
			this.numero = numConta;
			this.cartao = new Cartao(numCartao, titular);
			this.senha = senha;
			}
			public Cartao getCartao() {
				return cartao;
			}
			
			public void alteraCartao(int numeroDoCartao, Cliente titular) {
				this.cartao = new Cartao(numeroDoCartao, titular);
				}
			
			public String toString() {
				return "Numero da Conta: " + this.numero + " || " +  this.cartao.toString() + " || Senha: " + this.senha  + " || Saldo: " + this.saldo;
			}
			
			}

