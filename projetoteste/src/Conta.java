import java.sql.SQLOutput;
import java.util.Scanner;

public class Conta {
    //Atributos da classe Conta:
    private String numero;
    private Cliente titular;
    private String senha;
    private double saldo;
    private int dec;

    public Conta (String numero, Cliente titular, String senha, double saldo) {//Construtor de objeto Conta
        this.numero = numero;//Se utiliza o this para alterar o atributo do objeto, caso não usar, altera o atributo da classe
        this.titular = titular;
        this.senha = senha;
        this.saldo = saldo;
    }

    public void setDec(int dec) {//Método setter
        this.dec= dec;
    }
    public int getDec() {//Método getter
        return this.dec;
    }

    public void alteraSaldo() {
        /*
         * Esse método altera o saldo do objeto Conta, como apenas precisamos chamá-lo na main, não são
         * necessários os parâmentros
         *
         */
        if (dec == 1) {//Caso o usuário quiser fazer alteração no saldo
            System.out.println("> Qual operação voce deseja fazer?:");
            System.out.println("(1) Depósito (2) Retirada");
            Scanner scanOper = new Scanner(System.in);
            int operValue = scanOper.nextInt();
            System.out.println("\n-----------------------------------------");
            if (operValue == 1) {//Operação de depósito
                System.out.println("\nDEPÓSITO\n");
                System.out.println("- Qual é o valor a ser depositado?:");
                Scanner scanDep = new Scanner(System.in);
                double valDep =  scanDep.nextDouble();
                this.saldo += valDep;
                System.out.println("\n-----------------------------------------\n");
                System.out.println("Operação Concluída!");
                System.out.println("Saldo atual: " + this.saldo);
            } else if (operValue == 2) {//Operação de retirada
                System.out.println("\nRETIRADA\n");
                System.out.println("- Qual o valor a ser retirado?:");
                Scanner scanRet = new Scanner(System.in);
                double valRet = scanRet.nextDouble();
                this.saldo -= valRet;
                System.out.println("\n-----------------------------------------\n");
                System.out.println("Operação Concluída!");
                System.out.println("Saldo atual: " + this.saldo);
            } else {
                System.out.println("\n");
                System.out.println("ERRO: Operação Inválida");
            }


            // DEPOIS CRIAR UM CÓDIGO COM A MESMA FUNÇÃO, MAS USANDO SWITCH CASE;
        }
    }

    public String toString() {
        //Este método retorna os atributos do objeto como String
        return "- Numero da conta: " + this.numero + "\n" + this.titular.toString() + "\n- Senha: " + this.senha + " \n- Saldo: " + this.saldo;
    }



}
