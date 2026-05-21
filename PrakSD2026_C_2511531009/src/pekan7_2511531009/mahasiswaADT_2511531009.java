package pekan7_2511531009;

public class mahasiswaADT_2511531009 {

	String nama_1009;
	String nim_1009;
	String prodi_1009;
	
	// Constructor
	public mahasiswaADT_2511531009(String nama_1009, String nim_1009, String prodi_1009) {
		this.nama_1009 = nama_1009;
		this.nim_1009 = nim_1009;
		this.prodi_1009 = prodi_1009;
	}
	
	// Getter
	public String getNama_1009() {
		return nama_1009;
	}
	
	public String getNIM_1009() {
		return nim_1009;
	}
	
	public String getProdi_1009() {
		return prodi_1009;
	}
	
	// Setter
	public void setNama_1009(String nama_1009) {
		this.nama_1009 = nama_1009;
	}
	
	public void setNIM_1009(String nim_1009) {
		this.nim_1009 = nim_1009;
	}
	
	public void setProdi_1009(String prodi_1009) {
		this.prodi_1009 = prodi_1009;
	}
	
	@Override
	public String toString() {
		return nama_1009;
	}
}
