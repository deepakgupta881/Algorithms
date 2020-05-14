
public class HeapSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] array = { 22, 13, 17, 11, 10, 14, 12,22,18,2,45,15,11,12,16,199 };

		HeapSort heapSort = new HeapSort();
		heapSort.sort(array);
		heapSort.print(array);
		
	}

	private void print(int[] array) {
		// TODO Auto-generated method stub
		for(int i=0;i<array.length;i++) {
			System.out.println(array[i]);
		}
	}

	void sort(int[] array) {
		int length = array.length;

		// for max heapify left and right subtrees
		for (int i = length / 2; i >= 0; i--) {
			heapify(array, length, i);
		}

		
		// swap first and last element from the node and heapify
		for (int i = length - 1; i >= 0; i--) {
			int temp = array[0];
			array[0] = array[i];
			array[i] = temp;
			heapify(array, i, 0);
		}

	}

	private void heapify(int[] array, int length, int i) {
		int largest = i;

		int l = (2 * i) + 1;
		int r = (2 * i) + 2;

		if (l < length && array[l] > array[largest]) {
			largest = l;
		}

		if (r < length && array[r] > array[largest]) {
			largest = r;
		}

		if (i != largest) {
			int temp = array[i];
			array[i] = array[largest];
			array[largest] = temp;
			heapify(array, length, largest);
		}

	}

}
