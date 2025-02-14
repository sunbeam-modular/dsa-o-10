import java.util.Scanner;

public class Tester {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter vertex count : ");
		int count = sc.nextInt();
		
		Graph g = new Graph(count);
		
		g.accept(sc);
		g.print();
		
		sc.close();
	}

}

/*
6
7
0 1
0 2
0 3
1 2
1 4
3 4
3 5




*/

