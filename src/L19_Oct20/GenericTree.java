package L19_Oct20;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 20-Oct-2018
 *
 */

public class GenericTree {

	Scanner scn = new Scanner(System.in);

	private class Node {
		int data;
		ArrayList<Node> children = new ArrayList<>();
	}

	private Node root;

	public GenericTree() {
		this.root = takeInput(null, -1);
	}

	// ith child of parent
	private Node takeInput(Node parent, int ith) {

		if (parent == null) {
			System.out.println("Enter the data for root node");
		} else {
			System.out.println("Enter the data for " + ith + " child of " + parent.data);
		}

		// take data input from user
		int item = scn.nextInt();

		// make a new node
		Node nn = new Node();

		// set the data for node
		nn.data = item;

		// give prompt for no of children
		System.out.println("No of children for " + nn.data + " ?");

		// take input of no of children
		int noc = scn.nextInt();

		// loop on children
		for (int i = 0; i < noc; i++) {

			// recursive call for children
			Node child = takeInput(nn, i);

			// add in children arraylist
			nn.children.add(child);
		}

		// return new node
		return nn;

	}

	public void display() {
		System.out.println("---------------------");
		display(this.root);
		System.out.println("---------------------");
	}

	private void display(Node node) {

		// for (int i = node.children.size() - 1; i >= 0; i--) {
		// display(node.children.get(i));
		// }

		String str = node.data + " -> ";

		for (Node child : node.children) {
			str += child.data + ", ";
		}

		str += ".";
		System.out.println(str);

		for (Node child : node.children) {
			display(child);
		}
	}

	public int size() {
		return size(this.root);
	}

	private int size(Node node) {

		int ts = 0;

		for (Node child : node.children) {
			int cs = size(child);
			ts += cs;
		}

		return ts + 1;
	}

	public int max() {
		return max(this.root);
	}

	private int max(Node node) {

		int tm = node.data;

		for (Node child : node.children) {
			int cm = max(child);
			if (cm > tm) {
				tm = cm;
			}
		}

		return tm;

	}

	public boolean find(int item) {
		return find(this.root, item);
	}

	private boolean find(Node node, int item) {

		if (node.data == item) {
			return true;
		}

		boolean cf = false;
		for (Node child : node.children) {
			cf = find(child, item);

			if (cf)
				return true;
		}

		return cf;

	}

	public int ht() {
		return ht(this.root);
	}

	private int ht(Node node) {

		int th = -1;

		for (Node child : node.children) {

			int ch = ht(child);

			if (ch > th) {
				th = ch;
			}
		}

		return th + 1;

	}

	public void mirror() {
		mirror(this.root);
	}

	private void mirror(Node node) {

		int left = 0;
		int right = node.children.size() - 1;

		while (left < right) {
			Node ln = node.children.get(left);
			Node rn = node.children.get(right);

			node.children.set(left, rn);
			node.children.set(right, ln);

			left++;
			right--;

		}

		for (Node child : node.children) {
			mirror(child);
		}

	}

	public void display1() {
		display1(this.root);
	}

	private void display1(Node node) {

		System.out.println("hii " + node.data);

		for (int i = node.children.size() - 1; i >= 0; i--) {
			display1(node.children.get(i));
		}

		System.out.println("bye " + node.data);

	}

	public void preorder() {
		preorder(this.root);
	}

	// node child
	private void preorder(Node node) {

		System.out.println(node.data);

		for (Node child : node.children) {
			preorder(child);
		}

	}

	public void postorder() {
		postorder(this.root);
	}

	// child node
	private void postorder(Node node) {

		for (Node child : node.children) {
			postorder(child);
		}

		System.out.println(node.data);

	}

	public void levelOrder() {

		LinkedList<Node> queue = new LinkedList<>();
		queue.addLast(this.root);

		while (!queue.isEmpty()) {

			// remove
			Node rn = queue.removeFirst();

			// print
			System.out.print(rn.data + " ");

			// child enqueue
			for (Node child : rn.children) {
				queue.addLast(child);
			}

		}

		System.out.println();
	}

	public void levelOrderLW() {

		LinkedList<Node> queue = new LinkedList<>();
		LinkedList<Node> helper = new LinkedList<>();

		queue.addLast(this.root);

		while (!queue.isEmpty()) {

			// remove
			Node rn = queue.removeFirst();

			// print
			System.out.print(rn.data + " ");

			// child
			for (Node child : rn.children) {
				helper.addLast(child);
			}

			if (queue.isEmpty()) {
				System.out.println();

				queue = helper;
				helper = new LinkedList<>();
			}

		}

	}

	public void printAtLevel(int level) {

		printAtLevel(this.root, level, 0);
		System.out.println();
	}

	private void printAtLevel(Node node, int level, int count) {

		if (level == count) {
			System.out.print(node.data + " ");
		}

		for (Node child : node.children) {
			printAtLevel(child, level, count + 1);
		}

	}

	private class HeapMover {

		int size;
		boolean find;
		int max = Integer.MIN_VALUE;
		int ht;

		Node pred;
		Node succ;
		Node jl;

	}

	public void multiSolver(int item) {

		HeapMover mover = new HeapMover();

		multiSolver(this.root, item, 0, mover);

		System.out.println("Max : " + mover.max);
		System.out.println("Find : " + mover.find);
		System.out.println("Ht : " + mover.ht);
		System.out.println("Size : " + mover.size);

		System.out.println("Pred : " + (mover.pred != null && mover.find == true ? mover.pred.data : null));
		System.out.println("Succ : " + (mover.succ == null ? null : mover.succ.data));
		System.out.println("JL : " + (mover.jl == null ? null : mover.jl.data));
	}

	private void multiSolver(Node node, int item, int count, HeapMover mover) {

		mover.size++;

		if (mover.find == true && mover.succ == null) {
			mover.succ = node;
		}

		if (node.data == item) {
			mover.find = true;
		}

		if (mover.find == false) {
			mover.pred = node;
		}

		if (node.data > mover.max) {
			mover.max = node.data;
		}

		if (count > mover.ht) {
			mover.ht = count;
		}

		if (node.data > item) {

			if (mover.jl == null || node.data < mover.jl.data) {
				mover.jl = node;

			}
		}

		for (Node child : node.children) {
			multiSolver(child, item, count + 1, mover);
		}

	}

}
