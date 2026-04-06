package pekan1_2511531009;

public class JamDriver_2511531009 {

	public static void main(String[] args) {
		Jam_2511531009 a = new Jam_2511531009(23, 59, 50);
		Jam_2511531009 b = new Jam_2511531009(0, 0, 15);
		System.out.println("a		 = " + a);
		System.out.println("b		 = " + b);
		System.out.println("a+b		 = " + a.plus(b));
		System.out.println("next 20s = " + a.nextSecond(20));
		System.out.println("durasi(a,b)	= " + Jam_2511531009.durasiDetik(a, b));
		System.out.println("a.compareTo(b)	= " + a.compareTo(b));
	}

}