import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MazeSolver {
    int[] navgeableRows = {-1, 0, 0, 1};
    int[] navegableColumns = {-1, 0, 0, 1};
    public static String[][] maze = getMaze("src/input.txt") ;
    public static int[][] visited;
    public ArrayList<List<Integer>> solutionMaze = new ArrayList<List<Integer>>();
    String block = "#";
    String move = ".";
    int coordX;
    int coordY;

    public int[] getCoordinates() {
        int[] coordinates = {coordX, coordX};
        return coordinates;
    }

    public int[] getNavgeableRows() {
        return navgeableRows;
    }

    public void setNavgeableRows(int[] navgeableRows) {
        this.navgeableRows = navgeableRows;
    }

    public int[] getNavegableColumns() {
        return navegableColumns;
    }

    public void setNavegableColumns(int[] navegableColumns) {
        this.navegableColumns = navegableColumns;
    }

    public static String[][] getMaze(String fileName) {
        File f = new File("input.txt");
        Scanner s = null;
        try {
            s = new Scanner(f);
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found.");
            System.exit(1);
        }

        ArrayList<String> fileData = new ArrayList<String>();
        while (s.hasNextLine())
            fileData.add(s.nextLine());

        int rows = fileData.size();
        int cols = fileData.get(0).length();

        String[][] Maze = new String[rows][cols];

        for (int i = 0; i < fileData.size(); i++) {
            String d = fileData.get(i);
            for (int j = 0; j < d.length(); j++) {
                Maze[i][j] = d.charAt(j) + "";
            }
        }
        return Maze;
    }

    public int[][] solveMaze() {
        int initialX = 0;
        int initialY = 0;

        while(maze[initialX++][initialY++].equals(block.getCoordiate()) != true || maze[initialX++][initialY].equals(block.getCoordiate()) != true) {
            solveMaze();
        }
        return solutionMaze;
    }
}
