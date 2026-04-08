package pekan3_2511531009;

public class stackArray_2511531009 {
	static final int MAX_1009 = 1000;
	int top_1009;
	int a_1009[] = new int[MAX_1009];
	boolean isEmpty_1009() {
		return (top_1009 < 0);
	}
	
	stackArray_2511531009() {
		top_1009 = -1;
	}
	
	boolean push_1009(int x)	{
		if (top_1009 >= (MAX_1009 - 1)) {
			System.out.println("Stack overflow");
			return false;
		} else {
			a_1009[++top_1009] = x;
			System.out.printf("%d dimasukkan dalam stack%n", x);
			return true;
		}
	}
	
	int pop_1009() {
		if (top_1009 < 0) {
			System.out.println("Stack Underflow");
			return 0;
		} else {
			int x = a_1009[top_1009--];
			return x;
		}
	}
	
	int peek_1009() {
		if (top_1009 < 0) {
			System.out.println("Stack Underflow");
			return 0;
		} else {
			int x = a_1009[top_1009];
			return x;
		}
	}
	
	void print_1009() {
		for(int i_1009 = top_1009; i_1009 > -1 ; i_1009--) {
			System.out.print(" " + a_1009[i_1009]);
		}
	}
}
