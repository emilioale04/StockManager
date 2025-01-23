package epn.fis.stockmanager.api;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Service to fetch stock prices from Finnhub API.
 */
public class StockPriceFetcher {

    private static final String API_URL = "https://finnhub.io/api/v1/quote";
    private static final String API_KEY = "ct4v1h9r01qsnmq0uergct4v1h9r01qsnmq0ues0";

    /**
     * Fetches the current stock prices for a list of tickers.
     *
     * @param tickers List of ticker symbols to fetch prices for.
     * @return A map of ticker symbols and their current prices.
     * @throws IOException If there is an error during the API request.
     */
    public Map<String, Double> getStockPrices(List<String> tickers) throws IOException {
        Map<String, Double> prices = new HashMap<>();

        for (String ticker : tickers) {
            String urlString = constructUrl(ticker);
            JsonObject jsonResponse = fetchJsonResponse(urlString);

            if (jsonResponse.has("c") && !jsonResponse.get("c").isJsonNull()) {
                double currentPrice = jsonResponse.get("c").getAsDouble(); // 'c' represents the current price
                prices.put(ticker, currentPrice);
            } else {
                prices.put(ticker, null); // No price found for the ticker
            }
        }

        return prices;
    }

    /**
     * Constructs the API URL for a given ticker symbol.
     *
     * @param ticker The ticker symbol to fetch data for.
     * @return The constructed URL as a string.
     */
    private String constructUrl(String ticker) {
        return String.format("%s?symbol=%s&token=%s", API_URL, ticker, API_KEY);
    }

    /**
     * Fetches the JSON response from the given URL.
     *
     * @param urlString The URL to fetch the JSON response from.
     * @return A JsonObject containing the response.
     * @throws IOException If there is an error during the request.
     */
    private JsonObject fetchJsonResponse(String urlString) throws IOException {
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            StringBuilder response = new StringBuilder();
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            return JsonParser.parseString(response.toString()).getAsJsonObject();
        }
    }
}
