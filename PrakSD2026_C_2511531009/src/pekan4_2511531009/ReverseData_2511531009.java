package pekan4_2511531009;
import java.util.*;
public class ReverseData_2511531009 {

	public static void main(String[] args) {
		Queue<Integer> q_1009 = new LinkedList<Integer>();
		q_1009.add(1);
		q_1009.add(2);
		q_1009.add(3); // [1, 2, 3]
		
		System.out.println("sebelum reverse " + q_1009);
		Stack<Integer> s_1009 = new Stack<Integer>();
		while (!q_1009.isEmpty()) { // Q -> S
			s_1009.push(q_1009.remove());
		}
		
		while (!s_1009.isEmpty()) { // S -> Q
			q_1009.add(s_1009.pop());
		}
		
		System.out.println("sebelum reverse " + q_1009);

	}

}
