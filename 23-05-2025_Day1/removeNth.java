

class removeNth {
    
    public static Node removeNthFromEnd(Node head, int n) {
        Node res = new Node(-1);
        res.next = head;
        Node slow = res;
        Node fast = head; // ✅ Use a separate pointer instead of modifying head

        // ✅ Move fast pointer n steps ahead, checking for null
        while (n-- > 0) {
            if (fast == null) return res.next; // ✅ Handle if n > length
            fast = fast.next;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;
        return res.next;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        Node res = removeNth.removeNthFromEnd(head, 2);
        while (res != null) {
            System.out.print(res.data + " ");
            res = res.next;
        }
    }
}
class Node {
    Node next;
    int data;
    Node(int d) {
        data = d;
        next = null;
    }
}
