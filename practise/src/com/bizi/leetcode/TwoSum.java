package com.bizi.leetcode;

import org.junit.Test;

import java.util.HashMap;

/**
 Given an array of integers, find two numbers such that they add up to a specific target number.

 The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be
less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.

 You may assume that each input would have exactly one solution.

 Input: numbers={2, 7, 11, 15}, target=9
 Output: index1=1, index2=2
 */
public class TwoSum {
	public int[] twoSum1(int[] nums, int target) {
		int[] result = new int[2];
		for(int i=0;i<nums.length;i++){
			for(int j=1;j<nums.length;j++){
				if(i!=j&&nums[i]+nums[j]==target){
					result[0]=i+1;
					result[1]=j+1;
					return result;
				}
			}
		}
		return null;
	}
	public static int[] twoSum2(int[] nums, int target){
		int[] result = new int[2];
		HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
		for (int i=0;i<nums.length;i++){
			if(map.containsKey(nums[i])) {
				int index = map.get(nums[i]);
				result[0] = index+1;
				result[1] = i+1;
				break;
			}else{
				map.put(target - nums[i], i);
			}
		}
		return result;
	}

	@Test
	public void testTwoSum2(){
		int[] nums = new int[]{2,4,8,6};
		System.out.println(TwoSum.twoSum2(nums,10)[1]);
	}
}
