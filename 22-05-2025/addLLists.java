class Node{
    int val;
    Node next;
    Node(int val){
        this.val=val;
        this.next=null;  
    }}
class addLists{
    public static Node reverse(Node head){
        Node prev=null;
        while(head!=null){
            Node nxt=head.next;
            head.next=prev;
            prev=head;
            head=nxt;
        }
        return prev;
    }
    public static Node addLL(Node h1,Node h2){
        Node dummy=new Node(-1);
        Node rev1=reverse(h1);
        Node rev2=reverse(h2);
        Node curr=dummy;
        int carry=0;
        int sum=0;
        while(rev1!=null ||rev2!=null||carry!=0){
            int s1=(rev1!=null)?rev1.val:0;
            int s2=(rev2!=null)?rev2.val:0;
            sum=s1+s2+carry;
            carry=sum/10;
            
            curr.next=new Node(sum%10);
            curr=curr.next;
            if(rev1!=null) rev1=rev1.next;
            if(rev2!=null) rev2=rev2.next;
        }
        return reverse(dummy.next);
    }
    public static void main(String[] args) {
        Node h1=new Node(9);
        h1.next=new Node(9);
        h1.next.next=new Node(9);
        Node h2=new Node(0);
        h2.next=new Node(0);
        h2.next.next=new Node(1);
        Node res=addLL(h1, h2);
        while(res!=null){
            System.out.print(res.val+" ");
            res=res.next;}    
    }
}