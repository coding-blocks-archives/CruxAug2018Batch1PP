package L21_Oct23;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 23-Oct-2018
 *
 */

public class TryCatchDemo {

	public static void main(String[] args) throws Exception {

		System.out.println("hi");

		try {
			Student s = new Student();
			s.setAge(-10);
			System.out.println("after");

		} catch (Exception e) {
			// e.printStackTrace();
			System.out.println("in catch");
		}

		// System.out.println("bye");

	}

}
