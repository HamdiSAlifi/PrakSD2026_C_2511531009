package pekan3_2511531009;

public class Website_2511531009 {
	String judulWebsite_1009;
	String url_1009;
	
	// Constructors
	Website_2511531009(String jW_1009, String u_1009) {
		this.judulWebsite_1009	= jW_1009;
		this.url_1009 			= u_1009;
	}
	
	// Selectors	(Getter)
		public String getJudulWebsite_1009() {
			return judulWebsite_1009;
		}
		
		public String getURL_1009() {
			return url_1009;
		}
		
		// Mutator	(Setter)
		public void setJudulLagu_1009(String jW_1009) {
			this.judulWebsite_1009 = jW_1009;
		}
		
		public void setPenyanyi_1009(String u_1009) {
			this.url_1009 = u_1009;
		}
		
		@Override
		public String toString() {
			return "Judul Website : " + judulWebsite_1009 +
					", URL Website : " + url_1009;
		}	
}
