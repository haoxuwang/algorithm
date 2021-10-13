package wang.haoxu.study;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description [剑指 Offer II 082]含有重复元素集合的组合.java
 * @Date 2021/8/24 11:24 上午
 * @Author william.wang
 */
public class Solution082 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(candidates);
        process(candidates, target, res, temp, 0);
        return res;
    }
    public void process(int[] candidates, int target, List<List<Integer>> res, List<Integer> temp, int index) {
        if (0 == target) {
            res.add(new ArrayList<>(temp));
            return;
        }
        if (target < 0) {
            return;
        }
        if (index > candidates.length) {
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }
            temp.add(candidates[i]);
            process(candidates, target - candidates[i], res, temp, i+1);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution082 solution = new Solution082();
        System.out.println(solution.combinationSum2(new int[]{2,5,2,1,2}, 5));
    }
}
