import java.util.ArrayList;
import java.util.Scanner;

public class AdvancesAverageAlgorithm {

	public static void showOutput(ArrayList<Integer> dataList, int current) {
		int sum = 0;
		dataList.add(current);
		for (int i = 0; i < dataList.size(); i++) {
			sum += dataList.get(i);
		}
		double average = (double) sum / dataList.size();
		System.out.println(average);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int count = 1;
		ArrayList<Integer> dataList = new ArrayList<Integer>();
		int current = 0;
		int previous = 0;
		Scanner sc = new Scanner(System.in);
		while (count < 12) {
			System.out.println();
			int data = sc.nextInt();
			if (count == 11) {
				dataList.remove(0);
				previous = dataList.get(dataList.size() - 1);
				current = data;
				dataList.add(data);
				if (current > previous) {
					double div = (double) current / previous;
					if (div > 1.25) {
						dataList.clear();
						dataList.add(current);
						System.out.println(dataList.get(0));
						count = 1;
						count++;
					} else {
						
						AdvancesAverageAlgorithm.showOutput(dataList, current);
					}
				} else {
					double div = (double) previous / current;
					if (div > 1.25) {
						dataList.clear();
						dataList.add(current);
						System.out.println(dataList.get(0));
						count = 1;
						count++;
					} else {
						AdvancesAverageAlgorithm.showOutput(dataList, current);
					}
				}

			} else {
				if (dataList.size() == 0) {
					dataList.add(data);
					System.out.println(dataList.get(0));
				} else {
					previous = dataList.get(dataList.size() - 1);
					current = data;
					if (current > previous) {
						double div = (double) current / previous;
						if (div > 1.25) {
							dataList.clear();
							dataList.add(current);
							System.out.println(dataList.get(0));
							count = 1;
						} else {
							AdvancesAverageAlgorithm.showOutput(dataList, current);
						}
					} else {
						double div = (double) previous / current;
						if (div > 1.25) {
							dataList.clear();
							dataList.add(current);
							System.out.println(dataList.get(0));
							count = 1;
						} else {
							AdvancesAverageAlgorithm.showOutput(dataList, current);
						}
					}

				}

				count++;
			}
		}

	}

}
