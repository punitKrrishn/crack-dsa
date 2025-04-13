//package LinkedList.Questions;
//
//public class MergeTwoLists {
//    /**
//     * Definition for singly-linked list.
//     * public class ListNode {
//     *     int val;
//     *     ListNode next;
//     *     ListNode() {}
//     *     ListNode(int val) { this.val = val; }
//     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//     * }
//     */
//    class Solution {
//        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
//            ListNode temp1 = list1;
//            ListNode temp2 = list2;
//            ListNode resHead = new ListNode(100);
//
//            ListNode res = resHead;
//
//            // If both lists are empty
//            if (list1 == null && list2 == null) {
//                return null;
//            }
//
//            // If one list is empty, return the other list
//            if (list1 == null) {
//                return list2;
//            }
//            if (list2 == null) {
//                return list1;
//            }
//
//            while(temp1 != null && temp2 != null) {
//                if(temp1.val < temp2.val) {
//                    res.next = temp1;
//                    res = res.next;
//                    temp1 = temp1.next;
//                }else {
//                    res.next = temp2;
//                    res = res.next;
//                    temp2 = temp2.next;
//                }
//            }
//            while(temp1 != null) {
//                res.next = temp1;
//                res = res.next;
//                temp1 = temp1.next;
//            }
//            while(temp2 != null) {
//                res.next = temp2;
//                res = res.next;
//                temp2 = temp2.next;
//            }
//
//            resHead.val = resHead.next.val;
//            resHead.next = resHead.next.next;
//
//            return resHead;
//
//
//        }
//    }
//}
