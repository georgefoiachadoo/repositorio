package atividade2;

public class TesteBarata {
	public static void main(String[] args) {
		PopulacaoDeBaratas pb = new PopulacaoDeBaratas(10);
		System.out.println(pb.toString());
		pb.esperaUmTempo();
		System.out.println(pb.toString());
		pb.pulveriza();
		System.out.println(pb.toString());
		PopulacaoDeBaratas psp = new PopulacaoDeBaratas();
		System.out.println(psp.toString());
		psp.esperaUmTempo();
		psp.pulveriza();
		psp.pulveriza();
		System.out.println(psp.toString());
	}
}
