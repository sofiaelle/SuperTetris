package SuperTetris;

import org.newdawn.slick.*;
import java.util.Random;
import java.util.ArrayList;

public class SuperTetris extends BasicGame {

    private static int WINDOW_WIDTH = 800;
    private static int WINDOW_HEIGHT = 1020;
    public static int GAME_WINDOW_WIDTH = WINDOW_WIDTH - 350;
    private static int GRID_WIDTH = 10;
    private static int GRID_HEIGHT = 20;
    public static int GRID_SQUARE_SIZE = GAME_WINDOW_WIDTH / GRID_WIDTH;
    private static int BLOCK_SIZE = GRID_SQUARE_SIZE;
    private static Color BG_COLOR = new Color(0.2f, 0.1f, 0.5f, 1f);
    private static Color UI_COLOR = new Color(0.5f, 0.5f, 1.0f, 1f);
    private int sinceTick = 0;
    private int randInt;
    private Block currentBlock;
    Music mainTetrisMusic;
    private TrueTypeFont logoFont;
    private boolean[][] grid = new boolean[GRID_WIDTH][GRID_HEIGHT];

    //Generates a list with values of block types
    BlockType[] list_block = BlockType.values();
    ArrayList<Block> oldBlocks = new ArrayList<>();

    public SuperTetris() {
        super("SuperTetris");
    }

    public static void main(String[] args) {
        try {
            AppGameContainer app = new AppGameContainer(new SuperTetris());
            app.setDisplayMode(WINDOW_WIDTH, WINDOW_HEIGHT, false);
            app.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void init(GameContainer container) throws SlickException {
        // Add stuff that needs to be loaded once, at game load
        container.getGraphics().setBackground(BG_COLOR);

        //Set background music
        mainTetrisMusic = new Music("res/Tetris_theme.ogg");
        mainTetrisMusic.loop();

        // Load logo font
        this.logoFont = Utils.createFont("res/RacingSansOne-Regular.ttf", 42f);

        // create grid data
        this.currentBlock = new Block(BlockType.L_FORM);

        //Generates a random block
        int blockNumber = randomBlockNumber();
        currentBlock = new Block(list_block[blockNumber]);

    }

    @Override
    public void update(GameContainer container, int delta) throws SlickException {

        this.grid = this.getGridState(this.oldBlocks);

        this.sinceTick += delta;
        if (this.sinceTick >= 1000) {
            if(this.blockCanMoveDown(currentBlock)) {
                currentBlock.moveBlockDown();
            } else {
                oldBlocks.add(currentBlock);
                int blockNumber = randomBlockNumber();
                currentBlock = new Block(list_block[blockNumber]);
            }
            this.sinceTick = 0;
        }

    }

    private boolean[][] getGridState(ArrayList<Block> blocks) {
        boolean[][] newState = new boolean[GRID_WIDTH][GRID_HEIGHT];
        for (Block b : blocks) {
            for (Position p : b.getPosition()) {
                newState[p.x][p.y] = true;
            }
        }

        return newState;
    }

    public void render(GameContainer container, Graphics g) throws SlickException {
        // Logotype
        g.setColor(Color.white);
        container.getGraphics().setFont(logoFont);
        g.drawString("SuperTetris", 10, 40);

        // Background rectangles
        g.setColor(UI_COLOR);
        g.fillRect(10, 100, GAME_WINDOW_WIDTH, WINDOW_HEIGHT - 120);
        g.fillRect(WINDOW_WIDTH - 300, 100, 270, 500);

        // Score text
        g.setColor(Color.white);
        container.getGraphics().setFont(logoFont);
        g.drawString("Score: ",510,100);
        g.drawString("100"/* TODO: Insert score method here*/,650,100);

        // Grid
        for (int y = 0; y < GRID_HEIGHT; y++) {
            for (int x = 0; x < GRID_WIDTH; x++) {
                g.setColor(Color.black);
                g.drawRect(10 + x * GRID_SQUARE_SIZE, 100 + y * GRID_SQUARE_SIZE, GRID_SQUARE_SIZE, GRID_SQUARE_SIZE);
            }
        }

        for (Block b : oldBlocks) {
            this.drawBlock(g, b);
        }

        this.drawBlock(g, currentBlock);
    }

    // TODO: Would probably be nicer to have this method in some kind of renderUtils class
    private void drawBlock(Graphics g, Block block) {
        Position[] positions = this.getPixelPosition(block.getPosition());

        g.setColor(block.getColor());
        g.fillRect(positions[0].x, positions[0].y,SuperTetris.GRID_SQUARE_SIZE,SuperTetris.GRID_SQUARE_SIZE);
        g.fillRect(positions[1].x, positions[1].y,SuperTetris.GRID_SQUARE_SIZE,SuperTetris.GRID_SQUARE_SIZE);
        g.fillRect(positions[2].x, positions[2].y,SuperTetris.GRID_SQUARE_SIZE,SuperTetris.GRID_SQUARE_SIZE);
        g.fillRect(positions[3].x, positions[3].y,SuperTetris.GRID_SQUARE_SIZE,SuperTetris.GRID_SQUARE_SIZE);

        g.setColor(Color.black);
        g.drawRect(positions[0].x, positions[0].y,SuperTetris.GRID_SQUARE_SIZE,SuperTetris.GRID_SQUARE_SIZE);
        g.drawRect(positions[1].x, positions[1].y,SuperTetris.GRID_SQUARE_SIZE,SuperTetris.GRID_SQUARE_SIZE);
        g.drawRect(positions[2].x, positions[2].y,SuperTetris.GRID_SQUARE_SIZE,SuperTetris.GRID_SQUARE_SIZE);
        g.drawRect(positions[3].x, positions[3].y,SuperTetris.GRID_SQUARE_SIZE,SuperTetris.GRID_SQUARE_SIZE);

    }

    // TODO: Move blockCanMoveDown out from this class
    private boolean blockCanMoveDown(Block block) {
        Position[] currPos = block.getPosition();
        boolean canMove = true;
        for (Position p : currPos) {
            if ((p.y == GRID_HEIGHT - 1) || (grid[p.x][p.y + 1])) {
                canMove = false;
                continue;
            }
        }
        return canMove;
    }

    private boolean blockCanMoveLeft(Block block) {
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

    private boolean blockCanMoveRight(Block block) {
        Position[] currPos = block.getPosition();
        boolean canMove = true;
        for (Position p : currPos) {
            if ((p.x == GRID_WIDTH - 1) || (grid[p.x + 1][p.y])) {
                canMove = false;
                continue;
            }
        }
        return canMove;
    }

    // TODO: Move getPixelPosition out from this class
    // Returns pixel positions from grid position
    public Position[] getPixelPosition(Position[] pos) {
        int X_PADDING = 10;
        int Y_PADDING = 100;
        Position[] pixelPos = {
                new Position(pos[0].x * BLOCK_SIZE + X_PADDING, pos[0].y * BLOCK_SIZE + Y_PADDING),
                new Position(pos[1].x * BLOCK_SIZE + X_PADDING, pos[1].y * BLOCK_SIZE + Y_PADDING),
                new Position(pos[2].x * BLOCK_SIZE + X_PADDING, pos[2].y * BLOCK_SIZE + Y_PADDING),
                new Position(pos[3].x * BLOCK_SIZE + X_PADDING, pos[3].y * BLOCK_SIZE + Y_PADDING)
        };
        return pixelPos;
    }

    public void keyPressed(int key, char c) {
        if (key == Input.KEY_LEFT && this.blockCanMoveLeft(currentBlock)) {
            currentBlock.moveBlockLeft();
        }
        else if (key == Input.KEY_RIGHT && this.blockCanMoveRight(currentBlock)){
            currentBlock.moveBlockRight();
        }
        else if (key == Input.KEY_DOWN && this.blockCanMoveDown(currentBlock)){
            currentBlock.moveBlockDown();
        } else if (key == Input.KEY_M) {
            if(mainTetrisMusic.playing()) {
                mainTetrisMusic.pause();
            } else {
                mainTetrisMusic.resume();
            }
        }
    }

    private int randomBlockNumber(){
        Random rand = new Random();
        randInt = rand.nextInt(7);

        return randInt;
    }
}