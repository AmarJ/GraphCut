import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import javax.imageio.ImageIO;
import javax.swing.JPanel;


class TakeBlackPointsFromImage extends JPanel {

	private static String image;

	private static final long serialVersionUID = 1L;
	
	private Color imgColor = Color.BLACK;
	
	private static int SHADE = 190;
	
	public static BufferedImage readImage(String fileLocation) {
		
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File(fileLocation));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return img;
	}



	public static int takeNumberOfDesiredPixels(){
		BufferedImage image22 = readImage(image);
		image22 = toBlackAndWhite(image22);
		int numOfPix = 0; 
		int width = image22.getWidth();
		int height = image22.getHeight();
		
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {

				int pixel = image22.getRGB(i, j);
				int red = (pixel >> 16) & 0x000000FF;
				int green = (pixel >> 8) & 0x000000FF;
				int blue = (pixel) & 0x000000FF;
				
				for (int p=0;p<SHADE;p++){
					if (red == p && green == p && blue == p) {
						numOfPix++;
					}				
				}
			}
		}
		return numOfPix;
	}
	
	public static int[] getXCoordinates() {
		BufferedImage image22 = readImage(image);
		image22 = toBlackAndWhite(image22);
		int width = image22.getWidth();
		int height = image22.getHeight();
		
		int[] ArrayX = new int[takeNumberOfDesiredPixels()];
		
		int d = -1;
		
		for (int w = 0; w < width; w++) {
			for (int h = 0; h < height; h++) {

				int pixel = image22.getRGB(w, h);
				
				int red = (pixel >> 16) & 0x000000FF;
				/** 
				 * 	Shift all bits to the right as 16 bit
				 * then multiply or sth like filter with
				 * 0x000000FF then get the only last 8 bit 
				 * which is the red information 
				 * between 0 and 255
				 * **/
				int green = (pixel >> 8) & 0x000000FF;
				/** 
				 * 	Shift all bits to the rigt as 8 bit
				 * then multiply or sth like filter with
				 * 0x000000FF then get the only last 8 bit 
				 * which is the green information 
				 * between 0 and 255
				 * **/
				
				int blue = (pixel) & 0x000000FF;
				/**
				 * multiply or sth like filter with
				 * 0x000000FF then get the only last 8 bit 
				 * which is the blue information 
				 * between 0 and 255
				 * **/
				
				for (int i=0;i<SHADE;i++){
					if (red == i && green == i && blue == i) { 
						d++;
						ArrayX[d] = w;
					}				
				}
			}
			}
		return ArrayX;
	}

	public static int[] getYCoordinates() {
		BufferedImage image22 = readImage(image);
		image22 = toBlackAndWhite(image22);
		int width = image22.getWidth();
		int height = image22.getHeight();
		
		int[] ArrayY = new int[takeNumberOfDesiredPixels()];

		int d = -1;
		//stack overflow helped here :)
		for (int w = 0; w < width; w++) {
			for (int h = 0; h < height; h++) {

				int pixel = image22.getRGB(w, h);
				int red = (pixel >> 16) & 0x000000FF;
				int green = (pixel >> 8) & 0x000000FF;
				int blue = (pixel) & 0x000000FF;
				
				for (int i=0;i<SHADE;i++){
					if (red == i && green == i && blue == i) {
						d++;
						ArrayY[d] = h;
					}				
				}
			}
		}
		return ArrayY;
	}

	@Override
	protected void paintComponent(Graphics g) {
	
		int c[] =getXCoordinates();
		int a = c.length;

		int d[] =getYCoordinates();

		g.setColor(imgColor);
		for (int y = 0; y < a; y++) {

			g.drawLine(c[y],d[y],c[y],d[y]);
		}
	}
	
	public void changeColor(Color col){
		imgColor = col;
	}
	
	public void changeShade(int num){
		SHADE = num;
	}
	
	public void changeImg(String img){
		image = img;
	}
	
	//converts to greyscale
	private static BufferedImage toBlackAndWhite(BufferedImage image){ 
		try {
	         int width = image.getWidth();
	         int height = image.getHeight();
	         
	         for(int i=0; i<height; i++){
	         
	            for(int j=0; j<width; j++){
	            
	               Color c = new Color(image.getRGB(j, i));
	               int red = (int)(c.getRed() * 0.299);
	               int green = (int)(c.getGreen() * 0.587);
	               int blue = (int)(c.getBlue() *0.114);
	               Color newColor = new Color(red+green+blue,
	               
	               red+green+blue,red+green+blue);
	               
	               image.setRGB(j,i,newColor.getRGB());
	            }
	         }
	         
	         return image;
	         
	      } catch (Exception e) {}
			
		return image;
	}
	
}