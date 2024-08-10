package zoho_incubation_questions;

import java.io.*;
public class CountingValleys {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int steps = Integer.parseInt(bufferedReader.readLine().trim());

        String path = bufferedReader.readLine();

        int result = countingValleys(steps, path);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
    public static int countingValleys(int steps, String path) {
        int way = 0;
        int count = 0;

        for(int i=0;i<path.length();i++){
            if(path.charAt(i) == 'D'){
                way--;
            }else{
                way++;
            }
            if(way == 0 && path.charAt(i) == 'U'){
                count++;
            }
        }
        return count;
    }
}

