package pekan8_2511531009;
import java.util.Scanner;

public class sorting_2511531009 {

    private lagu_2511531009[] dataLagu_1009;
    private int jumlahLagu_1009;

    public sorting_2511531009() {
        dataLagu_1009 = new lagu_2511531009[20];
        jumlahLagu_1009 = 0;
    }

    public void inputData_1009(Scanner scanner_1009) {
        while (true) {
            try {
                System.out.print("Masukkan jumlah lagu (min 7, maks 20): ");
                jumlahLagu_1009 = Integer.parseInt(scanner_1009.nextLine());

                if (jumlahLagu_1009 >= 7 && jumlahLagu_1009 <= 20) {
                    break;
                } else {
                    System.out.println("[Error] Jumlah lagu harus di antara 7 dan 20. Silakan coba lagi.");
                }
            } catch (NumberFormatException e) {
                System.out.println("[Error] Input tidak valid! Harap masukkan angka bulat.");
            }
        }

        System.out.println("\nMasukkan data lagu:");
        for (int i_1009 = 0; i_1009 < jumlahLagu_1009; i_1009++) {
            System.out.println("Lagu ke-" + (i_1009 + 1) + ":");

            String judul_1009 = "";
            while (true) {
                System.out.print("Judul    : ");
                judul_1009 = scanner_1009.nextLine().trim();
                if (!judul_1009.isEmpty()) {
                    break;
                }
                System.out.println("[Error] Judul lagu tidak boleh kosong!");
            }

            String penyanyi_1009 = "";
            while (true) {
                System.out.print("Penyanyi : ");
                penyanyi_1009 = scanner_1009.nextLine().trim();
                if (!penyanyi_1009.isEmpty()) {
                    break;
                }
                System.out.println("[Error] Nama penyanyi tidak boleh kosong!");
            }

            int durasi_1009 = 0;
            while (true) {
                try {
                    System.out.print("Durasi (detik) : ");
                    durasi_1009 = Integer.parseInt(scanner_1009.nextLine());
                    if (durasi_1009 > 0) {
                        break;
                    }
                    System.out.println("[Error] Durasi harus lebih besar dari 0 detik!");
                } catch (NumberFormatException e) {
                    System.out.println("[Error] Input tidak valid! Harap masukkan angka bulat untuk durasi.");
                }
            }

            dataLagu_1009[i_1009] = new lagu_2511531009(judul_1009, penyanyi_1009, durasi_1009);
        }
    }

    public void shellSort_1009() {
        int n_1009 = jumlahLagu_1009;

        for (int gap_1009 = n_1009 / 2; gap_1009 > 0; gap_1009 /= 2) {
            for (int i_1009 = gap_1009; i_1009 < n_1009; i_1009++) {
                lagu_2511531009 temp_1009 = dataLagu_1009[i_1009];
                int j_1009;

                for (j_1009 = i_1009; j_1009 >= gap_1009 && dataLagu_1009[j_1009 - gap_1009].getJudul_1009()
                        .compareToIgnoreCase(temp_1009.getJudul_1009()) > 0; j_1009 -= gap_1009) {
                    dataLagu_1009[j_1009] = dataLagu_1009[j_1009 - gap_1009];
                }

                dataLagu_1009[j_1009] = temp_1009;
            }
        }
    }

    public void tampilData_1009() {
        System.out.println();
        System.out.println("Data Sebelum Sorting:");
        for (int i_1009 = 0; i_1009 < jumlahLagu_1009; i_1009++) {
            System.out.println("\n" + dataLagu_1009[i_1009].getJudul_1009()
                    + " - " + dataLagu_1009[i_1009].getDurasi_1009() + " detik");
        }

        shellSort_1009();

        System.out.println();
        System.out.println("Data Setelah Shell Sort (Judul Asc):");
        for (int i_1009 = 0; i_1009 < jumlahLagu_1009; i_1009++) {
            System.out.println((i_1009 + 1) + ". " + dataLagu_1009[i_1009].getJudul_1009()
                    + " - " + dataLagu_1009[i_1009].getDurasi_1009() + " detik");
        }
    }

    public static void main(String[] args) {
        Scanner scanner_1009 = new Scanner(System.in);

        System.out.println("=== Sorting Playlist NIM : 2511531009 ===");
        System.out.println("Algoritma : Shell Sort (Ascending Judul)");

        sorting_2511531009 playlist_1009 = new sorting_2511531009();
        playlist_1009.inputData_1009(scanner_1009);
        playlist_1009.tampilData_1009();

        scanner_1009.close();
    }
}