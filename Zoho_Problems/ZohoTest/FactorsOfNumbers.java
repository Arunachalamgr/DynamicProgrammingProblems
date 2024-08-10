package zoho_incubation_questions;


public class FactorsOfNumbers {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        int[] factor = new int[arr.length];
        for(int i=0;i<arr.length;i++){
            factor[i] = findFactor(arr[i]);
        }
        sort(factor,arr);

        for(int i=0;i<factor.length;i++){
            System.out.println(arr[i]+" "+factor[i]);
        }
    }
    public static int findFactor(int n){
        int counter = 1;

        for(int i=1;i<=n/2;i++){
            if(n % i == 0)
                counter++;
        }
        return counter;
    }
    public static void sort(int[] factor,int[] arr){
        for(int i=0;i<factor.length-1;i++){
            for(int j=0;j<factor.length-i-1;j++){
                if(factor[j] < factor[j+1]){
                    int tem = factor[j+1];
                    factor[j+1] = factor[j];
                    factor[j] = tem;
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
}
