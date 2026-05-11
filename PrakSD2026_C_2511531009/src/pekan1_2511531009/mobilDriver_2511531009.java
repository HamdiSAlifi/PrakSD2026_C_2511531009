package pekan1_2511531009;

public class mobilDriver_2511531009 {

	public static void main(String[] args) {
		mobilADT_2511531009 m1 = new mobilADT_2511531009("Bugatti Veyron",
				2005, 7993, 1000000, "Buggati");
		mobilADT_2511531009 m2 = new mobilADT_2511531009("Lamborgini Galardo",
				2004, 88890, 1500000, "Lamborgini");
		mobilADT_2511531009 m3 = new mobilADT_2511531009("Esemka",
				2019, 6686, 19000000, "Oslo Manufacturer");
		
		mobilADT_2511531009.tambahMobil(m1);
		mobilADT_2511531009.tambahMobil(m2);
		mobilADT_2511531009.tambahMobil(m3);
		
		System.out.println("a		 = " + m1);
		System.out.println("b		 = " + m2);
		System.out.println("c		 = " + m3);
		
	}

}