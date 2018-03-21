
import java.util.Scanner;

public class MergeSort {
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        int n=in.nextInt();
		int[] arr=new int[n];
        for (int i=0;i<n;i++) {
				arr[i]=in.nextInt();
        }
        
        mergeSort(arr,0,n-1);
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
            
        }
    }

    private static void mergeSort(int[] arr, int i, int n) {
        if(i<n){
            
            int m=(i+n)/2;
            mergeSort(arr,i,m);
            mergeSort(arr,m+1,n);
            mergeSort(arr,0,m,n);
        }
        
    }

    private static void mergeSort(int[] arr, int l, int m, int h) {
        int n1=m-l+1;
        int n2=h-m;
        int[] L=new int[n1];
        int[] R=new int[n2];
        for(int i=0;i<n1;i++)
            L[i]=arr[l+i];
        for(int j=0;j<n2;j++)
            R[j]=arr[m+j+1];
        int i=0,j=0,k=l;
        while(i<n1 && j<n2){
            if(L[i]<=R[j])
                arr[k++]=L[i++];
            else
                arr[k++]=R[j++];
            
        }
        while(i<n1){
            arr[k++]=L[i++];
        }
        while(j<n2){
            arr[k++]=R[j++];
        }
        }
           
}
