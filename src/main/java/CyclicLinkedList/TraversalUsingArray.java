package CyclicLinkedList;

import java.util.HashSet;

class ListNode {
    int data;       // Data stored in the node
    ListNode next;  // Reference to the next node

    // Constructor
    public ListNode(int data) {
        this.data = data;
        this.next = null; // Next is initialized as null
    }
}




public class TraversalUsingArray {
    private ListNode head;  // Head of the list

    // Constructor
    public TraversalUsingArray() {
        head = null;
    }



    public static void main(String[] args) {
      TraversalUsingArray list=new TraversalUsingArray();
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);
        head.next.next.next.next = head.next;

        System.out.println(list.isCycle(head));
    }
    public boolean isCycle(ListNode head){
        HashSet<Integer> set=new HashSet<>();
        ListNode temp=head;
        System.out.println(head.data);
        while(temp!=null){
            if(set.contains(temp.data)){
                return true;
            }
            else{
                set.add(temp.data);
            }
            temp=temp.next;
        }
        return false;

    }
}
