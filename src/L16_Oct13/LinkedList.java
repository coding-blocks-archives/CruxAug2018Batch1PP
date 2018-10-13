package L16_Oct13;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 13-Oct-2018
 *
 */

public class LinkedList {

	private class Node {
		int data;
		Node next;
	}

	private Node head;
	private Node tail;
	private int size;

	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		return this.size() == 0;
	}

	public void display() {

		System.out.println("----------------------------");

		Node temp = this.head;

		while (temp != null) {

			System.out.print(temp.data + " ");
			temp = temp.next;
		}

		System.out.println(".");
		System.out.println("----------------------------");
	}

	public int getFirst() throws Exception {

		if (this.size() == 0) {
			throw new Exception("LL is Empty");
		}

		return this.head.data;
	}

	public int getLast() throws Exception {

		if (this.size() == 0) {
			throw new Exception("LL is Empty");
		}

		return this.tail.data;
	}

	public int getAt(int k) throws Exception {

		if (this.size() == 0) {
			throw new Exception("LL is Empty");
		}

		if (k < 0 || k >= this.size()) {
			throw new Exception("Invalid Index");
		}

		Node temp = this.head;

		for (int i = 1; i <= k; i++) {
			temp = temp.next;
		}

		return temp.data;

	}

	private Node getNodeAt(int k) throws Exception {

		if (this.size() == 0) {
			throw new Exception("LL is Empty");
		}

		if (k < 0 || k >= this.size()) {
			throw new Exception("Invalid Index");
		}

		Node temp = this.head;

		for (int i = 1; i <= k; i++) {
			temp = temp.next;
		}

		return temp;

	}

	public void addLast(int item) {

		// create a new node
		Node nn = new Node();
		nn.data = item;
		nn.next = null;

		// attach
		if (this.size > 0)
			this.tail.next = nn;

		// data members update
		if (this.size == 0) {
			this.head = nn;
			this.tail = nn;
			this.size++;
		} else {
			this.tail = nn;
			this.size++;
		}

	}

	public void addFirst(int item) {

		// create a new node
		Node nn = new Node();
		nn.data = item;
		nn.next = null;

		// attach
		if (this.size > 0)
			nn.next = this.head;

		// summary update
		if (this.size == 0) {
			this.head = nn;
			this.tail = nn;
			this.size++;
		} else {
			this.head = nn;
			this.size++;
		}

	}

	public void addAt(int item, int k) throws Exception {

		if (k < 0 || k > this.size()) {
			throw new Exception("Invalid Index");
		}

		if (k == 0) {
			addFirst(item);
		} else if (k == this.size()) {
			addLast(item);
		} else {

			// create a new Node
			Node nn = new Node();
			nn.data = item;
			nn.next = null;

			// set the links
			Node prev = getNodeAt(k - 1);
			Node ahead = prev.next;

			prev.next = nn;
			nn.next = ahead;

			this.size++;

		}

	}

	public int removeFirst() throws Exception {

		if (this.size == 0) {
			throw new Exception("LL is Empty.");
		}

		int temp = this.head.data;

		if (this.size == 1) {
			this.head = null;
			this.tail = null;
			this.size = 0;
		} else {
			this.head = this.head.next;
			this.size--;
		}

		return temp;

	}

	public int removeLast() throws Exception {

		if (this.size == 0) {
			throw new Exception("LL is Empty.");
		}

		int temp = this.tail.data;

		if (this.size == 1) {
			this.head = null;
			this.tail = null;
			this.size = 0;
		} else {

			Node sm2 = getNodeAt(this.size - 2);
			sm2.next = null;
			this.tail = sm2;
			this.size--;

		}

		return temp;

	}

	public int removeAt(int k) throws Exception {

		if (this.size == 0) {
			throw new Exception("LL is Empty.");
		}

		if (k < 0 || k >= this.size) {
			throw new Exception("Invalid Index.");
		}

		if (k == 0) {
			return removeFirst();
		} else if (k == this.size - 1) {
			return removeLast();
		} else {

			Node prev = getNodeAt(k - 1);
			Node self = prev.next;
			Node ahead = self.next;

			// link
			prev.next = ahead;
			this.size--;

			return self.data;
		}
	}

	public int mid() {

		Node slow = this.head;
		Node fast = this.head;

		while (fast.next != null && fast.next.next != null) {

			slow = slow.next;
			fast = fast.next.next;
		}

		return slow.data;

	}

}
