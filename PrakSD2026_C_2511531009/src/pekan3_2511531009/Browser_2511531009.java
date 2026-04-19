package pekan3_2511531009;
import java.util.*;
public class Browser_2511531009 {
	
	// Tampilkan Menu
	public static void tampilkanMenu_1009() {
	    System.out.println("=== Browser History NIM : 2511531009 ===");
	    System.out.println("1. Kunjungi Website (Push)");
	    System.out.println("2. Tombol Back (Pop)");
	    System.out.println("3. Lihat Halaman Aktif (Peek)");
	    System.out.println("4. Cek Status History"); 
	    System.out.println("5. Keluar");              
	}
		
	// 1. Kunjungi Website (Push)
	public static void kunjungiWebsite_1009(Stack<Website_2511531009> stack_1009, Scanner sc_1009) {
		String[] labels_1009 = {"Masukkan Judul Website", "Masukkan URL Website"};
		int max_1009 = Arrays.stream(labels_1009).mapToInt(String::length).max().getAsInt(); // sorry bro, had to do this, OCD rlly triggered me so hard

		System.out.printf("%-" + max_1009 + "s : ", labels_1009[0]);
		String jW_1009 = sc_1009.nextLine();

		System.out.printf("%-" + max_1009 + "s : ", labels_1009[1]);
		String u_1009 = sc_1009.nextLine();

		stack_1009.push(new Website_2511531009(jW_1009, u_1009)); // menambahkan elemen ke puncak stack
		System.out.println("\nBerhasil mengunjungi halaman!\n");
	}
	
	// 2. Tombol Back (Pop)
	public static void tombolBack_1009(Stack<Website_2511531009> stack_1009) {
		if (!stack_1009.isEmpty()) { // cek stack
			Website_2511531009 backPage_1009 = stack_1009.pop(); // backPage = popped element
			System.out.println("\nKembali");
			System.out.println("Halaman " + backPage_1009.getJudulWebsite_1009() + 
					" berhasil dihapus dari history\n");
		} else {
			System.out.println("\nBelum ada halaman yang dikunjungi");
		}
	}
	
	// 3. Lihat Halaman Saat Ini (Peek)
	public static void lihatHalamanSaatIni_1009(Stack<Website_2511531009> stack_1009) {
		if (!stack_1009.isEmpty()) { // cek stack
			Website_2511531009 lastPage_1009 = stack_1009.peek(); // intip halaman terakhir
			System.out.println("Halaman terkahir dikunjungi adalah : " + 
			lastPage_1009.getJudulWebsite_1009() + "\n");
		} else {
			System.out.println("\nBelum ada halaman yang dikunjungi\n");
		}
	}
	
	// 4. Cek Status History
	public static void cekStatusHistory_1009(Stack<Website_2511531009> stack_1009) {
	    if (!stack_1009.isEmpty()) {
	        System.out.println("\nHistory saat ini (" + stack_1009.size() + " halaman):");
	        // Print dari atas to bawah
	        for (int i = stack_1009.size() - 1; i >= 0; i--) {
	            System.out.println("  - " + stack_1009.get(i).getJudulWebsite_1009());
	        }
	        System.out.println();
	    } else {
	        System.out.println("\nBelum ada halaman yang dikunjungi");
	    }
	}
	
	public static void main(String[] args) {
		Stack<Website_2511531009> webStack_1009 = new Stack<>();
		Scanner i_1009 = new Scanner(System.in);
		int choice_1009;
		do {
			tampilkanMenu_1009();
			System.out.print("Pilihan : ");
			choice_1009 = i_1009.nextInt();
			i_1009.nextLine();
			System.out.println();
			
			switch (choice_1009) {
			case 1 :
				kunjungiWebsite_1009(webStack_1009, i_1009);
				break;
			case 2 :
				tombolBack_1009(webStack_1009);
				break;
			case 3 :
				lihatHalamanSaatIni_1009(webStack_1009);
				break;
			case 4 :
				cekStatusHistory_1009(webStack_1009);
				break;
			case 5 :
				System.out.println("Keluar dari program");
				break;
			default:
				System.out.println("Pilihan tidak valid.\n");
			}
		} while (choice_1009 != 5);
		i_1009.close();

	}

}
