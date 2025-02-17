import java.util.Scanner;

public class Tester {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter vertex count : ");
		int count = sc.nextInt();
		
		Graph g = new Graph(count);
		
		g.accept(sc);
		//g.print();
		
		g.PrimsMST(1);
		
		sc.close();
	}

}

/*
7
12
0 1 2
1 4 10
4 6 6
6 5 1
5 2 5
2 0 4
0 3 1
1 3 3
4 3 7
6 3 4
5 3 8
2 3 2
 

*/

