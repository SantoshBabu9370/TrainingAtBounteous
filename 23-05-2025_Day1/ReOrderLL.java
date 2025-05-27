class Node {
    int data;
    Node next;
    Node(int d) {
        data = d;
        next = null;
    }
}
public class ReOrderLL {
    public static Node reOrder(Node head) {
        if (head==null||head.next==null) return head;
        Node slow=head;
        Node fast=head;
        while (fast!=null&&fast.next!=null) {
            slow=slow.next;
            fast=fast.next.next;
        }
        Node second = slow.next;
        slow.next = null;
        Node prev = null;
        while (second != null) {
            Node next = second.next;
            second.next = prev;
            prev = second;
            second = next;
        }
        Node first=head;
        second = prev;
        while (second != null) {
            Node temp1 = first.next;
            Node temp2 = second.next;
            first.next = second;
            second.next = temp1;
            first = temp1;
            second = temp2;
        }
        return head;
    }
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        Node res = ReOrderLL.reOrder(head);
        while (res != null) {
            System.out.print(res.data + " ");
            res = res.next;
        }
    }
}
