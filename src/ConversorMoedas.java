import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConversorMoedas {

    public static double obterTaxa(String moedaOrigem, String moedaDestino) throws IOException, InterruptedException {
        String apiKey = "3b3e43a93aa5cf5f29e32930";
        String endpoint = "https://v6.exchangerate-api.com/v6/" + apiKey + "/pair/" + moedaOrigem + "/" + moedaDestino;

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endpoint))
                .header("Accept", "application/json")
                .GET()
                .build();

        HttpClient client = HttpClient.newHttpClient();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 200) {
            String corpo = response.body();
            Gson gson = new Gson();

            JsonObject jsonObject = gson.fromJson(corpo, JsonObject.class);

            if (jsonObject.has("conversion_rate")) {
                return jsonObject.get("conversion_rate").getAsDouble();
            } else {
                throw new IOException("Campo 'conversion_rate' não encontrado na resposta da API.");
            }
        } else {
            throw new IOException("Erro ao acessar API: " + response.statusCode());
        }
    }

    public static double converter(double valor, double taxa) {
        return valor * taxa;
    }
}
