package poo.gestaodecaixa;

import poo.gestaodeconta.Conta;

public class Caixa {
	private Terminal meuTerminal;
	private CadastroContas bdContas;
	private double saldo;
	
	public Caixa (Terminal meuTerminal, CadastroContas bd) {
		this.meuTerminal = meuTerminal;
		this.bdContas = bd;
	}
	
	public double consultaSaldo( int numeroDaConta, int senha) {
	 Conta conta;
	 conta = this.bdContas.buscaConta(numeroDaConta);
	  if(conta!= null) {
		  return conta.verificaSaldo(senha);
	  } else {
		  return -1;
	  }
	}
	public boolean efetuaSaque(int numeroDaConta,
			double valor, int senha) {
		if(valor < 0 || (valor%50) != 0 || valor > 500 || valor > this.saldo) {
			return false;
		}
		Conta conta = bdContas.buscaConta(numeroDaConta);
		if (conta == null || !conta.debitaValor(valor, senha, "Saque Automatico")){
			return false;
			}
		this.liberaCedulas((int)(valor/50));
		this.saldo -= valor;
		if(this.saldo < 500){
		this.meuTerminal.setModo(0);
		}
		return true;
		}
		public void recarrega(){
		this.saldo = 2000;
		this.meuTerminal.setModo(1);
		}
		private void liberaCedulas(int quantidade){
		while(quantidade-- > 0){
		System.out.println("===/ R$50,00 /===");
			}
		}
	}

