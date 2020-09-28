package gaopei;

/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * <p>
 * 示例：
 * <p>
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * <p>
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 * <p>
 * 给定的 n 保证是有效的。
 * <p>
 * 进阶：
 * <p>
 * 你能尝试使用一趟扫描实现吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question19 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode newHead = new ListNode(-1);
        newHead.next = head;

        ListNode fast = newHead;
        ListNode slow = newHead;
        while (fast != null) {
            fast = fast.next;
            if (n >= 0) {
                n--;
                continue;
            }
            slow = slow.next;
        }
        if (slow != null && slow.next != null) {
            slow.next = slow.next.next;
        }
        return newHead.next;
    }

    public static void main(String[] args) {
        Question19 question19 = new Question19();
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);

        ListNode result = question19.removeNthFromEnd(listNode, 1);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

}
