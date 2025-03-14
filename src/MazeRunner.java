import java.util.ArrayList;
import java.util.List;

public class MazeRunner {
    public static void main(String[] args) {
        MazeSolver solver = new MazeSolver();
        ArrayList<List<Integer>> path = solver.solveMaze();

        if (path.isEmpty()) {
            return;
        }

        for (int i = 0; i < path.size(); i++) {
            List<Integer> coord = path.get(i);
            System.out.print("(" + coord.get(0) + ", " + coord.get(1) + ")");
            if (i < path.size() - 1) {
                System.out.print(" --> ");
            }
        }
        System.out.println();
    }
}
