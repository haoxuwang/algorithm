package wang.haoxu.easy.class01;

public class Code09_FindOneLessValueIndex {

	/**
	 * 局部最小值
	 * 如果arr[0]<arr[1] ,arr[0]为局部最小值
	 * 如果arr[arr.length-1]<arr[arr.length-2] ,arr[arr.length-1]为局部最小值
	 * 否则局部最小值一定在中间 并且至少有一个
	 * @param arr
	 * @return
	 */
	public static int getLessIndex(int[] arr) {
		if (arr == null || arr.length == 0) {
			return -1; // no exist
		}
		if (arr.length == 1 || arr[0] < arr[1]) {
			return 0;
		}
		if (arr[arr.length - 1] < arr[arr.length - 2]) {
			return arr.length - 1;
		}
		int left = 1;
		int right = arr.length - 2;
		int mid = 0;
		while (left < right) {
			mid = (left + right) / 2;
			if (arr[mid] > arr[mid - 1]) {
				// 左边至少有一个
				/**
				 *			。（中点）							。
				 *		。		。							。
				 *	。				。					。
				 *  								。
				 *								。（中点）
				 */
				right = mid - 1;
			} else if (arr[mid] > arr[mid + 1]) {
				// 右边至少有一个
				/**
				 * 	。
				 * 		。
				 * 			。
				 * 				。
				 * 					。（中点）
				 */
				left = mid + 1;
			} else {
				/**
				 *
				 * 	。				。
				 * 		。		。
				 * 			。（中点）        			。	。	。（中点）	。	。
				 *
				 *
				 */
				return mid;
			}
		}
		return left;
	}

	public static void printArray(int[] arr) {
		for (int i = 0; i != arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[] arr = { 6, 5, 3, 4, 6, 7, 8 };
		printArray(arr);
		int index = getLessIndex(arr);
		System.out.println("index: " + index + ", value: " + arr[index]);

	}

}
