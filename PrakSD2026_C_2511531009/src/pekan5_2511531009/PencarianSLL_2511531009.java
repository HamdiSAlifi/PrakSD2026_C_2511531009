package pekan5_2511531009;

public class PencarianSLL_2511531009 {
	
	static boolean searchKey_1009(NodeSLL_2511531009 head_1009, int key_1009) {
		NodeSLL_2511531009 curr_1009 = head_1009;
		while (curr_1009 != null) {
			if (curr_1009.data_1009 == key_1009)
				return true;
			curr_1009 = curr_1009.next_1009;					
		}
		return false;
	}
	
	public static void traversal_1009(NodeSLL_2511531009 head_1009) {
		// start from head
		NodeSLL_2511531009 curr_1009 = head_1009;
		
		// search until pointer == null
		while (curr_1009 != null) {
			System.out.print(" " + curr_1009.data_1009);
			curr_1009 = curr_1009.next_1009;
		}
		System.out.println("");
	}
	
	public static void main(String[] args) {
		NodeSLL_2511531009 head_1009 = new NodeSLL_2511531009(14);
		head_1009.next_1009 = new NodeSLL_2511531009(21);
		head_1009.next_1009.next_1009 = new NodeSLL_2511531009(13);
		head_1009.next_1009.next_1009.next_1009 = new NodeSLL_2511531009(30);
		head_1009.next_1009.next_1009.next_1009.next_1009 = new NodeSLL_2511531009(10);
		System.out.print("Penelusuran SLL : ");
		traversal_1009(head_1009);
		
		// data that will be searched
		int key_1009 = 30;
		System.out.print("cari data " + key_1009 + " = ");
		if (searchKey_1009(head_1009, key_1009))
			System.out.println("data ditemukan");
		else 
			System.out.println("data tidak ditemukan");
	}
}
