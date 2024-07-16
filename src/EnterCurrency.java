import java.util.Scanner;

public class EnterCurrency {
    public static void enter(Scanner scanner) {
        try {
            System.out.print("Digite a abreviação da moeda!\n");
            System.out.print("Exemplos USD, BRL, EUR, JPY e outros...\n");
            System.out.print("Digite a moeda de origem: ");
            String originCurrency = scanner.next().toUpperCase();
            System.out.print("Digite a moeda de destino: ");
            String destinationCurrency = scanner.next().toUpperCase();
            Converter.currencyConverter(originCurrency, destinationCurrency, scanner);
        } catch (Exception e) {
            System.out.println("*********************** - ERRO - *******************************");
            System.out.println("Ocorreu um erro: " + e.getMessage());
            System.out.println("****************************************************************");
            // Finalizar a aplicação
            System.exit(1);
        }
    }
}
