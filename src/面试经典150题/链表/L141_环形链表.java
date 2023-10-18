package 面试经典150题.链表;

import common.ListNode;

import java.util.HashSet;
import java.util.Set;

public class L141_环形链表 {

    public boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while(head != null){
            if(set.contains(head)){
                return true;
            }
            set.add(head);
            head = head.next;
        }
        return false;
    }
}
