


import java.util.Scanner;

class Node{
    int data;
    Node next;
    Node(int data){
        this.data=data;
        next=null;
    }
    Node head=null,last=null;
}

class LinkedIn {
    Node head=null,last=null;
    void insert(int data){
        Node node=new Node(data);
        if(head==null){
            head=last=node;
        }
        else{
            last.next=node;
            last=node;
        }
    }
    
    void insertAt(int pos, int data){
        Node node=new Node(data);
        if(head.data==pos){
            node.next=head;
            head=node;
        }
        else{
            Node temp=head.next;
            while(temp.next!=null && temp.next.data!=pos){
                temp=temp.next;
            }
            if(temp.next!=null){
            node.next=temp.next;
            temp.next=node;
            }
            
        }
    }
    
    void display(){
        Node node=head;
        while(node!=null){
            System.out.println(node.data);
            node=node.next;
        }
    }
}
public class SingleLinkedList {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        LinkedIn ll=new LinkedIn();
        int ch,data;
        while(true){
            System.out.println("1.create\n2.InsertAt\n3.delete\n4.Display");
            ch=in.nextInt();
            switch(ch){
                case 1: data=in.nextInt();
                        ll.insert(data);
                	break;
                case 2:int pos=in.nextInt();
                           data=in.nextInt();
                           ll.insertAt(pos,data);
                        
                case 4:ll.display();
                    break;
                case 5:System.exit(0);
           
            }
    
        }
        }
}
