
public class Lance {
	private double valor;
	private Pessoa licitante;
	
	public Lance (double valor, Pessoa l) {
		this.valor = valor;
		this.licitante = l;
	}
	
	public double getValor() {
		return valor;
	}
	public void setValor() {
	   this.valor = valor;
	}
	public Pessoa getl(Pessoa l) {
		return licitante;
	}
	public void setl(Pessoa l) {
	   this.licitante = l;
	}
}
