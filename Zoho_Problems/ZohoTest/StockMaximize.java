package zoho_incubation_questions;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

public class StockMaximize {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> prices = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList());

                long result = stockmax(prices);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }

    public static long stockmax(List<Integer> prices) {

        long price = 0;
        long maxSoFar = Integer.MIN_VALUE;

        for(int i=prices.size()-1;i>=0;i--){
            maxSoFar = Math.max(maxSoFar,prices.get(i));
            price += maxSoFar - prices.get(i);
        }
        return price;

    }
}

