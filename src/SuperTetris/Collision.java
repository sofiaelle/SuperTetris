package SuperTetris;

public class Collision {

    // TODO: Move blockCanMoveDown out from this class
    public static boolean blockCanMoveDown(boolean[][] grid, Block block) {
        Position[] currPos = block.getPosition();
        boolean canMove = true;
        for (Position p : currPos) {
            if ((p.y == grid[0].length - 1) || (grid[p.x][p.y + 1])) {
                canMove = false;
                continue;
            }
        }
        return canMove;
    }

    public static boolean blockCanMoveLeft(boolean[][] grid, Block block) {
        Position[] currPos = block.getPosition();
        boolean canMove = true;
        for (Position p : currPos) {
            if ((p.x == 0) || (grid[p.x - 1][p.y])) {
                canMove = false;
                continue;
            }
        }
        return canMove;
    }

    public static boolean blockCanMoveRight(boolean[][] grid, Block block) {
        Position[] currPos = block.getPosition();
        boolean canMove = true;
        for (Position p : currPos) {
            if ((p.x == grid.length - 1) || (grid[p.x + 1][p.y])) {
                canMove = false;
                continue;
            }
        }
        return canMove;
    }
}
