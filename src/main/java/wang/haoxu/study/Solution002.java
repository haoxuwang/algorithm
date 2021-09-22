package wang.haoxu.study;


/**
 * @Description 二进制加法
 * @Date 2021/8/24 11:24 上午
 * @Author william.wang
 */
public class Solution002 {

    public int singleNumber(int[] nums) {
        int one = 0, two = 0;
        for (int num : nums) {
            one = (one ^ num) & ~two;
            two = (two ^ num) & ~one;
        }
        return one;
    }

    /**
     *   ^ 异或 （相同为0  不同为1）  A ^ 0 = A  A ^ A = 0
     *   ~ 非   ~0 = -1  ~(-1)=0
     *   & 并   A & 0 = 0  A & -1 = A
     *
     *
     */
    public int singleNumber2(int[] nums) {
        int one = 0, two = 0;
        for (int num : nums) {
            one = (one ^ num) & ~two;
            two = (two ^ num) & ~one;
            System.out.println(one + " " + two);
        }
        return one;
    }

    public static void main(String[] args) {
        Solution002 solution = new Solution002();
        System.out.println(solution.singleNumber2(new int[]{2,2,3,2}));
    }
}
