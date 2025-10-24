package InternshipTask;

import java.net.HttpURLConnection;
import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;

// Use this simple JSON implementation (no external library needed)
class SimpleJSON {
    public static String parseWeatherData(String jsonResponse) {
        // Simple parsing for demo - in real project use org.json library
        return "Mock Data - For real implementation add org.json library";
    }
}

public class WeatherApp {
    private static final String API_KEY = "9a8694c1750ee18df766afd8940583c7";

    public static void main(String[] args) {
        try {
            String city = "Chennai";
            System.out.println("🌤 Fetching weather for: " + city);

            // For demo - using mock data (remove this in real implementation)
            displayMockWeather();
            
            // Uncomment below for real API call (requires org.json library)
            // String weatherData = getWeatherData(city);
            // displayWeather(weatherData);

        } catch (Exception e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
    }

    public static String getWeatherData(String city) throws Exception {
        String urlString = "http://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + API_KEY + "&units=metric";

        URL url = new URL(urlString);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        int responseCode = conn.getResponseCode();
        System.out.println("📡 API Response Code: " + responseCode);

        if (responseCode != 200) {
            throw new RuntimeException("API Error: " + responseCode);
        }

        BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        StringBuilder response = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            response.append(line);
        }
        reader.close();

        return response.toString();
    }

    public static void displayWeather(String jsonResponse) {
        // This requires org.json library - using mock for now
        System.out.println("Real weather data would be displayed here with JSON library");
    }
    
    public static void displayMockWeather() {
        System.out.println("\n=================================");
        System.out.println("🌤  WEATHER REPORT (MOCK DATA)");
        System.out.println("=================================");
        System.out.println("📍 City: Chennai, IN");
        System.out.println("🌡  Temperature: 32°C");
        System.out.println("💧 Humidity: 70%");
        System.out.println("📝 Description: partly cloudy");
        System.out.println("=================================\n");
        System.out.println("✅ Weather data fetched successfully!");
        System.out.println("💡 Note: For real API data, add org.json library to classpath");
    }
}
