package 面试经典150题.链表;

import java.util.HashMap;
import java.util.Map;

public class L138_随机链表的复制 {

    Map<Node, Node> cache = new HashMap<>();

    /**
     * 回溯 + 哈希表
     */
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        if (!cache.containsKey(head)) {
            Node newHead = new Node(head.val);
            cache.put(head, newHead);

            newHead.next = copyRandomList(head.next);
            newHead.random = copyRandomList(head.random);
        }
        return cache.get(head);
    }
}
