package L25_Nov3;

import L24_Oct28.GenericFxn.Car;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 03-Nov-2018
 *
 */

public class HeapClient {

	public static void main(String[] args) {

		Heap heap = new Heap();

		for (int i = 4; i >= 1; i--) {
			heap.add(i * 10);
		}

		for (int i = 40; i <= 45; i++) {
			heap.add(i * 10);
		}

		while (!heap.isEmpty()) {
			System.out.println(heap.remove());
		}

		Car[] cars = new Car[5];
		// display(carr);

		cars[0] = new Car(100, 10, "Black");
		cars[1] = new Car(400, 20, "Red");
		cars[2] = new Car(80, 60, "White");
		cars[3] = new Car(780, 5, "Brown");
		cars[4] = new Car(34, 100, "Grey");

		HeapGeneric<Car> heapg = new HeapGeneric<>();
		for (int i = 0; i < 5; i++) {
			heapg.add(cars[i]);
		}

		while (!heapg.isEmpty()) {
			System.out.println(heapg.remove());
		}

	}

}
