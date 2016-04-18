package list;

import java.util.HashMap;

/**
 * Created by huangzhibo on 4/7/16.
 */
public class FindFirstCommonNode {
        public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
            ListNode current1 = pHead1;
            ListNode current2 = pHead2;


            HashMap<ListNode, Integer> hashMap = new HashMap<ListNode, Integer>();
            while (current1 != null) {
                hashMap.put(current1, null);
                current1 = current1.next;
            }
            while (current2 != null) {
                if (hashMap.containsKey(current2))
                    return current2;
                current2 = current2.next;
            }

            return null;

        }
}
