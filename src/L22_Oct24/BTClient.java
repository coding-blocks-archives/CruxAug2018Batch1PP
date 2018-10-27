package L22_Oct24;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 24-Oct-2018
 *
 */

public class BTClient {

	// 10 true 20 true 40 false false true 50 false false true 30 false true 60
	// false false

	// diameter
	// 10 true 20 true 30 true 40 true 50 false false false false true 60 false true
	// 70 false true 80 false false true 90 false false
	public static void main(String[] args) {

		int[] pre = { 10, 20, 40, 50, 60, 70, 30, 80 };
		int[] in = { 40, 20, 60, 50, 70, 10, 80, 30 };
		BinaryTree bt = new BinaryTree(pre, in);
		bt.display();

		// System.out.println(bt.size());
		// System.out.println(bt.max());
		// System.out.println(bt.ht());
		// System.out.println(bt.find(500));
		// System.out.println(bt.diameter());
		// System.out.println(bt.diameter2());
		//
		// System.out.println(bt.isBalanced());
		// System.out.println(bt.isBalanced2());

		bt.preorder();
		bt.preOrderI();
		// bt.inorder();
		// bt.postorder();

	}

}
