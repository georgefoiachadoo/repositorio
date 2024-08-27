package default_package;

public class Teste {
	public static void main(String[] args) {
		Peixe p = new Peixe("Tilapia", "Barbatana", "Mar", 50, 2, "Marrom");
		Mamifero m = new Mamifero("Urso", "Marrom", "Terra", "Mel", 200, 200, 4);
		System.out.println("Zoo: " + p.toString() + m.toString());
	}
}
