package L21_Oct23.Adapters;

import L15_Oct7.DynamicStack;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 23-Oct-2018
 *
 */

public class QueueUsingStackEnqEff {

	DynamicStack primary = new DynamicStack();

	public void enqueue(int item) throws Exception {

		try {
			primary.push(item);

		} catch (Exception e) {
			throw new Exception("Queue is Full");
		}
	}

	public int dequeue() throws Exception {

		try {
			DynamicStack helper = new DynamicStack();

			while (primary.size() != 1) {
				int element = primary.pop();
				helper.push(element);
			}

			int rv = primary.pop();

			// place all elements in original stack
			while (helper.size() != 0) {
				int element = helper.pop();
				primary.push(element);
			}

			return rv;

		} catch (Exception e) {
			throw new Exception("Queue is Empty");
		}

	}

	public int getFront() throws Exception {

		try {
			DynamicStack helper = new DynamicStack();

			while (primary.size() != 1) {
				int element = primary.pop();
				helper.push(element);
			}

			int rv = primary.pop();
			helper.push(rv);

			// place all elements in original stack
			while (helper.size() != 0) {
				int element = helper.pop();
				primary.push(element);
			}

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
		System.out.println("-------------------");
		try {
			displayH();
		} catch (Exception e) {

		}
		System.out.println("-------------------");
	}

	private void displayH() throws Exception {

		if (primary.isEmpty()) {
			return;
		}

		int temp = primary.pop();
		displayH();
		System.out.println(temp);
		primary.push(temp);

	}

}
