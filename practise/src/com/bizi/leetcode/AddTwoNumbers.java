package com.bizi.leetcode;

/**
 * Created by fangbi.guo on 2015/10/27.
 */
public class AddTwoNumbers {
	public ListNode addTwoNumbers(ListNode node1, ListNode node2) {
		if(node1==null)
			return node2;
		if(node2 == null){
			return node1;
		}
		ListNode root = new ListNode(0);
		int sum = 0;
		int carry = 0;
		while(node1!=null && node2!=null){
			sum = node1.val + node2.val + carry;
			carry = sum/10;
			sum = sum%10;

			root.val = sum;

		}
		return null;
	}
}
class ListNode{
	public int val;
	public ListNode next;

	public ListNode(int val){
		this.val = val;
	}

}