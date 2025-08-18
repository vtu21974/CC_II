
import java.util.Scanner;

class Node {

    int data;
    Node next = null;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class remove_element {

    public static Node convert_Array_To_LL(int arr[]) {
        Node head = new Node(arr[0]);
        Node temp = head;
        for (int i = 1; i < arr.length; i++) {
            Node n = new Node(arr[i]);
            temp.next = n;
            temp = temp.next;
        }
        return head;
    }

    public static void print_LL(Node head) {
        Node temp = head;
        while (temp != null) {
            System.err.print(temp.data + " ");
            temp = temp.next;
        }
        System.err.println();
    }

    public static Node delete_x(Node head,int x){
        if(head == null) return  head;
        if(x == head.data){
            Node temp=head;
            head=temp.next;
            return head;
        }
        Node temp=head;
        while(temp!=null){
            if( x == temp.next.data){
                Node n=temp.next;
                temp.next=temp.next.next;
                break;
            }
            temp=temp.next;
        }
        return head;
    }

    public static void main(String[] args) {
        Scanner obj = new Scanner(System.in);
        int n=obj.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=obj.nextInt();
        }        
        Node head=convert_Array_To_LL(arr);
        System.err.println("Original LinkedList:");
        print_LL(head);
        int x=obj.nextInt();
        head=delete_x(head, x);
        print_LL(head);
    }
}
