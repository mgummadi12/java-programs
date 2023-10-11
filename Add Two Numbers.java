**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
 class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) {
        this.val = val;
    }
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
    
    // Deserialize a string to a ListNode.
    // Deserialize a string to a ListNode.
public static ListNode deserialize(String input) {
    // Remove square brackets and split by comma.
    String[] values = input.substring(1, input.length() - 1).split(",");
    ListNode dummy = new ListNode();
    ListNode current = dummy;
    
    for (String value : values) {
        current.next = new ListNode(Integer.parseInt(value.trim()));
        current = current.next;
    }
    
    return dummy.next;
}

}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(); // Create a dummy node to simplify handling edge cases.
        ListNode current = dummy;
        int carry = 0;

        while (l1 != null || l2 != null) {
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;
            int sum = x + y + carry;
            carry = sum / 10;

            current.next = new ListNode(sum % 10);
            current = current.next;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        if (carry > 0) {
            current.next = new ListNode(carry);
        }

        return dummy.next; // The result is in the next node of the dummy node.
    }
}