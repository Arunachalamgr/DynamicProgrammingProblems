package ZohoTest;
import java.util.*;
public class CompressString {
    public static void main(String [] ar){
        String s = "ABCDDD";

        Map<Character,Integer> map = new HashMap<>();
        int count = 0;
        for(int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            count = map.getOrDefault(c, 0);
            map.put(c, count + 1);
        }
        System.out.println(map.toString());

//       String s1 = "";
//        int count = 0;
//        for(int i=0,j=i+1;i<s.length();i++){
//
//          if(s.charAt(i) == s.charAt(j)){
//              count++;
//          }
//           if(count > 1){
//          s1 += s.charAt(i);
//          s1 += count;
//          count = 0;
//          }
//           else
//             s1 += s.charAt(i);
//
//            if(j != s.length()-1){
//                j++;
//            }
//        }
//
//        System.out.println(s1);
    }
}
