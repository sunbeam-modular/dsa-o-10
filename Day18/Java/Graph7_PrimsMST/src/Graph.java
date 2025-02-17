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
	
	public int findMinKeyVertex(int key[], boolean mst[]) {
		int minKey = INF, minKeyVertex = -1;
		for(int i = 0 ; i < vertexCount ; i++) {
			if(!mst[i] && key[i] < minKey) {
				minKey = key[i];
				minKeyVertex = i;
			}
		}
		return minKeyVertex;
	}
	
	public void PrimsMST(int start) {
		//0. create array to maintain MST, parent and key of every vertex
		boolean mst[] = new boolean[vertexCount];
		int parent[] = new int[vertexCount];
		int key[] = new int[vertexCount];
		//0. initially none of the vertex is added into mst, parent of every vertex is -1 and key is every vertex is INF
		for(int i = 0 ; i < vertexCount ; i++) {
			mst[i] = false;
			parent[i] = -1;
			key[i] = INF;
		}
		//0. make key of start vertex 0
		key[start] = 0;
		//1. Repeat below steps until all vertices are added into MST
		int count = 0;
		while(count < vertexCount) {
			//2. choose minimum key vertex which is not added into MST
			int u = findMinKeyVertex(key, mst);
			//3. add minimum key vertex into MST
			mst[u] = true;
			//4. increment count of mst
			count++;
			//5. update key and parent of adjacent vertices which are not added into MST
			for(int v = 0 ; v < vertexCount ; v++) {
				if(!mst[v] && adjMat[u][v] != INF && adjMat[u][v] < key[v]) {
					key[v] = adjMat[u][v];
					parent[v] = u;
				}
			}
		}
		//6. print MST and find its weight
		int wt = 0;
		System.out.print("MST : ");
		for(int i = 0 ; i < vertexCount ; i++) {
			System.out.print("(" + parent[i] + "," + i + ")");
			wt += key[i];
		}
		System.out.println("\n Weight : " + wt);
	}
}















