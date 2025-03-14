import java.util.ArrayList;
import java.util.List;

public class MazeHelper {
    
    // Directions: Up, Right, Down, Left  (row, col offsets)
    private static final int[] ROW_DIR = {-1, 0, 1, 0};
    private static final int[] COL_DIR = {0, 1, 0, -1};

    /**
     * A recursive DFS that tries to find a path from (row, col) to the bottom-right cell.
     * 
     * @param maze    The 2D maze of "#" and ".".
     * @param visited A 2D boolean array to mark visited cells.
     * @param row     Current row in the maze.
     * @param col     Current column in the maze.
     * @param path    A list of coordinates in the solution path, stored as [row, col].
     * @return        True if a path to the end is found, false otherwise.
     */
    public static boolean dfs(String[][] maze, boolean[][] visited, int row, int col, 
                              ArrayList<List<Integer>> path) {
        // If out of bounds or is blocked or already visited, stop.
        if (!isValidMove(maze, visited, row, col)) {
            return false;
        }
        
        // Mark current cell as visited.
        visited[row][col] = true;
        // Add current cell to path.
        path.add(List.of(row, col));

        // Check if we've reached the end (bottom-right corner).
        if (row == maze.length - 1 && col == maze[0].length - 1) {
            return true;
        }

        // Try all valid directions: up, right, down, left
        for (int i = 0; i < 4; i++) {
            int nextRow = row + ROW_DIR[i];
            int nextCol = col + COL_DIR[i];
            if (dfs(maze, visited, nextRow, nextCol, path)) {
                return true;
            }
        }

        // Backtrack: remove current cell from path and un-visit it.
        path.remove(path.size() - 1);
        visited[row][col] = false;
        return false;
    }

    /**
     * Check if (row, col) is within the bounds of the maze, 
     * not a '#' block, and not yet visited.
     */
    private static boolean isValidMove(String[][] maze, boolean[][] visited, int row, int col) {
        if (row < 0 || col < 0 || row >= maze.length || col >= maze[0].length) {
            return false;
        }
        if (maze[row][col].equals("#")) {
            return false;
        }
        return !visited[row][col];
    }
}