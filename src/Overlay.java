import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import javax.imageio.ImageIO;

public class Overlay {
	
	private static String imageLocation;
	private BufferedImage image;
	private static Graph[] graphs;
	private static int imageWidth;
	private static int imageHeight;
	
	public Overlay(String imageLocation){
		this.image = readImage(imageLocation);
		this.imageWidth = image.getWidth();
		this.imageHeight = image.getHeight();
		this.graphs = new Graph[imageHeight];
	}
	
	public static void graphOver(){
		
		Graph[] graphs = new Graph[imageHeight];
		
		Graph overlay1 = new Graph();
		
		Vertex[][] V = new Vertex[imageHeight][imageWidth];
		
		for (int i = 0; i < imageHeight; i++) {
			overlay1 = new Graph();
			V = new Vertex[imageHeight][imageWidth];
			for (int j = 0; j < imageWidth; j++) {
				V[j][i] = new Vertex(j+","+i);
				overlay1.addVertex(V[j][i]);
				if (j>0){
					overlay1.addEdge(V[j][i], V[j-1][i], 0);
				}
			}
			graphs[i] = overlay1;
		}
		printGraph(graphs, 2);
	}
	
	private static void printGraph(Graph[] e){
		for (int i=0;i<e.length;i++){
			System.out.println("Graph "+i+": "+Arrays.toString(e[i].getDegreeSequence()));
		}
	}
	
	private static void printGraph(Graph[] e, int line){
		System.out.println("Graph "+line+": "+Arrays.toString(e[line].getDegreeSequence()));
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
}
