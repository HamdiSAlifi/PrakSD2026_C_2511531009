package pekan6_2511531009;

import java.util.Iterator;

public class HapusDLL_2511531009 {
	
	// func : delete node at head
	public static NodeDLL_2511531009 delHead_1009(NodeDLL_2511531009 head_1009) {
		if (head_1009 == null) {
			return null;
		}
		NodeDLL_2511531009 temp_1009 = head_1009;
		head_1009 = head_1009.next_1009;
		if (head_1009 != null) {
			head_1009.prev_1009 = null;
		}
		return head_1009;
	}
	
	// func : delete node at the end
	public static NodeDLL_2511531009 delLast_1009(NodeDLL_2511531009 head_1009) {
		if (head_1009 == null) {
			return null;
		}
		if (head_1009.next_1009 == null) {
			return null;
		}
		NodeDLL_2511531009 curr_1009 = head_1009;
		while (curr_1009.next_1009 != null) {
			curr_1009 = curr_1009.next_1009;
		}
		// update previous node pointer
		if (curr_1009.prev_1009 != null) {
			curr_1009.prev_1009.next_1009 = null;
		}
		return head_1009;
	}
	
	// func :  delete at certain position
	public static NodeDLL_2511531009 delPos_1009(NodeDLL_2511531009 head_1009, int pos_1009) {
		// DLL isEmpty return value
		if (head_1009 == null) {
			return head_1009;
		}
		NodeDLL_2511531009 curr_1009 = head_1009;
		
		// transverse until node taht will be deleted
		for (int i_1009 = 1; curr_1009 != null && i_1009 < pos_1009; ++i_1009) {
			curr_1009 = curr_1009.next_1009;
		}
		
		// if the pos unsearchable
		if (curr_1009 == null) {
			return head_1009;
		}
		
		// Update pointer
		if (curr_1009.prev_1009 != null) {
			curr_1009.prev_1009.next_1009 = curr_1009.next_1009;
		}
		if (curr_1009.next_1009 != null) {
			curr_1009.next_1009.prev_1009 = curr_1009.prev_1009;
		}
		
		// if head want to be deleted
		if (head_1009 == curr_1009) {
			head_1009 = curr_1009.next_1009;
		}
		return head_1009;
	}
	
	// func : print DLL
	public static void printList(NodeDLL_2511531009 head_1009) {
		NodeDLL_2511531009 curr_1009 = head_1009;
		while (curr_1009 != null) {
			System.out.print(curr_1009.data_1009 + " ");
			curr_1009 = curr_1009.next_1009;
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		// create a DLL
		NodeDLL_2511531009 head_1009 = new NodeDLL_2511531009(1);
		head_1009.next_1009 = new NodeDLL_2511531009(2);
		head_1009.next_1009.prev_1009 = head_1009;
		head_1009.next_1009.next_1009 = new NodeDLL_2511531009(3);
		head_1009.next_1009.prev_1009 = head_1009.next_1009;
		head_1009.next_1009.next_1009.next_1009 = new NodeDLL_2511531009(4);
		head_1009.next_1009.next_1009.prev_1009 = head_1009.next_1009;
		head_1009.next_1009.next_1009.next_1009.next_1009 = new NodeDLL_2511531009(5);
		head_1009.next_1009.next_1009.next_1009.next_1009.prev_1009 = head_1009.next_1009.next_1009.next_1009;
		
		System.out.print("DLL awal : ");
		printList(head_1009);
		
		System.out.print("Setelah head dihapus : ");
		head_1009 = delHead_1009(head_1009);
		printList(head_1009);
		
		System.out.print("Setelah last node dihapus : ");
		head_1009 = delLast_1009(head_1009);
		printList(head_1009);
		
		System.out.print("hapus node ke 2 : ");
		head_1009 = delPos_1009(head_1009, 2);
		printList(head_1009);
		
		
		
		
	}
}
