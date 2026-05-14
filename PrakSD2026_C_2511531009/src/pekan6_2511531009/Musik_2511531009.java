package pekan6_2511531009;

import java.util.Scanner;

public class Musik_2511531009 {

    // Head dan tail playlist
    private static Lagu_2511531009 head_1009 = null;
    private static Lagu_2511531009 tail_1009 = null;

    // tambahLagu_1009 : menambahkan lagu baru di AKHIR playlist
    public static void tambahLagu_1009(String judul_1009, String penyanyi_1009) {
        Lagu_2511531009 baru_1009 = new Lagu_2511531009(judul_1009, penyanyi_1009);

        if (head_1009 == null) {
            // Playlist masih kosong — node pertama sekaligus head & tail
            head_1009 = baru_1009;
            tail_1009 = baru_1009;
        } else {
            // Sambungkan node baru di belakang tail saat ini
            baru_1009.prev_1009      = tail_1009;
            tail_1009.next_1009 = baru_1009;
            tail_1009           = baru_1009;
        }
        System.out.println("Lagu berhasil ditambahkan!");
    }

    // hapusLaguAwal_1009 (Delete Head) : hapus node terdepan
    public static void hapusLaguAwal_1009() {
        if (head_1009 == null) {
            System.out.println("Playlist kosong, tidak ada lagu yang dihapus.");
            return;
        }

        System.out.println("Lagu dihapus: \"" + head_1009.getJudul_1009()
                + "\" oleh " + head_1009.getPenyanyi_1009());

        if (head_1009 == tail_1009) {
            head_1009 = null;
            tail_1009 = null;
        } else {
            head_1009           = head_1009.next_1009;
            head_1009.prev_1009 = null;
        }
    }

    // tampilMaju_1009 (Forward Traversal) : dari head ke tail
    public static void tampilMaju_1009() {
        if (head_1009 == null) {
            System.out.println("Playlist kosong.");
            return;
        }

        System.out.println("--- Playlist (Maju) ---");
        Lagu_2511531009 current = head_1009;
        int no = 1;
        while (current != null) {
            System.out.println(no + ". " + current.getJudul_1009()
                    + " - " + current.getPenyanyi_1009());
            current = current.next_1009;
            no++;
        }
    }

    // tampilMundur_1009 (Backward Traversal) : dari tail ke head
    public static void tampilMundur_1009() {
        if (tail_1009 == null) {
            System.out.println("Playlist kosong.");
            return;
        }

        System.out.println("--- Playlist (Mundur) ---");
        Lagu_2511531009 current_1009 = tail_1009;
        int no_1009 = 1;
        while (current_1009 != null) {
            System.out.println(no_1009 + ". " + current_1009.getJudul_1009()
                    + " - " + current_1009.getPenyanyi_1009());
            current_1009 = current_1009.prev_1009;
            no_1009++;
        }
    }

    // --------------------------------------------------------
    // cariLagu_1009 — mencari lagu berdasarkan judul (case-insensitive)
    // --------------------------------------------------------
    public static void cariLagu_1009(String judul_1009) {
        if (head_1009 == null) {
            System.out.println("Playlist kosong.");
            return;
        }

        Lagu_2511531009 current_1009 = head_1009;
        boolean ditemukan_1009  = false;
        int no = 1;

        while (current_1009 != null) {
            if (current_1009.getJudul_1009().equalsIgnoreCase(judul_1009)) {
                System.out.println("Lagu ditemukan (#" + no + "): \""
                        + current_1009.getJudul_1009() + "\" oleh "
                        + current_1009.getPenyanyi_1009());
                ditemukan_1009 = true;
            }
            current_1009 = current_1009.next_1009;
            no++;
        }

        if (!ditemukan_1009) {
            System.out.println("Lagu \"" + judul_1009 + "\" tidak ditemukan.");
        }
    }

    // --------------------------------------------------------
    // Main — menu interaktif
    // --------------------------------------------------------
    public static void main(String[] args) {
        Scanner sc_1009       = new Scanner(System.in);
        int pilihan_1009 = 0;

        do {
            System.out.println("\n=== Antrian Musik NIM: 2511531009 ===");
            System.out.println("1. Tambah Lagu");
            System.out.println("2. Hapus Lagu Pertama");
            System.out.println("3. Lihat Playlist (Maju)");
            System.out.println("4. Lihat Playlist (Mundur)");
            System.out.println("5. Cari Lagu");
            System.out.println("6. Keluar");
            System.out.print("Pilihan: ");

            if (sc_1009.hasNextInt()) {
                pilihan_1009 = sc_1009.nextInt();
            } else {
                sc_1009.next();
                pilihan_1009 = -1;
            }
            sc_1009.nextLine();

            switch (pilihan_1009) {
                case 1:
                    System.out.print("Judul   : ");
                    String judul_1009    = sc_1009.nextLine();
                    System.out.print("Penyanyi: ");
                    String penyanyi_1009 = sc_1009.nextLine();
                    tambahLagu_1009(judul_1009, penyanyi_1009);
                    break;
                case 2:
                    hapusLaguAwal_1009();
                    break;
                case 3:
                    tampilMaju_1009();
                    break;
                case 4:
                    tampilMundur_1009();
                    break;
                case 5:
                    System.out.print("Masukkan judul lagu: ");
                    String cari_1009 = sc_1009.nextLine();
                    cariLagu_1009(cari_1009);
                    break;
                case 6:
                    System.out.println("Terima kasih! Program selesai.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }

        } while (pilihan_1009 != 6);

        sc_1009.close();
    }
}
