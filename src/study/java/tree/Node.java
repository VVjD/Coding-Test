package study.java.tree;

//default: 동일한 패키지 내에서만 접근 가능
class Node {
	String data;
	Node left;
	Node right;

	public Node(String data, Node left, Node right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}
	
}
