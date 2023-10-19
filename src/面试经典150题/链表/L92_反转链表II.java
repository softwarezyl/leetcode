package 面试经典150题.链表;

import common.ListNode;

/**
 * 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 * <p>
 * 示例 1：
 * 输入：head = [1,2,3,4,5], left = 2, right = 4
 * 输出：[1,4,3,2,5]
 * <p>
 * 示例 2：
 * 输入：head = [5], left = 1, right = 1
 * 输出：[5]
 */
public class L92_反转链表II {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;

        // 获取子串的前一个节点
        ListNode pre = dummyNode;
        for(int i=0; i<left-1; i++){
            pre = pre.next;
        }
        System.out.println("pre.val=" + pre.val);

        // 获取到子串右节点
        ListNode rightNode = pre;
        for(int i=0; i<right-left+1; i++){
            rightNode = rightNode.next;
        }

        // 获取子串的左节点
        ListNode leftNode = pre.next;
        ListNode last = rightNode.next;

        // 切断子串
        pre.next = null;
        rightNode.next = null;

        // 反转子串
        this.reverse(leftNode);

        // 拼接结果
        pre.next = rightNode;
        leftNode.next = last;
        return dummyNode.next;
    }

    private void reverse(ListNode head){
        ListNode node = head;

        ListNode pre = null;
        while(node != null){
            ListNode next = node.next;

            node.next = pre;
            pre = node;

            node = next;
        }
    }
}
