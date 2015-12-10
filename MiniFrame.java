
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.MemoryImageSource;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MiniFrame extends JFrame {
    private static final long serialVersionUID = 1L;
	MiniGraph Canvas;
    class RenderPanel extends JPanel {
        private static final long serialVersionUID = 1L;
        public void paint(Graphics graphics) {
            super.paintComponent(graphics);
            MemoryImageSource source;
        	int width = this.getWidth();
        	int height = this.getHeight();
            Graphics g2d = (Graphics2D) graphics;
            Canvas = new MiniGraph(width,height);
            source = new MemoryImageSource(width, height, Canvas.getPixels(), 0, width);
            source.setAnimated(true);
            Image img = createImage(source);
            g2d.drawImage(img,0,0,this);
        }
    }
    public MiniFrame(String title) {
    	super(title);
        this.add(new RenderPanel());
        this.setSize(800, 600);
    }
    public static void main(String[] args) {
        MiniFrame frame = new MiniFrame("Graphics2D");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
