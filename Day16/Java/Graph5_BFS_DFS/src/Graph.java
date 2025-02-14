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
	
	public void DFSTraversal(int start) {
		//0. create stack to push vertices
		Stack<Integer> st = new Stack<Integer>();
		//0. create array to mark vertices
		boolean marked[] = new boolean[vertexCount];
		//1. choose start vertex --- start
		//2. push start vertex on stack and mark it
		st.push(start);
		marked[start] = true;
		System.out.print("DFS Traversal : ");
		while(!st.isEmpty()) {
			//3. pop vertex from stack
			int u = st.pop();
			//4. print vertex on console
			System.out.print(" " + u);
			//5. push all non marked adjacents on stack and mark them
			for(int v = 0 ; v < vertexCount ; v++) {
				if(!marked[v] && adjMat[u][v]) {
					st.push(v);
					marked[v] = true;
				}
			}
		}//6. repeat untill stack is empty
		System.out.println("");
	}
	
	public void BFSTraversal(int start) {
		//0. create queue to push vertices
		Queue<Integer> q = new LinkedList<Integer>();
		//0. create array to mark vertices
		boolean marked[] = new boolean[vertexCount];
		//1. choose start vertex -- start
		//2. push start vertex on queue and mark it
		q.offer(start);
		marked[start] = true;
		System.out.print("BFS Traversal : ");
		while(!q.isEmpty()) {
			//3. pop vertex from queue
			int u = q.poll();
			//4. print vertex on console
			System.out.print(" " + u);
			//5. push all non marked adjacents on queue and mark them
			for(int v = 0 ; v < vertexCount ; v++) {
				if(!marked[v] && adjMat[u][v]) {
					q.offer(v);
					marked[v] = true;
				}
			}
		}//6. repeat untill queue is not empty
		System.out.println("");
	}
	
	public boolean isConnected(int start) {
		//0. create stack to push vertices
		Stack<Integer> st = new Stack<Integer>();
		//0. create array to mark vertices
		boolean marked[] = new boolean[vertexCount];
		//1. choose start vertex --- start
		//2. push start vertex on stack and mark it
		st.push(start);
		marked[start] = true;
		int count = 1;
		while(!st.isEmpty()) {
			//3. pop vertex from stack
			int u = st.pop();
			//5. push all non marked adjacents on stack and mark them
			for(int v = 0 ; v < vertexCount ; v++) {
				if(!marked[v] && adjMat[u][v]) {
					st.push(v);
					marked[v] = true;
					count++;
				}
				if(count == vertexCount)
					return true;
			}
		}//6. repeat untill stack is empty
		return false;
	}
	
	public boolean isBipartite(int start) {
		//0. create stack to push  vertices
		Stack<Integer> st = new Stack<Integer>();
		//0. create array to store colors : color1 = -1, color2 = 1, no color = 0
		//1. keep colors of all vertices in an array. Initially vertices have no color.
		int color[] = new int[vertexCount];
		//2. push start on stack & Assign it color1.
		st.push(start);
		color[start] = -1;
		while(!st.isEmpty()) {
			//3. pop the vertex.
			int u = st.pop();
			//4. push all its neighbors on the stack
			for(int v = 0 ; v < vertexCount ; v++) {
				if(adjMat[u][v]) {
					//5. For each such vertex if no color is assigned yet, assign opposite color of current vertex (c1-c2, c2-c1).
					if(color[v] == 0) {
						st.push(v);
						color[v] = color[u] * -1;
					}
					//6. If vertex is already colored with same of current vertex, graph is not bipartite (return).
					if(color[u] == color[v])
						return false;
				}
			}
		}//7. repeat steps 3-6 until stack is empty.
		return true;
	}
}















