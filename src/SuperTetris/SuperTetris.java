package SuperTetris;

import org.newdawn.slick.*;

public class SuperTetris extends BasicGame {

    private static int WINDOW_WIDTH = 800;
    private static int WINDOW_HEIGHT = 1000;
    private static int GAME_WINDOW_WIDTH =WINDOW_WIDTH-350;
    private static Color BG_COLOR = new Color(0.2f, 0.1f, 0.5f, 1f);
    private static Color UI_COLOR = new Color(0.5f,0.5f,1.0f, 1f);
    private static int SPAWN_X1 =100;
    private static int SPAWN_X2 =GAME_WINDOW_WIDTH/10;
    private static int SPAWN_Y1 =100;
    private static int SPAWN_Y2 =GAME_WINDOW_WIDTH/10;
    private TrueTypeFont logoFont;
    Block block1 = new Block(BlockType.CUBE);


    public SuperTetris() {
        super("SuperTetris");
    }

    public static void main(String[] args) {
        try
        {
            AppGameContainer app = new AppGameContainer(new SuperTetris());
            app.setDisplayMode(WINDOW_WIDTH, WINDOW_HEIGHT, false);
            app.start();
        }
        catch (SlickException e)
        {
            e.printStackTrace();
        }
    }

    public static void drawBlock(Block block, Graphics g) {
        System.out.println("Type of block: " + block.getType());

/*
        //Block1 (pyramid)
        g.setColor(Color.cyan);
        g.fillRect(SPAWN_X1,SPAWN_Y1,SPAWN_X2,SPAWN_Y2);
        g.fillRect(SPAWN_X1+SPAWN_X2,SPAWN_Y1+SPAWN_Y2,SPAWN_X2,SPAWN_Y2);
        g.fillRect(SPAWN_X1+SPAWN_X2,SPAWN_Y1,SPAWN_X2,SPAWN_Y2);
        g.fillRect(SPAWN_X1+SPAWN_X2*2,SPAWN_Y1,SPAWN_X2,SPAWN_Y2);

        g.setColor(Color.black);
        g.drawRect(SPAWN_X1,SPAWN_Y1,SPAWN_X2,SPAWN_Y2);
        g.drawRect(SPAWN_X1+SPAWN_X2,SPAWN_Y1+SPAWN_Y2,SPAWN_X2,SPAWN_Y2);
        g.drawRect(SPAWN_X1+SPAWN_X2,SPAWN_Y1,SPAWN_X2,SPAWN_Y2);
        g.drawRect(SPAWN_X1+SPAWN_X2*2,SPAWN_Y1,SPAWN_X2,SPAWN_Y2);


        //block2 (straight line)
        g.setColor(Color.magenta);
        g.fillRect(SPAWN_X1,SPAWN_Y1,SPAWN_X2,SPAWN_Y2);
        g.fillRect(SPAWN_X1+SPAWN_X2,SPAWN_Y1,SPAWN_X2,SPAWN_Y2);
        g.fillRect(SPAWN_X1+SPAWN_X2*2,SPAWN_Y1,SPAWN_X2,SPAWN_Y2);
        g.fillRect(SPAWN_X1+SPAWN_X2*3,SPAWN_Y1,SPAWN_X2,SPAWN_Y2);

        g.setColor(Color.black);
        g.drawRect(SPAWN_X1,SPAWN_Y1,SPAWN_X2,SPAWN_Y2);
        g.drawRect(SPAWN_X1+SPAWN_X2,SPAWN_Y1,SPAWN_X2,SPAWN_Y2);
        g.drawRect(SPAWN_X1+SPAWN_X2*2,SPAWN_Y1,SPAWN_X2,SPAWN_Y2);
        g.drawRect(SPAWN_X1+SPAWN_X2*3,SPAWN_Y1,SPAWN_X2,SPAWN_Y2);


        //block3 (z-form)
        g.setColor(Color.green);
        g.fillRect(SPAWN_X1,SPAWN_Y1,SPAWN_X2,SPAWN_Y2);
        g.fillRect(SPAWN_X1+SPAWN_X2,SPAWN_Y1,SPAWN_X2,SPAWN_Y2);
        g.fillRect(SPAWN_X1+SPAWN_X2,SPAWN_Y1+SPAWN_Y2,SPAWN_X2,SPAWN_Y2);
        g.fillRect(SPAWN_X1+SPAWN_X2*2,SPAWN_Y1+SPAWN_Y2,SPAWN_X2,SPAWN_Y2);

        g.setColor(Color.black);
        g.drawRect(SPAWN_X1,SPAWN_Y1,SPAWN_X2,SPAWN_Y2);
        g.drawRect(SPAWN_X1+SPAWN_X2,SPAWN_Y1,SPAWN_X2,SPAWN_Y2);
        g.drawRect(SPAWN_X1+SPAWN_X2,SPAWN_Y1+SPAWN_Y2,SPAWN_X2,SPAWN_Y2);
        g.drawRect(SPAWN_X1+SPAWN_X2*2,SPAWN_Y1+SPAWN_Y2,SPAWN_X2,SPAWN_Y2);


        //block4 (reverse z)
        g.setColor(Color.blue);
        g.fillRect(SPAWN_X1,SPAWN_Y1+SPAWN_Y2,SPAWN_X2,SPAWN_Y2);
        g.fillRect(SPAWN_X1+SPAWN_X2,SPAWN_Y1+SPAWN_Y2,SPAWN_X2,SPAWN_Y2);
        g.fillRect(SPAWN_X1+SPAWN_X2,SPAWN_Y1,SPAWN_X2,SPAWN_Y2);
        g.fillRect(SPAWN_X1+SPAWN_X2*2,SPAWN_Y1,SPAWN_X2,SPAWN_Y2);

        g.setColor(Color.black);
        g.drawRect(SPAWN_X1,SPAWN_Y1+SPAWN_Y2,SPAWN_X2,SPAWN_Y2);
        g.drawRect(SPAWN_X1+SPAWN_X2,SPAWN_Y1+SPAWN_Y2,SPAWN_X2,SPAWN_Y2);
        g.drawRect(SPAWN_X1+SPAWN_X2,SPAWN_Y1,SPAWN_X2,SPAWN_Y2);
        g.drawRect(SPAWN_X1+SPAWN_X2*2,SPAWN_Y1,SPAWN_X2,SPAWN_Y2);


        //block5 (cube)
        g.setColor(Color.yellow);
        g.fillRect(SPAWN_X1,SPAWN_Y1,SPAWN_X2,SPAWN_Y2);
        g.fillRect(SPAWN_X1+SPAWN_X2,SPAWN_Y1,SPAWN_X2,SPAWN_Y2);
        g.fillRect(SPAWN_X1,SPAWN_Y1+SPAWN_Y2,SPAWN_X2,SPAWN_Y2);
        g.fillRect(SPAWN_X1+SPAWN_X2,SPAWN_Y1+SPAWN_Y2,SPAWN_X2,SPAWN_Y2);

        g.setColor(Color.black);
        g.drawRect(SPAWN_X1,SPAWN_Y1,SPAWN_X2,SPAWN_Y2);
        g.drawRect(SPAWN_X1+SPAWN_X2,SPAWN_Y1,SPAWN_X2,SPAWN_Y2);
        g.drawRect(SPAWN_X1,SPAWN_Y1+SPAWN_Y2,SPAWN_X2,SPAWN_Y2);
        g.drawRect(SPAWN_X1+SPAWN_X2,SPAWN_Y1+SPAWN_Y2,SPAWN_X2,SPAWN_Y2);


        //block6 (L-form)
        g.setColor(Color.red);
        g.fillRect(SPAWN_X1,SPAWN_Y1,SPAWN_X2,SPAWN_Y2);
        g.fillRect(SPAWN_X1+SPAWN_X2,SPAWN_Y1,SPAWN_X2,SPAWN_Y2);
        g.fillRect(SPAWN_X1+SPAWN_X2*2,SPAWN_Y1,SPAWN_X2,SPAWN_Y2);
        g.fillRect(SPAWN_X1,SPAWN_Y1+SPAWN_Y2,SPAWN_X2,SPAWN_Y2);

        g.setColor(Color.black);
        g.drawRect(SPAWN_X1,SPAWN_Y1,SPAWN_X2,SPAWN_Y2);
        g.drawRect(SPAWN_X1+SPAWN_X2,SPAWN_Y1,SPAWN_X2,SPAWN_Y2);
        g.drawRect(SPAWN_X1+SPAWN_X2*2,SPAWN_Y1,SPAWN_X2,SPAWN_Y2);
        g.drawRect(SPAWN_X1,SPAWN_Y1+SPAWN_Y2,SPAWN_X2,SPAWN_Y2);


        //block7 (reverse L)
        g.setColor(Color.pink);
        g.fillRect(SPAWN_X1,SPAWN_Y1,SPAWN_X2,SPAWN_Y2);
        g.fillRect(SPAWN_X1+SPAWN_X2,SPAWN_Y1,SPAWN_X2,SPAWN_Y2);
        g.fillRect(SPAWN_X1+SPAWN_X2*2,SPAWN_Y1,SPAWN_X2,SPAWN_Y2);
        g.fillRect(SPAWN_X1+SPAWN_X2*2,SPAWN_Y1+SPAWN_Y2,SPAWN_X2,SPAWN_Y2);

        g.setColor(Color.black);
        g.drawRect(SPAWN_X1,SPAWN_Y1,SPAWN_X2,SPAWN_Y2);
        g.drawRect(SPAWN_X1+SPAWN_X2,SPAWN_Y1,SPAWN_X2,SPAWN_Y2);
        g.drawRect(SPAWN_X1+SPAWN_X2*2,SPAWN_Y1,SPAWN_X2,SPAWN_Y2);
        g.drawRect(SPAWN_X1+SPAWN_X2*2,SPAWN_Y1+SPAWN_Y2,SPAWN_X2,SPAWN_Y2);


*/


    }

    @Override
    public void init(GameContainer container) throws SlickException
    {
        // Add stuff that needs to be loaded once, at game load
        container.getGraphics().setBackground(BG_COLOR);

        // Load logo font
        this.logoFont = Utils.createFont("res/RacingSansOne-Regular.ttf", 42f);


    }

    @Override
    public void update(GameContainer container, int delta) throws SlickException
    {
        // Game logic that happens at each tick
    }

    public void render(GameContainer container, Graphics g) throws SlickException
    {
        // Logotype
        g.setColor(Color.white);
        container.getGraphics().setFont(logoFont);
        g.drawString("SuperTetris", 10, 40);

        // Background rectangles
        g.setColor(UI_COLOR);
        g.fillRect(10,100,GAME_WINDOW_WIDTH,WINDOW_HEIGHT-120);
        g.fillRect(WINDOW_WIDTH-300,100,270,500);

        drawBlock(block1,g);
    }
}