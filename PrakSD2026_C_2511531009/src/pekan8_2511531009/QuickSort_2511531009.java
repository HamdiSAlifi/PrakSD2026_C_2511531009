package pekan8_2511531009;

public class QuickSort_2511531009 {

	static void swap_1009(int[] arr_1009, int i_1009, int j_1009) {
		int temp_1009 = arr_1009[i_1009];
		arr_1009[i_1009] = arr_1009[j_1009];
		arr_1009[j_1009] = temp_1009;
	}


	// additional method : regulate pivot using Median-Of-Three
	static void medianOfThree(int[] arr_1009, int low_1009, int high_1009) {
		int mid_1009 = low_1009 + (high_1009 - low_1009) / 2;

		// sort low, mid, high element
		if (arr_1009[low_1009] > arr_1009[mid_1009]) {
			swap_1009(arr_1009, low_1009, mid_1009);
		}
		if (arr_1009[low_1009] > arr_1009[high_1009]) {
			swap_1009(arr_1009, low_1009, high_1009);
		}
		if (arr_1009[mid_1009] > arr_1009[high_1009]) {
			swap_1009(arr_1009, mid_1009, high_1009);
		}
		swap_1009(arr_1009, mid_1009, high_1009);
	}

	// func :
	static int partition_1009(int[] arr_1009, int low_1009, int high_1009) {
		// calls medianOfThree method before initialising a pivot
		medianOfThree(arr_1009, low_1009, high_1009);

		int pivot_1009	= arr_1009[high_1009];
		int i_1009		= (low_1009 - 1);

		for (int j_1009 = low_1009; j_1009 <= high_1009 - 1; j_1009++) {
			// if the current element is smaller or equal than pivot
			if (arr_1009[j_1009] < pivot_1009) {
				// increment of smaller index element
				i_1009++;
				swap_1009(arr_1009, i_1009, j_1009);
			}
		}
		swap_1009(arr_1009, i_1009 + 1, high_1009); // ✅ FIX 1: place pivot in correct position
		return (i_1009 + 1);
	}


	static void quickSort_1009(int[] arr_1009, int low_1009, int high_1009) {
		if (low_1009 < high_1009) {
			int pi_1009 = partition_1009(arr_1009, low_1009, high_1009);
			quickSort_1009(arr_1009, low_1009, pi_1009 - 1);
			quickSort_1009(arr_1009, pi_1009 + 1, high_1009); // ✅ FIX 2: pi+1 not pi-1
		}
	}

	public static void printArr(int[] arr_1009) {
		for (int i_1009 = 0; i_1009 < arr_1009.length; i_1009++) {
			System.out.print(arr_1009[i_1009] + " "); // ✅ FIX 3: err -> out
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[] arr_1009 = {10, 7, 8, 9, 1, 5};
		int N_1009 = arr_1009.length;
		System.out.print("Data sebelum diurutkan : ");
		printArr(arr_1009);

		quickSort_1009(arr_1009, 0, N_1009 - 1);

		System.out.print("Data Terurut quick sort: "); // ✅ FIX 4: added colon+space
		printArr(arr_1009);
	}
}