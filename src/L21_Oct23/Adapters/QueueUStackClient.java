package L21_Oct23.Adapters;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 23-Oct-2018
 *
 */

public class QueueUStackClient {

	public static void main(String[] args) throws Exception {

		QueueUsingStackDeqEff queue = new QueueUsingStackDeqEff();

		queue.enqueue(10);
		queue.enqueue(20);
		queue.enqueue(30);
		queue.enqueue(40);
		queue.enqueue(50);

		queue.display();

		System.out.println(queue.dequeue());

		queue.display();
	}

}
