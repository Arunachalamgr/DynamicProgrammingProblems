package DSA;

public class LongestIncreasingSubSequences {
    public static void main(String[] args) {
        int[] arr = {1,7,8,4,5,6,-1,9};
        int[][] dp = new int[arr.length][arr.length+1];
        System.out.println(findLongestIncSub(arr,0,-1,0,dp));
    }
    public static int findLongestIncSub(int[] arr,int index,int prevInd,int count,int[][] dp){
        if(index > arr.length-1) {
            return 0;
        }

        count =  findLongestIncSub(arr, index + 1, prevInd, count,dp);
        if(dp[index][prevInd+1] != 0) return dp[index][prevInd+1];
        if(prevInd == -1 || arr[index] > arr[prevInd]){
            count =  Math.max(1 + findLongestIncSub(arr,index+1,index,count,dp),count);
        }
        return dp[index][prevInd+1] = count;

    }
}
