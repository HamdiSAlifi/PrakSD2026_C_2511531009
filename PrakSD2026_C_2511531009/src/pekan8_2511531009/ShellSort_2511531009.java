package pekan8_2511531009;

public class ShellSort_2511531009 {

	public static void ShellSort_1009(int[] A_1009) {
		int n_1009 = A_1009.length;
		int gap_1009 = n_1009/2;
		while (gap_1009 > 0) {
			for (int i_1009 = gap_1009; i_1009 < n_1009; i_1009++) {
				int temp_1009 = A_1009[i_1009];
				int j_1009 = i_1009;
				while (j_1009 >= gap_1009 && A_1009[j_1009 - gap_1009] > temp_1009) {
					A_1009[j_1009] = A_1009[j_1009 - gap_1009];
					j_1009 = j_1009 - gap_1009;
				}
				A_1009[j_1009] = temp_1009;
			}
			gap_1009 = gap_1009 / 2;
		}
	}
	
	public static void main(String[] args) {
		int[] data_1009 = {3, 10, 4, 6, 8, 9, 7, 2, 1, 5};
		
		System.out.print("Sebelum : ");
		printArray_1009(data_1009);
		
		ShellSort_1009(data_1009);

		System.out.print("Sesudah (Shell Sort) : ");
		printArray_1009(data_1009);
	}
	
	public static void printArray_1009(int[] arr_1009) {
		for (int i_1009 : arr_1009)
			System.out.print(i_1009 + " ");
		System.out.println();
	}
}
