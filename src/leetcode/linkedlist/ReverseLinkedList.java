package leetcode.linkedlist;

import java.util.Arrays;
import java.util.List;

public class ReverseLinkedList {

    public static int findLen(ListNode head) {
        int i = 0;
        while (head != null) {
            i++;
            head = head.next;
        }
        return i;
    }

    public static List<ListNode> reverseNextK(ListNode head, int k) {
        ListNode current = head;
        ListNode pre = null;
        ListNode next = null;
        int i = 0;
        while (current != null && i < k) {
            next = current.next;
            current.next = pre;
            pre = current;
            current = next;
            i++;
        }
        return Arrays.asList(pre, current);
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        int totalLen = findLen(head);
        ListNode lastNodeOfCurrentList = null;
        ListNode lastNodeOfPreviousNode = null;
        ListNode current = head;
        ListNode pre = null;
        int i = 0;
        while (totalLen - i >= k && current != null) {
            lastNodeOfPreviousNode = pre;
            lastNodeOfCurrentList = current;
            int n = 0;
            while (current != null &&  n++ < k) {
                ListNode next = current.next;
                current.next = pre;
                pre = current;
                current = next;
            }
            if (lastNodeOfPreviousNode != null) {
                lastNodeOfPreviousNode.next = pre;
            } else {
                head = pre;
            }
            lastNodeOfCurrentList.next = current;
            i += k;
            pre = lastNodeOfCurrentList;
        }
        return head;
    }

    private static ListNode getKthNode(ListNode head, int k) {
        int i = 1;
        ListNode curr = head;
        while (i++ < k && curr != null) {
            curr = curr.next;
        }
        return curr;
    }

    public static void main(String[] args) {
        int [] case1 = {1,2,3,4,5};
        ListNode listNode = ListNode.fromArray(case1);
        ListNode.print(reverseKGroup(listNode, 2));
    }
}
