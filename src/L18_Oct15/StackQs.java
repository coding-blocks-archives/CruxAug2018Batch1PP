package L18_Oct15;

import L14_Oct6.Stack;
import L15_Oct7.DynamicStack;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 15-Oct-2018
 *
 */

public class StackQs {

	public static void main(String[] args) throws Exception {

		Stack s = new DynamicStack();
		s.push(10);
		s.push(20);
		s.push(30);
		s.push(40);
		s.push(50);

		s.display();
		displayReverse(s);
		s.display();

		actualReverse(s, new DynamicStack());

		s.display();

		int[] arr = { 10, 20, 3, 2, 5, 1, 70, 60 };
		nextGreaterElement(arr);

		int[] price = { 15, 20, 17, 30, 25, 13, 27, 14, 20, 35 };

		int[] span = stockSpan(price);
		for (int val : span) {
			System.out.print(val + "  ");
		}
		System.out.println();
	}

	public static void displayReverse(Stack s) throws Exception {

		if (s.isEmpty()) {
			return;
		}

		int temp = s.pop();
		displayReverse(s);

		System.out.println(temp);

		s.push(temp);

	}

	public static void actualReverse(Stack s, Stack helper) throws Exception {

		if (s.isEmpty()) {
			actualReverseHelper(s, helper);

			return;
		}

		int temp = s.pop();
		helper.push(temp);

		actualReverse(s, helper);

	}

	private static void actualReverseHelper(Stack s, Stack helper) throws Exception {

		if (helper.isEmpty()) {
			return;
		}

		int temp = helper.pop();
		actualReverseHelper(s, helper);
		s.push(temp);

	}

	public static void nextGreaterElement(int[] arr) throws Exception {

		Stack s = new DynamicStack();

		for (int i = 0; i < arr.length; i++) {

			while (!s.isEmpty() && s.peek() < arr[i]) {

				int temp = s.pop();
				System.out.println(temp + " -> " + arr[i]);

			}

			s.push(arr[i]);

		}

		while (!s.isEmpty()) {

			int temp = s.pop();
			System.out.println(temp + "-> -1");

		}

	}

	public static int[] stockSpan(int[] prices) throws Exception {

		int[] span = new int[prices.length];

		Stack s = new DynamicStack();

		for (int i = 0; i < prices.length; i++) {

			while (!s.isEmpty() && prices[s.peek()] < prices[i]) {
				s.pop();
			}

			if (s.isEmpty()) {
				span[i] = i + 1;
			} else {
				span[i] = i - s.peek();
			}

			s.push(i);
		}

		return span;

	}

}
