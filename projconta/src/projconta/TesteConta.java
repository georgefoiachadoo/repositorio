package projconta;

public class TesteConta {
	public static void main(String [] args) {
		Cliente c = new Cliente("George", "123");
		Cliente c2 = new Cliente ("Maria", "645");
		Conta c1 = new Conta(789, 456, c, 123, 500);
		Conta cdois = new Conta(444, 678, c2, 960, 500);
		System.out.println("Dados da conta 1:");
		System.out.println(c1.toString());
		System.out.println("------------------");
		System.out.println("Dados da conta 2:");
		System.out.println(cdois.toString());
	}
}
