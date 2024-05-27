package view;

import java.awt.*;

public class GraphicsUtils {

    public static void fillOval(Graphics g, int centerX, int centerY, int diam1, int diam2) {
        g.fillOval(centerX - diam1 / 2, centerY - diam2 / 2, diam1, diam2);
    }

    public static void drawOval(Graphics g, int centerX, int centerY, int diam1, int diam2) {
        g.drawOval(centerX - diam1 / 2, centerY - diam2 / 2, diam1, diam2);
    }

    public static int round(double value) {
        return (int) (value + 0.5);
    }

    public static void drawRect(Graphics g, int x, int y, int height, int width) {
        g.drawRect(x, y, width, height);
    }

    public static void fillRect(Graphics g, int x, int y, int height, int width) {
        g.fillRect(x, y, width, height);
    }
}
