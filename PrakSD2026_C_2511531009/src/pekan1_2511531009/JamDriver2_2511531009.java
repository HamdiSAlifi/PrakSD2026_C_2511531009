package pekan1_2511531009;
import java.util.Scanner;
public class JamDriver2_2511531009 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("=== Program Driver Objek Jam ===");
		
		// 1. Input Jam 1
		System.out.println("\n--- Input Jam 1 ---");
		Jam_2511531009 j1 = buatJamDariInput(input);
		
		// 2. Input Jam 2
		System.out.println("\n--- Input Jam 1 ---");			
		Jam_2511531009 j2 = buatJamDariInput(input);
		
		// 3. Menampilkan Data
		System.out.println("\n--- Hasil Operasi ---");
		System.out.println("Jam 1 (String)    : " + j1.toString());
		System.out.println("Jam 2 (String)    : " + j2.toString());
		System.out.println("Jam 1 dalam detik : " + j1.toString());
		System.out.println("Jam 2 dalam detik : " + j2.toString());

		// 4. Operasi Relasional (Perbandingan)
		int perbandingan = j1.compareTo(j2);
		if (perbandingan>0) {
			System.out.println("Status					: Jam 1 lebih lambat dari Jam 2");
		}
		else if (perbandingan<0) {
			System.out.println("Status					: Jam 1 lebih cepat dari Jam 2");
		}
		else {
			System.out.println("Status					: Jam 1 dan Jam 2 sama persis");
		}
		
		// 5. Operasi Aritmatika
		System.out.println("Durasi (J1 ke J2)			: " + Jam_2511531009.durasiDetik(j1, j2) + " detik");
		
		Jam_2511531009 jNext = j1.nextSecond();
		System.out.println("Jam 1 Detik Berikutnya		: " + jNext);
		
		Jam_2511531009 jPrev = j1.prevSecond();
		System.out.println("Jam 1 Detik Sebelumnya		: " + jPrev);
		
		// 6. Operasi Penjumlahan Jam
		Jam_2511531009 jHasilPlus = j1.plus(j2);
		System.out.println("Hasil J1 + J2				: " + jHasilPlus);
		
		input.close();
		System.out.println("\nProgram Selesai.");
	}
	
	/*
	 * Prosedur pembantu
	 */
	
	private static Jam_2511531009 buatJamDariInput(Scanner sc) {
		int h, m, s;
		while (true) {
			System.out.print("Masukkan Jam (0-23)   : ");
			h = sc.nextInt();
			System.out.print("Masukkan Menit (0-59)   : ");
			m = sc.nextInt();
			System.out.print("Masukkan Detik (0-59)   : ");
			s = sc.nextInt();
			
			// memanggil
			if (Jam_2511531009.isValid(h, m, s)) {
				return new Jam_2511531009(h, m, s);
			} else {
				System.out.println("[ERROR] Input tidak valid! silahkan ulangi.\n");
			}
		} 
	}
}