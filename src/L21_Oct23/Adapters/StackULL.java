package L21_Oct23.Adapters;

import L16_Oct13.LinkedList;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 23-Oct-2018
 *
 */

public class StackULL {

	LinkedList list = new LinkedList();

	public void push(int item) {
		list.addFirst(item);
	}

	public int pop() throws Exception {

		try {
			return list.removeFirst();
		} catch (Exception e) {
			throw new Exception("Stack is Empty.");
		}
	}

	public int top() throws Exception {

		try {
			return list.getFirst();
		} catch (Exception e) {
			throw new Exception("Stack is Empty.");
		}

	}

	public int size() {
		return list.size();
	}

	public boolean isEmpty() {
		return size() == 0;
	}

	public void display() {

		try {
			list.display();
		} catch (Exception e) {

		}
	}

}
