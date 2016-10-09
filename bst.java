import java.util.*;
import java.util.LinkedList;

public class bst {
	// Node is created
	static class Node {
		int data;
		Node Lchild;
		Node Rchild;

		Node() {
			this.data = 0;
			this.Lchild = null;
			this.Rchild = null;
           }

		Node(int d) {
			this.data = d;
			this.Lchild = null;
			this.Rchild = null;
		}

	}
   // insertion function to insert the nodes in a BST
	public static void insert(int d, Node n) {
		if (root == null) {
			root = new Node();
			root.data = d;
		} else {
			if (d < n.data) {
				if (n.Lchild != null)
					insert(d, n.Lchild);
				else {
					Node temp = new Node();
					temp.data = d;
					n.Lchild = temp;
				}
			} else if (d> n.data) {
				if (n.Rchild != null)
					insert(d, n.Rchild);
				else {
					Node temp = new Node();
					temp.data = d;
					n.Rchild = temp;
				}
			}
		}

	}

	static Node n = null, root = null;
	// display using Breadth First Search
  public void bfs(Node root) {
		Queue<Node> q = new LinkedList<Node>();
		int count = 0;
		if (root == null)
			return;
		q.add(root);
		while (!q.isEmpty()) {
			Node n = (Node) q.remove();
			System.out.print(" " + n.data);

			if (n.Lchild != null) {

				q.add(n.Lchild);
			} else if (n.Rchild != null) {
				Node t1 = new Node(-1);
				count++;
				q.add(t1);
			}
			if (n.Rchild != null) {
				q.add(n.Rchild);
			} else if (n.Lchild != null) {
				Node t1 = new Node(-1);
				count++;
				q.add(t1);
			}

		}
		System.out.println("\n" + "the number of gaps :: " + count);
	}

	public Node delete(Node n, int data) {
		if (n.data < data) {
			n.Rchild = delete(n.Rchild, data);
		} else if (n.data > data) {
			n.Lchild = delete(n.Lchild, data);
		} else {
			if (n.Rchild == null) {
				return n.Lchild;
			}
			if (n.Lchild == null) {
				return n.Rchild;
			}
			Node temp = n;
			n = min(temp.Rchild);
			n.Rchild = deleteMin(temp.Rchild);
			n.Lchild = temp.Lchild;
		}
		return n;
	}

	private Node min(Node n) {
		if (n.Lchild == null) {
			return n;
		} else {
			return min(n.Lchild);
		}
	}

	private Node deleteMin(Node n) {
		if (n.Lchild == null) {
			return n.Rchild;
		}
		n.Lchild = deleteMin(n.Lchild);
		return n;
	}

	public static void main(String args[]) {
       bst obj = new bst();
		insert(15, root);
		for (int i = 0; i < 30; i++) {
			if (i == 15) {
				i++;
			}
			insert(i, root);

		}
		System.out.println("BFS");
		obj.bfs(root);
		System.out.println("\n" + " Array representation  After deletion");
		root = obj.delete(root, 0);
		obj.bfs(root);

	}

}
