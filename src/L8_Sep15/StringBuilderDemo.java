package L8_Sep15;

import java.util.Scanner;

/**
 * @author Garima Chhikara
 * @date Sep 15, 2018
 */

public class StringBuilderDemo {

	public static void main(String[] args) {

		long start = System.currentTimeMillis();
		appendString();
		long end = System.currentTimeMillis();

		System.out.println(end - start);

		Scanner scn = new Scanner(System.in);
		
		// convert string to sb
		String str = scn.next();
		StringBuilder sb = new StringBuilder(str);
		System.out.println(sb.length());

		sb.append('a'); // constant
		System.out.println(sb);

		sb.append("bcd");
		System.out.println(sb);

		sb.insert(3, 'u'); // n
		System.out.println(sb);

		sb.setCharAt(2, 'z'); // constant
		System.out.println(sb);

		sb.deleteCharAt(2); // n
		System.out.println(sb);

		String ans = sb.toString();

	}

	public static void appendString() {

		// String ans = "";
		StringBuilder sb = new StringBuilder();

		for (int i = 1; i <= 100000; i++) {
			// ans = ans + i;
			sb.append(i);
		}

	}

}
