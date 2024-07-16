import java.net.URL;
import java.net.HttpURLConnection;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;
import com.google.gson.JsonParser;
import com.google.gson.JsonObject;

public class Converter {
    public static void currencyConverter(String originCurrency, String destinationCurrency, Scanner scanner) {
        try {
            String apiKey = "658681d7a1207d736a141708"; // Chave da API
            String url_str = "https://v6.exchangerate-api.com/v6/" + apiKey + "/latest/" + originCurrency;

            URL url = new URL(url_str);
            HttpURLConnection request = (HttpURLConnection) url.openConnection();
            request.connect();

            JsonObject jsonObj = JsonParser.parseReader(new InputStreamReader((InputStream) request.getContent())).getAsJsonObject();

            JsonObject conversionRates = jsonObj.getAsJsonObject("conversion_rates");

            if (!conversionRates.has(destinationCurrency)) {
                System.out.println("Moeda de destino inválida.");
                return;
            }

            double exchangeRate = conversionRates.get(destinationCurrency).getAsDouble();

            System.out.print("Digite o valor a ser convertido: ");
            double value = scanner.nextDouble();

            double convertedValue = value * exchangeRate;

            System.out.println("************* - RESULTADO DA CONVERSÃO - ***********************");
            System.out.println("           " + value + " " + originCurrency + " Equivalem a " + convertedValue + " " + destinationCurrency);
            System.out.println("****************************************************************");

            // Após exibir o resultado, aguarda a entrada do usuário para retornar ao menu principal
            System.out.println("\nPressione Enter para voltar ao menu principal...");
            scanner.nextLine(); // Limpa o buffer
            scanner.nextLine(); // Aguarda a entrada do usuário
        } catch (Exception e) {
            System.out.println("*********************** - ERRO - *******************************");
            System.out.println("Ocorreu um erro: " + e.getMessage());
            System.out.println("****************************************************************");
            // Finalizar a aplicação
            System.exit(1);
        }
    }
}