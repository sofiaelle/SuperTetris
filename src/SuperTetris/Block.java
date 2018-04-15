package SuperTetris;

import org.newdawn.slick.Color;

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
    private BlockType type;
    private Position[] position;
    private int rotatePos = 0;

    public Block(BlockType type) {
        this.type = type;
        this.position = getStartPosition();
    }

    public BlockType getType() {
        return this.type;
    }

    // Returns position in grid
    public Position[] getPosition() {
        return this.position;
    }

    public Position[] getStartPosition() {
        if (this.type == BlockType.CUBE) {
            //  X X
            //  X X
            Position[] positions = {
                    new Position(4, 0),
                    new Position(5, 0),
                    new Position(4, 1),
                    new Position(5, 1)
            };
            return positions;

            //   X
            // X X X
        } else if (this.type == BlockType.PYRAMID) {
            Position[] positions = {
                    new Position(4, 0),
                    new Position(3, 1),
                    new Position(4, 1),
                    new Position(5, 1)};
            return positions;

            //  X X X X
        } else if (this.type == BlockType.STRAIGHT) {
            Position[] positions = {
                    new Position(4, 0),
                    new Position(4, 1),
                    new Position(4, 2),
                    new Position(4, 3)
            };
            return positions;

            // X X
            //   X X
        } else if (this.type == BlockType.Z_FORM) {
            Position[] positions = {
                    new Position(4, 0),
                    new Position(5, 0),
                    new Position(5, 1),
                    new Position(6, 1)
            };
            return positions;

            //   X X
            // X X
        } else if (this.type == BlockType.REVERSE_Z) {
            Position[] list_position = {
                    new Position(4, 0),
                    new Position(5, 0),
                    new Position(4, 1),
                    new Position(3, 1)};
            return list_position;

            //  X X
            //    X
            //    X
        } else if (this.type == BlockType.L_FORM) {
            Position[] positions = {
                    new Position(4, 0),
                    new Position(5, 0),
                    new Position(5, 1),
                    new Position(5, 2)
            };
            return positions;

            // X X
            // X
            // X
        }else {
            Position[] positions = {
                    new Position(4, 0),
                    new Position(5, 0),
                    new Position(4, 1),
                    new Position(4, 2)
            };
            return positions;
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
        } else {
            return Color.black;
        }
    }

    public void setPosition(Position pos1, Position pos2, Position pos3, Position pos4) {
        Position[] positions = {pos1, pos2, pos3, pos4};
        this.position = positions;
    }

    public void moveBlockDown() {
        Position[] current_position = getPosition();
        Position pos1 = new Position(current_position[0].x, current_position[0].y + 1);
        Position pos2 = new Position(current_position[1].x, current_position[1].y + 1);
        Position pos3 = new Position(current_position[2].x, current_position[2].y + 1);
        Position pos4 = new Position(current_position[3].x, current_position[3].y + 1);
        this.setPosition(pos1, pos2, pos3, pos4);
    }

    public void moveBlockLeft() {
        Position[] current_position = getPosition();
        Position pos1 = new Position(current_position[0].x - 1, current_position[0].y);
        Position pos2 = new Position(current_position[1].x - 1, current_position[1].y);
        Position pos3 = new Position(current_position[2].x - 1, current_position[2].y);
        Position pos4 = new Position(current_position[3].x - 1, current_position[3].y);
        setPosition(pos1, pos2, pos3, pos4);
    }

    public void moveBlockRight() {
        Position[] current_position = getPosition();
        Position pos1 = new Position(current_position[0].x + 1, current_position[0].y);
        Position pos2 = new Position(current_position[1].x + 1, current_position[1].y);
        Position pos3 = new Position(current_position[2].x + 1, current_position[2].y);
        Position pos4 = new Position(current_position[3].x + 1, current_position[3].y);
        setPosition(pos1, pos2, pos3, pos4);
    }

  /*  public int rotatePosition() {
        if (rotatePos == 3) {
            rotatePos = 0;
        } else {
            rotatePos += 1;
        }
        return rotatePos;
    }

    public void rotateBlock() {
        Position[] current_position = getPosition();
        int currRotateState = rotatePosition();
        if (currRotateState == 0) {
            rotateBlock1(current_position);
        } else if (currRotateState == 1) {
            rotateBlock2(current_position);
        } else if (currRotateState == 2) {
            rotateBlock3(current_position);
        } else if (currRotateState == 3) {
            rotateBlock4(current_position);
        }
    }

    public void rotateBlock1(Position[] current_position){
        if (this.type == BlockType.PYRAMID) {
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
        } else {
            return Color.black;
        }
    }*/
}

class Position {
    public int x;
    public int y;

    public Position (int x, int y) {
        this.x =x;
        this.y =y;
    }
}
