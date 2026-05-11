package pekan6_2511531009;

public class insertDLL_2511531009 {
	
	// menambahkan node di awal DLL
	static NodeDLL_2511531009 insertBegin_1009(NodeDLL_2511531009 head_1009, int data_1009) {
		
		// new node
		NodeDLL_2511531009 new_node_1009 = new NodeDLL_2511531009(data_1009);
		new_node_1009.next_1009 = head_1009; // link new node to old head
		if (head_1009 != null) {
		    head_1009.prev_1009 = new_node_1009;
		}
		return new_node_1009;
	}
	// func :  add node at end
	public static NodeDLL_2511531009 insertEnd_1009(NodeDLL_2511531009 head_1009, int newData_1009) {
		
		// new mode
		NodeDLL_2511531009 newNode_1009 = new NodeDLL_2511531009(newData_1009);
		
		// DLL := null => head
		if (head_1009 == null) {
			head_1009 = newNode_1009;
		}
		else {
			NodeDLL_2511531009 curr_1009 = head_1009;
			while (curr_1009.next_1009 != null) {
				curr_1009 = curr_1009.next_1009;
			}
			curr_1009.next_1009 = newNode_1009;
			newNode_1009.prev_1009 = curr_1009;
		}
		return head_1009;
	} 
	
	//	func : add node in certain position
	public static NodeDLL_2511531009 insertAtPosition(NodeDLL_2511531009 head_1009, int pos_1009, int newData_1009) {
		
		// newNode
		NodeDLL_2511531009 newNode_1009 = new NodeDLL_2511531009(newData_1009);
		if (pos_1009 == 1) {
			newNode_1009.next_1009 = head_1009;
			if (head_1009 != null) {
				head_1009.prev_1009 = newNode_1009;
			}
			head_1009 = newNode_1009;
			return head_1009;
		}
		NodeDLL_2511531009 curr_1009 = head_1009;
		
		for (int i_1009 = 1; i_1009 < pos_1009 - 1 && curr_1009 != null; ++i_1009) {
			curr_1009 = curr_1009.next_1009;
		}
		if (curr_1009 == null) {
			System.out.println("Posisi tidak ada");
			return head_1009;
		}
		newNode_1009.prev_1009 = curr_1009;
		newNode_1009.next_1009 = curr_1009.next_1009;
		curr_1009.next_1009 = newNode_1009;
		if (newNode_1009.next_1009 != null) {
			newNode_1009.next_1009.prev_1009 = newNode_1009;
		}
		return head_1009;
	}
	
	public static void printList_1009(NodeDLL_2511531009 h_1009) {
		NodeDLL_2511531009 c_1009 = h_1009;
		while (c_1009 != null) {
			System.out.print(c_1009.data_1009 + " <-> ");
			c_1009 = c_1009.next_1009;
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		
		// membuat dll 2 <-> 3 <-> 5
		NodeDLL_2511531009 head_1009 =new NodeDLL_2511531009(2);
		head_1009.next_1009 = new NodeDLL_2511531009(3);
		head_1009.next_1009.prev_1009 = head_1009;
		head_1009.next_1009.next_1009 = new NodeDLL_2511531009(5);
		head_1009.next_1009.next_1009.prev_1009 = head_1009.next_1009;
		
		// cetak DLL awal
		System.out.print("DLL Awal : ");
		printList_1009(head_1009);
		
		// add 1 in the start/at the head
		head_1009 = insertBegin_1009(head_1009, 1);
		System.out.print("simpul 1 ditambah di awal : ");
		printList_1009(head_1009);
		
		// add 6 at the end
		System.out.print("simpul 1 ditambah di akhir : ");
		int data_1009 = 6;
		head_1009 = insertEnd_1009(head_1009, data_1009);
		printList_1009(head_1009);
		
		// add node 4 in pos 4
		System.out.print("tambah node 4 di posisi 4 : ");
		int data2_1009 = 4;
		int pos_1009 = 4;
		head_1009 = insertAtPosition(head_1009, pos_1009, data2_1009);
		printList_1009(head_1009);
	}
}
