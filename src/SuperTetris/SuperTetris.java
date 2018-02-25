package SuperTetris;

import org.newdawn.slick.*;
//import java.util.TimerTask;

public class SuperTetris extends BasicGame {

    private static int WINDOW_WIDTH = 800;
    private static int WINDOW_HEIGHT = 1020;
    public static int GAME_WINDOW_WIDTH = WINDOW_WIDTH - 350;
    private static int GRID_WIDTH = 10;
    private static int GRID_HEIGTH = 20;
    public static int GRID_SQUARE_SIZE = GAME_WINDOW_WIDTH / GRID_WIDTH;
    private static Color BG_COLOR = new Color(0.2f, 0.1f, 0.5f, 1f);
    private static Color UI_COLOR = new Color(0.5f, 0.5f, 1.0f, 1f);
    private int since_tick = 0;
    private int tick_amount = 0;
    private int click_amount = 0;

    private TrueTypeFont logoFont;
    Block block1 = new Block(BlockType.CUBE);

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

        // Load logo font
        this.logoFont = Utils.createFont("res/RacingSansOne-Regular.ttf", 42f);

        // create grid data
        boolean[][] grid_data = new boolean[GRID_WIDTH][GRID_HEIGTH];

    }

    @Override
    public void update(GameContainer container, int delta) throws SlickException {
        // Game logic that happens at each tick

        since_tick += delta;
        //move block
        if (since_tick > 1000 && tick_amount <18){
            since_tick =0;
            tick_amount +=1;
            block1.moveBlockDown();
        }

        //change grid status
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

        // Grid
        for (int y = 0; y < GRID_HEIGTH; y++) {
            for (int x = 0; x < GRID_WIDTH; x++) {
                g.setColor(Color.black);
                g.drawRect(10 + x * GRID_SQUARE_SIZE, 100 + y * GRID_SQUARE_SIZE, GRID_SQUARE_SIZE, GRID_SQUARE_SIZE);
            }
        }

        block1.drawBlock(g);
    }
    public void keyPressed(int key, char c){
        if(key == Input.KEY_LEFT && click_amount > -4){
            block1.moveBlockLeft();
            click_amount -=1;
        }
        else if (key == Input.KEY_RIGHT && click_amount < 4){
            block1.moveBlockRight();
            click_amount +=1;
        }
        else if (key == Input.KEY_DOWN){
            block1.moveBlockDown();
        }
    }
}