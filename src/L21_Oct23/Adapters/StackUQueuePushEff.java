package L21_Oct23.Adapters;

import L15_Oct7.DynamicQueue;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 23-Oct-2018
 *
 */

public class StackUQueuePushEff {

	DynamicQueue primary = new DynamicQueue();

	public void push(int item) throws Exception {

		try {
			primary.enqueue(item);
		} catch (Exception e) {
			throw new Exception("Stack is Full");
		}
	}

	public int pop() throws Exception {

		try {
			DynamicQueue helper = new DynamicQueue();

			while (primary.size() != 1) {
				int element = primary.dequeue();
				helper.enqueue(element);
			}

			int rv = primary.dequeue();
			primary = helper;

			return rv;

		} catch (Exception e) {
			throw new Exception("Stack is Empty.");
		}
	}

	public int top() throws Exception {

		try {
			DynamicQueue helper = new DynamicQueue();

			while (primary.size() != 1) {
				int element = primary.dequeue();
				helper.enqueue(element);
			}

			int rv = primary.dequeue();
			helper.enqueue(rv);
			primary = helper;

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

		System.out.println("-------------------");
		try {
			display(0);
		} catch (Exception e) {
			// throw new Exception("Error in Display");
		}
		System.out.println("-------------------");
	}

	private void display(int count) throws Exception {

		if (count == primary.size()) {
			return;
		}

		int temp = primary.dequeue();
		primary.enqueue(temp);

		display(count + 1);

		System.out.println(temp);

	}

}
