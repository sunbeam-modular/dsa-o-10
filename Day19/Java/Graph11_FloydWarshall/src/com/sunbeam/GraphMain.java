package com.sunbeam;

import java.util.Scanner;

public class GraphMain {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter vertex count : " );
		int v = sc.nextInt();
		
		Graph g = new Graph(v);
		
		g.accept(sc);
		//g.print();
		g.floydWarshall();
		
		sc.close();
	}

}

/*

4
6
0 1 8
3 1 2
3 2 9
2 0 4
1 2 1
0 3 1




*/














