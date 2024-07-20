package ZohoTest;

public class Factors {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        int[] factor = new int[arr.length];
        for(int i=0;i<arr.length;i++){
            factor[i] = findFactor(arr[i]);
        }
        sort(arr,factor);

        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i] +" " + factor[i]);
        }
    }
    public static int findFactor(int n){
        int counter = 1;

        for(int i=1;i<n;i++){
            if(n % i == 0){
                counter++;
            }
        }
        return counter;
    }
    public static void sort(int[] arr,int[] factor){
        for(int i=0;i<arr.length-1;i++){
            for(int j=0;j<arr.length - i -1;j++){
                if(factor[j] < factor[j+1]){
                    int temp = factor[j];
                    factor[j] = factor[j+1];
                    factor[j+1] = temp;
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
}
