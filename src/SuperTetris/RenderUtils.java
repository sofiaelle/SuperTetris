package SuperTetris;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

public class RenderUtils {

    public static void drawBlock(Graphics g, Block block) {
        Position[] positions = getPixelPosition(block.getPosition());

        g.setColor(block.getColor());
        g.fillRect(positions[0].x, positions[0].y, SuperTetris.GRID_SQUARE_SIZE, SuperTetris.GRID_SQUARE_SIZE);
        g.fillRect(positions[1].x, positions[1].y, SuperTetris.GRID_SQUARE_SIZE, SuperTetris.GRID_SQUARE_SIZE);
        g.fillRect(positions[2].x, positions[2].y, SuperTetris.GRID_SQUARE_SIZE, SuperTetris.GRID_SQUARE_SIZE);
        g.fillRect(positions[3].x, positions[3].y, SuperTetris.GRID_SQUARE_SIZE, SuperTetris.GRID_SQUARE_SIZE);

        g.setColor(Color.black);
        g.drawRect(positions[0].x, positions[0].y, SuperTetris.GRID_SQUARE_SIZE, SuperTetris.GRID_SQUARE_SIZE);
        g.drawRect(positions[1].x, positions[1].y, SuperTetris.GRID_SQUARE_SIZE, SuperTetris.GRID_SQUARE_SIZE);
        g.drawRect(positions[2].x, positions[2].y, SuperTetris.GRID_SQUARE_SIZE, SuperTetris.GRID_SQUARE_SIZE);
        g.drawRect(positions[3].x, positions[3].y, SuperTetris.GRID_SQUARE_SIZE, SuperTetris.GRID_SQUARE_SIZE);

    }

    // Returns pixel positions from given grid position
    public static Position[] getPixelPosition(Position[] pos) {
        int X_PADDING = 10;
        int Y_PADDING = 100;
        Position[] pixelPos = {
                new Position(pos[0].x * SuperTetris.BLOCK_SIZE + X_PADDING, pos[0].y * SuperTetris.BLOCK_SIZE + Y_PADDING),
                new Position(pos[1].x * SuperTetris.BLOCK_SIZE + X_PADDING, pos[1].y * SuperTetris.BLOCK_SIZE + Y_PADDING),
                new Position(pos[2].x * SuperTetris.BLOCK_SIZE + X_PADDING, pos[2].y * SuperTetris.BLOCK_SIZE + Y_PADDING),
                new Position(pos[3].x * SuperTetris.BLOCK_SIZE + X_PADDING, pos[3].y * SuperTetris.BLOCK_SIZE + Y_PADDING)
        };
        return pixelPos;
    }
}
