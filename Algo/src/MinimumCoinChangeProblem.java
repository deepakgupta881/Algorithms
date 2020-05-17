
public class MinimumCoinChangeProblem {

	public static void main(String[] args) {

		int total = 8;
		int[] coins = { 1, 5, 6,7 };

		int minCoinResult = findMinimumCoinsNeed(coins, total);

		System.out.print(minCoinResult);

	}

	public static int findMinimumCoinsNeed(int[] coins, int totalSum) {

		int n = coins.length;
		int[][] tempCoins = new int[n + 1][totalSum + 1];

		for (int i = 1; i <= n; i++) {
			tempCoins[i][0] = 0;
		}

		for (int j = 0; j <= totalSum; j++) {
			tempCoins[0][j] = j;
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= totalSum; j++) {
				if (coins[i - 1] > j) {
					tempCoins[i][j] = tempCoins[i - 1][j];
				} else {
					tempCoins[i][j] = Math.min(tempCoins[i - 1][j], 1 + tempCoins[i][j - coins[i-1]]);
				}
			}
		}
		return tempCoins[n][totalSum];
	}

}
