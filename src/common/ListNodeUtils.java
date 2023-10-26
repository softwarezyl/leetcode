package common;

public class ListNodeUtils {

    public static ListNode construct(int[] arr){
        ListNode head = new ListNode(arr[0]);

        ListNode cur = head;
        for(int i=1; i<arr.length; i++){
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
        return head;
    }

    public static void print(ListNode node){
        while(node != null){
            System.out.print(node.val + " ");
            node = node.next;
        }
    }

}
