package wang.haoxu.study.sort;

import wang.haoxu.study.util.SortUtil;

/**
 * @Description TODO
 * @Date 2021/8/5 3:09 下午
 * @Author william.wang
 */
public class MergeSort {



    private static void sort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        sort(arr, 0 , arr.length - 1);
    }
    private static void sort(int[] arr, int l, int r) {
        if (l == r) {
            return;
        }
        int mid = ( l + r ) / 2;
        sort(arr, l, mid);
        sort(arr, mid + 1, r);
        merge(arr, l, r);
    }
    private static void merge(int[] arr, int l, int r) {
        int mid = ( l + r ) / 2;
        int[] help = new int[r - l + 1];
        int i = 0;
        int p1 = l;
        int p2 = mid + 1;
        while (p1 <= mid && p2 <= r) {
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= mid) {
            help[i++] = arr[p1++];
        }
        while (p2 <= r) {
            help[i++] = arr[p2++];
        }
        for (i = 0; i < help.length; i++) {
            arr[l + i] = help[i];
        }
    }

    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = SortUtil.generateRandomArray(maxSize, maxValue);
            int[] arr2 = SortUtil.copyArray(arr1);
            sort(arr1);
            SortUtil.comparator(arr2);
            if (!SortUtil.isEqual(arr1, arr2)) {
                succeed = false;
                SortUtil.printArray(arr1);
                SortUtil.printArray(arr2);
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");

        int[] arr = SortUtil.generateRandomArray(maxSize, maxValue);
        SortUtil.printArray(arr);
        sort(arr);
        SortUtil.printArray(arr);

    }
}
