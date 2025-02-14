import java.util.Scanner;

public class Graph {
	private final int INF = 999;
	private int edgeCount, vertexCount;
	private int adjMat[][];
	
	public Graph(int vCount) {
		vertexCount = vCount;
		adjMat = new int[vertexCount][vertexCount];
		for(int u = 0 ; u < vertexCount ; u++) {
			for(int v = 0 ; v < vertexCount ; v++)
				adjMat[u][v] = INF;
		}
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
}















