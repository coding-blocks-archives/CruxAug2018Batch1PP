package L19_Oct20.OOPS_Story3;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 20-Oct-2018
 *
 */

public class Student {

	String name;
	int age;
	int rollNo;
	static int noOfStudents;

	public Student(String name, int age) {

		noOfStudents++;
		this.rollNo = noOfStudents;
		this.name = name;
		this.age = age;

	}

	public void introduceYourself() {

		System.out.println(this.name + " roll No is " + this.rollNo);
	}

	// cannot access this, non static variables
	// can access static variables
	public static int totalStudents() {
		return noOfStudents;
	}

	// can access this, non static variables
	// can access static variables
	public int getRollNo() {
		return noOfStudents;
	}
}
