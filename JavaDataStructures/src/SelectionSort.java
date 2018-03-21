
import java.util.Scanner;


public class SelectionSort {
     public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        int n=in.nextInt();
	int[] arr=new int[n];
        int i,j;
        for ( i=0;i<n;i++) 
            arr[i]=in.nextInt();
        for(i=0;i<n-1;i++){
            for(j=i+1;j<n;j++){
                if(arr[i]>=arr[j]){
                    int temp=arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp;
                    
                }
            }
        }
        for(i=0;i<n;i++)
            System.out.print(arr[i]+" ");
        }
}
