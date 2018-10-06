package L14_Oct6.OOPS_Story1;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 06-Oct-2018
 *
 */

public class Student {

	// data members
	String name = "abc";
	int age = 200;

	// default constructor
	public Student() {

	}

	// paramterized constructor
	public Student(String name, int age) {
		this.name = name;
		this.age = age;
	}

	// fxn
	public void introduceYourself() {
		System.out.println(name + " is " + age + " years old.");
	}

	public void sayHi(String name) {
		System.out.println(this.name + " says hi to " + name);
	}

}
