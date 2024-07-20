package ZohoTest;

import java.util.Arrays;

public class Cherry {
    public static void main(String[] args) {
        int[] arr = {0,90,180,270};
        int N = 4;
        int C = 4;

        System.out.println(findMaxCherry(arr,N,C));
    }
    public static int findMaxCherry(int[] arr,int N,int C){
        int angle = 360;
        int slice = angle / N;

        Arrays.sort(arr);
        int cherry = 0;
        for(int i=0;i<arr.length;i++){
            int count = 0;
            for(int j=arr.length-1;j>i;j--){
                if(arr[j] - arr[i] <= slice){
                    count = (j + 1) - i;
                    break;
                }
            }
            cherry = Math.max(count,cherry);
        }
        return cherry;
    }
}
