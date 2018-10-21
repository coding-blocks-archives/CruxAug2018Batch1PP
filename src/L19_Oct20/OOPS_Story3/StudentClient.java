package L19_Oct20.OOPS_Story3;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 20-Oct-2018
 *
 */

public class StudentClient {

	static int a = 10;

	public static void main(String[] args) {

		Student s1 = new Student("A", 10);
		Student s2 = new Student("B", 20);
		Student s3 = new Student("C", 30);

		System.out.println(s1.rollNo);
		System.out.println(s2.rollNo);
		System.out.println(s3.rollNo);

		s1.introduceYourself();

		System.out.println(Student.noOfStudents);

		System.out.println(s1.noOfStudents);
		System.out.println(a);

	}

}
