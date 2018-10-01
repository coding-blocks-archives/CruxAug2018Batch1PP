package L11_Sep29;

import L9_Sep16.RecursionGet;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 29-Sep-2018
 *
 */

public class RecursionPrint {

	public static void main(String[] args) {

		// printSS("abc", "");
		// printSSAscii("abc", "");
		// printKPC("145", "");
		// printCoinToss(3, "");

		// printPermutation("abc", "");
		// printPermutation2("abc", "");
		// System.out.println(boardPath(0, 10, ""));
		// System.out.println(mazePath(0, 0, 2, 2, ""));

		lexicoCounting(2, 1000);
	}

	public static void printSS(String ques, String ans) {

		if (ques.length() == 0) {
			System.out.println(ans);
			return;
		}

		char ch = ques.charAt(0);
		String roq = ques.substring(1);

		printSS(roq, ans); // no
		printSS(roq, ans + ch); // yes

	}

	public static void printSSAscii(String ques, String ans) {

		if (ques.length() == 0) {
			System.out.println(ans);
			return;
		}

		char ch = ques.charAt(0);
		String roq = ques.substring(1);

		printSSAscii(roq, ans); // no
		printSSAscii(roq, ans + ch); // yes
		printSSAscii(roq, ans + (int) ch); // ascii
	}

	public static void printKPC(String ques, String ans) {

		if (ques.length() == 0) {
			System.out.println(ans);
			return;
		}

		char ch = ques.charAt(0); // 1
		String code = RecursionGet.getCode(ch); // abc

		String roq = ques.substring(1); // 45

		for (int i = 0; i < code.length(); i++) {
			printKPC(roq, ans + code.charAt(i));
		}

	}

	public static void printCoinToss(int n, String ans) {

		if (n == 0) {
			System.out.println(ans);
			return;
		}

		printCoinToss(n - 1, ans + "H");
		printCoinToss(n - 1, ans + "T");

	}

	public static void printPermutation(String ques, String ans) {

		if (ques.length() == 0) {
			System.out.println(ans);
			return;
		}

		for (int i = 0; i < ques.length(); i++) {
			char ch = ques.charAt(i);
			String roq = ques.substring(0, i) + ques.substring(i + 1);
			printPermutation(roq, ans + ch);
		}

	}

	public static void printPermutation2(String ques, String ans) {

		if (ques.length() == 0) {
			System.out.println(ans);
			return;
		}

		char ch = ques.charAt(0);
		String roq = ques.substring(1);

		for (int i = 0; i <= ans.length(); i++) {

			String na = ans.substring(0, i) + ch + ans.substring(i);
			printPermutation2(roq, na);
		}

	}

	public static int boardPath(int curr, int end, String ans) {

		if (curr == end) {
			System.out.println(ans);
			return 1;
		}

		if (curr > end) {
			return 0;
		}

		int count = 0;

		for (int dice = 1; dice <= 6; dice++) {
			count += boardPath(curr + dice, end, ans + dice);
		}

		return count;
	}

	public static int mazePath(int cr, int cc, int er, int ec, String ans) {

		if (cr == er && cc == ec) {
			System.out.println(ans);
			return 1;
		}

		if (cr > er || cc > ec) {
			return 0;
		}

		int ch = mazePath(cr, cc + 1, er, ec, ans + "H"); // horizonatal
		int cv = mazePath(cr + 1, cc, er, ec, ans + "V"); // vertical

		return ch + cv;

	}

	public static void lexicoCounting(int curr, int end) {

		if (curr > end) {
			return;
		}

		System.out.println(curr);

		int i = 0;

		if (curr == 0) {
			i = 1;
		}

		for (; i <= 9; i++) {
			lexicoCounting(curr * 10 + i, end);
		}

	}

	public static void lexicoCounting2(int curr, int end) {

		if (curr > end) {
			return;
		}

		System.out.println(curr);

		for (int i = 0; i <= 9; i++) {
			lexicoCounting2(curr * 10 + i, end);
		}

		if (curr + 1 <= 9)
			lexicoCounting2(curr + 1, end);
	}

}
