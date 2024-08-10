package zoho_incubation_questions;


public class Cherries {
    public static void sort(int[] arr,int n){
        for(int i=(n/2)-1;i>=0;i--){
            heapify(arr,n,i);
        }
        for(int i=n-1;i>0;i--){
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            heapify(arr,i,0);
        }
    }
    public static void heapify(int[] arr,int n,int index){
        int lar = index;
        int left = 2 * index + 1;
        int right = 2 * index + 2;

        if(left < n && arr[left] > arr[lar]){
            lar = left;
        }
        if(right < n && arr[right] > arr[lar]){
            lar = right;
        }
        if(lar != index){
            int temp = arr[lar];
            arr[lar] = arr[index];
            arr[index] = temp;
            heapify(arr,n,lar);
        }
    }
    public static void main(String[] args) {
        int[] arr = {0,10,210,180,190,200};
        int N = 2;
        int C = 6;
        sort(arr,arr.length);

        int angle = 360;
        int slice = angle / N;


        int count = 0;
        for(int i=0;i<arr.length;i++) {
            int c = 0;
            for(int j=arr.length-1;j>=0;j--){
                if(arr[j] - arr[i] <= slice){
                    c = (j + 1) - i;
                    break;
                }
            }
            count = Math.max(c,count);
        }
        System.out.println(count);

    }
}
