package pekan6_2511531009;

public class Lagu_2511531009 {

	// --- Atribut ---
	private String judul_1009;
	private String penyanyi_1009;
	Lagu_2511531009 next_1009; // pointer ke node berikutnya
	Lagu_2511531009 prev_1009; // pointer ke node sebelumnya

	// --- Constructor ---
	public Lagu_2511531009(String judul_1009, String penyanyi_1009) {
	    this.judul_1009    = judul_1009;
	    this.penyanyi_1009 = penyanyi_1009;
	    this.next_1009     = null;
	    this.prev_1009     = null;
	}

	 // --- Getter (Selektor) ---
	 public String getJudul_1009() { 
		 return judul_1009; 
	}
	 
	 public String getPenyanyi_1009() { 
		 return penyanyi_1009; 
	}
	
	 // --- Setter (Mutator) ---
	public void setJudul_1009(String judul_1009) { 
		 this.judul_1009    = judul_1009; 
	}
	
	public void setPenyanyi_1009(String penyanyi_1009) { 
		this.penyanyi_1009 = penyanyi_1009; 
	}
	 
}