package L12_Sep30;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 30-Sep-2018
 *
 */

public class RecursionSorting {

	public static void main(String[] args) {

		// int[] one = { 10, 20, 30, 40, 50 };
		// int[] two = { 2, 3, 5, 15, 80, 90, 100 };
		//
		// int[] ans = mergeTwoSortedArrays(one, two);
		//
		// for (int val : ans) {
		// System.out.println(val);
		// }

		// int[] arr = { 100, 30, 40, 50, 20, 1, 8, 7, -3 };
		// int[] ans = mergeSort(arr, 0, arr.length - 1);

		int[] arr = new int[1000000];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = arr.length - i;
		}

		long start = System.currentTimeMillis();
		// quickSort(arr, 0, arr.length - 1);
		bubbleSort(arr);
		long end = System.currentTimeMillis();
		
		System.out.println(end - start);

		// for (int val : arr) {
		// System.out.println(val);
		// }

	}

	public static void bubbleSort(int[] arr) {

		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr.length - 1 - i; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
	}

	public static int[] mergeTwoSortedArrays(int[] one, int[] two) {

		int[] merged = new int[one.length + two.length];

		int i = 0;
		int j = 0;
		int k = 0;

		while (i < one.length && j < two.length) {

			if (one[i] < two[j]) {
				merged[k] = one[i];
				k++;
				i++;
			} else {
				merged[k] = two[j];
				k++;
				j++;
			}
		}

		if (i == one.length) {
			while (j < two.length) {
				merged[k] = two[j];
				k++;
				j++;
			}
		}

		if (j == two.length) {
			while (i < one.length) {
				merged[k] = one[i];
				k++;
				i++;
			}
		}

		return merged;

	}

	public static int[] mergeSort(int[] arr, int lo, int hi) {

		if (lo == hi) {
			int[] br = new int[1];
			br[0] = arr[lo];
			return br;
		}

		int mid = (lo + hi) / 2;

		int[] fh = mergeSort(arr, lo, mid);
		int[] sh = mergeSort(arr, mid + 1, hi);

		int[] sorted = mergeTwoSortedArrays(fh, sh);

		return sorted;

	}

	public static void quickSort(int[] arr, int lo, int hi) {

		if (lo >= hi) {
			return;
		}

		// partitioning
		int left = lo;
		int right = hi;
		int mid = (lo + hi) / 2;
		int pivot = arr[mid];

		while (left <= right) {

			while (arr[left] < pivot) {
				left++;
			}

			while (arr[right] > pivot) {
				right--;
			}

			// swap
			if (left <= right) {
				int temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;
				left++;
				right--;
			}

		}

		// partitioning complete

		// calls -> smaller prob
		quickSort(arr, lo, right);
		quickSort(arr, left, hi);

	}

}
