package GoRestTest;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class GoRestApiTest {

    private static final String TOKEN = "6635c21affa5f09cfee66d9532e4d654f1f745df07bd28ea601f2ee403c7d1ad";
    private static final String BASE_URL = "https://gorest.co.in/public/v2/users";

    public static void main(String[] args) throws Exception {
        HttpClient client = HttpClient.newHttpClient();

        // 1. Obtener usuarios
        HttpRequest getAll = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL))
                .build();
        HttpResponse<String> response1 = client.send(getAll, HttpResponse.BodyHandlers.ofString());
        System.out.println(response1.body());

        // 2. Crear nuevo usuario
        String email = "erik" + System.currentTimeMillis() + "@fravegaTech.com";
        String json = String.format("""
            {
              "name": "Erik Eleusippi",
              "gender": "male",
              "email": "%s",
              "status": "active"
            }
        """, email);

        HttpRequest create = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL))
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + TOKEN)
                .POST(HttpRequest.BodyPublishers.ofString(json))
                .build();
        HttpResponse<String> response2 = client.send(create, HttpResponse.BodyHandlers.ofString());
        System.out.println(response2.body());

        // 3. Obtener detalle del usuario creado
        String body = response2.body();
        int id = Integer.parseInt(body.split("\"id\":")[1].split(",")[0].trim());

        HttpRequest getOne = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + "/" + id))
                .header("Authorization", "Bearer " + TOKEN)
                .build();
        HttpResponse<String> response3 = client.send(getOne, HttpResponse.BodyHandlers.ofString());
        System.out.println(response3.body());
    }
}
