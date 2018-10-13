package L16_Oct13;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 13-Oct-2018
 *
 */

public class LLClient {

	public static void main(String[] args) throws Exception {

		LinkedList list = new LinkedList();

		list.addLast(10);
		list.addLast(20);
		list.addLast(30);

		list.display();

		System.out.println(list.getFirst());
		System.out.println(list.getLast());
		System.out.println(list.getAt(1));

		list.addFirst(40);
		list.addFirst(50);

		list.display();

		System.out.println(list.getFirst());

		list.addAt(60, 3);
		list.addAt(80, list.size());

		list.display();

		System.out.println(list.removeFirst());
		System.out.println(list.removeLast());
		list.display();

//		list.removeAt(list.size() - 1);
		list.display();

		System.out.println(list.mid());

	}

}
