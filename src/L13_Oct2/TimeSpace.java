package L13_Oct2;

import java.util.Arrays;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 02-Oct-2018
 *
 */

public class TimeSpace {

	public static void main(String[] args) {

		long start = System.currentTimeMillis();
		int[] arr = new int[1000000];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = i;
		}

		// bubblesort(arr);

		long end = System.currentTimeMillis();

		// System.out.println(end - start);

		// System.out.println(polynomial(3, 5));
		// System.out.println(countPalindromicSS("abcbdbb")); // 10

		SOE(25);
	}

	public static void bubblesort(int[] arr) {

		boolean flag = true;
		for (int counter = 0; counter < arr.length - 1; counter++) {

			for (int j = 0; j < arr.length - 1 - counter; j++) {

				if (arr[j] > arr[j + 1]) {

					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;

					flag = false;
				}
			}

			if (flag) {
				break;
			}
		}

	}

	public static int polynomial(int x, int n) {

		int sum = 0;
		int power = x;

		for (int coeff = n; coeff >= 1; coeff--) {

			sum += (coeff * power);
			power = power * x;

		}

		return sum;

	}

	public static int polynomialRec(int n, int x, int power) {

		if (n == 1) {
			return power;
		}

		int sp = polynomialRec(n - 1, x, power * x);
		int bp = n * power + sp;

		return bp;
	}

	public static int countPalindromicSS(String str) {

		int count = 0;

		// odd length palindromic ss
		for (int axis = 0; axis < str.length(); axis++) {

			for (int orbit = 0; axis - orbit >= 0 && axis + orbit < str.length(); orbit++) {

				if (str.charAt(axis - orbit) == str.charAt(axis + orbit)) {
					count++;
				} else {
					break;
				}

			}
		}

		// even length palindromic ss
		for (double axis = 0.5; axis < str.length(); axis++) {

			for (double orbit = 0.5; axis - orbit >= 0 && axis + orbit < str.length(); orbit++) {

				if (str.charAt((int) (axis - orbit)) == str.charAt((int) (axis + orbit))) {
					count++;
				} else {
					break;
				}

			}
		}

		return count;

	}

	// x^n in log n
	public static int power(int x, int n) {

		if (n == 0) {
			return 1;
		}

		int ans = 0;

		int rr = power(x, n / 2);
		if (n % 2 == 0) {
			ans = rr * rr;
		} else {
			ans = rr * rr * x;
		}

		return ans;
	}

	public static void SOE(int n) {

		boolean[] primes = new boolean[n + 1];

		Arrays.fill(primes, true);

		primes[0] = false;
		primes[1] = false;

		for (int table = 2; table * table <= n; table++) {

			if (primes[table] == false) {
				continue;
			}

			for (int multiplier = 2; multiplier * table <= n; multiplier++) {
				primes[table * multiplier] = false;
			}

		}

		for (int i = 0; i < primes.length; i++) {
			if (primes[i] == true) {
				System.out.println(i);
			}
		}

	}

}
