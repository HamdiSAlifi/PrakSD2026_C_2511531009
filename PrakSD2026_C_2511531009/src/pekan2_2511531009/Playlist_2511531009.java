package pekan2_2511531009;
import java.util.*;
public class Playlist_2511531009 {
	
	// Tampilkan Menu
	public static void tampilkanMenu_1009() {
		System.out.println("=== Playlist Musik NIM : 2511531009");
		System.out.println("1. Tambah Lagu");
		System.out.println("2. Lihat Playlist");
		System.out.println("3. Hapus Lagu");
		System.out.println("4. Keluar");
	}
	
	// Tambah Lagu
	public static void tambahLagu_1009(ArrayList<Musik_2511531009> list_1009, Scanner sc_1009) {
		System.out.print("Masukkan Judul Lagu : ");
		String jL_1009 = sc_1009.nextLine();
		System.out.print("Masukkan Penyanyi : ");
		String p_1009 = sc_1009.nextLine();
		System.out.print("Masukkan Durasi (sekon) : ");
		String d_1009 = sc_1009.nextLine();
		list_1009.add(new Musik_2511531009(jL_1009, p_1009, d_1009));
		System.out.println("Data berhasil ditambahkan.\n");
	}
	
	// Lihat Playlist
	public static void lihatPlaylist_1009(ArrayList<Musik_2511531009> list_1009) {
		if (list_1009.isEmpty()) {
			System.out.print("Daftar Lagu Kosong.");
		} else {
			System.out.print("Data Lagu : \n");
			for (Musik_2511531009 lagu_1009 : list_1009) {
				System.out.println(lagu_1009);
			}
			System.out.println();
		}
	}
	
	// Hapus Lagu
	public static void hapusLagu_1009(ArrayList<Musik_2511531009> list_1009, Scanner sc_1009) {
		System.out.print("Masukkan Lagu yang akan dihapus : ");
		String laguHapus_1009 = sc_1009.nextLine();
		boolean removed_1009 = list_1009.removeIf(lagu -> lagu.judulLagu_1009.equals(laguHapus_1009));
		
		if (removed_1009) {
			System.out.println("Data dengan Lagu " + laguHapus_1009 + " berhasil dihapus.\n");
		} else {
			System.out.println("Lagu tidak ditemukan\n");
		}
	}
	
	public static void main(String[] args) {
		ArrayList<Musik_2511531009> laguList = new ArrayList<>();
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
				tambahLagu_1009(laguList, i_1009);
				break;
			case 2 :
				lihatPlaylist_1009(laguList);
				break;
			case 3 :
				hapusLagu_1009(laguList, i_1009);
				break;
			case 4 :
				System.out.println("Keluar dari program");
				break;
			default:
				System.out.println("Pilihan tidak valid.\n");
			}
		} while (choice_1009 != 4);
		i_1009.close();

	}

}
