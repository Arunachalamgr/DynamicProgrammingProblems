package DSA;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class LetterCombinationOFThePhoneNumber{
    static List<String> ans = new ArrayList<>();
    public static List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) {
            return ans;
        }
        solve(0, new StringBuilder(), digits);
        return ans;
    }

    public static void solve(int index, StringBuilder sb, String digits) {
        if (index == digits.length()) {
            ans.add(sb.toString());
            return;
        }
        String str = findString(digits.charAt(index)-'0');
        for (int i = 0; i < str.length(); i++) {
            sb.append(str.charAt(i));
            solve(index + 1, sb, digits);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
    public static String findString(int index){
        return switch (index) {
            case 2 -> "abc";
            case 3 -> "def";
            case 4 -> "ghi";
            case 5 -> "jkl";
            case 6 -> "mno";
            case 7 -> "pqrs";
            case 8 -> "tuv";
            case 9 -> "wxyz";
            default -> "";
        };
    }

    public static void main(String[] args) {
        String digits = "234";
        letterCombinations(digits).forEach(System.out::println);
    }
}
