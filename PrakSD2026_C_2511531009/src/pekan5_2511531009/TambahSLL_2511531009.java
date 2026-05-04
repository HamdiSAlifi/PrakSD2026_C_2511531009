package pekan5_2511531009;

public class TambahSLL_2511531009 {
	public static NodeSLL_2511531009 insertAtFront_1009(NodeSLL_2511531009 head_1009, int value_1009) {
		NodeSLL_2511531009 new_node_1009 = new NodeSLL_2511531009(value_1009);
		new_node_1009.next_1009 = head_1009;
		return new_node_1009;
	}
	
	// adds node in the end funct
	public static NodeSLL_2511531009 insertAtEnd_1009(NodeSLL_2511531009 head_1009, int value_1009) {
		// create node with a value
		NodeSLL_2511531009 newNode_1009 = new NodeSLL_2511531009(value_1009);
		
		// if list isEmpty, then node ecomes head
		if (head_1009 == null) {
			return newNode_1009;
		}
		
		// store head to temp. var.
		NodeSLL_2511531009 last_1009 = head_1009;
		// find to the last node
		while (last_1009.next_1009 != null) {
			last_1009 = last_1009.next_1009;
		}
		
		// change the pointer
		last_1009.next_1009 =  newNode_1009;
		return head_1009;
	}
	static NodeSLL_2511531009 getNode_1009(int data_1009) {
		return new NodeSLL_2511531009(data_1009);
	}
	
	static NodeSLL_2511531009 insertPos_1009(NodeSLL_2511531009 headNode_1009, int pos_1009, int val_1009) {
		NodeSLL_2511531009 head_1009 = headNode_1009;
		if (pos_1009 < 1) {
			System.out.println("Invalid position.");
		}
		if (pos_1009 == 1) {
			NodeSLL_2511531009 new_node_1009 = new NodeSLL_2511531009(val_1009);
			new_node_1009.next_1009 = head_1009;
			return new_node_1009;
		} else {
			while (pos_1009-- != 0) {
				if (pos_1009 == 1) {
					NodeSLL_2511531009 newNode_1009 = getNode_1009(val_1009);
					newNode_1009.next_1009 = headNode_1009.next_1009;
					headNode_1009.next_1009 = newNode_1009;
					break;
				}
				headNode_1009 = headNode_1009.next_1009;
			}
			if (pos_1009 != 1)
				System.out.println("Posisi di luar jangkauan");
		}
		return head_1009;
	}
	public static void printList_1009(NodeSLL_2511531009 head_1009) {
		NodeSLL_2511531009 curr_1009 = head_1009;
		while (curr_1009.next_1009 != null) {
			System.out.print(curr_1009.data_1009 + "-->");
			curr_1009 = curr_1009.next_1009;
		}
		if (curr_1009.next_1009 == null) {
			System.out.print(curr_1009.data_1009);
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		// example linked list 2 -> 3 -> 5 -> 6
		NodeSLL_2511531009 head_1009 = new NodeSLL_2511531009(2);
		head_1009.next_1009 = new NodeSLL_2511531009(3);
		head_1009.next_1009.next_1009 = new NodeSLL_2511531009(5);
		head_1009.next_1009.next_1009.next_1009 = new NodeSLL_2511531009(6);
		
		// print original list
		System.out.print("Senarai berantai awal : ");
		printList_1009(head_1009);
		
		// adds new node to the head
		System.out.print("tambah 1 simpul di depan: ");
		int data_1009 = 1;
		head_1009 = insertAtFront_1009(head_1009, data_1009);
		
		// print updated list
		printList_1009(head_1009);
		
		// adds new node to the end
		System.out.print("tambah 1 simpul di belakang: ");
		int data2_1009 = 7;
		head_1009 = insertAtEnd_1009(head_1009, data2_1009);
		
		// print updated list
		printList_1009(head_1009);
		
		System.out.print("tambah 1 simpul ke data 4: ");
		int data3_1009 = 4 ; 
		int pos_1009 = 4 ; 
		head_1009 = insertPos_1009(head_1009, pos_1009, data3_1009);
		
		// print updated list
		printList_1009(head_1009);
	}
}
