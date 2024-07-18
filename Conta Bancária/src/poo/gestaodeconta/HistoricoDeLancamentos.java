package poo.gestaodeconta;

public class HistoricoDeLancamentos {
	private Lancamento[] lancamentos;
	private int numLancamentos;
	private int ultimoLancamento;

	public HistoricoDeLancamentos(int numLancamentos) {
		this.numLancamentos = numLancamentos;
		this.lancamentos = new Lancamento[numLancamentos + 1];

	}

	public void realizaLancamento(String descricao, double valor) {
		if (this.ultimoLancamento == this.numLancamentos) {
			for (int i = 1; i <= 10; i++) {
				this.lancamentos[i - 1] = this.lancamentos[i];
			}
		} else {
			this.ultimoLancamento++;
		}
		this.lancamentos[this.ultimoLancamento] = new Lancamento(descricao, valor);
	}

	public String geraHistoricoDeLancamentos() {
		StringBuilder historico = new StringBuilder();
		for (int i = 1; i <= this.ultimoLancamento; i++) {
			historico.append(this.lancamentos[i].getDescricao()).append(":R$").append(this.lancamentos[i].getValor())
					.append("\n");
		}
		return historico.toString();
	}
}
