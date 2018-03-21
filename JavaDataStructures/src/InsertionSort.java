
import java.util.Scanner;
public class InsertionSort {
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        int n=in.nextInt();
	int[] arr=new int[n];
        int i,k;
        for ( i=0;i<n;i++) 
            arr[i]=in.nextInt();
        for(i=1;i<n;i++){
            int key=arr[i];
            int j=i-1;
            while(j>=0 && arr[j]>=key){
                arr[j+1]=arr[j];
                j--;
               }
            arr[j+1]=key;
        }
        for(i=0;i<n;i++)
            System.out.print(arr[i]+" ");
        
    }
    
}
