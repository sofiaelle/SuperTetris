package SuperTetris;

import org.newdawn.slick.*;

public class SuperTetris extends BasicGame {

    private static int WINDOW_WIDTH = 800;
    private static int WINDOW_HEIGHT = 1000;
    private static Color BG_COLOR = new Color(0.2f, 0.1f, 0.5f, 1f);
    private static Color UI_COLOR = new Color(0.5f,0.5f,1.0f, 1f);

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

    public static void drawBlock(Block block) {
        System.out.println("Type of block: " + block.getType());
    }

    @Override
    public void init(GameContainer container) throws SlickException
    {
        // Add stuff that needs to be loaded once, at game load
        container.getGraphics().setBackground(BG_COLOR);
    }

    @Override
    public void update(GameContainer container, int delta) throws SlickException
    {
        // Game logic that happens at each tick
    }

    public void render(GameContainer container, Graphics g) throws SlickException
    {
        // All rendering

        // UI elements
        g.drawString("SuperTetris", 10, 40);
        g.setColor(UI_COLOR);
        g.fillRect(10,100,WINDOW_WIDTH-250,WINDOW_HEIGHT-200);
        g.fillRect(WINDOW_WIDTH-230,100,220,500);
    }
}