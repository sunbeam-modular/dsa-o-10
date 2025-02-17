import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Graph {
	static class Edge{
		private int src, dest, wt;
		public Edge(int s, int d, int w) {
			src = s;
			dest = d;
			wt = w;
		}
	}
	
	private final int INF = 999;
	private int edgeCount, vertexCount;
	private int adjMat[][];
	private List<Edge> edgeList;
	
	public Graph(int vCount) {
		vertexCount = vCount;
		adjMat = new int[vertexCount][vertexCount];
		for(int u = 0 ; u < vertexCount ; u++) {
			for(int v = 0 ; v < vertexCount ; v++)
				adjMat[u][v] = INF;
		}
		edgeList = new ArrayList<Graph.Edge>();
	}
	
	public void accept(Scanner sc) {
		System.out.print("Enter edge count : ");
		edgeCount = sc.nextInt();
		System.out.println("Enter edges of the graph : (src, dest, wt) :");
		for(int i = 0 ; i < edgeCount ; i++) {
			int src = sc.nextInt();
			int dest = sc.nextInt();
			int wt = sc.nextInt();
			adjMat[src][dest] = wt;
			//adjMat[dest][src] = wt;		//comment this line for directed graph
			edgeList.add(new Edge(src, dest, wt));
		}
	}
	
	public void print() {
		System.out.println("Graph : ");
		System.out.println("Vertex count : " + vertexCount);
		System.out.println("Edge count : " + edgeCount);
		for(int u = 0 ; u < vertexCount ; u++) {
			for(int v = 0 ; v < vertexCount ; v++) {
				System.out.print(adjMat[u][v] + "\t");
			}
			System.out.println("");			
		}
	}
	
	public void bellamanFordAlgorithm(int start) {
		//0. create an array to maintain distances of all vertices
		int dist[] = new int[vertexCount];
		//1. Initialize all distances to INF and dist of start is 0
		for(int i = 0 ; i < vertexCount ; i++)
			dist[i] = INF;
		dist[start] = 0;
		//2. relax all edges v-1 times
		for(int i = 0 ; i < vertexCount-1 ; i++) {
			//2.1 for each edge update dist of dest
			for(Edge e : edgeList) {
				int u = e.src, v = e.dest, wt = e.wt;
				if(dist[u] != INF && dist[u] + wt < dist[v]) {
					dist[v] = dist[u] + wt;
				}
			}
		}
		//3. relax one more time to check -ve edge cycle
		for(Edge e : edgeList) {
			int u = e.src, v = e.dest, wt = e.wt;
			if(dist[u] != INF && dist[u] + wt < dist[v]) {
				System.out.println("Graph has -ve edge cycle");
				return;
			}
		}
		//4. print shortest distances of all vertices
		System.out.println("Shortest distances : ");
		for(int i = 0 ; i < vertexCount ; i++){
			System.out.println(start + "->" + i + " = " + dist[i]);
		}
	}
}















