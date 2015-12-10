
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.image.*;

public class MiniFrame extends JFrame {
    private static final long serialVersionUID = 1L;
    class MyPanel extends JPanel {
        private static final long serialVersionUID = 1L;
        public void paint(Graphics graphics) {
            super.paintComponent(graphics);
            Graphics g2d = (Graphics2D) graphics;
            MemoryImageSource source;
            int width = getSize().width, height = getSize().height;
            int size = width * height;
            int[] pixels = new int[size];
            for (int i = 0; i < size; i++) {
                pixels[i] = getARGB((int)(i*1.0/size*255),(int)(i*1.0/size*255),(int)(i*1.0/size*60),255);
            }
            source = new MemoryImageSource(width, height, pixels, 0, width);
            source.setAnimated(true);
            Image img = createImage(source);
            g2d.drawImage(img,0,0,this);
        }
        public int getARGB( int r, int g, int b, int alpha) {
            return (alpha << 24) | (r << 16) | (g << 8) | b;
        }
    }
    public MiniFrame(String title) {
    	super(title);
        this.add(new MyPanel());
        this.setSize(800, 600);
    }
    public static void main(String[] args) {
        MiniFrame frame = new MiniFrame("Graphics2D");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
