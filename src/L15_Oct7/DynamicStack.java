package L15_Oct7;

import L14_Oct6.Stack;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 07-Oct-2018
 *
 */

public class DynamicStack extends Stack {

	@Override
	public void push(int item) throws Exception {

		if (isFull()) {

			int[] oa = this.data;
			int[] na = new int[2 * oa.length];

			for (int i = 0; i < oa.length; i++) {
				na[i] = oa[i];
			}

			this.data = na;

		}

		super.push(item);
	}

}
