import java.util.Scanner;

public class Menu {
    public void mostrarMenu() {
        Scanner inputDoUsuario = new Scanner(System.in);
        int escolhaDoMenu = 0;

       do {
            System.out.println("*******************************************");
            System.out.println("Seja bem vindo(a) ao Conversor de Moedas =]\n");
            System.out.println("1) Dólar Americano (USD) para Real Brasileiro (BRL)");
            System.out.println("2) Real Brasileiro (BRL) para Dólar Americano (USD)");
            System.out.println("3) Dólar Americano (USD) para Peso Argentino (ARS)");
            System.out.println("4) Peso Argentino (ARS) para Dólar Americano (USD)");
            System.out.println("5) Dólar Americano (USD) para Peso Colombiano (COP)");
            System.out.println("6) Peso Colombiano (COP) para Dólar Americano (USD)");
            System.out.println("7) Sair");
            System.out.println("Escolha uma opção válida");
            System.out.println("*******************************************");

            escolhaDoMenu = inputDoUsuario.nextInt();

            switch (escolhaDoMenu) {
                case 1:
                    Conversor.conversorDeMoedas("USD", "BRL", inputDoUsuario);
                    break;
                case 2:
                    Conversor.conversorDeMoedas("BRL", "USD", inputDoUsuario);
                    break;
                case 3:
                    Conversor.conversorDeMoedas("USD", "ARS", inputDoUsuario);
                    break;
                case 4:
                    Conversor.conversorDeMoedas("ARS", "USD", inputDoUsuario);
                    break;
                case 5:
                    Conversor.conversorDeMoedas("USD", "COP", inputDoUsuario);
                    break;
                case 6:
                    Conversor.conversorDeMoedas("COP", "USD", inputDoUsuario);
                    break;
                case 7:
                    System.out.println("Você escolheu sair...");
                    break;
                default:
                    System.out.println("Opção inválida");
                    escolhaDoMenu = 0;
            }
        }  while (escolhaDoMenu != 7);
            inputDoUsuario.close();
        }
    }