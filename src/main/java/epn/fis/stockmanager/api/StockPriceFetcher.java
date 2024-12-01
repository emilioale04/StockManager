package epn.fis.stockmanager.api;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StockPriceFetcher {

    private static final String API_URL = "https://finnhub.io/api/v1/quote";
    private static final String API_KEY = "ct4v1h9r01qsnmq0uergct4v1h9r01qsnmq0ues0";

    public Map<String, Double> getStockPrices(List<String> tickers) throws IOException {
        Map<String, Double> prices = new HashMap<>();

        for (String ticker : tickers) {
            String urlString = constructUrl(ticker);
            JSONObject jsonResponse = fetchJsonResponse(urlString);

            if (jsonResponse.has("c")) {
                double currentPrice = jsonResponse.getDouble("c"); // 'c' represents the current price
                prices.put(ticker, currentPrice);
            } else {
                prices.put(ticker, null); // No price found for the ticker
            }
        }

        return prices;
    }

    private String constructUrl(String ticker) {
        return String.format("%s?symbol=%s&token=%s", API_URL, ticker, API_KEY);
    }

    private JSONObject fetchJsonResponse(String urlString) throws IOException {
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            StringBuilder response = new StringBuilder();
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            return new JSONObject(response.toString());
        }
    }
}
