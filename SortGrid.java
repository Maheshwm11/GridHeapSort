public class SortGrid {
    private static int compares = 0;
    private static int[][] grid;
    private static int n;

    // PUBLIC METHODS
    public static int sort(int[][] thisGrid) {
        compares = 0;
        grid = thisGrid;
        n = thisGrid.length;
        buildHeap();
        for (int i = n*n - 1; i > 0; i--) {
            int[] indices = getIndices(i);
            int iRow = indices[0];
            int iColumn = indices[1];
            swap(0, 0, iRow, iColumn);
            bottomUp(0, (iRow * n) + iColumn);
        }

        return compares;
    }

    private static void buildHeap() {
        for (int i = ((n*n)/2) - 1; i >= 0; i--) {
            bottomUp(i, n*n);
        }
    }

    private static void bottomUp(int th, int length) {
        boolean repeat = true;
        int current = th;
        boolean valid = true;

        while (repeat) {
            repeat = false;

            int[] indices = getIndices(current); //gets indices from 0-based indexing
            int cR = indices[0];
            int cC = indices[1];

            int lC = 2 * current + 1;
            int rC = lC + 1;

            int[] indicesLeft = getIndices(lC);
            int lCR = indicesLeft[0];
            int lCC = indicesLeft[1];

            int[] indicesRight = getIndices(rC);
            int rCR = indicesRight[0];
            int rCC = indicesRight[1];

            if (lC >= length) {
                break;
            }
            if (rC >= length) {
                valid = false;
            }
            int gR, gC;

            if (valid) {
                if (lessThan(lCR, lCC, rCR, rCC)) {
                    gR = rCR;
                    gC = rCC;
                } else {
                    gR = lCR;
                    gC = lCC;
                }

                if (lessThan(cR, cC, gR, gC)) {
                    swap(gR, gC, cR, cC);
                    current = (gR * n) + gC;
                    repeat = true;
                }
            } else if (lessThan(cR, cC, lCR, lCC)) {
                swap(lCR, lCC, cR, cC);
                current = (lCR * n) + lCC;
                repeat = true;
            }
        }
    }

    private static int[] getIndices(int th) {
        return new int[]{(th / n), (th % n)};
    }

    //  HELPER METHODS 
    // returns true if value at (r1, c1) is less
    // than value at (r2, c2) and false otherwise;
    // counts as 1 compare
    private static boolean lessThan(int r1, int c1, int r2, int c2) {
        compares++;

        if (grid[r1][c1] < grid[r2][c2])
            return true;

        return false;
    }

    // returns true if value at (r1, c1) is greater than
    // value at (r2, c2) and false otherwise;
    // counts as 1 compare
    private static boolean greaterThan(int r1, int c1, int r2, int c2) {
        compares++;

        if (grid[r1][c1] > grid[r2][c2])
            return true;

        return false;
    }

    // swaps values in the grid
    // at (r1, c1) and (r2, c2);
    // assumes that the parameters
    // are within the bounds
    private static void swap(int r1, int c1, int r2, int c2) {
        int temp = grid[r1][c1];
        grid[r1][c1] = grid[r2][c2];
        grid[r2][c2] = temp;
    }
}
