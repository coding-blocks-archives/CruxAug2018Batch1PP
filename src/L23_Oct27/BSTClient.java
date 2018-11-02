package L23_Oct27;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 27-Oct-2018
 *
 */

public class BSTClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] in = { 5, 10, 15, 20, 25, 30, 35 };

		BST bst = new BST(in);
		bst.display();

		// bst.printInRange(7, 32);
		// bst.replaceWithSumLarger();
		bst.display();
		bst.add(24);
		bst.add(25);
		// bst.add(26);

		bst.display();
		bst.remove(20);
		bst.display();

	}

}
