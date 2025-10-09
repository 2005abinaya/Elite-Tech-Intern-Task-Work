package Task2Weather;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
public class WeatherClient {
	    public static void main(String[] args) {
	        try {
	            String url = "https://api.open-meteo.com/v1/forecast?latitude=12.9716&longitude=77.5946&current_weather=true";

	            // Step 1: Request send
	            HttpClient client = HttpClient.newHttpClient();
	            HttpRequest request = HttpRequest.newBuilder()
	                    .uri(URI.create(url))
	                    .build();

	            // Step 2: Response receive
	            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
	            String json = response.body();

	            // Step 3: Parse JSON
	            ObjectMapper mapper = new ObjectMapper();
	            JsonNode root = mapper.readTree(json);
	            JsonNode currentWeather = root.get("current_weather");

	            // Step 4: Display values
	            double temp = currentWeather.get("temperature").asDouble();
	            double wind = currentWeather.get("windspeed").asDouble();
	            String time = currentWeather.get("time").asText();

	            System.out.println("🌤 Current Weather Data:");
	            System.out.println("Temperature: " + temp + "°C");
	            System.out.println("Wind Speed: " + wind + " m/s");
	            System.out.println("Time: " + time);

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	}
	

}
}
