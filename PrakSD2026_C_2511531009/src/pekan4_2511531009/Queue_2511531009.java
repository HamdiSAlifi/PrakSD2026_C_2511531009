package pekan4_2511531009;

import java.util.Stack;

public class Queue_2511531009 {
    int front_1009, rear_1009, size_1009;
    int max_1009;
    String[] array_1009;

    // Konstruktor untuk menginisialisasi queue
    public Queue_2511531009(int max_1009) {
        this.max_1009 = max_1009; // Meng-assign kapasitas input ke kapasitas pada class
        front_1009 = this.size_1009 = 0;
        rear_1009 = max_1009 - 1;
        array_1009 = new String[this.max_1009];
    }

    // Method untuk mengecek apakah queue penuh
    boolean isFull_1009() {
        return (size_1009 == max_1009);
    }

    // Method untuk mengecek apakah queue kosong
    boolean isEmpty_1009() {
        return (size_1009 == 0);
    }

    // Method untuk menambahkan elemen ke queue (enqueue)
    void enqueue_1009(String item_1009) {
        if (isFull_1009()) {
            System.out.println("Antrian penuh! Tidak bisa menambahkan pelanggan.");
            return;
        }
        rear_1009 = (rear_1009 + 1) % max_1009; // Pindahkan rear ke posisi berikutnya
        array_1009[rear_1009] = item_1009; // Masukkan data ke posisi rear
        size_1009++; // Tambah ukuran queue
        System.out.println(item_1009 + " berhasil ditambahkan ke antrian.");
    }

    // Method untuk menghapus elemen dari queue (dequeue)
    String dequeue_1009() {
        if (isEmpty_1009()) {
            System.out.println("Antrian kosong! Tidak ada pelanggan yang bisa dihapus.");
            return null;
        }
        String item_1009 = array_1009[front_1009]; // Ambil data dari posisi front
        front_1009 = (front_1009 + 1) % max_1009; // Pindahkan front ke posisi berikutnya
        size_1009--; // Kurangi ukuran queue
        System.out.println(item_1009 + " telah dilayani dan dihapus dari antrian.");
        return item_1009;
    }

    // Method untuk menampilkan isi antrian
    void display_1009() {
        if (isEmpty_1009()) {
            System.out.println("Antrian kosong!");
            return;
        }
        System.out.println("Isi Antrian:");
        int index_1009 = front_1009;
        for (int i = 0; i < size_1009; i++) {
            System.out.println((i + 1) + ". " + array_1009[index_1009]);
            index_1009 = (index_1009 + 1) % max_1009;
        }
    }

    // Method untuk membalik isi antrian
    void reverse_1009() {
        if (isEmpty_1009()) {
            System.out.println("Antrian kosong! Tidak bisa dibalik.");
            return;
        }
        Stack<String> stack_1009 = new Stack<>();
        while (!isEmpty_1009()) {
            stack_1009.push(dequeue_1009()); // Pindahkan semua elemen ke stack
        }
        while (!stack_1009.isEmpty()) {
            enqueue_1009(stack_1009.pop()); // Kembalikan elemen dari stack ke queue
        }
        System.out.println("Antrian berhasil dibalik.");
    }
}