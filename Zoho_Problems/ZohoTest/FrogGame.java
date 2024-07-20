package ZohoTest;

import java.util.Arrays;

public class FrogGame {
    public static void main(String[] args) {
        int[] arr = {1,2,7,2,5,8,4,1,0,0,0,0,0,4};
        int[][] dp = new int[arr.length][arr.length];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }
        System.out.println(minJump(arr,0,0,dp));
    }
    public static int minJump(int[] arr,int index,int count,int[][] dp){
        if(index >= arr.length-1){
            return count;
        }
        if(arr[index] == 0){
            return 0;
        }
        if(dp[index][count] != -1)return dp[index][count];
        int tk = minJump(arr,index+arr[index],count+1,dp);
        int nt = minJump(arr,index+arr[index],count,dp);
        return  dp[index][count] = Math.max(tk,nt);

    }
}
