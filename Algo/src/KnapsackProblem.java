
public class KnapsackProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int totalWeight = 90;

		int[] wt = { 10, 20, 30, 40 };
		int[] value = { 60, 100, 120, 50 };

		int subsetResult = knapSackProb(totalWeight, wt, value, value.length);
		System.out.print(subsetResult);
	}

	static int knapSackProb(int W, int wt[], int val[], int n) {
		int i, w;
		int K[][] = new int[n + 1][W + 1];
		for (i = 0; i <= n; i++) {
			for (w = 0; w <= W; w++) {
				if (i == 0 || w == 0)
					K[i][w] = 0;
				else if (wt[i - 1] <= w)
					K[i][w] = Math.max(val[i - 1] + K[i - 1][w - wt[i - 1]], K[i - 1][w]);
				else
					K[i][w] = K[i - 1][w];
			}
		}

		return K[n][W];
	}

}
