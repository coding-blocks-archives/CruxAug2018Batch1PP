package L8_Sep15;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Garima Chhikara
 * @date Sep 15, 2018
 */

public class RecursionDemo {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		// int num = scn.nextInt();
		// printDecInc(5);
		// printSkips(7);
		// System.out.println(Factorial(num));
		// System.out.println(fibonacci(num));
		int[] arr = { 10, 20, 130, 40, 20, 50, 20 };
		// displayReverse(arr, 0);

		System.out.println(max(arr, 0));
		System.out.println(findStartIndex(arr, 0, 20));
		System.out.println(findEndIndex(arr, 0, 20));
		System.out.println(findAllIndexAL(arr, 0, 20));
		int[] ans = findAllIndex(arr, 0, 20, 0);
		for (int val : ans) {
			System.out.println(val);
		}

		int i = 4;

		int a = ++i;
		System.out.println(a + " " + i);

	}

	public static void printDec(int n) {

		if (n == 0) {
			return;
		}

		// work of smaller problem gets converted to bigger problem
		System.out.println(n);

		// assumption
		printDec(n - 1);

	}

	public static void printInc(int n) {

		if (n == 0)
			return;

		printInc(n - 1);

		System.out.println(n);

	}

	public static void printDecInc(int n) {

		if (n == 0)
			return;

		System.out.println(n);

		printDecInc(n - 1);

		System.out.println(n);

	}

	public static void printSkips(int n) {

		if (n == 0)
			return;

		if (n % 2 != 0)
			System.out.println(n);

		printSkips(n - 1);

		if (n % 2 == 0)
			System.out.println(n);

	}

	public static int Factorial(int n) {

		if (n == 1) {
			return 1;
		}
		// smaller prob
		int fnm1 = Factorial(n - 1);
		int fn = fnm1 * n;

		return fn;

		// return Factorial(n - 1) * n;

	}

	public static int power(int x, int n) {

		if (n == 0) {
			return 1;
		}
		int sp = power(x, n - 1);
		int bp = sp * x;

		return bp;

	}

	public static int fibonacci(int n) {

		if (n == 0 || n == 1) {
			return n;
		}

		int fnm1 = fibonacci(n - 1);
		int fnm2 = fibonacci(n - 2);

		int fn = fnm1 + fnm2;

		return fn;

	}

	public static void display(int[] arr, int vidx) {

		if (vidx == arr.length) {
			return;
		}

		System.out.println(arr[vidx]);
		display(arr, vidx + 1);
	}

	public static void displayReverse(int[] arr, int vidx) {

		if (vidx == arr.length) {
			return;
		}

		displayReverse(arr, vidx + 1);
		System.out.println(arr[vidx]);
	}

	public static int max(int[] arr, int vidx) {

		if (vidx == arr.length) {
			return Integer.MIN_VALUE;
		}

		int recAns = max(arr, vidx + 1);

		if (recAns > arr[vidx]) {
			return recAns;
		} else {
			return arr[vidx];
		}
	}

	public static int findStartIndex(int[] arr, int vidx, int item) {

		if (vidx == arr.length) {
			return -1;
		}

		if (arr[vidx] == item) {
			return vidx;
		}

		int recAns = findStartIndex(arr, vidx + 1, item);

		return recAns;

	}

	public static int findEndIndex(int[] arr, int vidx, int item) {

		if (vidx == arr.length) {
			return -1;
		}

		int recAns = findEndIndex(arr, vidx + 1, item);

		if (arr[vidx] == item && recAns == -1) {
			return vidx;
		} else {
			return recAns;
		}

	}

	public static ArrayList<Integer> findAllIndexAL(int[] arr, int vidx, int item) {

		if (vidx == arr.length) {
			ArrayList<Integer> bres = new ArrayList<>();
			return bres;
		}

		ArrayList<Integer> recAns = findAllIndexAL(arr, vidx + 1, item);

		if (arr[vidx] == item) {
			recAns.add(0, vidx);
		}

		return recAns;

	}

	public static int[] findAllIndex(int[] arr, int vidx, int item, int count) {

		if (vidx == arr.length) {

			int[] bres = new int[count];
			return bres;
		}

		int[] recAns;

		if (arr[vidx] == item) {
			recAns = findAllIndex(arr, vidx + 1, item, count + 1);
			recAns[count] = vidx;
		} else {
			recAns = findAllIndex(arr, vidx + 1, item, count);
		}

		return recAns;

	}

}
