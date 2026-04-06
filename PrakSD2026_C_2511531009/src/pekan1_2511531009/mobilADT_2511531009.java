package pekan1_2511531009;

public final class mobilADT_2511531009 {
	String nama, merk;
	int  tahun, harga, cc;
	
	// constructor
	public mobilADT_2511531009(String nama, int tahun,int cc, int harga, String merk) {
		this.nama =  nama;
		this.tahun =  tahun;
		this.cc =  cc;
		this.harga =  harga;
		this.merk =  merk;
		
	}
	// setter
	public void setNama(String nama) {
		this.nama = nama;
	}
	public void setTahun(int tahun) {
		this.tahun = tahun;
	}
	public void setCC(int cc) {
		this.cc = cc;
	}
	public void setHarga(int harga) {
		this.harga = harga;
	}
	public void setMerk(String merk) {
		this.merk = merk;
	}
	// getter
	public String getNama() {
		return nama;
	}
	public int getTahun() {
		return tahun;
	}
	public int getCC() {
		return cc;
	}
	public int getHarga() {
		return harga;
	}
	public String getMerk() {
		return merk;
	}
	
	private static int length = 0;
	private static mobilADT_2511531009[] garasi = new mobilADT_2511531009[0];
	
	// tambah mobil
	public static void tambahMobil(mobilADT_2511531009 mobil) {
		length++;
		
		mobilADT_2511531009[] tGarasi = new mobilADT_2511531009[length];
		
		tGarasi[length - 1] = mobil;
		
		for (int i = 0 ; i < length - 1; i++) {
			tGarasi[i] = garasi[i];
		}
		
		garasi = tGarasi;
	}
	
	// hapus mobil
	public static void hapusMobil(int index) {
		mobilADT_2511531009[] temp = new mobilADT_2511531009[length - 1];
		
		for (int i = index; i < length - 1; i++) {
			garasi[index] = garasi[index+1];
		}
		
		length--;
		for (int i = index; i < length; i++) {
			temp[i] = garasi[i];
		}
		
		garasi = temp;
	}
	
}
