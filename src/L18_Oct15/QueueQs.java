package L18_Oct15;

import L15_Oct7.DynamicQueue;
import L15_Oct7.Queue;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 15-Oct-2018
 *
 */

public class QueueQs {

	public static void main(String[] args) throws Exception {

		Queue q = new DynamicQueue();
		q.enqueue(10);
		q.enqueue(20);
		q.enqueue(30);
		q.enqueue(40);
		q.enqueue(50);

		q.display();
		displayReverse(q, 0);
		q.display();

		actualReverse(q);
		q.display();

	}

	public static void displayReverse(Queue q, int count) throws Exception {

		if (count == q.size()) {
			return;
		}

		int temp = q.dequeue();
		q.enqueue(temp);

		displayReverse(q, count + 1);

		System.out.println(temp);

	}

	public static void actualReverse(Queue q) throws Exception {

		if (q.isEmpty()) {
			return;
		}

		int temp = q.dequeue();

		actualReverse(q);

		q.enqueue(temp);

	}

}
