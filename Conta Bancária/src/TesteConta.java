
public class TesteConta {
	
	public static void main(String[] args) {
		
		Cliente cliente = new Cliente("123", "João");
		Conta c1 = new Conta(1, cliente, 123, 200);
		
		c1.creditaValor(500, "Saque");
		
		System.out.println(c1.verificaSaldo(123));
	}

}
