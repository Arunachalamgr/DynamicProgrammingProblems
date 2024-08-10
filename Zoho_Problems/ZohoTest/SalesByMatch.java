package zoho_incubation_questions;


import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

public class SalesByMatch {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> ar = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = sockMerchant(n, ar);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
    public static int sockMerchant(int n, List<Integer> ar) {
        // Write your code here
        Collections.sort(ar);
        HashMap<Integer,Integer> mp = new HashMap<>();

        for(Integer ele : ar){
            mp.put(ele,mp.getOrDefault(ele,0)+1);
        }
        int totalPairs = 0;
        int pair = 0;
        for(Map.Entry<Integer,Integer> e : mp.entrySet()){
            pair = e.getValue() / 2;
            totalPairs += pair;
        }
        return totalPairs;

    }
}


