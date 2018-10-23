package L21_Oct23.Adapters;

import L15_Oct7.DynamicQueue;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 23-Oct-2018
 *
 */

public class StackUQueuePopEff {

	DynamicQueue primary = new DynamicQueue();

	public void push(int item) throws Exception {

		try {

			DynamicQueue helper = new DynamicQueue();
			helper.enqueue(item);

			while (primary.size() != 0) {
				int element = primary.dequeue();
				helper.enqueue(element);
			}

			primary = helper;

		} catch (Exception e) {
			throw new Exception("Stack is Full");
		}
	}

	public int pop() throws Exception {

		try {

			int rv = primary.dequeue();
			return rv;

		} catch (Exception e) {
			throw new Exception("Stack is Empty.");
		}
	}

	public int top() throws Exception {

		try {

			int rv = primary.getFront();
			return rv;

		} catch (Exception e) {
			throw new Exception("Stack is Empty.");
		}

	}

	public int size() {
		return primary.size();
	}

	public boolean isEmpty() {
		return size() == 0;
	}

	public void display() {
		primary.display();
	}
}
