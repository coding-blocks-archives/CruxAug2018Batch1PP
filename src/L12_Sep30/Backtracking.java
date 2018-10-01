package L12_Sep30;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 30-Sep-2018
 *
 */

public class Backtracking {

	public static void main(String[] args) {

		System.out.println(NQueens(new boolean[4][4], 0, ""));
	}

	public static int NQueens(boolean[][] board, int row, String ans) {

		if (row == board.length) {
			System.out.println(ans);
			return 1;
		}

		int count = 0;

		for (int col = 0; col < board[0].length; col++) {
			if (isItSafeToPlaceQueen(board, row, col)) {
				board[row][col] = true;
				count += NQueens(board, row + 1, ans + "(" + row + "-" + col + ")");
				board[row][col] = false;
			}
		}

		return count;
	}

	public static boolean isItSafeToPlaceQueen(boolean[][] board, int row, int col) {

		int r = row - 1;
		int c = col;

		// vertically up
		while (r >= 0) {
			if (board[r][c]) {
				return false;
			}
			r--;
		}

		// diagonally left
		r = row - 1;
		c = col - 1;

		while (r >= 0 && c >= 0) {

			if (board[r][c]) {
				return false;
			}
			r--;
			c--;

		}

		// diagonally right
		r = row - 1;
		c = col + 1;

		while (r >= 0 && c < board[0].length) {

			if (board[r][c]) {
				return false;
			}
			r--;
			c++;

		}

		return true;

	}

}
