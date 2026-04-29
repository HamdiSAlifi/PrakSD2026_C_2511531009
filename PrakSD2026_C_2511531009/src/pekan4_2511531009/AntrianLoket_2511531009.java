package pekan4_2511531009;

import java.util.Scanner;

public class AntrianLoket_2511531009 {
    public static void main(String[] args) {
        Scanner scanner_1009 = new Scanner(System.in);
        Queue_2511531009 queue_1009 = new Queue_2511531009(10); // Kapasitas maksimal antrian adalah 10

        int pilihan_1009;
        do {
            System.out.println("\n== PROGRAM ANTRIAN LOKET ===");
            System.out.println("1. Tambah Antrian");
            System.out.println("2. Hapus Antrian");
            System.out.println("3. Tampilkan Antrian");
            System.out.println("4. Reverse");
            System.out.println("5. Keluar");
            System.out.print("Pilih Menu : ");
            pilihan_1009 = scanner_1009.nextInt();
            scanner_1009.nextLine(); // Membersihkan newline

            switch (pilihan_1009) {
                case 1:
                    System.out.print("Masukkan nama pelanggan : ");
                    String namaPelanggan_1009 = scanner_1009.nextLine();
                    queue_1009.enqueue_1009(namaPelanggan_1009);
                    break;
                case 2:
                    queue_1009.dequeue_1009();
                    break;
                case 3:
                    queue_1009.display_1009();
                    break;
                case 4:
                    queue_1009.reverse_1009();
                    break;
                case 5:
                    System.out.println("Keluar dari program...");
                    break;
                default:
                    System.out.println("Menu tidak valid! Silakan coba lagi.");
            }
        } while (pilihan_1009 != 5);

        scanner_1009.close();
    }
}