package atividade1;
public class Automovel {

    private String placa;
    private double kmTotal;
    private double capacidadeDoTanque;
    private double eficiencia;
    private double combustivelNoTanque;
    private int numeroDeViagensRealizadas;

    public Automovel(String placa, double capacidadeDoTanque, double eficiencia){
        this.placa = placa;
        this.capacidadeDoTanque = capacidadeDoTanque;
        this.eficiencia = eficiencia;
    }


public String getPlaca() {
    return placa;
}
public double getKmTotal() {
    return kmTotal;
}
public double getCapacidadeDoTanque() {
    return capacidadeDoTanque;
}
public double getEficiencia() {
    return eficiencia;
}
public double getCombustivelNoTanque() {
    return combustivelNoTanque;
}

public int getNumeroDeViagensRealizadas() {
    return numeroDeViagensRealizadas;
}

public void abastece(double quantidade) {
    if(quantidade > 0) {
        this.combustivelNoTanque += quantidade;
        if(this.getCombustivelNoTanque() >
                this.getCapacidadeDoTanque()) {
            this.combustivelNoTanque = this.getCapacidadeDoTanque();
        }
    }
}

public void dirige(double distancia) {
    if (distancia > 0) {
        if (this.gastoDeCombustivel(distancia) >
                this.combustivelNoTanque) {
            distancia = this.autonomia();
        }
        this.numeroDeViagensRealizadas++;
        this.kmTotal += distancia;
        this.combustivelNoTanque -= this.gastoDeCombustivel(distancia);
    }
}
public double gastoDeCombustivel(double distancia) {
    return distancia / this.eficiencia;
}
public double autonomia() {
    return this.combustivelNoTanque * this.eficiencia;
}

}