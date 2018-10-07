package L15_Oct7;

import L14_Oct6.Stack;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 07-Oct-2018
 *
 */

public class DSClient {

	public static void main(String[] args) throws Exception {

		Stack s = new DynamicStack();
		s.push(10);
		s.push(20);
		s.push(30);
		s.push(40);
		s.push(50);
		s.push(60);
		s.push(70);

		s.display();

	}

}
