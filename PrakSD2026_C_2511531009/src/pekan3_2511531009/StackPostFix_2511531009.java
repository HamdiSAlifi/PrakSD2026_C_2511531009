package pekan3_2511531009;
import java.util.*;
public class StackPostFix_2511531009 {
	public static int postfixEvaluate_1009(String expression) {
		Stack<Integer> s_1009 = new Stack<Integer>();
		Scanner ip_1009 = new Scanner(expression);
		
		while (ip_1009.hasNext() ) {
			if (ip_1009.hasNextInt())  {
				s_1009.push(ip_1009.nextInt());
			} else {
				String op = ip_1009.next();
				int oprnd2 = s_1009.pop();
				int oprnd1 = s_1009.pop();
				
				if (op.equals("+")) {
					s_1009.push(oprnd1 + oprnd2);
				}
				else if (op.equals("-")) {
					s_1009.push(oprnd1 - oprnd2);
				}
				else if (op.equals("*")) {
					s_1009.push(oprnd1 * oprnd2);
				}
				else {
					s_1009.push(oprnd1 / oprnd2);
				}
				
			}
		}
		ip_1009.close();
		return s_1009.pop();
	}
		
	public static void main(String[] args) {
		System.out.println("hasil postfix = " + postfixEvaluate_1009("5 2 4 * + 7 -"));
	}
}
