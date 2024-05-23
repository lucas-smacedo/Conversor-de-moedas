import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Objects;
import java.util.Scanner;

public class Conversor {
    public static void conversorDeMoedas(String moedaOriginal, String moedaDestinataria, Scanner inputDoUsuario) {
        try {
            String url_str = "https://v6.exchangerate-api.com/v6/015fa7570f3f534f0898a110/latest/USD";
            URL url = new URL(url_str);
            HttpURLConnection request = (HttpURLConnection) url.openConnection();
            request.connect();

            JsonParser jp = new JsonParser();
            JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
            JsonObject jsonobj = root.getAsJsonObject();

            JsonObject conversion_rates = jsonobj.getAsJsonObject("conversion_rates");

            float taxaCambial = conversion_rates.get(moedaDestinataria).getAsFloat();
            float valorOriginal = conversion_rates.get(moedaOriginal).getAsFloat();

            System.out.println("Digite a quantia a ser convertida: ");
            float valor = inputDoUsuario.nextFloat();

            float valorConvertido = 0;

            if (moedaOriginal.equalsIgnoreCase("USD")){
                valorConvertido = valor * taxaCambial;
            } else {
                valorConvertido = valor / valorOriginal;
            }

            System.out.println("Valor " + valor + " " + moedaOriginal + " correspondem ao valor final de: " + valorConvertido + " " + moedaDestinataria);
            inputDoUsuario.nextLine();
            inputDoUsuario.nextLine();
            System.out.println("Pressione Enter para continuar.");
            } catch (Exception e) {
            System.out.println("Ocorreu um erro, utilize a virgula como separador de milhar.");
            System.out.println(e.getMessage());
            inputDoUsuario.next();
        }



    }
}
