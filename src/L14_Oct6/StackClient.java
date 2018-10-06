package L14_Oct6;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 06-Oct-2018
 *
 */

public class StackClient {

	public static void main(String[] args) throws Exception {

		Stack s = new Stack();
		s.push(10);
		s.push(20);
		s.push(30);
		s.display();
		System.out.println(s.peek());
		s.push(40);
		s.display();
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());
		s.display();
		System.out.println(s.pop());

	}

}
