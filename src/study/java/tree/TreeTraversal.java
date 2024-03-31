package study.java.tree;

import java.io.*;
import java.util.*;

//백준 1991번, 트리 순회
public class TreeTraversal {

	static Node node = new Node("A", null, null);

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer;

		int N = Integer.parseInt(reader.readLine()); // 이진 트리 노드의 개수
		// 트리 생성

		for (int i = 0; i < N; i++) {
			tokenizer = new StringTokenizer(reader.readLine());

			// 루트, 왼쪽 자식 노드, 오른쪽 자식 노드
			String root = tokenizer.nextToken();
			String left = tokenizer.nextToken();
			String right = tokenizer.nextToken();

			addNode(node, root, left, right);
		}

		preorder(node);
		System.out.println();
		inorder(node);
		System.out.println();
		postorder(node);

	}

	
	
	private static void addNode(Node node, String root, String left, String right) {
		if (node.data.equals(root)) {// 루트가 A인 경우
			if (left.equals(".")) {
				node.left = null;
			} else {
				node.left = new Node(left, null, null);
			}

			if (right.equals(".")) {
				node.right = null;
			} else {
				node.right = new Node(right, null, null);
			}
		} else {
			if (node.left != null) {
				addNode(node.left, root, left, right);
			}

			if (node.right != null) {
				addNode(node.right, root, left, right);
			}
		}
	} // addNode

	
	
	// 전위 순회
	public static void preorder(Node node) {
		if (node == null) {
			return;
		}

		System.out.print(node.data);
		preorder(node.left);
		preorder(node.right);
	} // preorder

	
	
	// 중위 순회
	public static void inorder(Node node) {
		if (node == null) {
			return;
		}

		inorder(node.left);
		System.out.print(node.data);
		inorder(node.right);
	} // inorder

	
	
	// 후위 순회
	public static void postorder(Node node) {
		if (node == null) {
			return;
		}

		postorder(node.left);
		postorder(node.right);
		System.out.print(node.data);
	} // postorder

	
	
	static class Node {
		String data;
		Node left;
		Node right;

		public Node(String data, Node left, Node right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}

	}

}
