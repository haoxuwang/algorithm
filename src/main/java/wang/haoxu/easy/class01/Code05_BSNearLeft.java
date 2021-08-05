package wang.haoxu.easy.class01;

public class Code05_BSNearLeft {

	// 在arr上，找满足>=value的最左位置
	public static int nearestIndex(int[] arr, int value) {
		int L = 0;
		int R = arr.length - 1;
		int index = -1;
		int mid = 0;
		while (L < R) {
			mid = L + ((R - L) >> 1);
			if (arr[mid] >= value) {
				index = mid;
				R = mid - 1;
			} else {
				L = mid + 1;
			}
		}
		return arr[L] >= value ? L : index;
	}

	public static void main(String[] args) {
		int a[] = {1,4,5,5,5,5,5,5,6,7,8};
		System.out.println(nearestIndex(a, 3));
	}

}
