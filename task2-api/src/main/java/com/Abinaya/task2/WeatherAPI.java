package com.Abinaya.task2;

import java.net.HttpURLConnection;
import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import org.json.JSONObject;

public class WeatherAPI {
    private static final String API_KEY = "9a8694c1750ee18df766afd8940583c7";

    public static void main(String[] args) {
        try {
            String city = "Chennai";
            System.out.println("🌤 Fetching weather for: " + city);

            String weatherData = getWeatherData(city);
            displayWeather(weatherData);

        } catch (Exception e) {
            System.out.println("❌ Error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static String getWeatherData(String city) throws Exception {
        String urlString = "http://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + API_KEY + "&units=metric";

        URL url = new URL(urlString);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        // RESPONSE CHECK
        int responseCode = conn.getResponseCode();
        System.out.println("📡 API Response Code: " + responseCode);

        if (responseCode != 200) {
            throw new RuntimeException("API Error: " + responseCode);
        }

        // RESPONSE READ
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
        JSONObject json = new JSONObject(jsonResponse);

        String city = json.getString("name");
        String country = json.getJSONObject("sys").getString("country");
        double temp = json.getJSONObject("main").getDouble("temp");
        int humidity = json.getJSONObject("main").getInt("humidity");
        String description = json.getJSONArray("weather").getJSONObject(0).getString("description");

        // DISPLAY
        System.out.println("\n=================================");
        System.out.println("🌤  WEATHER REPORT");
        System.out.println("=================================");
        System.out.println("📍 City: " + city + ", " + country);
        System.out.println("🌡  Temperature: " + temp + "°C");
        System.out.println("💧 Humidity: " + humidity + "%");
        System.out.println("📝 Description: " + description);
        System.out.println("=================================\n");
    }
}