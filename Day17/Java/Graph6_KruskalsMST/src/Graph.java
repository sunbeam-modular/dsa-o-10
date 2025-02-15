import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Graph {
	static class Edge{
		private int src, dest;
		private int wt;
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
		edgeList = new ArrayList<Edge>();
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
			adjMat[dest][src] = wt;		//comment this line for directed graph
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
	
	public void kruskalsMST() {
		// create list if edges for MST
		List<Edge> mst = new ArrayList<Graph.Edge>();
		//1. sort all edges of graph
		edgeList.sort((e1, e2) -> e1.wt - e2.wt);
		
		for(int i = 0 ; i < edgeList.size() ; i++) {
			//2.1 pick an edge with minimum weight
			Edge e = edgeList.get(i);
			//2.2 add edge into MST
			mst.add(e);
			//2.3 check if it is forming cycle
			if(hasCycle(mst))
				mst.remove(mst.size()-1);
			//3. if v-1 edges are added into MST then stop
			if(mst.size() ==  vertexCount - 1)
				break;
		}
		//4. print mst and find its wt
		System.out.print("MST : ");
		int wt = 0;
		for(Edge e : mst) {
			System.out.print("(" + e.src + "-" + e.dest + ")");
			wt += e.wt;
		}
		System.out.println("\n Weight of MST : " + wt);
	}
	
	public boolean hasCycle(List<Edge> mst) {
		// consider every vertex of graph in seperate set
		int parent[] = new int[vertexCount];
		for(int i = 0 ; i < vertexCount ; i++)
			parent[i] = -1;
		// check of every edge of mst
		for(Edge e : mst) {
			//find root of src
			int sr = find(e.src, parent);
			// find root of dest
			int dr = find(e.dest, parent);
			// if both roots are equal means cycle is formed
			if(sr == dr)
				return true;
			// if both roots are different then take their union
			union(sr, dr, parent);
		}
		return false;
	}
	
	public int find(int v, int parent[]) {
		while(parent[v] != -1)
			v = parent[v];
		return v;
	}
	
	public void union(int sr, int dr, int parent[]) {
		parent[sr] = dr;
	}
}















