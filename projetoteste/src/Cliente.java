import java.util.Scanner;
public class Cliente {
    private String nome;//Atributo de classe nome
    private String cpf;//Atributo de classe cpf

    public Cliente (String nome, String cpf) {
        this.nome = nome;//auto referencia de atributo para colocar os atributos da classe no objeto cliente
        this.cpf = cpf;
    }


    public String getNome() {//metodo getter
        return this.nome;
    }//método getter
    public String getCpf() {
        return this.cpf;
    }//método getter
    public void setNome(String nome) {//metodo setter
        this.nome = nome;
    }//metodo setter

    public String toString() {
        return "- Nome: " + this.nome  + "\n- Cpf: " + this.cpf;
    }

    /*
     * Cpf nao precisa de metodo setter pois não será alterado;
     */

}
