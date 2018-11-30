package com.xuyuanchao.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 编写一个程序，找出第 n 个丑数。
 *
 * 丑数就是只包含质因数 2, 3, 5 的正整数。
 *
 * 示例:
 *
 * 输入: n = 10 输出: 12 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。 说明:
 *
 * 1 是丑数。 n 不超过1690。
 *
 * tips:
 *
 * 1. The naive approach is to call isUgly for every number until you reach the nth one. Most
 * numbers are not ugly. Try to focus your effort on generating only the ugly ones.
 *
 * 2. An ugly number must be multiplied by either 2, 3, or 5 from a smaller ugly number.
 *
 * 3. The key is how to maintain the order of the ugly numbers. Try a similar approach of merging
 * from three sorted lists: L1, L2, and L3.
 *
 * 4. Assume you have Uk, the kth ugly number. Then Uk+1 must be Min(L1 * 2, L2 * 3, L3 * 5).
 *
 * @author xuyuanchao
 * @date 2018/11/30
 */
public class P0264UglyNumberII {

  public static void main(String[] args) {
    new P0264UglyNumberII().nthUglyNumber(10);
  }

  public int nthUglyNumber(int n) {
    if (n == 1) {
      return 1;
    }
    List<Integer> l1 = new ArrayList();
    l1.add(1);
    List<Integer> l2 = new ArrayList();
    l2.add(1);
    List<Integer> l3 = new ArrayList();
    l3.add(1);

    int count = 1;
    while (true) {
      List<Integer> list = new ArrayList<>(3);
      list.add(l1.get(l1.size() - 1) * 2);
      list.add(l2.get(l2.size() - 1) * 3);
      list.add(l3.get(l3.size() - 1) * 5);
      Collections.sort(list);

      if (++count == n) {
        return list.get(0);
      }

      l1.add(list.get(2));
      Collections.sort(l1);

      l2.add(list.get(1));
      Collections.sort(l2);

      l3.add(list.get(0));
      Collections.sort(l3);
    }
  }
}
