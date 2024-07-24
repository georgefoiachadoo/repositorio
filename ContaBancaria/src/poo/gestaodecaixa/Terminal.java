package poo.gestaodecaixa;

import java.util.Scanner;

public class Terminal {
	private Caixa meuCaixa;
	private int modoAtual;

	public Terminal(CadastroContas bd) {
		this.meuCaixa = new Caixa(this, bd);
	}

	public void iniciaOperacao() {
		int opcao;
		opcao = this.getOpcao();
		while (opcao != 4) {
			switch (opcao) {
			case 1:
				double saldo = this.meuCaixa.consultaSaldo(getInt("Numero da Conta"), getInt("Senha"));
				if (saldo != -1) {
					System.out.println("Saldo Atual: " + saldo);
				} else {
					System.out.println("Conta/senha inválida");
				}
				break;
			case 2:
				boolean b = this.meuCaixa.efetuaSaque(getInt("Numero da Conta"), (double) getInt("Valor"),
						getInt("Senha"));
				if (b) {
					System.out.println("Retire o dinheiro");
				} else {
					System.out.println("Pedido de saque recusado");
				}
				break;
			case 3:
				this.meuCaixa.recarrega();
				break;
			case 5:
				int bool = this.meuCaixa.depositoCheque(getInt("Numero da Conta"), (double) getInt("Valor"),
						getInt("Senha"));
				if (bool == 1) {
					System.out.println("Depósito Realizado!");
				} else if (bool == 2) {
					System.out.println("Senha incorreta");
				}

				break;
			case 6:
				int bol = this.meuCaixa.depositoCheque(getInt("Numero da Conta"), (double) getInt("Valor"),
						getInt("Senha"));
				if (bol == 1) {
					System.out.println("Depósito Realizado!");
				} else if (bol == 2) {
					System.out.println("Senha incorreta");
				}

				break;
			case 7:
				int test = this.meuCaixa.transfere(getInt("Numero da Conta 1"), getInt("Numero da Conta 2"),
						(double) getInt("Valor"), getInt("Senha"));
				if (test == 1) {
					System.out.println("Transferencia Realizada!");
				} else if (test == 2) {
					System.out.println("Senha incorreta");
				}
				break;
			case 8:
				this.meuCaixa.mostraExtrato(getInt("Numero da Conta"), getInt("Senha"));
				break;
				

			}
			opcao = getOpcao();
		}
	}

	public void setModo(int modo) {
		if (modo == 0 || modo == 1) {
			this.modoAtual = modo;
		}
	}

	private int getOpcao() {
		int opcao;
		do {
			if (this.modoAtual == 1) {
				opcao = getInt(
						"Opcao: 1 - Consulta Saldo, 2 - Saque, 5 - Deposito (Cheque), 6 - Deposito(Cedulas), 7 - Transferencia, 8 - Ver Extrato, 4 - Sair");
				if (opcao != 1 & opcao != 2 & opcao != 4 & opcao != 5 & opcao != 6 & opcao != 7 & opcao != 8) {
					opcao = 0;
				}
			} else {
				opcao = getInt("Opcao: 3 - Recarrega, 4 - Sair");
				if (opcao != 3 & opcao != 4) {
					opcao = 0;
				}
			}
		} while (opcao == 0);
		return opcao;
	}

	private int getInt(String string) {
		Scanner r = new Scanner(System.in);
		System.out.println("Entre com " + string);

		if (r.hasNextInt()) {
			return r.nextInt();
		}
		String st = r.next();
		System.out.println("Erro na Leitura de Dados");
		return 0;
	}
}