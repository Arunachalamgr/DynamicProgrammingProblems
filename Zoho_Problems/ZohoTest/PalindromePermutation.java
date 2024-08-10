package zoho_incubation_questions;
import java.util.*;

public class PalindromePermutation {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        String str = scan.next();

        HashMap<Character,Integer> mp = new HashMap<>();

        for(int i=0;i<str.length();i++){
            mp.put(str.charAt(i),mp.getOrDefault(str.charAt(i),0)+1);
        }
        int count = 0;

        for(Map.Entry<Character,Integer> e : mp.entrySet()){
            if(e.getValue() % 2 != 0){
                count++;
            }
        }
        if(count > 1){
            System.out.println("No");
        }else{
            System.out.println("Yes");
        }

    }
}