import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class Window {
	
	public static String image = "img8.jpg";
	
	public static String output = "demo_output/output_"+image+".png";
	
	public static BufferedImage readImage(String fileLocation) {
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File(fileLocation));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return img;
	}

	public static void Window() {
			
		TakeBlackPointsFromImage example = new TakeBlackPointsFromImage();
		
		BufferedImage image1 = readImage("demo_input/"+image);
		//pick color of rendered drawing
		example.changeColor(Color.red);
		//shades of grey that it scans for 0(Black)->255(pure white)
		example.changeShade(190);
		int width = image1.getWidth();
		int height = image1.getHeight() + 30;
		
		JFrame frame = new JFrame("ReDraw");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(example);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setSize(width, height);
	    //frame.setBackground(Color.red);
		
		//saves it as a png
		try {
			BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
			Graphics2D g = image.createGraphics();
			example.setSize(width, height);
			layoutComponent(example);
			example.print(g);
			
			ImageIO.write(image,"PNG", new File(output));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void init() {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				Window();
			}
		});
	}
	
	private static void layoutComponent(Component component) {
	    synchronized (component.getTreeLock()) {
	        component.doLayout();

	        if (component instanceof Container) {
	            for (Component child : ((Container) component).getComponents()) {
	                layoutComponent(child);
	            }
	        }
	    }
	}

}
