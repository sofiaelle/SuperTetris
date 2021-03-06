package SuperTetris;

import org.newdawn.slick.*;
import java.util.Random;
import java.util.ArrayList;
import java.util.Stack;

public class SuperTetris extends BasicGame {

    private static int WINDOW_WIDTH = 800;
    private static int WINDOW_HEIGHT = 1020;
    public static int GAME_WINDOW_WIDTH = WINDOW_WIDTH - 350;
    private static int GRID_WIDTH = 10;
    private static int GRID_HEIGHT = 20;
    public static int GRID_SQUARE_SIZE = GAME_WINDOW_WIDTH / GRID_WIDTH;
    public static int BLOCK_SIZE = GRID_SQUARE_SIZE;
    private static Color BG_COLOR = new Color(0.2f, 0.1f, 0.5f, 1f);
    private static Color UI_COLOR = new Color(0.5f, 0.5f, 1.0f, 1f);
    private int sinceTick = 0;
    private int randInt;
    private Block currentBlock;
    Music mainTetrisMusic;
    private TrueTypeFont logoFont;
    private boolean[][] grid = new boolean[GRID_WIDTH][GRID_HEIGHT];
    private Block incomingBlock;

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
        currentBlock = new Block(list_block[randomBlockNumber()]);

        //Creates the incoming block
        incomingBlock = new Block(list_block[randomBlockNumber()]);

    }

    @Override
    public void update(GameContainer container, int delta) throws SlickException {

        this.grid = this.getGridState(this.oldBlocks);

        this.sinceTick += delta;
        if (this.sinceTick >= 1000) {
            if(Collision.blockCanMoveDown(this.grid, currentBlock)) {
                currentBlock.moveBlockDown();
            } else {
                oldBlocks.add(currentBlock);
                currentBlock = incomingBlock;
                incomingBlock = new Block(list_block[randomBlockNumber()]);
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

        //Next block text
        g.drawString("Next block:", 510,150 );

        // Grid
        for (int y = 0; y < GRID_HEIGHT; y++) {
            for (int x = 0; x < GRID_WIDTH; x++) {
                g.setColor(Color.black);
                g.drawRect(10 + x * GRID_SQUARE_SIZE, 100 + y * GRID_SQUARE_SIZE, GRID_SQUARE_SIZE, GRID_SQUARE_SIZE);
            }
        }

        for (Block b : oldBlocks) {
            RenderUtils.drawBlock(g, b);
        }

        RenderUtils.drawIncomingBlock(g,incomingBlock);

        RenderUtils.drawBlock(g, currentBlock);

    }

    public void keyPressed(int key, char c) {
        if (key == Input.KEY_LEFT && Collision.blockCanMoveLeft(this.grid, currentBlock)) {
            currentBlock.moveBlockLeft();
        }
        else if (key == Input.KEY_RIGHT && Collision.blockCanMoveRight(this.grid, currentBlock)){
            currentBlock.moveBlockRight();
        }
        else if (key == Input.KEY_DOWN && Collision.blockCanMoveDown(this.grid, currentBlock)){
            currentBlock.moveBlockDown();
        } else if (key == Input.KEY_M) {
            if(mainTetrisMusic.playing()) {
                mainTetrisMusic.pause();
            } else {
                mainTetrisMusic.resume();
            }
        }/*else if (key == Input.KEY_UP && Collision.blockCanRotate(this.grid, currentBlock)){
            currentBlock.rotateBlock();
        }*/
    }

    private int randomBlockNumber(){
        Random rand = new Random();
        randInt = rand.nextInt(7);

        return randInt;
    }
}