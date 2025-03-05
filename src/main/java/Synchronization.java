import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Synchronization {
    private static final Object countryLock = new Object();
    private static final Object starWarsLock = new Object();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the Country name: ");
        String countryName = scanner.nextLine();
        scanner.close();

        //Create a thread that makes an API request to RestCountries API.
        Thread thread = new Thread(() -> fetchCountry(countryName));
        thread.start();
    }
    private static void fetchCountry(String countryName) {
        synchronized (countryLock) {
            String url = "https://restcountries.com/v3.1/name/" + countryName;
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).GET().build();
            try {
                HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
                if (response.statusCode() == 200) {
                    JsonArray jsonArray = JsonParser.parseString(response.body()).getAsJsonArray();
                    JsonObject country = jsonArray.get(0).getAsJsonObject();

                    String name = country.getAsJsonObject("name").get("common").getAsString();
                    long population = country.get("population").getAsLong();
                    String continent = country.getAsJsonArray("continents").get(0).getAsString();
                    String capital = country.getAsJsonArray("capital").get(0).getAsString();
                    System.out.println(name + " is a great country with a population of " + population +
                            " and is in the " + continent + " continent. Capital(s): " + capital);
                } else {
                    System.out.println("Country not found. Fetching Star Wars character...");
                    Thread starWarsThread = new Thread((Synchronization ::fetchCharacter));
                    starWarsThread.start();
                }
            } catch (IOException | InterruptedException e) {
                System.out.println("Error fetching country details: " + e.getMessage());
            }
                }
            }
            private static void fetchCharacter() {
        synchronized (starWarsLock) {
            String url = "https://swapi.dev/api/people/4/";
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).GET().build();
            try{
                HttpResponse<String> starWarsResponse = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
                if (starWarsResponse.statusCode() == 200) {
                    JsonObject character = JsonParser.parseString(starWarsResponse.body()).getAsJsonObject();
                    String name = character.get("name").getAsString();
                    System.out.println("Character : " + name);
                } else {
                    System.out.println("Error fetching Star Wars character: " + starWarsResponse.body());
                }
            } catch (IOException | InterruptedException e) {
                throw new RuntimeException(e);

            }
        }
    }
}
