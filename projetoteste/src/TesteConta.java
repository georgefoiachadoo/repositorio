import java.util.Scanner;
import static java.lang.Integer.parseInt;//importa a função parse Int

public class TesteConta {
    public static void main(String[] args) {

        Cliente cliente1 = new Cliente("George", "609.617");
        Cliente cliente2 = new Cliente("Matheus", "606.543");
        Conta c1 = new Conta("1200", cliente1, "2434", 900);
        Conta c2 = new Conta ("1123", cliente2, "3523", 745);
        System.out.println("\n-----------------------------------------\n");
        System.out.println(">> Dados da conta:");
        System.out.println(c1.toString());
        System.out.println("\n-----------------------------------------");
        System.out.println(">> Voce deseja alterar o saldo? (Digite 1 para SIM ; Digite 2 para NÃO)");
        Scanner scAlt = new Scanner (System.in);//Invoca o Scanner
        int decAlt = scAlt.nextInt();//a variavel armazena o valor inteiro do Scanner(comando nextInt)
        /*
         * nextInt = transforma a entrada do scanner em inteiro
         * nextFloat = tranforma em float
         * nextLine = transforma em String
         */
        c1.setDec(decAlt);
        c1.alteraSaldo();

        System.out.println("\n-----------------------------------------\n");
        System.out.println(">> Dados da conta:");
        System.out.println(c2.toString());
        System.out.println("\n-----------------------------------------\n");
        System.out.println(">> Voce deseja alterar o saldo? (Digite 1 para SIM ; Digite 2 para NÃO)");
        scAlt = new Scanner(System.in);
        decAlt = scAlt.nextInt();
        c2.setDec(decAlt);
        c2.alteraSaldo();


    }
}