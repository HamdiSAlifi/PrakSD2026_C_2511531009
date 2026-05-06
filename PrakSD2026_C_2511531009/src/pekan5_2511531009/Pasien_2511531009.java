package pekan5_2511531009;

public class Pasien_2511531009 {
	
	// Atribut
	String namaPasien_1009;
	String keluhan_1009;
	int nomorAntrian_1009;
	
	// pointer ngab
	Pasien_2511531009 next_1009;	
	
	// Constructor
	public Pasien_2511531009(String nP_1009, String kel_1009, int noAnt_1009) {
		this.namaPasien_1009	= nP_1009;
		this.keluhan_1009		= kel_1009;
		this.nomorAntrian_1009	= noAnt_1009;
		this.next_1009			= null;
	}
	
	// Getterssssssssssssss
	public String getNamaPasien_1009() {
		return namaPasien_1009;
	}
	
	public String getKeluhan_1009() {
		return keluhan_1009;
	}
	
	public int getNomorAntrian_1009() {
		return nomorAntrian_1009;
	}
	
	// Setterssssssssssssss
	public void setNamaPasien_1009(String namaPasien_1009) {
		this.namaPasien_1009 = namaPasien_1009;
	}
	
	public void setKeluhan_1009(String keluhan_1009) {
		this.keluhan_1009 = keluhan_1009;
	}
}
