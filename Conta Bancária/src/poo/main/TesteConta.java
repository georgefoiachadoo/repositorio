package poo.main;
import poo.gestaodecaixa.*;
import poo.gestaodeconta.*;
public class TesteConta {
	
	public static void main(String[] args) {
		Cliente clientes[] = { new Cliente("123", "Aparecida"), new Cliente("666", "Valdemar")};
		
		CadastroContas bd = new CadastroContas(2);
		for (int i = 0; i < clientes.length ; i++) {
			bd.adicionaConta(new Conta(i+1, clientes[i], 123, 1000.0));
		}
		Terminal t1 = new Terminal(bd);
		t1.iniciaOperacao();
		
	}

}
