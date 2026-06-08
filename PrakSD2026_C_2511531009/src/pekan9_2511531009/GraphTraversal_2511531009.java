package pekan9_2511531009;
import java.util.*;
public class GraphTraversal_2511531009 {
	private Map<String, List<String>> graph_1009 = new HashMap<>();
	
	public void addEdge_1009(String node1_1009, String node2_1009) {
		graph_1009.putIfAbsent(node1_1009, new ArrayList<>());
		graph_1009.putIfAbsent(node2_1009, new ArrayList<>());
		graph_1009.get(node1_1009).add(node2_1009);
		graph_1009.get(node2_1009).add(node1_1009);
	}
	
	public void printGraph_1009() {
		System.out.println("Graf Awal (Adjacency List): ");
		for (String node_1009 : graph_1009.keySet()) {
			List<String> neighbors_1009 = graph_1009.get(node_1009);
			System.out.println(node_1009 + " -> " + String.join(", ", neighbors_1009));
		}
	}
	
	public void dfs_1009(String start_1009) {
		Set<String> visited_1009 = new HashSet<>();
		System.out.println("Penelususran DFS");
		dfsHelper_1009(start_1009, visited_1009);
		System.out.println();
	}

	private void dfsHelper_1009(String current_1009, Set<String> visited_1009) {
		if (visited_1009.contains(current_1009)) {
			return;
		}
		visited_1009.add(current_1009);
		System.out.print(current_1009 + " ");
		for (String neighbor_1009 : graph_1009.getOrDefault(current_1009, new ArrayList<>())) {
			dfsHelper_1009(neighbor_1009, visited_1009);
		}
	}
	
    public void bfs_1009(String start) {
        Set<String> visited_1009 = new HashSet<>();
        Queue<String> queue_1009 = new LinkedList<>();
        queue_1009.add(start);
        visited_1009.add(start);
        System.out.println("Penelusuran BFS:");
        while (!queue_1009.isEmpty()) {
            String current = queue_1009.poll();
            System.out.print(current + " ");
            for (String neighbor : graph_1009.getOrDefault(current, new ArrayList<>())) {
                if (!visited_1009.contains(neighbor)) {
                    queue_1009.add(neighbor);
                    visited_1009.add(neighbor);
                }
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        GraphTraversal_2511531009 graph_1009 = new GraphTraversal_2511531009();

        graph_1009.addEdge_1009("A", "B");
        graph_1009.addEdge_1009("A", "C");
        graph_1009.addEdge_1009("B", "D");
        graph_1009.addEdge_1009("B", "E");
        System.out.println("Graf Awal adalah: ");
        graph_1009.printGraph_1009();
        graph_1009.dfs_1009("A");
        graph_1009.bfs_1009("A");
    }
}