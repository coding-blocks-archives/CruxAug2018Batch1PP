package L25_Nov3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 03-Nov-2018
 *
 */

public class HashMapDemo {

	public static void main(String[] args) {

		HashMap<String, Integer> map = new HashMap<>();

		// put
		map.put("India", 10);
		map.put("US", 20);
		map.put("UK", 30);
		System.out.println(map);

		map.put("US", 50);
		System.out.println(map);

		// get
		System.out.println(map.get("India"));
		System.out.println(map.get("Aus"));

		// containsKey
		System.out.println(map.containsKey("India"));
		System.out.println(map.containsKey("Aus"));

		// remove
		System.out.println(map.remove("US"));
		System.out.println(map);

		System.out.println(map.remove("Aus"));
		System.out.println(map);

		// keySet
		Set<String> keys = map.keySet();

		for (String key : map.keySet()) {
			System.out.println(key);
		}

		ArrayList<String> list = new ArrayList<>(map.keySet());

		System.out.println(list);

		System.out.println(maxFrequencyCharacter("aaaaabhgdhv"));

		int[] one = { 5, 3, 3, 10, 20, 2, 2, 3, 10 };
		int[] two = { 2, 2, 2, 10, 5, 5, 10, 10, 20 };

		System.out.println(intersection(one, two));

		int[] arr = { 2, 12, 9, 16, 10, 5, 3, 20, 25, 11, 1, 8, 6 , 13};
		System.out.println(longestSeq(arr));

	}

	public static char maxFrequencyCharacter(String str) {

		HashMap<Character, Integer> map = new HashMap<>();

		for (int i = 0; i < str.length(); i++) {

			char ch = str.charAt(i);

			if (map.containsKey(ch)) {
				int of = map.get(ch);
				int nf = of + 1;
				map.put(ch, nf);

				// map.put(ch, map.get(ch) + 1) ;
			} else {
				map.put(ch, 1);
			}
		}

		int maxfreq = 0;
		char maxfreqchar = ' ';

		for (Character key : map.keySet()) {

			int value = map.get(key);

			if (value > maxfreq) {
				maxfreq = value;
				maxfreqchar = key;
			}
		}

		return maxfreqchar;

	}

	public static ArrayList<Integer> intersection(int[] one, int[] two) {

		ArrayList<Integer> ans = new ArrayList<>();

		HashMap<Integer, Integer> map = new HashMap<>();

		// freq hashmap create on the basis of first array
		for (int i = 0; i < one.length; i++) {

			int element = one[i];

			if (map.containsKey(element)) {
				map.put(element, map.get(element) + 1);
			} else {
				map.put(element, 1);
			}

		}

		// elements of second array which are present in map with freq > 0
		for (int i = 0; i < two.length; i++) {

			int element = two[i];

			if (map.containsKey(element) && map.get(element) > 0) {

				ans.add(element);
				map.put(element, map.get(element) - 1);
			}
		}

		return ans;

	}

	public static ArrayList<Integer> longestSeq(int[] arr) {

		HashMap<Integer, Boolean> map = new HashMap<>();

		for (int i = 0; i < arr.length; i++) {

			int element = arr[i];

			if (map.containsKey(element - 1)) {
				map.put(element, false);
			} else {
				map.put(element, true);
			}

			if (map.containsKey(element + 1)) {
				map.put(element + 1, false);
			}

		}

		int maxCount = 0;
		int starting = 0;

		for (Integer key : map.keySet()) {

			if (map.get(key)) {

				int count = 0;

				while (map.containsKey(key + count)) {
					count++;
				}

				if (count > maxCount) {
					maxCount = count;
					starting = key;
				}
			}

		}

		ArrayList<Integer> ans = new ArrayList<>();

		for (int i = 0; i < maxCount; i++) {
			ans.add(starting + i);
		}

		return ans;

	}

}
