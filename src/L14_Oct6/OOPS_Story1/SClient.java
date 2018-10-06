package L14_Oct6.OOPS_Story1;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 06-Oct-2018
 *
 */

public class SClient {

	public static void main(String[] args) {

		Student s = new Student();

		// get
		System.out.println(s.name);
		System.out.println(s.age);

		// set
		s.name = "Rohit";
		s.age = 20;

		// get
		System.out.println(s.name);
		System.out.println(s.age);

		Student s1 = s;
		System.out.println(s1.age);

		s1.age = 50;
		System.out.println(s1.age);
		System.out.println(s.age);

		Student s3 = new Student();
		s3.age = 10;
		s3.name = "A";

		Student s4 = new Student();
		s4.age = 20;
		s4.name = "B";

		System.out.println("\n-- Test 1 --");
		Test1(s3, s4);
		System.out.println(s3.age + " " + s3.name);
		System.out.println(s4.age + " " + s4.name);

		System.out.println("\n-- Test 2 --");
		// Test2(s4, s3);
		System.out.println(s3.age + " " + s3.name);
		System.out.println(s4.age + " " + s4.name);

		System.out.println("\n-- Test 3 --");
		int myAge = 30;
		String myName = "C";

		Test3(s3, s4.age, s4.name, myAge, myName);
		System.out.println(s3.age + " " + s3.name);
		System.out.println(s4.age + " " + s4.name);
		System.out.println(myAge + " " + myName);

		Student s5 = new Student();
		s5.name = "Amit";
		s5.age = 50;

		Student s6 = new Student();
		s6.name = "Ashish";
		s6.age = 100;

		s5.introduceYourself();
		s6.introduceYourself();

		s5.sayHi("Naman");

		Student s7 = new Student("Kuldeep", 20);
		s7.introduceYourself();

	}

	public static void Test3(Student p, int age, String name, int myAge, String myName) {
		p.age = 0;
		p.name = "_";
		age = 0;
		name = "_";
		myAge = 0;
		myName = "_";
	}

	public static void Test2(Student s1, Student s2) {

		// s1 = new Student();
		int tempa = s1.age;
		s1.age = s2.age;
		s2.age = tempa;

		// s2 = new Student();
		String tempn = s1.name;
		s1.name = s2.name;
		s2.name = tempn;
	}

	public static void Test1(Student s1, Student s2) {
		Student temp = s1;
		s1 = s2;
		s2 = temp;
	}
}
