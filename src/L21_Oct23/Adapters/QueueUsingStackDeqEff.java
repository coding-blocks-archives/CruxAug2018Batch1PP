package L21_Oct23.Adapters;

import L15_Oct7.DynamicStack;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 23-Oct-2018
 *
 */

public class QueueUsingStackDeqEff {

	DynamicStack primary = new DynamicStack();

	public void enqueue(int item) throws Exception {

		try {

			DynamicStack helper = new DynamicStack();

			while (primary.size() != 0) {
				int element = primary.pop();
				helper.push(element);
			}

			primary.push(item);

			while (helper.size() != 0) {
				int element = helper.pop();
				primary.push(element);
			}

		} catch (Exception e) {
			throw new Exception("Queue is Full");
		}
	}

	public int dequeue() throws Exception {

		try {
			int rv = primary.pop();
			return rv;
		} catch (Exception e) {
			throw new Exception("Queue is Empty");
		}

	}

	public int getFront() throws Exception {

		try {
			int rv = primary.peek();
			return rv;

		} catch (Exception e) {
			throw new Exception("Queue is Empty");
		}

	}

	public int size() {
		return primary.size();
	}

	public boolean isEmpty() {
		return this.size() == 0;
	}

	public void display() {
		primary.display();
	}

}
