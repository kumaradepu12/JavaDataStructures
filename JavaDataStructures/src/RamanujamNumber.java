
import java.util.Scanner;
import java.lang.Math.*;

public class RamanujamNumber {
    public static void main(String[] a){
        Scanner in = new Scanner(System.in);
        long t=in.nextLong();
        while(t>0){
        long n=in.nextLong();
        long m=in.nextLong();
        int res=0;
        while(n<=m){
            int count=0;
            for(long i=1;i<=(int)Math.cbrt(n);i++)
                for(long j=i+1;j<=(int)Math.cbrt(n);j++ )
                     if((i*i*i+j*j*j)==n)
                        count++;
                  if(count==2)
                	res++;
            	n++;
           }
           System.out.println(res);
           t--;
       }
     }
}

