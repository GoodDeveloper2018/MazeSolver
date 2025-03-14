import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MazeSolver {
    int[] navgeableRows = {-1, 0, 1, 0};
    int[] navegableColumns = {0, 1, 0, -1};

    public static String[][] maze = getMaze("input.txt");
    public static boolean[][] visited;

    public ArrayList<List<Integer>> solutionMaze = new ArrayList<>();

    String block = "#";
    String move = ".";

    int coordX;
    int coordY;

    public int[] getCoordinates() {
        int[] coordinates = {coordX, coordY};
        return coordinates;
    }

    public static String[][] getMaze(String fileName) {
        File f = new File(fileName);
        Scanner s = null;
        try {
            s = new Scanner(f);
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
            System.exit(1);
        }

        ArrayList<String> fileData = new ArrayList<>();
        while (s.hasNextLine()) {
            fileData.add(s.nextLine());
        }
        s.close();

        int rows = fileData.size();
        int cols = fileData.get(0).length();

        String[][] Maze = new String[rows][cols];

        for (int i = 0; i < rows; i++) {
            String line = fileData.get(i);
            for (int j = 0; j < cols; j++) {
                Maze[i][j] = String.valueOf(line.charAt(j));
            }
        }
        return Maze;
    }

    /**
     * Solve the maze recursively from (0, 0) to the (bottom-right) cell.
     * Return the path as a list of (row, col) coords.
     */
    public ArrayList<List<Integer>> solveMaze() {
        int rows = maze.length;
        int cols = maze[0].length;

        visited = new boolean[rows][cols];

        // Attempt to solve the maze, starting at (0, 0).
        boolean foundPath = MazeHelper.dfs(maze, visited, 0, 0, solutionMaze);

        if (!foundPath) {
            System.out.println("No path found!");
        }

        return solutionMaze;
    }
}
