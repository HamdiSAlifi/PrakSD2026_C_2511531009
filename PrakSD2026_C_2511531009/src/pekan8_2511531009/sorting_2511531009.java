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
        System.out.print("Masukkan jumlah lagu (min 7, maks 20): ");
        jumlahLagu_1009 = Integer.parseInt(scanner_1009.nextLine());

        if (jumlahLagu_1009 < 7) {
            System.out.println("Jumlah lagu minimal 7. Jumlah diatur ke 7.");
            jumlahLagu_1009 = 7;
        }
        if (jumlahLagu_1009 > 20) {
            System.out.println("Jumlah lagu maksimal 20. Jumlah diatur ke 20.");
            jumlahLagu_1009 = 20;
        }

        System.out.println("Masukkan data lagu:");
        for (int i = 0; i < jumlahLagu_1009; i++) {
            System.out.println("Lagu ke-" + (i + 1) + ":");

            System.out.print("Judul    : ");
            String judul_1009 = scanner_1009.nextLine();

            System.out.print("Penyanyi : ");
            String penyanyi_1009 = scanner_1009.nextLine();

            System.out.print("Durasi (detik) : ");
            int durasi_1009 = scanner_1009.nextInt();
            
            // fix the scanner skip bug
            scanner_1009.nextLine();

            dataLagu_1009[i] = new lagu_2511531009(judul_1009, penyanyi_1009, durasi_1009);
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