package visualizer;

import java.util.ArrayList;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Font;
import javax.swing.JFrame;

public class Window extends JFrame {
    private int[] list;
    private int[] selectedIndexes;
    private int windowWidth;
    private int windowHeight;
    private int boxSize;
    private int padding;
    private String fontName;
    private int fontSize;
    private boolean selectAllItems = false;

    public Window(int[] list) {
        super();

        this.list = list;
        windowWidth = Config.windowWidth;
        windowHeight = Config.windowHeight;
        boxSize = Config.boxSize;
        padding = Config.padding;
        fontName = Config.fontName;
        fontSize = Config.fontSize;

        setPreferredSize(new Dimension(windowWidth, windowHeight));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setAlwaysOnTop(false);
        setBackground(Color.black);
                
        pack();
        setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        int count = list.length;

        g.clearRect(0, 0, windowWidth, windowHeight);
        g.setFont(new Font(fontName, Font.PLAIN, 20));

        for (int i = 0; i <= list.length-1; i++) {
            int number = list[i];

            Color boxColor = (
                i == selectedIndexes[0] || 
                i == selectedIndexes[1] ||
                selectAllItems
            ) ? Color.CYAN : Color.MAGENTA;

            // Calculate individual position for each box (together they have to be centered)
            int occuppiedWidth = Utils.calculateTotalBoxesWidth(count);
            // Base x position of centered occuppied area
            int x = (windowWidth - occuppiedWidth) / 2;
            // Add box width and padding to get exact x position
            x = x + (boxSize + padding) * i;
            int y = (windowHeight / 2) - (boxSize / 4);
            
            g.setColor(boxColor);
            g.drawRect(x, y, boxSize, boxSize);

            g.setColor(Color.WHITE);
            g.drawString(
                String.valueOf(number),
                x+(boxSize/2)-(fontSize/2),
                y+(boxSize/2)+(fontSize/2)
            );
        }
    }

    public void setSelectionIndexes(int[] indexes) {
        selectedIndexes = indexes;
    }
   
    public void selectAllItems() {
        selectAllItems = true;
        repaint();
    }

    public void updateList(int[] list) {
        this.list = list;
    }

}
