package ZohoTest;

import java.util.Stack;

public class MaximalRectangle{
    public static void main(String[] args) {
        int[][] arr= new int[][] {{1,0,1,1,0},
                                  {1,0,1,1,1},
                                  {1,1,1,1,1},
                                  {0,1,1,0,0},
                                  {0,0,1,1,0}};

        Stack<Integer> stack = new Stack<>();
        int max = Integer.MIN_VALUE;
        int[] ar = new int[arr.length];
        for(int i=0;i<arr.length;i++){
            int j = 0;
            while(j < arr.length){
                ar[i] += arr[j][i];
                j++;
            }
        }
        System.out.println(findMaxInArr(ar,0,ar.length,max,stack));
    }
    public static int findMaxInArr(int[] ar,int sIndex,int eIndex,int max,Stack<Integer> stack){
        int[] ar1 = new int[ar.length];
        int[] ar2 = new int[ar.length];

        for(int i=0;i<ar.length;i++){
            if(stack.isEmpty()){
                stack.push(i);
            }else{
                while(!stack.isEmpty()){
                    if(ar[stack.peek()] < ar[i]){
                        stack.push(i);
                        ar1[i] = stack.peek()+1;
                        break;
                    }else{
                        stack.pop();
                    }
                    if(stack.isEmpty()) {
                        stack.push(i);
                        break;
                    }
                }
            }
        }
         stack = new Stack<>();
        for(int i=ar.length-1;i>=0;i--){
            if(stack.isEmpty()){
                stack.push(i);
                ar2[i] = ar.length-1;
            }else{
                while(!stack.isEmpty()){
                    if(ar[stack.peek()] > ar2[i]) {
                        stack.push(i);
                        ar2[i] = stack.peek()-1;
                        break;
                    }else{
                        stack.pop();
                    }
                }
            }
        }
        for(int i=0;i<ar1.length;i++){
            max = Math.max(max,ar[i] * Math.abs(ar1[i] - ar2[i]) + 1);
        }
        return max;
    }
}
