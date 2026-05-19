package pekan7_2511531009;

public class insertionSort_2511531009 {
	public static void insertionSort_1009 (int[] arr) {
		int n_1009 = arr.length;
		for (int i_1009 = 1; i_1009 < n_1009; i_1009++) {
			int key_1009 = arr[i_1009];
			int j_1009 = i_1009 - 1;
			while (j_1009 >=0 && arr[j_1009] > key_1009) {
				arr[j_1009 + 1] = arr[j_1009];
				j_1009--;
			}
			arr[j_1009 + 1] = key_1009;
		}
	}
	public static void main(String[] args) {
		int arr_1009[] = {23, 78, 45, 8, 32, 56, 1 };
		int n_1009 = arr_1009.length;
		System.out.printf("Array yang belum terurut:\n");
		for (int i_1009 = 0; i_1009 < n_1009; i_1009++) 
			System.out.print(arr_1009[i_1009] + " ");
		System.out.println("");
		insertionSort_1009(arr_1009);
		System.out.printf("Array yang terurut:\n");
		for (int i_1009 = 0; i_1009 < n_1009; i_1009++)
			System.out.print(arr_1009[i_1009] + " ");
		System.out.println("");
	}
}