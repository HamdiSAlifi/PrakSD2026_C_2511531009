package pekan2_2511531009;
import java.util.*;
public class MahasiswaDriver_2511531009 {
	// 1. Method untuk menampilkan menu
	public static void tampilkanMenu() {
		System.out.println("\nMenu");
		System.out.println("1. Tambah Mahasiswa");
		System.out.println("2. Tampilkan Semua Mahasiswa");
		System.out.println("3. Hapus Mahasiswa Berdasarkan NIM");
		System.out.println("4. Cari Mahasiswa Berdasarkan NIM");
		System.out.println("5. Keluar");
	}
	
	// 2. Method untuk tambah Mahasiswa
	public static void tambahMahasiswa(ArrayList<mahasiswa_2511531009> list, Scanner sc) {
		System.out.println("Masukkan NIM : ");
		String nim = sc.nextLine();
		System.out.println("Masukkan Nama : ");
		String nama = sc.nextLine();
		System.out.println("Masukkan Prodi : ");
		String prodi = sc.nextLine();
		list.add(new mahasiswa_2511531009(nim, nama, prodi));
		System.out.println("Mahasiswa berhasil ditambahkan.");
	}
	
	// 3. Method untuk tampilkan semua data
	public static void tampilkanSemuaMahasiswa(ArrayList<mahasiswa_2511531009> list) {
		if (list.isEmpty()) {
			System.out.println("Daftar mahasiswa kosong.");
		} else {
			System.out.println("Data Mahasiswa : ");
			for (mahasiswa_2511531009 mhs : list) {
				System.out.println(mhs);
			}
		}
	}
	
	// 4. Method untuk hapus mahasiswa berdasarkan NIM
	public static void hapusMahasiswa(ArrayList<mahasiswa_2511531009> list, Scanner sc) {
		System.out.println("Masukkan NIM yang akan dihapus : ");
		String nimHapus = sc.nextLine();
		boolean removed = list.removeIf(mhs -> mhs.nim.equals(nimHapus));
		
		if (removed) {
			System.out.println("Data dengan NIM " + nimHapus + " berhasil dihapus.");
		} else {
			System.out.println("NIM tidak ditemukan");
		}
	}
	
	// 5. Method untuk cari mahasiswa berdasarkan NIM
	public static void cariMahasiswa(ArrayList<mahasiswa_2511531009> list, Scanner sc) {
		System.out.println("Masukkan NIM yang akan dicari : ");
		String nimCari = sc.nextLine();
		boolean ditemukan = false;
		
		for (mahasiswa_2511531009 mhs : list) {
			if (mhs.nim.equals(nimCari)) {
				System.out.println("Hasil Pencarian : " + mhs);
				ditemukan = true;
				break;
			}
		}
		
		if (!ditemukan) {
			System.out.println("NIM tidak ada");
		}
	}
	
	public static void main(String[] args) {
		ArrayList<mahasiswa_2511531009> mahasiswaList = new ArrayList<>();
		Scanner scanner = new Scanner(System.in);
		int choice;
		do {
			tampilkanMenu();
			System.out.println("Pilih menu : ");
			choice = scanner.nextInt();
			scanner.nextLine();
			
			switch (choice) {
			case 1:
				tambahMahasiswa(mahasiswaList, scanner);
				break;
			case 2:
				tampilkanSemuaMahasiswa(mahasiswaList);
				break;
			case 3:
				hapusMahasiswa(mahasiswaList, scanner);
				break;
			case 4:
				cariMahasiswa(mahasiswaList, scanner);
				break;
			case 5:
				System.out.println("Keluar dari program");
				break;
			default:
				System.out.println("Pilihan tidak valid.");
			}
			
		} while (choice != 5);
		scanner.close();
	}
	
}
