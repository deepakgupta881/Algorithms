import java.util.ArrayList;
import java.util.Scanner;

/* Problem Description

You will develop a program that will take an average of up 
to 10 numbers. Each number will get input individually by the 
user with the output being displayed right after. Each value will 
be stored in an array. The array will reset if the difference via 
division between the current and previous numbers is greater 
than 1.25. You will have to see which value is the greatest and 
which is the least. For example, if your current value is 9 and the 
previous value is 10, then you will have to divide 10 by 9. Keep 
in mind, if 10 was current value and 9 was previous than the 
division would also be 10 divided by 9 because we are dividing 
the greatest by the least value from the current and previous 
input. The first value entered will always be printed out. If the 
second value does not exceed the difference threshold, then the 
input will be added to the array and it will take the average of 
the array. If it does exceed the difference threshold, the array 
will reset with just the current value in the array. When the 
eleventh or more value is put into the array, the head value will 
be deleted, and the previous will be added on to the tail. Keep in 
mind, the difference threshold check is still applied. 
Example:  
Input: 10 
Array [10] 
Output 10 
Input: 11 
Array [10,11] 
Output [10.5] 
Input: 20  
Array [20] Array resets because difference between 20 / 11 is greater than 1.25 
Output:20 
Input 21 
Array [20,21] 
Output: 20.5 
Input: 22 
Array [20,21,22] 
Output: 21 
Input:21  
Array [20,21,22,21] 
Output:21 
Input: 23 
Array [20,21,22,21,23] 
Output: 21.4 
Input: 24 
Array [20,21,22,21,23,24] 
Output: 21.83333333333 
Input: 22 
Array [20,21,22,21,23,24,22] 
Output: 21.8571429 
Input: 21 
Array [20,21,22,21,23,24,22,21] 
Output: 21.75 
Input: 23 
Array [20,21,22,21,23,24,22,21,23] 
Output:21.8888888888 
Input: 20  
Array [20,21,22,21,23,24,22,21,23,20] 
Output: 21.7  
Input: 22 
Array [21,22,21,23,24,22,21,23,20,22] Notice the head (20) is deleted and the input (22) is added 
to the tail. 
Output: 21.9 
Input: 23 
Array [22,21,23,24,22,21,23,20,22,23] 
Output: 22.1 
Input: 50 
Array [50] 50/23 is greater than 1.25 so array will reset 
Output: 50  
Input 51  
Array [50,51] 
Output 50.5 
 
*/

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
