
import java.util.Scanner;
class TreeNode{
    int data;
    int height;
    TreeNode left;
    TreeNode right;
    TreeNode(int data){
        this.data=data;
        this.height=0;
        this.left=null;
        this.right=null;
    }
    TreeNode root=null;
}

class AVLImple
{
    TreeNode root;
    TreeNode insert(int data,TreeNode temp) {
        if(temp==null)
            return (new TreeNode(data));
        else if(data<temp.data)
            temp.left=insert(data,temp.left);
        else temp.right=insert(data,temp.right);
        if(temp.right!=null)
            System.out.println(temp.right.data);
        if(temp.left!=null)
            System.out.println(temp.left.data);
        return actualprocess(data,temp);

    }
     private TreeNode actualprocess(int data,TreeNode temp) {
        temp.height=1+Math.max(height(temp.left), height(temp.right));
                 System.out.println("HERE "+temp.data+" "+temp.height);

        int balance=height(temp.left)-height(temp.right);
        if(balance>=2){
            if(data<temp.left.data){
                temp=rightRotate(temp);
            }
            else {
                temp.left=leftRotate(temp.left);
                temp=rightRotate(temp);
                
            }
            
        }
        if(balance<=-2){
            if(data>temp.right.data){
                temp=leftRotate(temp);
            }
            else{
                temp.right=rightRotate(temp.right);
                temp=leftRotate(temp);
            }
        }
        return temp;
    }
    int height(TreeNode node){
        return (node==null)?-1:node.height;
    }

    private TreeNode rightRotate(TreeNode z) {
            TreeNode y=z.left;
            TreeNode x=y.right;
            y.right=z;
            z.left=x;
            z.height=1+Math.max(height(z.left), height(z.right));
            y.height=1+Math.max(height(y.left), height(y.right));
            return y;
    }
    private TreeNode leftRotate(TreeNode z){
            TreeNode y=z.right;
            TreeNode x=y.left;
            y.left=z;
            z.right=x;
            z.height=1+Math.max(height(z.left), height(z.right));
            y.height=1+Math.max(height(y.left), height(y.right));
            return y;
   }

    

    TreeNode delete(int data,TreeNode temp) {
        if(temp==null)
            return temp;
        else if(data<temp.data)
            temp.left=delete(data,temp.left);
        else if(data>temp.data)
            temp.right=delete(data,temp.right);
        else{
                
                if(temp.left==null){
                    temp=temp.right;
                }
                if(temp.right==null)
                {
                    temp=temp.left;
                }
                
                else{
                    TreeNode y=minimum(temp.right);
                    temp.data=y.data;
                    temp.right=delete(temp.data,y.right);
                }
        }
        if(temp==null)
            return temp;
        return actualprocess(data,temp);
    }

    private TreeNode minimum(TreeNode temp) {
        if(temp.left!=null)
            return minimum(temp.left);
        else return temp;
    }

   
    
    void display(TreeNode root) {
        if(root!=null){
            display(root.left);
            System.out.println(root.data+" "+root.height);
            display(root.right);
        }
    }
    }
class AVLTreeTest {

     public static void main(String[] args) {
    Scanner in=new Scanner(System.in);
        AVLImple tree=new AVLImple();
    int data,ch;
    while(true){
        System.out.println("1.Insert\n2.Delete\n3.HeightOfTree\n4.Display\n");
        ch=in.nextInt();
        switch(ch){
            case 1:data=in.nextInt();
                    tree.root=tree.insert(data,tree.root);
                    break;
          case 2: data=in.nextInt();
                       tree.root=tree.delete(data,tree.root);
                       break;
          case 3: System.out.println(tree.root.height);
                    break;
            case 4: tree.display(tree.root);
                    break;
                        
                
        }
        
    }
        
        
    }
    
}
