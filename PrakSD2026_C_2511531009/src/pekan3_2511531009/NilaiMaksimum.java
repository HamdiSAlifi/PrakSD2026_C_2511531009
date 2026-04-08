package pekan3_2511531009;

import java.util.Stack;

public class NilaiMaksimum {

	public static int max(Stack<Integer> s_1009) {
		Stack<Integer> backup_1009= new Stack<Integer>();
		
		int maxValue_1009 = s_1009.pop();
		backup_1009.push(maxValue_1009);
		
		while (!s_1009.isEmpty()) {
			int next = s_1009.pop();
			backup_1009.push(next);
			maxValue_1009 = Math.max(maxValue_1009, next);
			
		}
		while (!backup_1009.isEmpty()) {
			s_1009.push(backup_1009.pop());
			
		}
		return maxValue_1009;
	}
	
	public static void main(String[] args) {
		Stack<Integer> s_1009 = new Stack<Integer>();
		s_1009.push(70);
		s_1009.push(12);
		s_1009.push(20);
		System.out.println("isi stack " + s_1009);
		System.out.println("Stack Teratas " + s_1009.peek());
		System.out.println("Nilai maximum " + max(s_1009));

	}

}
