package DSA;

public class WildCharacterMatching {
    public static void main(String[] args) {
        String s1 = "*abc*?";
        String s2 = "abconfaa";
        boolean[][] dp = new boolean[s1.length()][s2.length()];
        System.out.println(findPresentOrNot(s1,s2,s1.length()-1,s2.length()-1,dp));
    }
    public static boolean findPresentOrNot(String s1,String s2,int ind1,int ind2,boolean[][] dp){
        if(ind1 < 0 && ind2 < 0){
            return true;
        }
        if(ind1 < 0 && ind2 >=0) return  false;
        if(ind2 < 0  && ind1 >=0){
            for(int i=0;i<ind1;i++){
                if(s1.charAt(i) != '*')
                    return false;
            }
            return true;
        }
        if(dp[ind1][ind2]) return dp[ind1][ind2];

        if(s1.charAt(ind1) == s2.charAt(ind2) || s1.charAt(ind1) == '?'){
            return dp[ind1][ind2] = findPresentOrNot(s1,s2,ind1-1,ind2-1,dp);
        }
        else if(s1.charAt(ind1) == '*'){
            return dp[ind1][ind2] = findPresentOrNot(s1,s2,ind1-1,ind2,dp) | findPresentOrNot(s1,s2,ind1,ind2-1,dp);
        }
        return false;
    }
}
