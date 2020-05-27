package com.sumanth.algos;

import java.util.Stack;

/*
You are given two non-empty linked lists representing two non-negative integers.
The digits are stored in reverse order and each of their nodes contain a single digit.
Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example:

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.
 */
public class AddTwoNumbers {
    private class ListNode {
       int val;
       ListNode next;
       ListNode() {}
       ListNode(int val) { this.val = val; }
       ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

    public void twoSumAlgo(){
        ListNode l12=new ListNode(3,null);
        ListNode l11=new ListNode(4,l12);
        ListNode l1=new ListNode(2,l11);
        ListNode l22=new ListNode(4,null);
        ListNode l21=new ListNode(6,l22);
        ListNode l2=new ListNode(5,l21);

        ListNode result = addTwoNumbers(l1, l2);
        Stack<Integer> tempStack = new Stack<Integer>();
        while(result.next!=null){
            tempStack.push(result.val);
            result=result.next;
        }
        tempStack.push(result.val);
        while(!tempStack.isEmpty()){
            System.out.print(tempStack.pop());
        }
    }

    /*
     *   Algorithm: Normal Addition with Carry
     */
    private ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }
}
/*
CComplexity Analysis

    Time complexity : O(max(m,n)). Assume that m and n represents the length of l1 and l2
    respectively, the algorithm above iterates at most max(m,n) times.

    Space complexity : O(max(m,n)). The length of the new list is at most max⁡(m,n)+1.

 */
