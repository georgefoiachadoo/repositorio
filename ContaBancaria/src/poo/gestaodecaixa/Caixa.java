package poo.gestaodecaixa;

import poo.gestaodeconta.*;
public class Caixa {
	private Terminal meuTerminal;
	private CadastroContas bdContas;
	private double saldo;

	public Caixa(Terminal meuTerminal, CadastroContas bd) {
		this.meuTerminal = meuTerminal;
		this.bdContas = bd;
	}

	public double consultaSaldo(int numeroDaConta, int senha) {
		Conta conta;
		conta = this.bdContas.buscaConta(numeroDaConta);
		if (conta != null) {
			return conta.verificaSaldo(senha);
		} else {
			return -1;
		}
	}

	public boolean efetuaSaque(int numeroDaConta, double valor, int senha) {
		if (valor < 0 || (valor % 50) != 0 || valor > 500 || valor > this.saldo) {
			return false;
		}
		Conta conta = bdContas.buscaConta(numeroDaConta);
		if (conta == null || !conta.debitaValor(valor, senha, "Saque Automatico")) {
			return false;
		}
		this.liberaCedulas((int) (valor / 50));
		this.saldo -= valor;
		if (this.saldo < 500) {
			this.meuTerminal.setModo(0);
		}
		return true;
	}

	public void recarrega() {
		this.saldo = 2000;
		this.meuTerminal.setModo(1);
	}

	private void liberaCedulas(int quantidade) {
		while (quantidade-- > 0) {
			System.out.println("===/ R$50,00 /===");
		}
	}

	public int depositoCheque(int num, double val, int senha) {

		Conta c = bdContas.buscaConta(num);
		boolean t = c.creditaValor(val, "Depósito", senha);
		if (t == true) {
			return 1;
		} else {
			return 2;
		}
	}
	public int transfere(int num1, int num2, double val, int senha ) {
		Conta cn1 = bdContas.buscaConta(num1);
		Conta cnh = bdContas.buscaConta(num2);
		boolean t = cn1.debitaValor(val, senha, "Retirada");
		if (t == true) {
			cnh.creditaValor(val, "Deposito", senha);
			return 1;
		} else {
			return 2;
		}
			
	}
	
	public void mostraExtrato(int num, int senha) {
		Conta c = bdContas.buscaConta(num);
		System.out.println(c.geraExtrato(senha));
	}
}