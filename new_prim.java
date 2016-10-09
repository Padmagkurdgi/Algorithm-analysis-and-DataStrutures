import java.util.*;

public class new_prim {
	static int infinite = 999999;
	// creation of weighted undirected graph
	int[][] edgeCost;
	int T_Nodes;
    // function for prim algorithm
	new_prim(int[][] mat) {
		int i, j;
		T_Nodes = mat.length;
		edgeCost = new int[T_Nodes][T_Nodes];
		for (i = 0; i < T_Nodes; i++) {
			for (j = 0; j < T_Nodes; j++) {
				edgeCost[i][j] = mat[i][j];
				if (edgeCost[i][j] == 0)
					edgeCost[i][j] = infinite;
			}
		}
	}
      // array to maintain the unvisited set of nodes
	public int unVisited(boolean[] arr) {
		boolean done = true;
		for (int i = 0; i < arr.length; i++)
			if (arr[i] == false)
				return i;

		return -1;
	}

	public void Prim() {
		int i, j, k, x, y;

		boolean[] Visited = new boolean[T_Nodes];
		int[] Prev_Node = new int[T_Nodes];
		Visited[0] = true; // Starting vertex of minimum spanning tree
		for (k = 1; k < T_Nodes; k++) {
			Visited[k] = false;
		}
		// initially there is no edge for node zero, as it is the starting vertex
		
		Prev_Node[0] = 0;
		// loop to find the minimum cost link among all the links.
		for (k = 1; k < T_Nodes; k++) {
			x = y = 0;
			for (i = 0; i < T_Nodes; i++)
				for (j = 0; j < T_Nodes; j++) {
					if (Visited[i] && !Visited[j] && edgeCost[i][j] < edgeCost[x][y]) {
						x = i;
						y = j;
					}
				}
			Prev_Node[y] = x;
			Visited[y] = true;
		}
		display_minSpanTree(Prev_Node);
	}
     // function to display the edges of minimum spanning tree
	void display_minSpanTree(int[] a) {
		System.out.println("Minimum spanning tree of a given tree is as follows :");
		for (int i = 1; i < T_Nodes; i++)
			System.out.println(a[i] + " --> " + i);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the size of graph");
		int n = sc.nextInt();
		// entering the weighted undirected graph
		System.out.println("enter the edgeCosts of weighted undirected graph(adjacency matrix)");
		int adj_mat[][] = new int[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				adj_mat[i][j] = sc.nextInt();
			}
		}
		new_prim obj1 = new new_prim(adj_mat);
		obj1.Prim();

	}
}
