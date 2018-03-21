
import java.util.Scanner;
import java.util.Stack;


public class TowersofHonoi {

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        Stack<Integer>[] tower=new Stack[3];
        for(int i=n;i>=1;i--)
            tower[0].push(i);
        int steps=toh(tower,n,1,2,3);
    }

    private static int toh(Stack<Integer>[] tower,int n, int f, int s, int t) {
       if(n==0){
           return 1+tower[s].push(tower[f].pop());
                     
       }
       else{
           toh(tower,n-1,f,s,t);
           tower[s].push(tower[f].pop());
           return 1+toh(tower,n,s,t,f);
       
           
       }
       return    
   }
