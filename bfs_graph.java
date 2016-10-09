import java.util.*;
import java.util.LinkedList;

public class bfs_graph {
	// queue is initialised for bfs traversal of graph
	Queue<Integer> queue = new LinkedList<Integer>();

	// function for bfs traversal
	public void bfs_graph(int adj_mat[][], int start) {
		int T_Nodes = adj_mat[start].length - 1;
		int[] visited = new int[T_Nodes + 1];

		visited[start] = 1;
		queue.add(start);

		while (!queue.isEmpty()) {
			int node = queue.remove();
			int i = node;
			System.out.print(i + "\t");
			int j =1;
			while ( j <= T_Nodes) {
				if (adj_mat[node][j] == 1 && visited[j] == 0) {
					queue.add(j);
					visited[j] = 1;
				}
				j++;
			}
		}
	}

	public static void main(String[] args) {
		int T_Nodes, start;

		System.out.println("Enter the number of nodes in the bfs graph");
		Scanner sc = new Scanner(System.in);
		T_Nodes = sc.nextInt();
   // Graph is represented using adjacency matrix
		int adj_mat[][] = new int[T_Nodes + 1][T_Nodes + 1];
		System.out.println("Enter the  edges of adj_mat");
		// entering the edges and nodes of graph
		for (int i = 1; i <= T_Nodes; i++)
			for (int j = 1; j <= T_Nodes; j++)
				adj_mat[i][j] = sc.nextInt();

		System.out.println("Enter the start node of graph");
		start = sc.nextInt();

		System.out.println(" bfs traversal  ");
		bfs_graph obj1 = new bfs_graph();
		obj1.bfs_graph(adj_mat, start);
		
	}
}