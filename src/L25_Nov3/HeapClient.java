package L25_Nov3;

import java.util.ArrayList;

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

		ArrayList<ArrayList<Integer>> lists = new ArrayList<>();

		ArrayList<Integer> list1 = new ArrayList<>();
		list1.add(10);
		list1.add(20);
		list1.add(30);
		list1.add(40);

		ArrayList<Integer> list2 = new ArrayList<>();
		list2.add(5);
		list2.add(6);
		list2.add(70);

		ArrayList<Integer> list3 = new ArrayList<>();
		list3.add(17);
		list3.add(19);
		list3.add(25);
		list3.add(40);

		lists.add(list1);
		lists.add(list2);
		lists.add(list3);

		System.out.println(lists);

		System.out.println(mergeKSortedArrays(lists));

		ArrayList<Integer> list = new ArrayList<>();
		list.add(10);
		list.add(200);
		list.add(90);
		list.add(100);
		list.add(24);
		list.add(5);

		System.out.println(kLargestElements(list, 3));

	}

	private static class Pair implements Comparable<Pair> {

		int data;
		int listNo;
		int indexNo;

		@Override
		public int compareTo(Pair o) {
			return o.data - this.data;
		}
	}

	public static ArrayList<Integer> mergeKSortedArrays(ArrayList<ArrayList<Integer>> lists) {

		ArrayList<Integer> ans = new ArrayList<>();

		HeapGeneric<Pair> heap = new HeapGeneric<>();

		for (int i = 0; i < lists.size(); i++) {

			Pair np = new Pair();
			np.data = lists.get(i).get(0);
			np.listNo = i;
			np.indexNo = 0;
			heap.add(np);
		}

		while (!heap.isEmpty()) {

			Pair rp = heap.remove();
			ans.add(rp.data);

			// update and insert again
			rp.indexNo++;
			if (rp.indexNo < lists.get(rp.listNo).size()) {
				rp.data = lists.get(rp.listNo).get(rp.indexNo);
				heap.add(rp);
			}

		}
		return ans;

	}

	public static ArrayList<Integer> kLargestElements(ArrayList<Integer> list, int k) {

		ArrayList<Integer> ans = new ArrayList<>();

		Heap heap = new Heap();

		for (int i = 0; i < k; i++) {
			heap.add(list.get(i));
		}

		for (int i = k; i < list.size(); i++) {

			int min = heap.getHP();

			if (list.get(i) > min) {
				heap.remove();
				heap.add(list.get(i));
			}
		}

		while (!heap.isEmpty()) {
			ans.add(heap.remove());
		}

		return ans;
	}

}
