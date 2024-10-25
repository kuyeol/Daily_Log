package arrays;

/**
 * Count number of inversions in an array of integers.
 * 
 * An inversion is a pair of indices: (i,j) such that i < j and array[i] >
 * array[j].
 * 
 * Signature of expected method:
 * 
 *    public static long countInversions(int[] array)  {...}
 */
public class CountInversions {
	public static long countInversions(int[] array) {
		return countInversions(array, 0, array.length - 1,
				new int[array.length]);
	}

	// Recursively counts the inversions.
	private static long countInversions(int[] array, int start, int end,
			int[] merged) {
		if (start == end) {
			merged[0] = array[start];
			return 0L;
		}

		int middle = (start + end) / 2;

		int[] left = new int[middle - start + 1];
		long leftInversions = countInversions(array, start, middle, left);
		int[] right = new int[end - middle];
		long rightInversions = countInversions(array, middle + 1, end, right);

		return leftInversions + rightInversions
				+ mergeAndCountInversions(left, right, merged);
	}

	// This method is very similar to merge sort's merge method. Study the
	// merge method first if you don't immediately understand the below.
	private static long mergeAndCountInversions(int[] foo, int[] bar,
			int[] merged) {
		if (foo == null || bar == null || merged == null) {
			throw new NullPointerException(
					"One or more of foo/bar/merged is null.");
		}

		long numInversions = 0L;
		int fooIndex = 0, barIndex = 0;
		int sortedIndex = 0;
		while (fooIndex < foo.length && barIndex < bar.length) {
			if (foo[fooIndex] <= bar[barIndex]) {
				merged[sortedIndex] = foo[fooIndex];
				fooIndex++;
			} else {
				numInversions += foo.length - fooIndex;
				merged[sortedIndex] = bar[barIndex];
				barIndex++;
			}

			sortedIndex++;
		}

		while (fooIndex < foo.length) {
			merged[sortedIndex] = foo[fooIndex];
			fooIndex++;
			sortedIndex++;
		}

		while (barIndex < bar.length) {
			merged[sortedIndex] = bar[barIndex];
			barIndex++;
			sortedIndex++;
		}

		return numInversions;
	}
}
