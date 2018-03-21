
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

 class ShortestPathCost {
    public static void main(String[] a){
    Scanner in=new Scanner(System.in);
    int c=in.nextInt();
    int f=in.nextInt();
    int[][] arr=new int[c][c];
    for(int i=0;i<f;i++)
        arr[in.nextInt()-1][in.nextInt()-1]=in.nextInt();
        
    int sum=shortestPathCost(arr,c,0);
        System.out.println(sum);
    }

    private static int shortestPathCost(int[][] arr, int c, int src) {
       boolean[] status=new boolean[c];
        Arrays.fill(status, false);

        int[] dist=new int[c];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src]=0;
        for(int i=0;i<c-1;i++){
            int value=minimimvalue(status,dist);
            status[value]=true;
            for(int j=0;j<c;j++){
                if(arr[value][j]!=0 && !status[j] && dist[value]!=Integer.MAX_VALUE){
                    if(dist[value]+arr[value][i]<dist[j]){
                        dist[j]=dist[value]+arr[value][j];
                    }
                    
                }
            }
        
    }
        return dist[c-1];
    
}

    private static int minimimvalue(boolean[] status, int dist[]) {
        int min=Integer.MAX_VALUE,index=-1;
        for(int i=0;i<dist.length;i++){
            if(!status[i] && min>=dist[i])
            {
                min=dist[i];  
                index=i;
            }
        }
        return index;
    }
}
