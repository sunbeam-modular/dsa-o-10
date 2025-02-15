import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Graph {
	private int edgeCount, vertexCount;
	private boolean adjMat[][];
	
	public Graph(int vCount) {
		vertexCount = vCount;
		adjMat = new boolean[vertexCount][vertexCount];
	}
	
	public void accept(Scanner sc) {
		System.out.print("Enter edge count : ");
		edgeCount = sc.nextInt();
		System.out.println("Enter edges of the graph : (src, dest) :");
		for(int i = 0 ; i < edgeCount ; i++) {
			int src = sc.nextInt();
			int dest = sc.nextInt();
			adjMat[src][dest] = true;
			adjMat[dest][src] = true;		//comment this line for directed graph
		}
	}
	
	public void print() {
		System.out.println("Graph : ");
		System.out.println("Vertex count : " + vertexCount);
		System.out.println("Edge count : " + edgeCount);
		for(int u = 0 ; u < vertexCount ; u++) {
			for(int v = 0 ; v < vertexCount ; v++) {
				System.out.print(adjMat[u][v] ? "1" + " " : "0" + " ");
			}
			System.out.println("");			
		}
	}
	
	
	
	public void singleSourcePathLength(int start) {
		//0. create queue
		Queue<Integer> q = new LinkedList<Integer>();
		//0. create array to mark vertices
		boolean marked[] = new boolean[vertexCount];
		//0. create array to store path length of each vertex
		int length[] = new int[vertexCount];
		//1. push start vertex on queue, mark it, update its length to 0
		q.offer(start);
		marked[start] = true;
		length[start] = 0;
		System.out.print("Path length tree : ");
		while(!q.isEmpty()) {
			//2. pop vertex from queue
			int u = q.poll();
			//3. for non marked adjacent, push it, mark it, update its length and also print edge from current to neighbour
			for(int v = 0 ; v < vertexCount ; v++) {
				if(!marked[v] && adjMat[u][v]) {
					q.offer(v);
					marked[v] = true;
					length[v] = length[u] + 1;
					System.out.print("(" + u + "," + v + ")");
				}
			}
		}// repeat above steps untill queue is empty
		System.out.println("\n Length from " + start + " : ");
		// print path length array
		for(int i = 0 ; i < vertexCount ; i++)
			System.out.println(start + "->" + i + " = " + length[i]);		
	}
	
	public void DFSSpanningTree(int start) {
		//0. create stack to push vertices
		Stack<Integer> st = new Stack<Integer>();
		//0. create array to mark vertices
		boolean marked[] = new boolean[vertexCount];
		//1. choose start vertex --- start
		//2. push start vertex on stack and mark it
		st.push(start);
		marked[start] = true;
		System.out.print("DFS Spanning Tree : ");
		while(!st.isEmpty()) {
			//3. pop vertex from stack
			int u = st.pop();
			//5. push all non marked adjacents on stack and mark them
			for(int v = 0 ; v < vertexCount ; v++) {
				if(!marked[v] && adjMat[u][v]) {
					st.push(v);
					marked[v] = true;
					System.out.print("(" + u + "," + v + ")");
				}
			}
		}//6. repeat untill stack is empty
		System.out.println("");
	}
	
	public void BFSSpanningTree(int start) {
		//0. create queue to push vertices
		Queue<Integer> q = new LinkedList<Integer>();
		//0. create array to mark vertices
		boolean marked[] = new boolean[vertexCount];
		//1. choose start vertex -- start
		//2. push start vertex on queue and mark it
		q.offer(start);
		marked[start] = true;
		System.out.print("BFS Spanning Tree : ");
		while(!q.isEmpty()) {
			//3. pop vertex from queue
			int u = q.poll();
			//5. push all non marked adjacents on queue and mark them
			for(int v = 0 ; v < vertexCount ; v++) {
				if(!marked[v] && adjMat[u][v]) {
					q.offer(v);
					marked[v] = true;
					//4. print vertex to neighbor edge on console
					System.out.print("(" + u + "-" + v + ")");
				}
			}
		}//6. repeat untill queue is not empty
		System.out.println("");
	}
}















