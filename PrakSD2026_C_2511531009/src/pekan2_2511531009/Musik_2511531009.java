package pekan2_2511531009;

public class Musik_2511531009 {
	String judulLagu_1009;
	String penyanyi_1009;
	String durasi_1009; // unit : sekon
	
	// Constructors
	Musik_2511531009(String jL_1009, String p_1009, String d_1009) {
		this.judulLagu_1009 = jL_1009;
		this.penyanyi_1009 	= p_1009;
		this.durasi_1009 	= d_1009;
	}
	
	// Selectors	(Getter)
	public String getJudulLagu_1009() {
		return judulLagu_1009;
	}
	
	public String getPenyanyi_1009() {
		return penyanyi_1009;
	}
	
	public String getDurasi_1009() {
		return durasi_1009;
	}
	
	// Mutator		(Setter)
	public void setJudulLagu_1009(String jL_1009) {
		this.judulLagu_1009 = jL_1009;
	}
	
	public void setPenyanyi_1009(String p_1009) {
		this.penyanyi_1009 = p_1009;
	}
	
	public void setDurasi_1009(String d_1009) {
		this.durasi_1009 = d_1009;
	}
	
	@Override
	public String toString() {
		return "Judul Lagu : " + judulLagu_1009 +
				", Penyanyi : " + penyanyi_1009 +
				", Durasi : " + durasi_1009 + " sekon";
	}
}
