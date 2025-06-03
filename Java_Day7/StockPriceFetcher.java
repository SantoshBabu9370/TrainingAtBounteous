package Java_Day7;


import java.util.*;
import java.util.concurrent.*;

class StockFetcher implements Callable<Map<String, Double>> {
    private final List<String> symbols;

    public StockFetcher(List<String> symbols) {
        this.symbols = symbols;
    }

    @Override
    public Map<String, Double> call() {
        Map<String, Double> prices = new HashMap<>();
        for (String symbol : symbols) {
            // Simulate fetching stock price
            prices.put(symbol, Math.random() * 1000);
        }
        return prices;
    }
}

public class StockPriceFetcher {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        List<String> symbols = Arrays.asList("AAPL", "GOOGL", "MSFT", "AMZN", "TSLA");
        int batchSize = 2;
        ExecutorService executor = Executors.newFixedThreadPool(2);
        List<Future<Map<String, Double>>> futures = new ArrayList<>();

        for (int i = 0; i < symbols.size(); i += batchSize) {
            List<String> batch = symbols.subList(i, Math.min(i + batchSize, symbols.size()));
            futures.add(executor.submit(new StockFetcher(batch)));
        }

        Map<String, Double> allPrices = new HashMap<>();
        for (Future<Map<String, Double>> future : futures) {
            allPrices.putAll(future.get());
        }

        allPrices.forEach((symbol, price) -> System.out.println(symbol + ": " + price));
        executor.shutdown();
    }
}
