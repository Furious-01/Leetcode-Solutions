/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    private ListNode frontPointer;

    public boolean isPalindrome(ListNode head) {
        frontPointer = head;
        return recursivelyCheck(head);
    }

    private boolean recursivelyCheck(ListNode currentNode) {
        if (currentNode == null) {
            return true;
        }

        boolean isPal = recursivelyCheck(currentNode.next);
        if (!isPal) {
            return false;
        }

        boolean isEqual = (frontPointer.val == currentNode.val);
        frontPointer = frontPointer.next;

        return isEqual;
    }
}
