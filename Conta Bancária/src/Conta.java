
public class Conta {

	private int numero;
	private Cliente titular;
	private int senha;
	private double saldo;
	private Lancamento[] lancamentos;
	private int ultimoLancamento;
	private HistoricoDeLancamentos HistoricoDeLancamentos;

	public Conta(int numero, Cliente titular, int senha, double saldo) {
		this.numero = numero;
		this.titular = titular;
		this.senha = senha;
		this.saldo = saldo;
		this.HistoricoDeLancamentos = new HistoricoDeLancamentos(10);
	}

	public Cliente getTitular() {
		return this.titular;
	}

	public void setTitular(Cliente titular) {
		this.titular = titular;
	}

	public int getNumero() {
		return this.numero;
	}

	public boolean creditaValor(double valor, String operacaoBancaria) {
		if (valor < 0) {
			return false;
		}
		this.realizaLancamento(operacaoBancaria, -valor);
		this.saldo+= valor;
		return true;
	}

	public double verificaSaldo(int senha) {
		if (senhaEhValida(senha)) {
			return this.saldo;
		}
		return -1;
	}

	public boolean debitaValor(double valor, int senha,
		String operacaoBancaria) {
			if (!senhaEhValida(senha) | valor > this.saldo | valor < 0) {
			return false;
			}
			
			this.realizaLancamento(operacaoBancaria, -valor);
			this.saldo -= valor;
			return true;
	}
	private void realizaLancamento(String descricao, double valor) {
		if(this.ultimoLancamento == 10) {
		for(int i = 1; i < 10; i++) {
		this.lancamentos[i-1] = this.lancamentos[i];
		}
		}
		else {
		this.ultimoLancamento++;
		}
		this.lancamentos[this.ultimoLancamento] =
		new Lancamento(descricao, valor);
		}
	
	private boolean senhaEhValida(int senha) {
		if(senha == this.senha) {
			return true;
		}
	
		return false;
	}
	
	

}
