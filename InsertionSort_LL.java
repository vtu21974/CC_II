
import java.util.Scanner;

class Node {

    int data;
    Node next = null;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class InsertionSort_LL {

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

    public static Node insertion_Sort_LL(Node head) {
        Node dummy = new Node(0);
        Node temp = head;
        while (temp != null) {
            Node n = temp.next;
            Node pos = dummy;
            while (pos.next != null && pos.next.data < temp.data) {
                pos = pos.next;
            }
            temp.next = pos.next;
            pos.next = temp;
            temp = n;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        Scanner obj = new Scanner(System.in);
        int n = obj.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = obj.nextInt();
        }
        Node head = convert_Array_To_LL(arr);
        System.err.println("Original LinkedList:");
        print_LL(head);
        Node sortedHead = insertion_Sort_LL(head);
        System.err.println("Sorted linkedlist");
        print_LL(sortedHead);
    }
}
