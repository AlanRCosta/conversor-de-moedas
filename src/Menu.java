import java.util.Scanner;

public class Menu {
    public void display() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("----------------------------------------------------------------");
            System.out.println("Seja bem-vindo(a) ao Conversor de Moedas =]");
            System.out.println("----------------------------------------------------------------");
            System.out.println("1) Dólar =>> Real Brasileiro");
            System.out.println("2) Real Brasileiro =>> Dólar");
            System.out.println("3) Dólar =>> Peso Argentino");
            System.out.println("4) Peso Argentino =>> Dólar");
            System.out.println("5) Dólar =>> Peso Colombiano");
            System.out.println("6) Peso Colombiano =>> Dólar");
            System.out.println("7) Escolha as moedas de origem e destino");
            System.out.println("8) Sair \n");

            System.out.print("Escolha uma opção válida: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    Converter.currencyConverter("USD", "BRL", scanner);
                    break;
                case 2:
                    Converter.currencyConverter("BRL", "USD", scanner);
                    break;
                case 3:
                    Converter.currencyConverter("USD", "ARS", scanner);
                    break;
                case 4:
                    Converter.currencyConverter("ARS", "USD", scanner);
                    break;
                case 5:
                    Converter.currencyConverter("USD", "COP", scanner);
                    break;
                case 6:
                    Converter.currencyConverter("COP", "USD", scanner);
                    break;
                case 7:
                    EnterCurrency.enter(scanner);
                    break;
                case 8:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("*********************** - ERRO - *******************************");
                    System.out.println("Opção inválida.");
                    System.out.println("****************************************************************");
                    // Após exibir o resultado, aguarda a entrada do usuário para retornar ao menu principal
                    System.out.println("\nPressione Enter para voltar ao menu principal...");
                    scanner.nextLine(); // Limpa o buffer
                    scanner.nextLine(); // Aguarda a entrada do usuário
            }
        } while (choice != 8);

        scanner.close();
        // Finalizar a aplicação
        System.exit(1);
    }
}