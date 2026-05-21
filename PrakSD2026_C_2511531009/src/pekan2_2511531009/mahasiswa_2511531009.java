package pekan2_2511531009;

public class mahasiswa_2511531009 {
	String nim;
	String nama;
	String prodi;
	mahasiswa_2511531009(String nim, String nama, String prodi) {
		this.nim = nim;
		this.nama = nama;
		this.prodi = prodi;
	}
	@Override
	public String toString() {
		return "NIM : " + nim + ", Nama : " + nama + ", Prodi : " + prodi;
	}
}
