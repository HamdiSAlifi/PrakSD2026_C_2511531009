package pekan4_2511531009;
import java.util.*;
public class QueueLinkedList_2511531009 {

	public static void main(String[] args) {
		Queue<Integer> q_1009 = new LinkedList<Integer>();
		// tambah elemen
		for (int i_1009 = 0; i_1009 < 6; i_1009++)
			q_1009.add(i_1009);
		
		// menampilkan isi antrean
		System.out.println("Elemen Antrian " + q_1009);
		
		// menghapus kepala antrian
		int hapus_1009 = q_1009.remove();
		System.out.println("hapus elemen " + hapus_1009);
		System.out.println(q_1009);
		
		// melihat antrean terdepan
		int depan_1009 = q_1009.peek();
		System.out.println("Kepala antrian " + depan_1009);
		
		// melihat size antrean
		int banyak_1009 = q_1009.size();
		System.out.println("Size antrian " + banyak_1009);
	}
}
