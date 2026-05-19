package pekan7_2511531009;

public class bubbleSort_2511531009 {

	public static void bubbleSort_1009(int arr_1009[]) {
		int n_1009 = arr_1009.length;
		for (int i_1009 = 0; i_1009 < n_1009 - 1; i_1009++) {
			for (int j_1009 = 0; j_1009 < n_1009 - i_1009 - 1; j_1009++) {
				if (arr_1009[j_1009] > arr_1009[j_1009 + 1]) {
					int temp_1009 = arr_1009[j_1009];
					arr_1009[j_1009] = arr_1009[j_1009 + 1];
					arr_1009[j_1009 + 1] = temp_1009;
//					System.out.println("data : " + arr_1009[j_1009] + " " + arr_1009[j_1009++]);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		int arr_1009[] = {23, 78, 45, 8, 32, 56, 1 };
		int n_1009 = arr_1009.length;
		System.out.printf("Array yang belum terurut:\n");
		for (int i_1009 = 0; i_1009 < n_1009; i_1009++) 
			System.out.print(arr_1009[i_1009] + " ");
		System.out.println("");

		bubbleSort_1009(arr_1009);
		
		System.out.printf("Array yang terurut:\n");
		for (int i_1009 = 0; i_1009 < n_1009; i_1009++)
			System.out.print(arr_1009[i_1009] + " ");
		System.out.println("");
	}
}