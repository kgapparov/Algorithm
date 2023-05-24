package leetcode.linkedlist;

import java.util.List;

public class ListNode {
   public ListNode next;
   public Integer val;

    public ListNode() {
    }

    public ListNode(ListNode next, Integer val) {
        this.next = next;
        this.val = val;
    }
    public static ListNode fromArray(int[] arr) {
        ListNode dummy = new ListNode(null, 0);
        ListNode curr = dummy;
        for (int n : arr) {
            if (curr == null) {
                curr = new ListNode(null, n);
            }
            curr = curr.next;
        }
        return dummy.next;
    }
    public static void print(ListNode listNode) {
        int i = 0;
        ListNode curr = listNode;
        while (curr != null) {
            i++;
            curr = curr.next;
        }
        int idx = 0;
        while (listNode != null) {
            System.out.printf("%d", listNode.val);
            if (idx++ < i - 1) {
                System.out.print(" -> ");
            }
            listNode = listNode.next;
        }
        System.out.println();
    }
}
