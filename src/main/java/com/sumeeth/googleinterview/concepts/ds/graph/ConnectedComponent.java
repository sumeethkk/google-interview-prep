package com.sumeeth.googleinterview.concepts.ds.graph;

public class ConnectedComponent {


    static int MAX_CONNECTED_COMP_COUNT = 0;
    static int[][] result = new int[6][8];

    /*
    [0,1,1,1,1,0]
    [0,0,2,1,1,0]
    [0,1,2,2,2,0]
    [0,1,2,1,2,0]
    [0,1,2,1,2,0]

    max connected component = 2  (total= 8 )
     */
    public static void main(String[] args) {
        int input[][] = {
                {1, 4, 4, 4, 4, 3, 3, 1},
                {2, 1, 1, 4, 3, 3, 1, 1},
                {3, 2, 1, 1, 2, 3, 2, 1},
                {3, 3, 2, 1, 2, 2, 2, 2},
                {3, 1, 3, 1, 1, 4, 4, 4},
                {1, 1, 3, 1, 1, 4, 4, 4}
        };

        int input2[][] = {
                {1, 4, 4, 4, 4, 3, 3, 4},
                {2, 1, 1, 4, 3, 3, 1, 4},
                {3, 2, 1, 1, 2, 3, 2, 4},
                {3, 3, 2, 1, 2, 2, 2, 4},
                {3, 1, 3, 1, 1, 4, 4, 4},
                {1, 1, 3, 1, 1, 4, 4, 4}
        };
        printMatrix(input2);

//        DFS(matrix);
        System.out.println(getMaxRegion(input2));

        printResults();


    }

    public static void DFS(int[][] grid) {

        int h = grid.length;
        if (h == 0)
            return;
        int l = grid[0].length;

        //created visited array
        boolean[][] visited = new boolean[h][l];
        System.out.println("Depth-First Search: ");
        DFSUtil(grid, 0, 0, visited);
    }

    public static void DFSUtil(int[][] grid, int row, int col, boolean[][] visited) {

        int H = grid.length;
        int L = grid[0].length;

        if (row < 0 || col < 0 || row >= H || col >= L || visited[row][col])
            return;

        //mark the cell visited
        visited[row][col] = true;
        System.out.print(grid[row][col] + " ");
        DFSUtil(grid, row + 1, col, visited); // go right
        DFSUtil(grid, row - 1, col, visited); //go left
        DFSUtil(grid, row, col + 1, visited); //go down
        DFSUtil(grid, row, col - 1, visited); // go up
    }

    private static void resetVisits(boolean[][] visitedRegion) {
        for (int i = 0; i < visitedRegion.length; i++) {
            for (int j = 0; j < visitedRegion[i].length; j++) {
                visitedRegion[i][j] = false;
            }
        }
    }

    private static void resetResults(boolean[][] visitedRegion,int[][] grid , int currKey) {
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                if (visitedRegion[i][j] &&
                        grid[i][j] == currKey)
                    result[i][j] = grid[i][j];
                else
                    result[i][j] = 0;
            }
        }
    }

    private static boolean isValidMove(int i, int j, boolean[][] visitedRegion, int[][] grid) {

        if (i >= 0 && j >= 0 && i < grid.length && j < grid[0].length) {
            return !visitedRegion[i][j];
        }
        return false;

    }

    public static int getMaxRegion(int[][] matrix) {
        boolean[][] visitedRegion = new boolean[matrix.length][matrix[0].length];
        int maxRegion = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                resetVisits(visitedRegion);
                MAX_CONNECTED_COMP_COUNT = 0;
                getMaxRegion(matrix, visitedRegion, row, col, matrix[row][col]);
                if(MAX_CONNECTED_COMP_COUNT >= maxRegion){
                    maxRegion = MAX_CONNECTED_COMP_COUNT;
                    resetResults(visitedRegion,matrix,matrix[row][col]);
                }
            }
        }
        return maxRegion;
    }

    private static void getMaxRegion(int[][] matrix, boolean[][] visitedRegion, int row, int col, int currentKey) {
        //base condition
        if (matrix[row][col] != currentKey) {
            return;
        }
        visitedRegion[row][col] = true;
//        System.out.println("Exploring+(" + row + "," + col + ") for key:" + currentKey);
        MAX_CONNECTED_COMP_COUNT++;
        result[row][col]=currentKey;
        for (int r = row; r <= row + 1; r++) {
            for (int c = col; c <= col + 1; c++) {
                if (isValidMove(r, c, visitedRegion, matrix)) {
                    getMaxRegion(matrix, visitedRegion, r, c, currentKey);
                }
            }

        }
    }


    public static void printMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + ", ");
            }
            System.out.println();
        }
    }

    public static void printResults() {
        for (int row = 0; row < result.length; row++) {
            for (int col = 0; col < result[row].length; col++) {
                System.out.print(result[row][col]==0?"*":result[row][col] + ", ");
            }
            System.out.println();
        }
    }
}
