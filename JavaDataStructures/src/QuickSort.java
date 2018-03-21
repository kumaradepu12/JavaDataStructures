
import java.util.ArrayList;
import java.util.Scanner;


public class QuickSort {

    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        int n=in.nextInt();
		int[] arr=new int[n];
        for (int i=0;i<n;i++) {
				arr[i]=in.nextInt();
        }
        
        quickSort(arr,0,n-1);
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
            
        }

    }

    private static void quickSort(int[] a, int i, int n) { 
        if(i<n){
        
            int q=partition(a,i,n);
            quickSort(a,i,q-1);
            quickSort(a,q+1,n);
        }
    }

    private static int partition(int[] a, int l, int n) {
        int pivot=a[n];

        int p=l-1;
        int temp,i;
        for(i=l;i<n;i++){
            if(a[i]<=pivot){
                p++;
                temp=a[p];
                a[p]=a[i];
                a[i]=temp;
                
            }
            
        }
        temp=a[p+1];
        a[p+1]=pivot;
        a[n]=temp;
        return (p+1);
    }
    
}
