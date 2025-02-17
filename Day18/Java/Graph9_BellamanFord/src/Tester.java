import java.util.Scanner;

public class Tester {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter vertex count : ");
		int count = sc.nextInt();
		
		Graph g = new Graph(count);
		
		g.accept(sc);
		//g.print();
		
		g.bellamanFordAlgorithm(0);
		
		sc.close();
	}

}

/*
5
7
0 1 6
0 2 5
2 1 -2
1 3 -1
2 3 4
2 4 3
3 4 3





*/

