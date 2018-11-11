package L27_Nov10.OOPS_Story4;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 10-Nov-2018
 *
 */

public class Overloading {

	public static void main(String[] args) {

		add();

		int[] arr = { 4, 5 };

		// add(2, 3.4, 4.5);
	}

	public static void add(int a, int b) {
		int sum = a + b;

		System.out.println(sum);
	}

	public static void add(int a, int b, int c) {
		int sum = a + b + c;

		System.out.println(sum);
	}

	public static void add(int a, double b, double c) {
		double sum = a + b + c;

		System.out.println(sum);
	}

	public static void add(int... a) {

		System.out.println("in var args");

		int s = 0;

		for (int val : a) {
			s += val;
		}

		System.out.println(s);
	}

}
