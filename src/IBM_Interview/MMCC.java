package IBM_Interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MMCC {

	public static int getMinimumMoves(ArrayList<Integer> prices, int k) {
		int n = prices.size();
		Collections.sort(prices);
		int medianIndex = (n + 1) / 2;
		int median = prices.get(medianIndex - 1);
		int diff = k - median;
		int moves = 0;
		if (diff <= 0) {
			return moves;
		}
		for (int i = medianIndex; i < n; i++) {
			if (prices.get(i) > k) {
				prices.set(i, prices.get(i) - diff);
				moves += diff;
			} else if (prices.get(i) < k) {
				prices.set(i, prices.get(i) + diff);
				moves += diff;

			} else {
				moves = Math.min(moves, diff);
			}
		}
		return moves;
	}

	public static void main(String[] args) {
		ArrayList<Integer> prices = new ArrayList<>(Arrays.asList(3,3,6,3,9));
		int k = 2;
		int minimumMoves = getMinimumMoves(prices, k);
		System.out.println("Minimum number of moves: " + minimumMoves);

	}

}
