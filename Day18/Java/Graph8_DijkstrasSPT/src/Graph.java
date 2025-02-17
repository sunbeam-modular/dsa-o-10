import java.util.Arrays;
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
			//adjMat[dest][src] = wt;		//comment this line for directed graph
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
	
	public int findMinDistVertex(int dist[], boolean spt[]) {
		//System.out.println("dist : " + Arrays.toString(dist));
		int minDist = INF, minDistVertex = -1;
		for(int i = 0 ; i < vertexCount ; i++) {
			if(!spt[i] && dist[i] < minDist) {
				minDist = dist[i];
				minDistVertex = i;
			}
		}
		//System.out.println("minDistVertex : " + minDistVertex);
		return minDistVertex;
	}
	
	public void dijkstrasSPT(int start) {
		//0. create array to maintain SPT and dist of every vertex
		boolean spt[] = new boolean[vertexCount];
		int dist[] = new int[vertexCount];
		//0. initially none of the vertex is added into mst, parent of every vertex is -1 and key is every vertex is INF
		for(int i = 0 ; i < vertexCount ; i++) {
			spt[i] = false;
			dist[i] = INF;
		}
		//0. make dist of start vertex 0
		dist[start] = 0;
		//1. Repeat below steps until all vertices are added into SPT
		
		int count = 0;
		while(count < vertexCount) {
			//2. choose minimum dist vertex which is not added into SPT
			int u = findMinDistVertex(dist, spt);
			//3. add minimum dist vertex into SPT
			spt[u] = true;
			//4. increment count of spt
			count++;
			//5. update dist of adjacent vertices which are not added into SPT
			for(int v = 0 ; v < vertexCount ; v++) {
				if(!spt[v] && adjMat[u][v] != INF && dist[u] + adjMat[u][v] < dist[v]) {
					dist[v] = dist[u] + adjMat[u][v];
				}
			}
		}
		//6. print SPT
		System.out.print("Shorted distances from " + start + " : ") ;
		for(int i = 0 ; i < vertexCount ; i++) {
			System.out.println(start + "->" + i + " = " + dist[i]);
		}
	}
}















