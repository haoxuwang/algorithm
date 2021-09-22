package wang.haoxu.study;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Description [剑指 Offer II 083]没有重复元素集合的全排列.java
 * @Date 2021/8/24 11:24 上午
 * @Author william.wang
 */
public class Solution083 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        for (int x: nums) {
            temp.add(x);
        }
        process(nums, result, temp, 0);
        return result;
    }
    void process(int[] nums, List<List<Integer>> result, List<Integer> temp, int index) {
        if (index == nums.length) {
            result.add(new ArrayList<>(temp));
            return;
        }
        for (int i = index; i < nums.length; i ++) {
            Collections.swap(temp, index, i);
            process(nums, result, temp, index + 1);
            Collections.swap(temp, index, i);
        }
    }

    public static void main(String[] args) {
        Solution083 solution = new Solution083();
        System.out.println(solution.permute(new int[]{1,2,3}));
    }
}
