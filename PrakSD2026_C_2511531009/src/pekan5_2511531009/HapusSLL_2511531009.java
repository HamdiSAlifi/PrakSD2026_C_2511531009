package pekan5_2511531009;

public class HapusSLL_2511531009 {

	// funtion to delete head node
	public static NodeSLL_2511531009 deleteHead_1009(NodeSLL_2511531009 head_1009) {
		// if SLL is empty
		if (head_1009 == null)
			return null;
		
		// move to the next node
		head_1009 =	head_1009.next_1009;
		
		// return new head
		return head_1009;
	}
	
	// function to delete last node
	public static NodeSLL_2511531009 removeLastNode(NodeSLL_2511531009 head_1009) {
		// if the list is empty, return null value
		if (head_1009 == null) {
			return null;
		}
		
		//if list contains one node, delete node and return null
		if (head_1009.next_1009 == null) {
			return null;
		}
		
		// search second last node
		NodeSLL_2511531009 secondLast_1009 = head_1009;
		while (secondLast_1009.next_1009.next_1009 != null) {
			secondLast_1009 = secondLast_1009.next_1009;
		}
		
		// delete last node
		secondLast_1009.next_1009 = null;
		return head_1009;
	}
	
	// function to delete node in a certain position
	public static NodeSLL_2511531009 deleteNode_1009(NodeSLL_2511531009 head_1009, int pos_1009) {
		NodeSLL_2511531009 temp_1009 = head_1009;
		NodeSLL_2511531009 prev_1009 = null;
		
		// if linked list is null
		if (temp_1009 == null)
			return head_1009;
		
		// case 1 : head is deleted
		if (pos_1009 == 1) {
			head_1009 = temp_1009.next_1009;
			return head_1009;
		}
		
		// kasus 2 : menghapus node di tengah
		// search to the targeted node that will to be deleted
		for (int i_1009 = 1; temp_1009 != null && i_1009 < pos_1009; i_1009++) {
			prev_1009 = temp_1009;
			temp_1009 = temp_1009.next_1009;
		}
		// if founded, delete node
		if (temp_1009 != null) {
			prev_1009.next_1009 = temp_1009.next_1009;
		} else {
			System.out.println("Data tidak ditemukan");
		}
		return head_1009;		
	}
	
	// function to print SLL
	public static void printList_1009(NodeSLL_2511531009 head_1009) {
		NodeSLL_2511531009 curr_1009 = head_1009;
		while (curr_1009.next_1009 != null) {
			System.out.print(curr_1009.data_1009 + "-->");
			curr_1009 = curr_1009.next_1009;
		}
		if (curr_1009.next_1009 == null) {
			System.out.print(curr_1009.data_1009);
		}
		System.out.println();
	}
	
	// Driver/Main class
	public static void main(String[] args) {
		// Create SLL 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> null
		NodeSLL_2511531009 head_1009 = new NodeSLL_2511531009(1);
		head_1009.next_1009 = new NodeSLL_2511531009(2);
		head_1009.next_1009.next_1009 = new NodeSLL_2511531009(3);
		head_1009.next_1009.next_1009.next_1009 = new NodeSLL_2511531009(4);
		head_1009.next_1009.next_1009.next_1009.next_1009 = new NodeSLL_2511531009(5);
		head_1009.next_1009.next_1009.next_1009.next_1009.next_1009 = new NodeSLL_2511531009(6);
		
		// print early list
		System.out.println("list awal : ");
		printList_1009(head_1009);
		
		// delete head
		head_1009 = deleteHead_1009(head_1009);
		System.out.println("List setelah simpul terakhir di hapus : ");
		printList_1009(head_1009);
		
		// deleteing node at pos[2]
		int pos2_1009 = 2;
		head_1009 = deleteNode_1009(head_1009, pos2_1009);
		// print list after deletion
		System.out.println("List setelah posisi 2 dihapus : ");
		printList_1009(head_1009);
	}
}
