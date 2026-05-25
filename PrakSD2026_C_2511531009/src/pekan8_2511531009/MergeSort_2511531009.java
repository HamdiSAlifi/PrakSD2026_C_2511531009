package pekan8_2511531009;

public class MergeSort_2511531009 {
	
	void merge_1009(int arr_1009[], int l_1009, int m_1009, int r_1009) {
		// find sizes of
		int n1_1009 = m_1009 - l_1009 + 1;
		int n2_1009 = r_1009 - m_1009;
		
		// temp arrays
		int L_1009[] = new int[n1_1009];
		int R_1009[] = new int[n2_1009];
		
		// copy data to temp
		for (int i_1009 = 0; i_1009 < n1_1009; ++i_1009) {
			L_1009[i_1009] = arr_1009[l_1009 + i_1009];
		}
		
		for (int j_1009 = 0; j_1009 < n2_1009; ++j_1009) {
			R_1009[j_1009] = arr_1009[m_1009 + 1 + j_1009]; // 1 -> m_1009 + 1
		}
		
		int i_1009 = 0, j_1009 = 0;
		// intitial index of merged subaray array
		int k_1009 = l_1009; // ✅ FIX 2: 1 -> l_1009
		while (i_1009 < n1_1009 && j_1009 < n2_1009) {
			if (L_1009[i_1009] <= R_1009[j_1009]) {
				arr_1009[k_1009] = L_1009[i_1009]; 
				i_1009++;
			} else {
				arr_1009[k_1009] = R_1009[j_1009];
				j_1009++;
			}
			k_1009++;
		}
		
		//copy remaining element of L[] if any
		while (i_1009 < n1_1009) {
			arr_1009[k_1009] = L_1009[i_1009];
			i_1009++;
			k_1009++;
		}
		
		//copy remaining element of R[] if any
		while (j_1009 < n2_1009) {
			arr_1009[k_1009] = R_1009[j_1009];
			j_1009++;
			k_1009++;
		}
	}
	
	void sort_1009(int arr[], int l_1009, int r_1009) {
		if (l_1009 < r_1009) {
			// find the mid point
			int m_1009 = (l_1009 + r_1009) / 2;
			
			// sort first and second halves
			sort_1009(arr, l_1009, m_1009);
			sort_1009(arr, m_1009 + 1, r_1009); //  m_1009 + l_1009 -> m_1009 + 1
			
			// mrege the sorted halves
			merge_1009(arr, l_1009, m_1009, r_1009);
		}
	}

	// a utility funct to print arr of size n 
	static void printArray_1009(int arr_1009[]) {
		int n_1009 = arr_1009.length;
		for (int i_1009 = 0; i_1009 < n_1009; i_1009++) {
			System.out.print(arr_1009[i_1009] + " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		int arr_1009[] = {12, 11, 13, 5, 6, 7};
		System.out.println("Sebelum terurut : ");
		printArray_1009(arr_1009);
		
		MergeSort_2511531009 ob_1009 = new MergeSort_2511531009();
		
		ob_1009.sort_1009(arr_1009, 0, arr_1009.length - 1);
		System.out.println("\nSesudah Terurut menggunakan Merge SOrt :");
		printArray_1009(arr_1009);
	}
}