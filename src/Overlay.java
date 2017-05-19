import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.awt.Color;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Overlay extends JPanel {
	private static final long serialVersionUID = 1L;
	private static BufferedImage image;
	private Color imgColor = Color.BLACK;
	private static int imageWidth;
	private static int imageHeight;
	private static int SHADE = 200;
	private static Graph backgroundGraph;
	private static Graph foregroundGraph;
	private static Vertex[][] V;
	
	public Overlay(String imageLocation){
		this.image = readImage(imageLocation);
		this.imageWidth = image.getWidth();
		this.imageHeight = image.getHeight();
		this.V = new Vertex[imageWidth][imageHeight];
		this.backgroundGraph = new Graph();
		this.foregroundGraph = new Graph();
	}
	
	private static void graphOver(){
		
		image =  toBlackAndWhite(image);
		
		for (int x = 0; x < imageWidth; x++) {
			for (int y = 0; y < imageHeight; y++) {
			
				int pixel = image.getRGB(x, y);
				
				int red = (pixel >> 16) & 0x000000FF;
				/** 
				 * 	Shift all bits to the right as 16 bit
				 * then multiply or sth like filter with
				 * 0x000000FF then get the only last 8 bit 
				 * which is the red information 
				 * between 0 and 255
				 * **/
				int green = (pixel >> 8) & 0x000000FF;				
				int blue = (pixel) & 0x000000FF;

				V[x][y] = new Vertex(x+","+y);
				for (int p=0;p<SHADE;p++){	
					if (red == p && green == p && blue == p) { 
						foregroundGraph.addVertex(V[x][y]);
					} else {
						backgroundGraph.addVertex(V[x][y]);
					}
				}
			}	
		}
		
		/*weights
		for (int i=0;i<imageHeight;i++){
			for (int j=1;j<imageWidth;j++){
				foregroundGraphs[i].addEdge(V[i][j], V[i][j-1]);
			}
		}
		*/
	}
	
	
	private static void printGraph(Graph[] e){
		for (int i=0;i<e.length;i++){
			if (i<10)
				System.out.println("Graph "+i+" : "+Arrays.toString(e[i].getDegreeSequence()));
			else 
				System.out.println("Graph "+i+": "+Arrays.toString(e[i].getDegreeSequence()));
		}
	}
	
	private static void printGraph(Graph[] e, int line){
		System.out.println("Graph "+line+": "+Arrays.toString(e[line].getDegreeSequence()));
	}
	
	private static void printGraph(Graph e){
		System.out.println("Graph 1"+Arrays.toString(e.getDegreeSequence()));
	}
	
	public static BufferedImage readImage(String fileLocation) {
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File(fileLocation));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return img;
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		
		g.setColor(imgColor);
				
		graphOver();
		
		for (int x=0;x<imageWidth;x++){
			for (int y=0;y<imageHeight;y++){
				if (foregroundGraph.containsVertex(V[x][y])){
					g.drawLine(x,y,x,y);
				}
			}
		}
		
	}
	
	public void changeColor(Color col){
		imgColor = col;
	}
	
	public void changeShade(int num){
		SHADE = num;
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
