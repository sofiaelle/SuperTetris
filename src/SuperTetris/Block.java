package SuperTetris;

enum BlockType {
    CUBE,
    STRAIGHT
}

public class Block {
    BlockType type;

    public Block(BlockType type) {
        this.type = type;
    }

    public BlockType getType() {
        return this.type;
    }
}
