import Mmath.*;

public class MiniGraph {
	int width;
	int height;
	int[] pixels;
	public MiniGraph(int width, int height){
        int size = width * height;
        pixels = new int[size];
        /*for (int i = 0; i < size; i++) {
            pixels[i] = getARGB((int)(i*1.0/size*255),(int)(i*1.0/size*255),(int)(i*1.0/size*60),255);
        }*/
        for (int y = 0,i = 0; y < height; y++) {
        	for(int x = 0; x < width; x++,i++){
        		pixels[i] = getARGB(x*255.0/width,y*255.0/height,0,255);
        	}
        }
	}
    private int getARGB( int r, int g, int b, int alpha) {
    	r = Mbasic.Isinclude(r, 0, 255);
    	g = Mbasic.Isinclude(g, 0, 255);
    	b = Mbasic.Isinclude(b, 0, 255);
    	alpha = Mbasic.Isinclude(alpha, 0, 255);
        return (alpha << 24) | (r << 16) | (g << 8) | b;
    }
    private int getARGB( double r, double g, double b, double alpha) {
    	return getARGB((int)r,(int)g,(int)b,(int)alpha);
    }
    public int[] getPixels(){
    	return pixels;
    }
    public void setPixels(int pos,int r, int g, int b, int alpha){
    	pixels[pos] = getARGB(r,g,b,alpha);
    }
    public void setPixels(int pos,int argb){
    	pixels[pos] = argb;
    }
}
