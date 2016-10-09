import java.util.LinkedList;
import java.util.*;
import java.util.Scanner;
import java.util.Stack;

public class dfs_graphh {

	// stack is initialised for dfs traversal of graph
	Stack dfs_stack = new Stack();
		// function for bds traversal
		public void dfs_graph(int adj_mat[][], int start) {
			int T_Nodes = adj_mat[start].length - 1;
			int[] visited = new int[T_Nodes + 1];

			visited[start] = 1;
			dfs_stack.push(start);

			
			while (!dfs_stack.isEmpty()) {
				int node = (int) dfs_stack.pop();
				int i = node;
				System.out.print(i + "\t");
				int j =1;
				while (j <= T_Nodes) {
					if (adj_mat[node][j] == 1 && visited[j] == 0) {
						dfs_stack.push(j);
						visited[j] = 1;
					}
					j++;
				}
			}
		}

		public static void main(String[] args) {
			int T_Nodes, start;

			System.out.println("Enter the number of nodes in the dfs graph");
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

			System.out.println(" dfs traversal : ");
			dfs_graphh obj1 = new dfs_graphh();
			obj1.dfs_graph(adj_mat, start);
			
		}
}
