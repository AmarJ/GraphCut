import java.util.Arrays;

public class Test {

	public static void main(String[] args) {
		
		Graph G = new Graph();
		
		Vertex[][] V = new Vertex[3][5];
	
		V[0][0] = new Vertex("A");
		V[0][1] = new Vertex("B");
		V[0][2] = new Vertex("C");
		V[0][3] = new Vertex("D");
		V[1][0] = new Vertex("E");
		V[1][1] = new Vertex("F");
		V[1][2] = new Vertex("G");
		V[1][3] = new Vertex("H");
		V[2][0] = new Vertex("I");
		V[2][1] = new Vertex("J");
		V[2][2] = new Vertex("K");
		V[2][3] = new Vertex("L");
		V[2][4] = new Vertex("M");

		for (int i=0;i<3;i++){
			for (int j=0;j<4;j++){
				G.addVertex(V[i][j]);
			}
		}
		
		G.addEdge(V[0][0], V[0][1], 1);
		G.addEdge(V[0][1], V[0][2], 1);
		
		
		System.out.println("Graph 1: deg"+Arrays.toString(G.getDegreeSequence()));
		System.out.println(G.getEdges());
		System.out.println(G.containsVertex(V[0][0]));
		System.out.println(G.containsVertex(V[2][4]));
		
		//Petersen graph 
		/*
		Graph petersenG = new Graph();

		V = new Vertex[10];
		
		V[0] = new Vertex("0");
		V[1] = new Vertex("1");
		V[2] = new Vertex("2");
		V[3] = new Vertex("3");
		V[4] = new Vertex("4");
		V[5] = new Vertex("5");
		V[6] = new Vertex("6");
		V[7] = new Vertex("7");
		V[8] = new Vertex("8");
		V[9] = new Vertex("9");
		
		for (int i=0;i<V.length;i++){
			petersenG.addVertex(V[i]);
		}
		
		//Ver 0
		petersenG.addEdge(V[0], V[1]);
		petersenG.addEdge(V[0], V[4]);
		petersenG.addEdge(V[0], V[7]);
		
		//Ver 1
		petersenG.addEdge(V[1], V[5]);
		petersenG.addEdge(V[1], V[2]);
		
		//Ver 2
		petersenG.addEdge(V[2], V[3]);
		petersenG.addEdge(V[2], V[9]);
		
		//Ver 3
		petersenG.addEdge(V[3], V[4]);
		petersenG.addEdge(V[3], V[6]);
		
		//Ver 4
		petersenG.addEdge(V[4], V[8]);

		//Ver 5
		petersenG.addEdge(V[5], V[6]);
		petersenG.addEdge(V[5], V[8]);

		//Ver 6
		petersenG.addEdge(V[6], V[7]);
		
		//Ver 7
		petersenG.addEdge(V[7], V[9]);
		
		//Ver 8
		petersenG.addEdge(V[8], V[9]);
				
		//System.out.println("Petersen graph: deg"+Arrays.toString(petersenG.getDegreeSequence()));
		//System.out.println(petersenG.getEdges());
		*/
	}
	
	

}
