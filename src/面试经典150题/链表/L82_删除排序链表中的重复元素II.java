package 面试经典150题.链表;

import common.ListNode;
import common.ListNodeUtils;

/**
 * 给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回 已排序的链表 。
 *
 * 示例 1：
 * 输入：head = [1,2,3,3,4,4,5]
 * 输出：[1,2,5]
 *
 *  示例 2：
 * 输入：head = [1,1,1,2,3]
 * 输出：[2,3]
 *
 *
 * 提示：
 * 链表中节点数目在范围 [0, 300] 内
 * -100 <= Node.val <= 100
 * 题目数据保证链表已经按升序 排列
 */
public class L82_删除排序链表中的重复元素II {

    public ListNode deleteDuplicates(ListNode head) {
        if(head == null){
            return null;
        }

        ListNode dummy = new ListNode(0, head);

        ListNode pre = dummy;
        ListNode current = dummy.next;

        while(current != null){
            ListNode next = current.next;
            if(next != null && current.val == next.val){
                while(next != null && current.val == next.val){
                    next = next.next;
                }
                pre.next = next;
                current = next;
            }else{
                pre = pre.next;
                current = current.next;
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        L82_删除排序链表中的重复元素II test = new L82_删除排序链表中的重复元素II();

        ListNode node1 = ListNodeUtils.construct(new int[]{1, 2, 3, 3, 4, 4, 5});
        ListNode head1 = test.deleteDuplicates(node1);
        ListNodeUtils.print(head1);

        ListNode node2 = ListNodeUtils.construct(new int[]{1, 1});
        ListNode head2 = test.deleteDuplicates(node2);
        ListNodeUtils.print(head2);

    }
}
