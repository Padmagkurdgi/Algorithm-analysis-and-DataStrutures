import java.util.*;

public class dfs_topo {
	Stack<Integer> stack = new Stack<Integer>();

	public int[] topo(int adj_mat[][], int start) {
		int T_Nodes = adj_mat[start].length - 1;
		int[] topo_sort = new int[T_Nodes + 1];
		int pos = 1;
		int j;
		int visited[] = new int[T_Nodes + 1];
		int node = start;
		int i = start;
		visited[start] = 1;
		stack.push(start);
		while (!stack.isEmpty()) {
			node = stack.peek();
			while (i <= T_Nodes) {
				if (adj_mat[node][i] == 1 && visited[i] == 1) {
					if (stack.contains(i)) {
						System.out.println("topological sorting cannot be performed");
						return null;
					}
				}
				if (adj_mat[node][i] == 1 && visited[i] == 0) {
					stack.push(i);
					visited[i] = 1;
					node = i;
					i = 1;
					continue;
				}
				i++;
			}
			j = stack.pop();
			topo_sort[pos++] = j;
			i = ++j;
		}
		return topo_sort;
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int topo_sort[] = null;
		System.out.println("Enter the total number of nodes ");
        int T_Nodes = sc.nextInt();
		int adj_mat[][] = new int[T_Nodes + 1][T_Nodes + 1];
		System.out.println("Enter the edges of directed graph (adjacency matrix)");
		for (int i = 1; i <= T_Nodes; i++)
			for (int j = 1; j <= T_Nodes; j++)
				adj_mat[i][j] = sc.nextInt();
		System.out.println("Enter the start of the graph");
		int start = sc.nextInt();
		System.out.println(" Topological sort :");
		dfs_topo toposort = new dfs_topo();
		topo_sort = toposort.topo(adj_mat, start);
		for (int i = topo_sort.length - 1; i > 0; i--) {
			if (topo_sort[i] != 0)
				System.out.print(topo_sort[i] + "---->");
		}

	}
}
