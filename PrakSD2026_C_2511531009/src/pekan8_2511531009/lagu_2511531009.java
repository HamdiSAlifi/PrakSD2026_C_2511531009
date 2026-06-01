package pekan8_2511531009;

public class lagu_2511531009 {
    // Atribut
    private String judul_1009;
    private String penyanyi_1009;
    private int durasi_1009;

    // Constructor
    public lagu_2511531009(String judul_1009, String penyanyi_1009, int durasi_1009) {
        this.judul_1009 = judul_1009;
        this.penyanyi_1009 = penyanyi_1009;
        this.durasi_1009 = durasi_1009;
    }

    // Getter
    public String getJudul_1009() { return judul_1009; }
    public String getPenyanyi_1009() { return penyanyi_1009; }
    public int getDurasi_1009() { return durasi_1009; }

    // Setter
    public void setJudul_1009(String judul_1009) { this.judul_1009 = judul_1009; }
    public void setPenyanyi_1009(String penyanyi_1009) { this.penyanyi_1009 = penyanyi_1009; }
    public void setDurasi_1009(int durasi_1009) { this.durasi_1009 = durasi_1009; }

    // toString Override
    @Override
    public String toString() {
        return judul_1009 + " - " + penyanyi_1009 + " - " + durasi_1009 + " detik";
    }
}
