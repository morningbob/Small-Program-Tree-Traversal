import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TreeTraversal {
	
	List<Node> tree = new ArrayList<Node>();
	List<Node> route = new ArrayList<Node>();
	
	public class Node{
		int mKey;
		int mLeftChild;
		int mRightChild;
		
		public Node(int key, int left, int right) {
			mKey = key;
			mLeftChild = left;
			mRightChild = right;
		}
	}
	
	public void preOrderTraversal(Node nodeToTraverse){
		
		route.add(nodeToTraverse);
		if (nodeToTraverse.mLeftChild >= 0) {
			preOrderTraversal(tree.get(nodeToTraverse.mLeftChild));
		}
		if (nodeToTraverse.mRightChild >= 0) {
		preOrderTraversal(tree.get(nodeToTraverse.mRightChild));
		}
	}
	
	public void inOrderTraversal(Node nodeToTraverse){
		if (nodeToTraverse.mLeftChild >= 0) {
			inOrderTraversal(tree.get(nodeToTraverse.mLeftChild));
		}
		
		route.add(nodeToTraverse);
		if (nodeToTraverse.mRightChild >= 0) {
			inOrderTraversal(tree.get(nodeToTraverse.mRightChild));
		}
		
	}
	
	public void postOrderTraversal(Node nodeToTraverse){
		if (nodeToTraverse.mLeftChild >= 0) {
			postOrderTraversal(tree.get(nodeToTraverse.mLeftChild));
		}
		if (nodeToTraverse.mRightChild >= 0) {
			postOrderTraversal(tree.get(nodeToTraverse.mRightChild));
		}
		
		route.add(nodeToTraverse);
	}
	
	public static void main(String[] args) throws IOException {
		// create the binary search tree
		// [key, left, right, key left, right...]
		// [node 0, node 1, node 2,...]
		// the first key is the root, which is node 0
		new TreeTraversal().run();
		
		
	}
	public void run() throws IOException {
		int[] putNodesListHere = {};
		for (int i=0; i<putNodesListHere.length; i+=3) {
			Node node = new Node(putNodesListHere[i],putNodesListHere[i+1],putNodesListHere[i+2]);
			tree.add(node);
		}
		// amend the method of traversal here
		inOrderTraversal(tree.get(0));
		for (Node node : route) {
			System.out.print(" "+node.mKey+" ");
		}
	}
	
}
