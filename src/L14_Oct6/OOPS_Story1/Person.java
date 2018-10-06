package L14_Oct6.OOPS_Story1;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 06-Oct-2018
 *
 */

public class Person {

	private String name;
	private int age;

	public void setAge(int age) throws Exception  {

		if (age < 0) {
			throw new Exception("Invalid Age");
		}

		this.age = age;
	}

	public int getAge() {
		return this.age;
	}
}
