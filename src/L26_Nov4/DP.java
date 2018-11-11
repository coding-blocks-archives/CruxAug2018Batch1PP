package L26_Nov4;

import java.util.Arrays;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 04-Nov-2018
 *
 */

public class DP {

	public static void main(String[] args) {

		long start = System.currentTimeMillis();

		int n = 200;
		// System.out.println(fibTD(n, new int[n + 1]));
		// System.out.println(fibI(n));
		// System.out.println(fibISE(n));

		// System.out.println(boardPathBU(0, n, new int[n + 1]));
		// System.out.println(boardPathI(n));
		// System.out.println(boardPathISE(n));

		// System.out.println(mazePathTD(0, 0, n, n, new int[n + 1][n + 1]));
		// System.out.println(mazePathI(n, n));
		// System.out.println(mazePathISE(n, n));

		// System.out.println(LCSBU("abcdvghjdfgvhjdgfeyur",
		// "agcfdcdvghchdgcyeugfyeug"));
		// System.out.println(EditDistanceBU("saturday", "sunday"));

		// int[] arr = new int[n];
		// for (int i = 0; i < n; i++) {
		// arr[i] = i + 1;
		// }

		// int[] arr = { 2, 3, 5, 1, 4 };
		// System.out.println(WineProblem(arr, 0, arr.length - 1, 1));
		// System.out.println(WineProblem2(arr, 0, arr.length - 1));
		// System.out.println(WineProblemTD(arr, 0, arr.length - 1, new
		// int[arr.length][arr.length]));
		// System.out.println(WineProblemBU(arr));

		// int[] arr = { 2, 3, 4, 5, 6 };
		// System.out.println(MCM(arr, 0, arr.length - 1));
		// System.out.println(MCMTD(arr, 0, arr.length - 1, new
		// int[arr.length][arr.length]));
		// System.out.println(MCMBU(arr));

		int[] wt = { 1, 3, 4, 5 };
		int[] prices = { 1, 4, 5, 7 };
		int cap = 70;

		// System.out.println(KnapsackTD(wt, prices, 0, cap, new int[wt.length][cap +
		// 1]));
		// System.out.println(KnapsackBU(wt, prices, cap));

		int[] arr = { 40, 60, 20 };
		System.out.println(Mixtures(arr, 0, arr.length - 1, new int[arr.length][arr.length]));
		System.out.println(MixturesBU(arr));

		long end = System.currentTimeMillis();

		System.out.println("Time : " + (end - start));

	}

	public static int fibTD(int n, int[] strg) {

		if (n == 0 || n == 1) {
			return n;
		}

		if (strg[n] != 0) {
			return strg[n];
		}

		int fnm1 = fibTD(n - 1, strg);
		int fnm2 = fibTD(n - 2, strg);

		int fn = fnm1 + fnm2;

		// store in array
		strg[n] = fn;

		return fn;
	}

	public static int fibI(int n) {

		int[] strg = new int[n + 1];

		strg[0] = 0;
		strg[1] = 1;

		for (int i = 2; i <= n; i++) {
			strg[i] = strg[i - 1] + strg[i - 2];
		}

		return strg[n];
	}

	public static int fibISE(int n) {

		int[] strg = new int[2];

		strg[0] = 0;
		strg[1] = 1;

		for (int i = 1; i <= n - 1; i++) {
			int sum = strg[0] + strg[1];
			strg[0] = strg[1];
			strg[1] = sum;

		}

		return strg[1];

	}

	public static int boardPathTD(int curr, int end, int[] strg) {

		if (curr == end) {
			return 1;
		}

		if (curr > end) {
			return 0;
		}

		if (strg[curr] != 0) {
			return strg[curr];
		}

		int count = 0;

		for (int dice = 1; dice <= 6; dice++) {
			count += boardPathTD(curr + dice, end, strg);
		}

		strg[curr] = count;

		return count;
	}

	public static int boardPathI(int n) {

		int[] strg = new int[n + 6];
		strg[n] = 1;

		for (int i = n - 1; i >= 0; i--) {
			strg[i] = strg[i + 1] + strg[i + 2] + strg[i + 3] + strg[i + 4] + strg[i + 5] + strg[i + 6];
		}

		return strg[0];

	}

	public static int boardPathISE(int n) {

		int[] strg = new int[6];
		strg[0] = 1;

		for (int i = 1; i <= n; i++) {

			int sum = strg[0] + strg[1] + strg[2] + strg[3] + strg[4] + strg[5];

			strg[5] = strg[4];
			strg[4] = strg[3];
			strg[3] = strg[2];
			strg[2] = strg[1];
			strg[1] = strg[0];

			strg[0] = sum;

		}

		return strg[0];

	}

	public static int mazePathTD(int cr, int cc, int er, int ec, int[][] strg) {

		if (cr == er && cc == ec) {
			return 1;
		}

		if (cr > er || cc > ec) {
			return 0;
		}

		if (strg[cr][cc] != 0) {
			return strg[cr][cc];
		}

		int ch = mazePathTD(cr, cc + 1, er, ec, strg); // horizonatal
		int cv = mazePathTD(cr + 1, cc, er, ec, strg); // vertical

		strg[cr][cc] = ch + cv;
		return ch + cv;

	}

	public static int mazePathI(int er, int ec) {

		int[][] strg = new int[er + 2][ec + 2];

		for (int row = er; row >= 0; row--) {

			for (int col = ec; col >= 0; col--) {

				if (row == er && col == ec) {
					strg[row][col] = 1;
				} else {
					strg[row][col] = strg[row + 1][col] + strg[row][col + 1];
				}
			}
		}

		return strg[0][0];

	}

	public static int mazePathISE(int er, int ec) {

		int[] strg = new int[ec + 1];
		Arrays.fill(strg, 1);

		for (int slide = er - 1; slide >= 0; slide--) {

			for (int col = strg.length - 2; col >= 0; col--) {
				strg[col] = strg[col] + strg[col + 1];
			}
		}

		return strg[0];

	}

	public static int LCS(String s1, String s2) {

		if (s1.length() == 0 || s2.length() == 0) {
			return 0;
		}

		char ch1 = s1.charAt(0);
		char ch2 = s2.charAt(0);

		String ros1 = s1.substring(1);
		String ros2 = s2.substring(1);

		int ans = 0;

		if (ch1 == ch2) {
			ans = LCS(ros1, ros2) + 1;
		} else {
			ans = Math.max(LCS(ros1, s2), LCS(s1, ros2));
		}

		return ans;
	}

	public static int LCSBU(String s1, String s2) {

		int[][] strg = new int[s1.length() + 1][s2.length() + 1];

		for (int row = s1.length() - 1; row >= 0; row--) {

			for (int col = s2.length() - 1; col >= 0; col--) {

				if (s1.charAt(row) == s2.charAt(col)) {
					strg[row][col] = strg[row + 1][col + 1] + 1;
				} else {
					strg[row][col] = Math.max(strg[row][col + 1], strg[row + 1][col]);
				}
			}
		}

		return strg[0][0];

	}

	public static int EditDistance(String s1, String s2) {

		if (s1.length() == 0 || s2.length() == 0) {
			return Math.max(s1.length(), s2.length());
		}

		char ch1 = s1.charAt(0);
		char ch2 = s2.charAt(0);

		String ros1 = s1.substring(1);
		String ros2 = s2.substring(1);

		int ans = 0;

		if (ch1 == ch2) {
			ans = EditDistance(ros1, ros2);
		} else {

			int insert = EditDistance(ros1, s2);
			int delete = EditDistance(s1, ros2);
			int replace = EditDistance(ros1, ros2);

			ans = Math.min(replace, Math.min(insert, delete)) + 1;
		}

		return ans;
	}

	public static int EditDistanceBU(String s1, String s2) {

		int[][] strg = new int[s1.length() + 1][s2.length() + 1];

		for (int row = s1.length(); row >= 0; row--) {

			for (int col = s2.length(); col >= 0; col--) {

				if (row == s1.length()) {
					strg[row][col] = s2.length() - col;
					continue;
				}

				if (col == s2.length()) {
					strg[row][col] = s1.length() - row;
					continue;
				}

				if (s1.charAt(row) == s2.charAt(col)) {
					strg[row][col] = strg[row + 1][col + 1];
				} else {
					int insert = strg[row + 1][col];
					int delete = strg[row][col + 1];
					int replace = strg[row + 1][col + 1];

					strg[row][col] = Math.min(replace, Math.min(insert, delete)) + 1;
				}
			}
		}

		return strg[0][0];

	}

	public static int WineProblem(int[] prices, int si, int ei, int yr) {

		if (si > ei) {
			return 0;
		}

		int sc = WineProblem(prices, si + 1, ei, yr + 1) + (prices[si] * yr);
		int ec = WineProblem(prices, si, ei - 1, yr + 1) + (prices[ei] * yr);

		return Math.max(sc, ec);
	}

	public static int WineProblem2(int[] prices, int si, int ei) {

		if (si > ei) {
			return 0;
		}

		int yr = prices.length - (ei - si);

		int sc = WineProblem2(prices, si + 1, ei) + (prices[si] * yr);
		int ec = WineProblem2(prices, si, ei - 1) + (prices[ei] * yr);

		return Math.max(sc, ec);
	}

	public static int WineProblemTD(int[] prices, int si, int ei, int[][] strg) {

		int yr = prices.length - (ei - si);

		if (si == ei) {
			return prices[si] * yr;
		}

		if (strg[si][ei] != 0) {
			return strg[si][ei];
		}

		int sc = WineProblemTD(prices, si + 1, ei, strg) + (prices[si] * yr);
		int ec = WineProblemTD(prices, si, ei - 1, strg) + (prices[ei] * yr);

		int ans = Math.max(sc, ec);

		strg[si][ei] = ans;

		return ans;
	}

	public static int WineProblemBU(int[] prices) {

		int n = prices.length;

		int[][] strg = new int[n][n];

		for (int slide = 0; slide <= n - 1; slide++) {

			for (int si = 0; si <= n - slide - 1; si++) {

				int ei = si + slide;

				int yr = n - (ei - si);

				if (si == ei) {
					strg[si][ei] = prices[si] * yr;
				} else {
					int sc = strg[si + 1][ei] + (prices[si] * yr);
					int ec = strg[si][ei - 1] + (prices[ei] * yr);

					strg[si][ei] = Math.max(sc, ec);
				}

			}

		}

		return strg[0][n - 1];

	}

	public static int MCM(int[] arr, int si, int ei) {

		if (si + 1 == ei) {
			return 0;
		}

		int min = Integer.MAX_VALUE;

		for (int k = si + 1; k <= ei - 1; k++) {

			int fc = MCM(arr, si, k);
			int sc = MCM(arr, k, ei);

			int sw = arr[si] * arr[k] * arr[ei];

			int total = fc + sc + sw;

			if (total < min) {
				min = total;
			}
		}

		return min;
	}

	public static int MCMTD(int[] arr, int si, int ei, int[][] strg) {

		if (si + 1 == ei) {
			return 0;
		}

		if (strg[si][ei] != 0) {
			return strg[si][ei];
		}

		int min = Integer.MAX_VALUE;

		for (int k = si + 1; k <= ei - 1; k++) {

			int fc = MCMTD(arr, si, k, strg);
			int sc = MCMTD(arr, k, ei, strg);

			int sw = arr[si] * arr[k] * arr[ei];

			int total = fc + sc + sw;

			if (total < min) {
				min = total;
			}
		}

		strg[si][ei] = min;

		return min;
	}

	public static int MCMBU(int[] arr) {

		int n = arr.length;

		int[][] strg = new int[arr.length][arr.length];

		for (int slide = 1; slide <= n - 2; slide++) {

			for (int si = 0; si <= n - slide - 2; si++) {

				int ei = si + slide + 1;

				int min = Integer.MAX_VALUE;

				for (int k = si + 1; k <= ei - 1; k++) {

					int fc = strg[si][k];
					int sc = strg[k][ei];

					int sw = arr[si] * arr[k] * arr[ei];

					int total = fc + sc + sw;

					if (total < min) {
						min = total;
					}
				}

				strg[si][ei] = min;

			}
		}

		return strg[0][n - 1];

	}

	public static int KnapsackTD(int[] wt, int[] prices, int vidx, int cap, int[][] strg) {

		if (vidx == wt.length) {
			return 0;
		}

		if (strg[vidx][cap] != 0) {
			return strg[vidx][cap];
		}

		int include = 0;

		if (cap >= wt[vidx]) {
			include = KnapsackTD(wt, prices, vidx + 1, cap - wt[vidx], strg) + prices[vidx];
		}

		int exclude = KnapsackTD(wt, prices, vidx + 1, cap, strg);

		int ans = Math.max(include, exclude);

		strg[vidx][cap] = ans;

		return ans;

	}

	public static int KnapsackBU(int[] wt, int[] prices, int cap) {

		int nr = wt.length + 1;
		int nc = cap + 1;

		int[][] strg = new int[nr][nc];

		for (int row = 0; row < nr; row++) {

			for (int col = 0; col < nc; col++) {

				if (row == 0 || col == 0) {
					strg[row][col] = 0;
				} else {

					int include = 0;
					if (col >= wt[row - 1]) {
						include = prices[row - 1] + strg[row - 1][col - wt[row - 1]];
					}

					int exclude = strg[row - 1][col];

					int ans = Math.max(include, exclude);

					strg[row][col] = ans;

				}

			}
		}

		return strg[nr - 1][nc - 1];

	}

	public static int color(int[] arr, int si, int ei) {
		int sum = 0;

		for (int i = si; i <= ei; i++) {
			sum += arr[i];
		}

		return sum % 100;
	}

	public static int Mixtures(int[] arr, int si, int ei, int[][] strg) {

		if (si >= ei) {
			return 0;
		}

		if (strg[si][ei] != 0) {
			return strg[si][ei];
		}

		int min = Integer.MAX_VALUE;

		for (int k = si; k <= ei - 1; k++) {

			int fc = Mixtures(arr, si, k, strg);
			int sc = Mixtures(arr, k + 1, ei, strg);

			int sw = color(arr, si, k) * color(arr, k + 1, ei);

			int ta = fc + sc + sw;

			if (ta < min) {
				min = ta;
			}

		}

		strg[si][ei] = min;

		return min;

	}

	public static int MixturesBU(int[] arr) {

		int n = arr.length;
		int[][] strg = new int[n][n];

		for (int slide = 1; slide <= n - 1; slide++) {

			for (int si = 0; si <= n - slide - 1; si++) {

				int ei = si + slide;

				int min = Integer.MAX_VALUE;

				for (int k = si; k <= ei - 1; k++) {

					int fc = strg[si][k];
					int sc = strg[k + 1][ei];

					int sw = color(arr, si, k) * color(arr, k + 1, ei);

					int ta = fc + sc + sw;

					if (ta < min) {
						min = ta;
					}

				}

				strg[si][ei] = min;

			}

		}

		return strg[0][n - 1];

	}

}
