package com.bizi.leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by fangbi.guo on 2015/10/27.
 */
public class LengthOfLongestSubstring {
	public static int lengthOfLongestSubstring(String s){
		int maxLen = 0;
		char[] data = s.toCharArray();
		for(int i=0;i<data.length;i++){
			int temLen = 1;
			for(int j=i+1;j<data.length;j++){
				if(data[i]==data[j]){
					break;
				}else{
					temLen++;
				}
			}
			maxLen = maxLen>temLen?maxLen:temLen;
		}
		return maxLen;
	}

	@Test
	public void testLengthOfLongestSubstring1(){
//		System.out.println(LengthOfLongestSubstring.lengthOfLongestSubstring("abc"));
//		System.out.println(LengthOfLongestSubstring.lengthOfLongestSubstring(""));
		System.out.println(LengthOfLongestSubstring.lengthOfLongestSubstring("cdd"));
	}

	public static int lengthOfLongestSubstring2(String s){
		int pre = 0;
		char[] data = s.toCharArray();
		Map<Character,Integer> map = new HashMap<Character,Integer>();
		for(int i=0;i<data.length;i++){
			if(map.containsKey(data[i])){
				pre = Math.max(pre,map.size());
				i = map.get(data[i]);
				map.clear();
			}else{
				map.put(data[i],i);
			}
		}
		return Math.max(pre,map.size());
	}
}
