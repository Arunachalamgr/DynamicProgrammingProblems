package zoho_incubation_questions;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;


public class EqualStacks {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n1 = Integer.parseInt(firstMultipleInput[0]);

        int n2 = Integer.parseInt(firstMultipleInput[1]);

        int n3 = Integer.parseInt(firstMultipleInput[2]);

        List<Integer> h1 = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> h2 = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> h3 = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = equalStacks(h1, h2, h3);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
    public static int equalStacks(List<Integer> h1, List<Integer> h2, List<Integer> h3) {
        int len1 = h1.stream().mapToInt(Integer::intValue).sum();
        int len2 = h2.stream().mapToInt(Integer::intValue).sum();
        int len3 = h3.stream().mapToInt(Integer::intValue).sum();
        int ind1 =0,ind2 = 0,ind3 = 0;

        while(true){
            if(len1 == len2 && len1 == len3){
                return len1;
            }
            if(len1 >= len2 && len1 >= len3){
                len1 -= h1.get(ind1++);
            }
            else if(len2 >= len1 && len2 >= len3){
                len2 -= h2.get(ind2++);
            }
            else{
                len3 -= h3.get(ind3++);
            }
        }

    }
}
