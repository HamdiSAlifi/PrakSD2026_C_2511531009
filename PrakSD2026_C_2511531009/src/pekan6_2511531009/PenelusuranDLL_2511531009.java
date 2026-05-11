package pekan6_2511531009;

public class PenelusuranDLL_2511531009 {
	
	// func : forward search
	static void forwardTraversal_1009(NodeDLL_2511531009 head_1009) {
		// start search from head
		NodeDLL_2511531009 curr_1009 = head_1009;
		
		// continue search until end
		while (curr_1009 != null) {
			// print data
			System.out.print(curr_1009.data_1009 + " <-> ");
			
			// mode to next node
			curr_1009 = curr_1009.next_1009;
		}
		// print a line
		System.out.println();
	}
	// func : backward search
	static void backwardTraversal_1009(NodeDLL_2511531009 tail_1009) {
		// start search from the end
		NodeDLL_2511531009 curr_1009 = tail_1009;
		
		// continue until the head
		while (curr_1009 != null) {
			// print data
			System.out.print(curr_1009.data_1009 + " <-> ");
			
			// move to prev node
			curr_1009 = curr_1009.prev_1009;
		}
		// print a line
		System.out.println();
	}
	
	public static void main(String[] args) {
		// print DLLs
		NodeDLL_2511531009 head_1009 = new NodeDLL_2511531009(1);
		NodeDLL_2511531009 second_1009 = new NodeDLL_2511531009(2);
		NodeDLL_2511531009 third_1009 = new NodeDLL_2511531009(3);
		
		head_1009.next_1009 = second_1009;
		second_1009.prev_1009 = head_1009;
		second_1009.next_1009 = third_1009;
		third_1009.prev_1009 = second_1009;
		
		System.out.println("Penelusuran Maju : ");
		forwardTraversal_1009(head_1009);
		
		System.out.println("Penelusuran Mundur : ");
		backwardTraversal_1009(third_1009);
	}
}
