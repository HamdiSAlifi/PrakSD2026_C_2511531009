package pekan9_2511531009;

public class BTree_2511531009 {
	private Node_2511531009 root_1009;
	private Node_2511531009 currentNode_1009;
	public BTree_2511531009 () {
		root_1009 = null;
	}
	public boolean search_1009 (int data_1009) {
		return search_1009 (root_1009, data_1009);
	}
	private boolean search_1009 (Node_2511531009 node_1009, int data_1009) {
		if (node_1009 == null)
			return false;
		if (node_1009.getData_1009() == data_1009)
			return true;
		if (search_1009(node_1009.getLeft_1009(), data_1009))
			return true;
		return search_1009(node_1009.getRight_1009(), data_1009);
	}
	public void printInorder_1009() {
		if (root_1009 != null)
			root_1009.printInorder_1009(root_1009);
	}
	public void printPreorder_1009() {
		if (root_1009 != null)
			root_1009.printPreorder_1009(root_1009);
	}
	public void printPostorder_1009() {
		if (root_1009 != null)
			root_1009.printPostorder_1009(root_1009);
	}
	
	public Node_2511531009 getRoot_1009() {
		return root_1009;
	}
	
	public boolean isEmpty_1009 () {
		return root_1009 == null;
	}
	
	public int countNodes_1009() {
		return countNodes_1009 (root_1009);
	}
	
	private int countNodes_1009 (Node_2511531009 node_1009) {
		if (node_1009 == null) {
			return 0;
		} else {
			int count_1009 = 1;
			count_1009 += countNodes_1009 (node_1009.getLeft_1009());
			count_1009 += countNodes_1009 (node_1009.getRight_1009());
			return count_1009;
		}
	}
	
	public void print_1009 () {
		if (root_1009 != null)
			root_1009.print_1009();
	}
	
	public Node_2511531009 getCurrent_1009() {
		return currentNode_1009;
	}
	
	public void setCurrent (Node_2511531009 node_1009) {
		this.currentNode_1009 = node_1009;
	}
	
	public void setRoot_1009 (Node_2511531009 root_1009) {
		this.root_1009 = root_1009;
	}
	

}