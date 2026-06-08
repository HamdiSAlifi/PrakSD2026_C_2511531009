package pekan9_2511531009;

public class BTreeDriver_2511531009 {

	public static void main(String[] args) {
		
		BTree_2511531009 tree_1009 = new BTree_2511531009();
		System.out.print("Jumlah simpul awal pohon : ");
		System.out.println(tree_1009.countNodes_1009());
		
		Node_2511531009 root_1009 = new Node_2511531009(1);
		
		tree_1009.setRoot_1009(root_1009);
		
		System.out.print("Jumlah simpul jika hanya ada root : ");
		System.out.println(tree_1009.countNodes_1009());
		
		Node_2511531009 node2_1009 = new Node_2511531009(2);
		Node_2511531009 node3_1009 = new Node_2511531009(3);
		Node_2511531009 node4_1009 = new Node_2511531009(4);
		Node_2511531009 node5_1009 = new Node_2511531009(5);
		Node_2511531009 node6_1009 = new Node_2511531009(6);
		Node_2511531009 node7_1009 = new Node_2511531009(7);
		Node_2511531009 node8_1009 = new Node_2511531009(8);
		Node_2511531009 node9_1009 = new Node_2511531009(9);
		
		root_1009.setLeft_1009(node2_1009);
		node2_1009.setLeft_1009(node4_1009);
		node2_1009.setRight_1009(node5_1009);
		node4_1009.setRight_1009(node8_1009);
		
		root_1009.setRight_1009(node3_1009);
		
		node3_1009.setLeft_1009(node6_1009);
		node3_1009.setRight_1009(node7_1009);
		
		node6_1009.setLeft_1009(node9_1009);
		
		
		tree_1009.setCurrent(tree_1009.getRoot_1009());
		System.out.print("menampilkan simpul terakhir : ");
		System.out.println(tree_1009.getCurrent_1009().getData_1009());
		System.out.print("Jumlah simpul; setelah simpul 7 ditambahkan : ");
		System.out.println(tree_1009.countNodes_1009());
		System.out.print("Inorder : ");
		tree_1009.printInorder_1009();
		System.out.println();
		System.out.print("Preorder : ");
		tree_1009.printPreorder_1009();
		System.out.println();
		System.out.print("Postorder : ");
		tree_1009.printPostorder_1009();
		System.out.println();
		System.out.println("\nMenampilkan simpul dalam bentuk pohon");
		tree_1009.print_1009();
		
		
	}
}