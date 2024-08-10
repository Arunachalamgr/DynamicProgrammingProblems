package zoho_incubation_questions;

import java.util.Scanner;

public class TheDiffOfMaxAndMin {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        int size = scan.nextInt();
        int[] arr = new int[size];
        for(int i=0;i<arr.length;i++){
            arr[i] = scan.nextInt();
        }
        System.out.print(findDiff(arr));
    }
    public static int findDiff(int[] arr){
        int maxCount = Integer.MIN_VALUE;
        int minCount = Integer.MAX_VALUE;
        int c1 = 0;

        for(int i=0;i<arr.length;i++){
            if(arr[i] == 1){
                c1++;
            }else{
                if(c1> 1) {
                    maxCount = Math.max(maxCount, c1);
                    minCount = Math.min(c1, minCount);
                    c1 = 0;
                }
            }
        }
        if(c1 > 1) {
            maxCount = Math.max(maxCount, c1);
            minCount = Math.min(c1, minCount);
        }

        return minCount == Integer.MAX_VALUE ? 0 : maxCount - minCount;


    }
}

