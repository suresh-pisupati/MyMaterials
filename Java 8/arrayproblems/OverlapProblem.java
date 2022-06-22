package arrayproblems;

import java.util.Arrays;

public class OverlapProblem {

	private static class Interval {

		int start, end;

		public Interval(int start, int end) {

			this.start = start;
			this.end = end;
		}
	}

	private boolean isOverlap(Interval[] givenInterval) {

		// Sort the given interval
		Arrays.sort(givenInterval, (interval1, interval2) -> {
			return interval1.start - interval2.start;
		});

		// Iterate through the given interval to find the overlap
		// If the start of the interval is less than the previous end interval then
		// there is overlap
		for (int index = 1; index < givenInterval.length; index++) {
			if (givenInterval[index - 1].end > givenInterval[index].start) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {

		OverlapProblem obj = new OverlapProblem();
		Interval arr2[] = { new Interval(6, 8), new Interval(1, 3), new Interval(2, 4), new Interval(4, 7) };
		System.out.println(obj.isOverlap(arr2) ? "Yes" : "No");
	}

}
