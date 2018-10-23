package L21_Oct23;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 23-Oct-2018
 *
 */

public class Student {

	private int age = 0;

	public void setAge(int age) throws Exception {

		if (age < 0) {
			throw new Exception("Invalid Age.");
		}

		this.age = age;
	}
}
