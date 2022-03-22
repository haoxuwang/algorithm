package wang.haoxu.study;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List maxSubArray(int[] nums) {
        int sum = 0;
        List temp = new ArrayList();
        int max = Integer.MIN_VALUE;
        List maxArray = new ArrayList();
        if(nums.length == 1) {
            maxArray.add(nums[0]);
            return maxArray;
        }
        for(int i= 0;i<nums.length;i++) {
            if(sum>0){
                temp.add(nums[i]);
                sum +=nums[i];
            }else{
                temp.clear();
                temp.add(nums[i]);
                sum = nums[i];
            }
            if(sum > max) {
                max = sum;
                maxArray.clear();
                for (int i1 = 0; i1 < temp.size(); i1++) {
                    maxArray.add(temp.get(i1));
                }
            }
        }
        return maxArray;

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List list = solution.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
        list.forEach(System.out::println);
    }
}
