import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MazeRunner {
    public static void main(String[] args) throws FileNotFoundException {
        String dasSolution = new Scanner(new File("src/DasSolution.txt")).useDelimiter("\\Z").next();
        String mySolution = new Scanner(new File("src/MySolution.txt")).useDelimiter("\\Z").next();
        if (mySolution.equals(dasSolution)) {
            System.out.println("YAY!");
        }
        MazeSolve solver = new MazeSolve();
        ArrayList<List<Integer>> path = solver.solveMaze();

        if (path.isEmpty()) {
            return;
        }

        for (int i = 0; i < path.size(); i++) {
            List<Integer> coord = path.get(i);
            System.out.print("(" + coord.get(0) + ", " + coord.get(1) + ")");
            if (i < path.size() - 1) {
                System.out.print(" ---> ");
            }
        }
        System.out.println();
    }
}
