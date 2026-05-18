package pekan7_2511531009;

public class selectionSort_2511531009 {
	
	public static void selectionSort_2511531009(int[] arr_1009) {
		int n_1009 = arr_1009.length;
		for (int i_1009 = 0; i_1009 < n_1009; i_1009++) {
			int minIndex_1009 = i_1009;
			for (int j_1009 = i_1009 + 1; j_1009 < arr_1009.length; j_1009++) {
				if (arr_1009[j_1009] < arr_1009[minIndex_1009]) {
					minIndex_1009 = j_1009;					
				}
			}
			int temp_1009 = arr_1009[i_1009];
			arr_1009[i_1009] = arr_1009[minIndex_1009];
			arr_1009[minIndex_1009] = temp_1009;
		}
	}
	
	public static void main(String[] args) {
		int arr_1009[] = {23,78,48,8,32,56,1};
		int n_1009 = arr_1009.length;
		System.out.printf("array yang belum tersusun : ");
		for (int i_1009 = 0; i_1009 < n_1009; i_1009++)
			System.out.print(arr_1009[i_1009] + " ");
		System.out.println("");
		
		selectionSort_2511531009(arr_1009);
		
		System.out.printf("array yang sudah tersusun : ");
		for (int i_1009 = 0; i_1009 < n_1009; i_1009++) {
			System.out.print(arr_1009[i_1009] + " ");
		}
		System.out.println("");
	}
}