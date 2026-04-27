package pekan4_2511531009;
import java.util.*;
public class IterasiQueue_2511531009 {

	public static void main(String[] args) {
		Queue<String> q_1009 = new LinkedList<>();
		
		q_1009.add("Praktikum");
		q_1009.add("Struktur");
		q_1009.add("Data");
		q_1009.add("dan");
		q_1009.add("Algoritma");
		
		Iterator<String> ite_1009 = q_1009.iterator();
		while (ite_1009.hasNext()) {
			System.out.print(ite_1009.next() + " ");
		}
	}

}
