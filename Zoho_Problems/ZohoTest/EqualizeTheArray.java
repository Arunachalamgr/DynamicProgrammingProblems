package zoho_incubation_questions;
import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;


public class EqualizeTheArray {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = equalizeArray(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
    public static int equalizeArray(List<Integer> arr) {
        HashMap<Integer,Integer> mp = new HashMap<>();
        for(int ele : arr){
            mp.put(ele,mp.getOrDefault(ele,0)+1);
        }
        int maxCount = Integer.MIN_VALUE;
        int count = 0;
        for(Map.Entry<Integer,Integer> e : mp.entrySet()){
            maxCount = Math.max(maxCount,e.getValue());
            count += e.getValue();
        }
        return count - maxCount;
    }
}

