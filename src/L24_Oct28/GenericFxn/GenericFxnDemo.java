package L24_Oct28.GenericFxn;

import java.util.Comparator;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 28-Oct-2018
 *
 */

public class GenericFxnDemo {

	public static void main(String[] args) {

		Integer[] arr = { 10, 20, 30, 40, 50 };

		String[] sarr = { "hello", "hi", "bye", "cb" };
		display(arr);
		display(sarr);

		Car[] carr = new Car[5];
		// display(carr);

		carr[0] = new Car(100, 10, "Black");
		carr[1] = new Car(400, 20, "Red");
		carr[2] = new Car(80, 60, "White");
		carr[3] = new Car(780, 5, "Brown");
		carr[4] = new Car(34, 100, "Grey");

		// display(carr);

		// bubbleSort(carr);
		// display(carr);
		bubbleSort(carr, new CarSpeedComparator());
		display(carr);
		bubbleSort(carr, new CarPriceComparator());
		display(carr);
		bubbleSort(carr, new CarColorComparator());
		display(carr);

	}

	public static <T> void display(T[] arr) {
		for (T val : arr) {
			System.out.println(val);
		}
		System.out.println();

	}

	// private static void display(String[] arr) {
	// for (String val : arr) {
	// System.out.println(val);
	// }
	//
	// }
	//
	// public static void display(Integer[] arr) {
	// for (Integer val : arr) {
	// System.out.println(val);
	// }
	// }

	public static <T extends Comparable<T>> void bubbleSort(T[] arr) {

		for (int counter = 0; counter < arr.length - 1; counter++) {

			for (int j = 0; j < arr.length - 1 - counter; j++) {

				if (arr[j].compareTo(arr[j + 1]) > 0) {
					T temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}

	}

	public static <T> void bubbleSort(T[] arr, Comparator<T> comparator) {

		for (int counter = 0; counter < arr.length - 1; counter++) {

			for (int j = 0; j < arr.length - 1 - counter; j++) {

				if (comparator.compare(arr[j], arr[j + 1]) > 0) {
					T temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}

	}

}
