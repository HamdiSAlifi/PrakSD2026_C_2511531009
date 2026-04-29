package pekan4_2511531009;

import java.util.Stack;

public class Queue_2511531009 {
    int front_1009, rear_1009, size_1009;
    int capacity_1009;
    String[] array_1009;

    // Konstruktor: inisialisasi antrian dengan kapasitas tertentu
    public Queue_2511531009(int capacity_1009) {
        this.capacity_1009 = capacity_1009;
        front_1009 = 0;
        rear_1009 = capacity_1009 - 1;
        size_1009 = 0;
        array_1009 = new String[this.capacity_1009];
    }

    // Cek apakah antrian penuh
    boolean isFull_1009() {
        return size_1009 == capacity_1009;
    }

    // Cek apakah antrian kosong
    boolean isEmpty_1009() {
        return size_1009 == 0;
    }

    // Menambahkan pelanggan ke belakang antrian (dengan pesan untuk pengguna)
    void enqueue_1009(String item_1009) {
        if (isFull_1009()) {
            System.out.println("Antrian penuh! Tidak bisa menambahkan pelanggan.");
            return;
        }
        rear_1009 = (rear_1009 + 1) % capacity_1009;
        array_1009[rear_1009] = item_1009;
        size_1009++;
        System.out.println(item_1009 + " berhasil ditambahkan ke antrian.");
    }

    // Menghapus pelanggan dari depan antrian (dengan pesan untuk pengguna)
    String dequeue_1009() {
        if (isEmpty_1009()) {
            System.out.println("Antrian kosong! Tidak ada pelanggan yang bisa dihapus.");
            return null;
        }
        String item_1009 = array_1009[front_1009];
        front_1009 = (front_1009 + 1) % capacity_1009;
        size_1009--;
        System.out.println(item_1009 + " telah dilayani dan dihapus dari antrian.");
        return item_1009;
    }

    // reverse
    private void enqueueSilent_1009(String item_1009) {
        rear_1009 = (rear_1009 + 1) % capacity_1009;
        array_1009[rear_1009] = item_1009;
        size_1009++;
    }

    private String dequeueSilent_1009() {
        String item_1009 = array_1009[front_1009];
        front_1009 = (front_1009 + 1) % capacity_1009;
        size_1009--;
        return item_1009;
    }

    // Menampilkan seluruh isi antrian
    void display_1009() {
        if (isEmpty_1009()) {
            System.out.println("Antrian kosong!");
            return;
        }
        System.out.println("Isi Antrian:");
        int idx = front_1009;
        for (int i = 0; i < size_1009; i++) {
            System.out.println((i + 1) + ". " + array_1009[idx]);
            idx = (idx + 1) % capacity_1009;
        }
    }

    // Membalik isi antrian
    // 1. Pindahkan semua elemen dari queue ke stack (gunakan dequeueSilent)
    // 2. Pindahkan semua elemen dari stack ke queue (gunakan enqueueSilent)
    void reverse_1009() {
        if (isEmpty_1009()) {
            System.out.println("Antrian kosong! Tidak bisa dibalik.");
            return;
        }

        Stack<String> stack_1009 = new Stack<>();
        
        // Langkah 1: Queue → Stack
        while (!isEmpty_1009()) {
            stack_1009.push(dequeueSilent_1009());
        }
        
        // Langkah 2: Stack → Queue
        while (!stack_1009.isEmpty()) {
            enqueueSilent_1009(stack_1009.pop());
        }
        
        System.out.println("Antrian berhasil dibalik.");
    }
}