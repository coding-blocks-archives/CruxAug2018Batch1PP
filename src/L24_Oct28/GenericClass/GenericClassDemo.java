package L24_Oct28.GenericClass;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 28-Oct-2018
 *
 */

public class GenericClassDemo {

	public static void main(String[] args) {

		Pair<Pair<String, Integer>, Double> p = new Pair<>();
		p.one = new Pair<>();
		System.out.println(p.one.one);

		LinkedListGeneric<String> list = new LinkedListGeneric<>();
		list.addFirst("abc");
		list.addFirst("def");
		list.addFirst("ghi");

		list.display();

	}

}
