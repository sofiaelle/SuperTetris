package SuperTetris;

import javafx.geometry.Pos;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

enum BlockType {
    CUBE,
    STRAIGHT,
    PYRAMID,
    Z_FORM,
    REVERSE_Z,
    L_FORM,
    REVERSE_L
}

public class Block {
    BlockType type;
    private static int SPAWN_X1 = 190;
    private static int SPAWN_X2 = SuperTetris.GAME_WINDOW_WIDTH / 10;
    private static int SPAWN_Y1 = 100;
    private static int SPAWN_Y2 = SuperTetris.GAME_WINDOW_WIDTH / 10;


    public Block(BlockType type) {
        this.type = type;
    }

    public BlockType getType() {
        return this.type;
    }

    public Position[] getPosition() {
        //Position[] list_position = new Position[4];
        if (this.type == BlockType.CUBE) {
            Position[] list_position = {
                    new Position(SPAWN_X1, SPAWN_Y1),
                    new Position(SPAWN_X1 + SPAWN_X2, SPAWN_Y1),
                    new Position(SPAWN_X1, SPAWN_Y1 + SPAWN_Y2),
                    new Position(SPAWN_X1 + SPAWN_X2, SPAWN_Y1 + SPAWN_Y2)};
            return list_position;

        } else if (this.type == BlockType.PYRAMID) {
            Position[] list_position = {
                    new Position(SPAWN_X1, SPAWN_Y1),
                    new Position(SPAWN_X1 + SPAWN_X2, SPAWN_Y1 + SPAWN_Y2),
                    new Position(SPAWN_X1 + SPAWN_X2, SPAWN_Y1),
                    new Position(SPAWN_X1 + SPAWN_X2 * 2, SPAWN_Y1)};
            return list_position;

        } else if (this.type == BlockType.STRAIGHT){
            Position[] list_position = {
                    new Position(SPAWN_X1, SPAWN_Y1),
                    new Position(SPAWN_X1+SPAWN_X2,SPAWN_Y1),
                    new Position(SPAWN_X1+SPAWN_X2*2,SPAWN_Y1),
                    new Position(SPAWN_X1+SPAWN_X2*3,SPAWN_Y1)};
            return list_position;

        } else if(this.type == BlockType.Z_FORM){
            Position[] list_position = {
                    new Position(SPAWN_X1, SPAWN_Y1),
                    new Position(SPAWN_X1+SPAWN_X2,SPAWN_Y1),
                    new Position(SPAWN_X1+SPAWN_X2,SPAWN_Y1+SPAWN_Y2),
                    new Position(SPAWN_X1+SPAWN_X2*2,SPAWN_Y1+SPAWN_Y2)};
            return list_position;

        } else if (this.type == BlockType.REVERSE_Z){
            Position[] list_position = {
                    new Position(SPAWN_X1,SPAWN_Y1+SPAWN_Y2),
                    new Position(SPAWN_X1+SPAWN_X2,SPAWN_Y1+SPAWN_Y2),
                    new Position(SPAWN_X1+SPAWN_X2,SPAWN_Y1),
                    new Position(SPAWN_X1+SPAWN_X2*2,SPAWN_Y1)};
            return list_position;

        } else if (this.type == BlockType.L_FORM){
            Position[] list_position = {
                    new Position(SPAWN_X1,SPAWN_Y1),
                    new Position(SPAWN_X1+SPAWN_X2,SPAWN_Y1),
                    new Position(SPAWN_X1+SPAWN_X2*2,SPAWN_Y1),
                    new Position(SPAWN_X1,SPAWN_Y1+SPAWN_Y2)};
            return list_position;

        } else if (this.type == BlockType.REVERSE_L){
            Position[] list_position = {
                    new Position(SPAWN_X1,SPAWN_Y1),
                    new Position(SPAWN_X1+SPAWN_X2,SPAWN_Y1),
                    new Position(SPAWN_X1+SPAWN_X2*2,SPAWN_Y1),
                    new Position(SPAWN_X1+SPAWN_X2*2,SPAWN_Y1+SPAWN_Y2)};
            return list_position;
        } else {
            Position[] list_position = {
                    new Position(SPAWN_X1,SPAWN_Y1),
                    new Position(SPAWN_X1+SPAWN_X2,SPAWN_Y1),
                    new Position(SPAWN_X1+SPAWN_X2*2,SPAWN_Y1),
                    new Position(SPAWN_X1+SPAWN_X2*2,SPAWN_Y1+SPAWN_Y2)};
            return list_position;
        }
        }

        public Color getColor() {

            if (this.type == BlockType.CUBE) {
                return Color.yellow;

            } else if (this.type == BlockType.PYRAMID) {
                return Color.cyan;

            } else if (this.type == BlockType.STRAIGHT) {
                return Color.magenta;

            } else if (this.type == BlockType.Z_FORM) {
                return Color.green;

            } else if (this.type == BlockType.REVERSE_Z) {
                return Color.blue;

            } else if (this.type == BlockType.L_FORM) {
                return Color.red;

            } else if (this.type == BlockType.REVERSE_L) {
                return Color.pink;
            } else{
                return Color.black;
            }
        }


    public void drawBlock(Graphics g) {
        Position[] list_positions = this.getPosition();

        g.setColor(this.getColor());
        g.fillRect(list_positions[0].x,list_positions[0].y,SuperTetris.GRID_SQUARE_SIZE,SuperTetris.GRID_SQUARE_SIZE);
        g.fillRect(list_positions[1].x,list_positions[1].y,SuperTetris.GRID_SQUARE_SIZE,SuperTetris.GRID_SQUARE_SIZE);
        g.fillRect(list_positions[2].x,list_positions[2].y,SuperTetris.GRID_SQUARE_SIZE,SuperTetris.GRID_SQUARE_SIZE);
        g.fillRect(list_positions[3].x,list_positions[3].y,SuperTetris.GRID_SQUARE_SIZE,SuperTetris.GRID_SQUARE_SIZE);

        g.setColor(Color.black);
        g.drawRect(list_positions[0].x,list_positions[0].y,SuperTetris.GRID_SQUARE_SIZE,SuperTetris.GRID_SQUARE_SIZE);
        g.drawRect(list_positions[1].x,list_positions[1].y,SuperTetris.GRID_SQUARE_SIZE,SuperTetris.GRID_SQUARE_SIZE);
        g.drawRect(list_positions[2].x,list_positions[2].y,SuperTetris.GRID_SQUARE_SIZE,SuperTetris.GRID_SQUARE_SIZE);
        g.drawRect(list_positions[3].x,list_positions[3].y,SuperTetris.GRID_SQUARE_SIZE,SuperTetris.GRID_SQUARE_SIZE);

    }
}

class Position {
    public int x;
    public int y;

    public Position (int x, int y) {
        this.x =x;
        this.y =y;
    }
}
