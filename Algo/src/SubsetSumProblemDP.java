
public class SubsetSumProblemDP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int total = 10;
		int[] numbers = { 3, 4,5,2};

		boolean subsetResult = findSubsetSum(numbers, total);
		System.out.print(subsetResult);
	}

	private static boolean findSubsetSum(int[] numbers, int total) {
		int n = numbers.length;
		boolean[][] tempSum = new boolean[n + 1][total + 1];
		tempSum[0][0] = true;
		for (int i = 1; i <= n; i++)
			tempSum[i][0] = true;
		for (int j = 1; j <= total; j++)
			tempSum[0][j] = false;

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= total; j++) {
				tempSum[i][j] = tempSum[i - 1][j];
				if (j >= numbers[i - 1]) {
					tempSum[i][j] = tempSum[i][j] || tempSum[i-1][j - numbers[i - 1]];
				}
			}
		}

		return tempSum[n][total];
	}

}
