package pekan9_2511531009;

public class Node_2511531009 {
	int data_1009;
	Node_2511531009 left_1009;
	Node_2511531009 right_1009;
	public Node_2511531009 (int data_1009) {
		this.data_1009 = data_1009;
		left_1009 = null;
		right_1009 = null;
		}
	public void setLeft_1009 (Node_2511531009 node_1009) {
		if (left_1009 == null)
			left_1009 = node_1009;
	}
	public void setRight_1009 (Node_2511531009 node_1009) {
		if (right_1009 == null)
			right_1009 = node_1009;
	}
	public Node_2511531009 getLeft_1009 () {
		return left_1009;
	}
	public Node_2511531009 getRight_1009 () {
		return right_1009;
	}
	public int getData_1009 () {
		return data_1009;
	}
	public void setData_1009 (int data_1009) {
		this.data_1009 = data_1009;
	}
	void printPreorder_1009 (Node_2511531009 node_1009) {
		if (node_1009 == null)
			return;
		System.out.print(node_1009.data_1009 + " ");
		printPreorder_1009 (node_1009.left_1009);
		printPreorder_1009 (node_1009.right_1009);
	}
	void printPostorder_1009 (Node_2511531009 node_1009) {
		if (node_1009 == null)
			return;
		printPostorder_1009 (node_1009.left_1009);
		printPostorder_1009 (node_1009.right_1009);
		System.out.print(node_1009.data_1009 + " ");
	}
	void printInorder_1009 (Node_2511531009 node) {
		if (node == null)
			return;
		printInorder_1009 (node.left_1009);
		System.out.print(node.data_1009 + " ");
		printInorder_1009 (node.right_1009);
			
	}
	public String print_1009 () {
		return this.print_1009("", true, "");
	}
	public String print_1009 (String prefix_1009, boolean isTail_1009, String sb_1009) {
		if (right_1009 != null) {
			right_1009.print_1009(prefix_1009 +( isTail_1009 ? "|   ": "    "),false, sb_1009);
		}
		System.out.println(prefix_1009+(isTail_1009 ? "\\--" : "/--")+data_1009);
		if (left_1009 != null) {
			left_1009.print_1009(prefix_1009 +(isTail_1009 ? "    ": "|   "),true, sb_1009);
		}
		return sb_1009;
	}

}