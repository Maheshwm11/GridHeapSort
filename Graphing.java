import java.util.Random;
import java.util.Scanner;

public class Graphing {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N;
        while (true) {
            System.out.println("Enter the value for N (should be > 0):");
            if (scan.hasNextInt()) {
                N = scan.nextInt();
                scan.nextLine();
                int compares = 0;
                for (int k = 0; k < 5; k++) {
                    Random rand = new Random();
                    int[][] grid = new int[N][N];
                    for (int i = 0; i < N; i++) {
                        for (int j = 0; j < N; j++) {
                            grid[i][j] = rand.nextInt();
                        }
                    }
                    compares += SortGrid.sort(grid);
                }
                System.out.println("Average out of 5 tries for N = " + N + ": " + (compares / 5));
            } else {
                if (scan.nextLine().compareTo("exit") != 0)
                    System.out.println("Enter a valid input!");
                else
                    break;
            }
        }
    }
}
