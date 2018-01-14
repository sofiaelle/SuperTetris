package SuperTetris;

import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.util.ResourceLoader;

import java.awt.*;
import java.io.InputStream;

public class Utils {
    public static TrueTypeFont createFont(String filepath, float fontSize) {
        Font awtFont = null;
        try {
            InputStream is = ResourceLoader.getResourceAsStream(filepath);
            awtFont = Font.createFont(Font.TRUETYPE_FONT, is);
            awtFont = awtFont.deriveFont(fontSize);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new TrueTypeFont(awtFont, true);
    }
}
