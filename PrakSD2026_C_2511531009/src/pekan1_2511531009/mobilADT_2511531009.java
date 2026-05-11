package pekan1_2511531009;

public final class mobilADT_2511531009 {
    String nama, merk;
    int tahun, harga, cc;

    public mobilADT_2511531009(String nama, int tahun, int cc, int harga, String merk) {
        this.nama = nama;
        this.tahun = tahun;
        this.cc = cc;
        this.harga = harga;
        this.merk = merk;
    }

    // Setters
    public void setNama(String nama)  { this.nama = nama; }
    public void setTahun(int tahun)   { this.tahun = tahun; }
    public void setCC(int cc)         { this.cc = cc; }
    public void setHarga(int harga)   { this.harga = harga; }
    public void setMerk(String merk)  { this.merk = merk; }

    // Getters
    public String getNama()  { return nama; }
    public int getTahun()    { return tahun; }
    public int getCC()       { return cc; }
    public int getHarga()    { return harga; }
    public String getMerk()  { return merk; }

    private static int length = 0;
    private static mobilADT_2511531009[] garasi = new mobilADT_2511531009[0];

    public static void tambahMobil(mobilADT_2511531009 mobil) {
        length++;
        mobilADT_2511531009[] tGarasi = new mobilADT_2511531009[length];
        for (int i = 0; i < length - 1; i++) {
            tGarasi[i] = garasi[i];
        }
        tGarasi[length - 1] = mobil;
        garasi = tGarasi;
    }

    public static void hapusMobil(int index) {
        // ✅ Bug 2 fixed: use i, not index
        for (int i = index; i < length - 1; i++) {
            garasi[i] = garasi[i + 1];
        }
        length--;
        mobilADT_2511531009[] temp = new mobilADT_2511531009[length];
        // ✅ Bug 3 fixed: start from 0, not index
        for (int i = 0; i < length; i++) {
            temp[i] = garasi[i];
        }
        garasi = temp;
    }

    // ✅ Bug 1 fixed: correct format string
    @Override
    public String toString() {
        return String.format("Nama: %s, Merk: %s, Tahun: %d, CC: %d, Harga: %d",
                             nama, merk, tahun, cc, harga);
    }
}