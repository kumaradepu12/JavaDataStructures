
import java.util.Scanner;


class BinaryTree{
    int data;
    BinaryTree left,right;
    BinaryTree(int data){
        this.data=data;
        left=right=null;
    }
    BinaryTree root=null,parent=null;
}

class Tree{
    BinaryTree root,parent;
    void insert(int data){
        BinaryTree bt=new BinaryTree(data);
           BinaryTree temp=root,temp1=null;
            while(temp!=null){
                temp1=temp;
                temp=(temp.data>=bt.data)?temp.left:temp.right;
                        
                
            }
            bt.parent=temp1;
            if(root==null){
                root=bt;
            }
            else if(temp1.data>=bt.data){
                temp1.left=bt;
            }
            else{ 
                temp1.right=bt;
            }
            
        }
    
        void Transplant(BinaryTree u, BinaryTree v){
            if(u.parent==null){
                root=v;
            }
            if(u.parent.left==u)
            {
                u.parent.left=v;
            }
            else u.parent.right=v;
            if(v!=null)
                v.parent=u.parent;
        }
        BinaryTree minimum(BinaryTree temp){
            if(temp.left!=null)
                temp=temp.left;
            return temp;
        }
    void delete(int data){
        BinaryTree temp=root,temp1=null;
        if(root==null){
            System.out.println("No tree found");
            return;
        }
        while(temp!=null && temp.data!=data){
            temp=(temp.data>=data)?temp.left:temp.right;
            
        }
        if(temp.left==null){
            Transplant(temp,temp.right);
        }
        else if(temp.right==null){
            Transplant(temp,temp.left);
        }
        else{
            BinaryTree min=minimum(temp.right);
               if(min.parent!=temp){
                   Transplant(min,min.right);
                   min.right=temp.right;
                   min.parent=temp.parent;
                   min.right.parent=min;
               }
               Transplant(temp,min);
               min.left=temp.left;
               min.left.parent=min;
               
               
               
        }
    }
    
    void display(BinaryTree temp){
        if(temp!=null){
            display(temp.left);
            System.out.print(temp.data+" ");
            display(temp.right);
            
        }
    }

    int heighOfTree(BinaryTree root) {
        if(root==null)
            return 0;
        else return 1+Math.max(heighOfTree(root.left), heighOfTree(root.right));
        }

    int heightofnode(int data, BinaryTree root) {
        while(root!=null && root.data!=data){
                root=(root.data)>data?root.left:root.right;
            }
        if(root!=null)
            return heighOfTree(root);
        else return 0;
        }

    int heightofallnode(BinaryTree root,int sum) {
        if(root!=null){
            heightofallnode(root.left,sum);
            sum+=heighOfTree(root)-1;
            heightofallnode(root.right,sum);
        }
        return sum;
        
    }
    }
    

public class BinarySearchTree {

    public static void main(String[] args) {
    Scanner in=new Scanner(System.in);
        Tree tree=new Tree();
    int data,ch;
    while(true){
        System.out.println("\n1.Insert\n2.Delete\n3.Tree Height\n4.HeightOfNode\n5.HeightOfAllNodes\n6.Display\n");
        ch=in.nextInt();
        switch(ch){
            case 1:data=in.nextInt();
                    tree.insert(data);
                    break;
            case 2: data=in.nextInt();
                       tree.delete(data);
                       break;
            case 3: System.out.println(tree.heighOfTree(tree.root)-1);
                    break;
            case 4:data=in.nextInt();
                    int height=tree.heightofnode(data, tree.root);
                    if(height!=0)
                        System.out.println(height-1);
                    else System.out.println("No Such Node Found");
                    break;
            case 5:System.out.println(tree.heightofallnode(tree.root,0));
                        break;
            case 6: tree.display(tree.root);
                        
                
        }
    }
        
        
    }
    
}
