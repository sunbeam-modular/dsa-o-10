package com.sunbeam;

import java.util.Scanner;

public class Graph {
	private final int INF = 999;
	private int vertexCount;
	private int edgeCount;
	private int adjMat[][];
	public Graph(int vCount) {
		vertexCount = vCount;
		adjMat = new int[vertexCount][vertexCount];
		for(int i = 0 ; i < vertexCount ; i++) {
			for(int j = 0 ; j < vertexCount ; j++)
				adjMat[i][j] = INF;
		}
	}
	
	public void accept(Scanner sc) {
		System.out.print("Enter Edge count: ");
		edgeCount = sc.nextInt();
		System.out.println("Enter Edges (src, dest, wt) : ");
		for(int i = 0 ; i < edgeCount ; i++) {
			int src = sc.nextInt();
			int dest = sc.nextInt();
			int wt = sc.nextInt();
			adjMat[src][dest] = wt;
			//adjMat[dest][src] = wt;		//comment this line if graph is directed graph
		}
	}
	
	public void print() {
		System.out.println("Graph : ");
		for(int i = 0 ; i < vertexCount ; i++) {
			for(int j = 0 ; j < vertexCount ; j++) {
				System.out.print(adjMat[i][j] + "\t");
			}
			System.out.println("");
		}
	}
	
	public void floydWarshall() {
		//1. create and initialize distance matrix
		int dist[][] = new int[vertexCount][vertexCount];
		for(int u = 0 ; u < vertexCount ; u++) {
			for(int v = 0 ; v < vertexCount ; v++) {
				dist[u][v] = adjMat[u][v];	
			}
			dist[u][u] = 0;
		}
		//2. consider every vertex as intermediate vertex
		for(int i = 0 ; i < vertexCount ; i++) {
			//2.1 update distances of all vertices from each vertex
			for(int u = 0 ; u < vertexCount ; u++) {
				for(int v = 0 ; v < vertexCount ; v++) {
					if(dist[u][i] != INF && dist[i][v] != INF && dist[u][i] + dist[i][v] < dist[u][v])
						dist[u][v] = dist[u][i] + dist[i][v];
				}
			}
		}
		
		//3. print distances matrix
		System.out.println("Distances : ");
		for(int u = 0 ; u < vertexCount ; u++) {
			for(int v = 0 ; v < vertexCount ; v++)
				System.out.print(" " + dist[u][v]);
			System.out.println("");
		}
	}
	

}



















