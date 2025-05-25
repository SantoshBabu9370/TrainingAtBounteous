public class removeNth {

    public static int countNodes(Node head){
        int count=0;
        while(head!=null){
            head=head.next;
            count++;
        }return count;
    }
    public static Node removeN(Node head,int n){
        n=countNodes(head)-n+1;
        Node curr=head;
        while(curr!=null){
            n--;
            if(n==1){
                curr.next=curr.next.next;
            }
            curr=curr.next;
        }
        return head;

    }
    public static void main(String[] args) {
        Node h1=new Node(1);
        h1.next=new Node(9);
        h1.next.next=new Node(0);
        h1.next.next.next=new Node(2);

        Node res=removeN(h1,1);
        while(res!=null){
            System.out.print(res.val+" ");
            res=res.next;
        }




        
    }
    
}
