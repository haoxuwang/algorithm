package wang.haoxu.study;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description [剑指 Offer II 081]允许重复选择元素的组合.java
 * @Date 2021/8/24 11:24 上午
 * @Author william.wang
 */
public class Solution081 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new LinkedList<>();
        dfs(candidates,target,temp, res, 0,0);
        return res;
    }
    private void dfs(int[] candidates, int target, List<Integer> temp, List<List<Integer>> res, int i, int currSum) {
        if (currSum == target) {
            res.add(new LinkedList<>(temp));
            return;
        }
        if (currSum > target) {
            return;
        }
        for (int j=i;j<candidates.length;j++) {
            temp.add(candidates[j]);
            dfs(candidates,target,temp, res, j,currSum+candidates[j]);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution081 solution = new Solution081();
        System.out.println(solution.combinationSum(new int[]{2,3,5,8,9}, 8));
    }
}
