package com.xuyuanchao.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的绝对值最大为 k。
 *
 * 示例 1:
 *
 * 输入: nums = [1,2,3,1], k = 3 输出: true 示例 2:
 *
 * 输入: nums = [1,0,1,1], k = 1 输出: true 示例 3:
 *
 * 输入: nums = [1,2,3,1,2,3], k = 2 输出: false
 *
 * @author xuyuanchao
 * @date 2018/11/30
 */
public class P0219ContainsDuplicateII {

  public boolean containsNearbyDuplicate(int[] nums, int k) {
    Map<Integer, List<Integer>> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      List<Integer> value = map.computeIfAbsent(nums[i], integer -> new ArrayList<>());
      for (Integer v : value) {
        if (i - v <= k) {
          return true;
        }
      }
      value.add(i);
    }
    return false;
  }

  public boolean containsNearbyDuplicateI(int[] nums, int k) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      if (map.containsKey(nums[i]) && (i - map.get(nums[i])) <= k) {
        return true;
      }
      map.put(nums[i], i);
    }
    return false;
  }

  public static void main(String[] args) {
    int[] nums = {1, 2, 3, 1};
    new P0219ContainsDuplicateII().containsNearbyDuplicate(nums, 3);
  }
}
