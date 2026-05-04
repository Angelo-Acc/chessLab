import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.json.JSONObject;

public class ChessApiClient {

    private static final String API_URL = "https://chess-api.com/v1";

    public String callRestAPIForNextMove(String fen) throws Exception {
        // Build the JSON request body
        String requestBody = "{\"fen\": \"" + fen + "\", \"depth\": 2}";

        // Create the HTTP client and request
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(API_URL))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();

        // Send the request and get the response
        System.out.println("Calling REST API " + API_URL);
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        // Parse the JSON response and print the fen field
        JSONObject json = new JSONObject(response.body());
        String returnedFen = json.getString("fen");

        System.out.println("Returned FEN: " + returnedFen);
        return returnedFen;
    }
}