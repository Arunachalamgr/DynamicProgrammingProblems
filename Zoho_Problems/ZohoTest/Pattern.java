package ZohoTest;

public class Pattern {
    public static void main(String ar[]){
        int n = 5;
        int a=n;
        n= (5*2)-1;
        int mid = n/2;
        int count = 1,k=1;
        for(int i=1;i<=a;i++){
            for(int j=0;j<mid;j++){
                System.out.print(" ");
            }
            mid--;
            int middle = count /2;
            k=i;
            for(int j=1;j<=count;j++){
                if(j <= middle || count == 1){
                    System.out.print(k++);
                }else{
                    System.out.print(k--);
                }
            }
            count +=2;
            System.out.println();
        }

    }
}
