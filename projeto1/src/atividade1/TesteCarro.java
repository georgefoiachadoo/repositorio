package atividade1;

public class TesteCarro {
    public static void main (String [] args) {
        Automovel automovel = new Automovel("PTY5B23", 50, 10);
        automovel.abastece(50);
        System.out.println(automovel.getCombustivelNoTanque());
        automovel.dirige(400.0);
        System.out.println(automovel.getCombustivelNoTanque());
        System.out.println("Numero de viagens realizadas:" + automovel.getNumeroDeViagensRealizadas());
        System.out.println("Quilometragem total: " + automovel.getKmTotal());
        automovel.dirige(150);
        System.out.println("Quilometragem total: " + automovel.getKmTotal());
        //a main()
        
    }
}
