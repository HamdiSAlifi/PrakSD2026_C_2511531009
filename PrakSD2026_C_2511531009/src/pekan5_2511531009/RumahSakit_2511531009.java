package pekan5_2511531009;
import java.util.Scanner;

public class RumahSakit_2511531009 {
	
    private Pasien_2511531009 head_1009; // Pointer ke head
    private int counter_1009 = 0; 		// Counter untuk nomor antrian

    // Mendaftarkan Pasien (Insert at Tail)
    public void daftarkanPasien_1009(String namaPasien_1009, String keluhan_1009) {
        Pasien_2511531009 newNode_1009 = new Pasien_2511531009(namaPasien_1009, keluhan_1009, ++counter_1009);

        if (head_1009 == null) {
            head_1009 = newNode_1009;
        } else {
            Pasien_2511531009 temp_1009 = head_1009;
            while (temp_1009.next_1009 != null) {
                temp_1009 = temp_1009.next_1009;
            }
            temp_1009.next_1009 = newNode_1009;
        }
        System.out.println("Pasien berhasil didaftarkan! Nomor Antrian: " + counter_1009);
    }

    // Panggil Pasien (Delete Head)
    public void panggilPasien_1009() {
        if (head_1009 == null) {
            System.out.println("Antrian kosong!");
        } else {
            Pasien_2511531009 pasienDipanggil_1009 = head_1009;
            head_1009 = head_1009.next_1009;
            System.out.println("Pasien dipanggil: " + pasienDipanggil_1009.getNamaPasien_1009() +
                    ", Keluhan: " + pasienDipanggil_1009.getKeluhan_1009() +
                    ", Nomor Antrian: " + pasienDipanggil_1009.getNomorAntrian_1009());
        }
    }

    // Tampilkan Antrian (Display)
    public void tampilkanAntrian_1009() {
        if (head_1009 == null) {
            System.out.println("Antrian kosong!");
        } else {
            Pasien_2511531009 temp_1009 = head_1009;
            System.out.println("=== Daftar Antrian ===");
            while (temp_1009 != null) {
                System.out.println("Nomor Antrian: " + temp_1009.getNomorAntrian_1009() +
                        ", Nama: " + temp_1009.getNamaPasien_1009() +
                        ", Keluhan: " + temp_1009.getKeluhan_1009());
                temp_1009 = temp_1009.next_1009;
            }
        }
    }

    // Cari Pasien (Search)
    public void cariPasien_1009(String namaPasien_1009) {
        if (head_1009 == null) {
            System.out.println("Antrian kosong!");
        } else {
            Pasien_2511531009 temp_1009 = head_1009;
            boolean found_1009 = false;
            while (temp_1009 != null) {
                if (temp_1009.getNamaPasien_1009().equalsIgnoreCase(namaPasien_1009)) {
                    System.out.println("Pasien ditemukan: " +
                            "Nomor Antrian: " + temp_1009.getNomorAntrian_1009() +
                            ", Nama: " + temp_1009.getNamaPasien_1009() +
                            ", Keluhan: " + temp_1009.getKeluhan_1009());
                    found_1009 = true;
                    break;
                }
                temp_1009 = temp_1009.next_1009;
            }
            if (!found_1009) {
                System.out.println("Pasien tidak ditemukan!");
            }
        }
    }

    // Cek status antrian
    public void cekStatusAntrian_1009() {
        if (head_1009 == null) {
            System.out.println("Antrian kosong!");
        } else {
            System.out.println("Total Pasien: " + counter_1009);
            System.out.println("Pasien Terdepan: " +
                    "Nomor Antrian: " + head_1009.getNomorAntrian_1009() +
                    ", Nama: " + head_1009.getNamaPasien_1009() +
                    ", Keluhan: " + head_1009.getKeluhan_1009());
        }
    }

    public static void main(String[] args) {
        Scanner scanner_1009 = new Scanner(System.in);
        RumahSakit_2511531009 rumahSakit_1009 = new RumahSakit_2511531009();
        int pilihan_1009;

        do {
            System.out.println("=== Antrian Rumah Sakit NIM: 2511531009 ===");
            System.out.println("1. Daftarkan Pasien (Insert)");
            System.out.println("2. Panggil Pasien (Delete Head)");
            System.out.println("3. Tampilkan Antrian (Display)");
            System.out.println("4. Cari Pasien (Search)");
            System.out.println("5. Cek Status Antrian");
            System.out.println("6. Keluar");
            System.out.print("Pilihan: ");
            pilihan_1009 = scanner_1009.nextInt();
            scanner_1009.nextLine(); // this is important >:|

            switch (pilihan_1009) {
                case 1:
                    System.out.print("Masukkan Nama Pasien: ");
                    String namaPasien_1009 = scanner_1009.nextLine();
                    System.out.print("Masukkan Keluhan: ");
                    String keluhan_1009 = scanner_1009.nextLine();
                    rumahSakit_1009.daftarkanPasien_1009(namaPasien_1009, keluhan_1009);
                    break;
                case 2:
                    rumahSakit_1009.panggilPasien_1009();
                    break;
                case 3:
                    rumahSakit_1009.tampilkanAntrian_1009();
                    break;
                case 4:
                    System.out.print("Masukkan Nama Pasien yang Dicari: ");
                    String namaCari_1009 = scanner_1009.nextLine();
                    rumahSakit_1009.cariPasien_1009(namaCari_1009);
                    break;
                case 5:
                    rumahSakit_1009.cekStatusAntrian_1009();
                    break;
                case 6:
                    System.out.println("Terima kasih telah menggunakan program ini!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
            System.out.println();
        } while (pilihan_1009 != 6);

        scanner_1009.close();
    }
}