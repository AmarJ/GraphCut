package graph_overlay;
import java.util.*;

public class Graph {
    
    private HashMap<String, Vertex> vertices;
    private HashMap<Integer, Edge> edges;
    
    public Graph(){
        this.vertices = new HashMap<String, Vertex>();
        this.edges = new HashMap<Integer, Edge>();
    }

    public Graph(ArrayList<Vertex> vertices){
        this.vertices = new HashMap<String, Vertex>();
        this.edges = new HashMap<Integer, Edge>();
        
        for(Vertex v: vertices){
            this.vertices.put(v.getLabel(), v);
        }
    }

    public boolean addEdge(Vertex one, Vertex two){
        return addEdge(one, two, 1);
    }
    
    public boolean addEdge(Vertex one, Vertex two, int weight){
        if(one.equals(two)){
            return false;   
        }
       
        //ensures the Edge is not in the Graph
        Edge e = new Edge(one, two, weight);
        if(edges.containsKey(e.hashCode())){
            return false;
        }
       
        //and that the Edge isn't already incident to one of the vertices
        else if(one.containsNeighbor(e) || two.containsNeighbor(e)){
            return false;
        }
            
        edges.put(e.hashCode(), e);
        one.addNeighbor(e);
        two.addNeighbor(e);
        return true;
    }

    public boolean containsEdge(Edge e){
        if(e.getOne() == null || e.getTwo() == null){
            return false;
        }
        
        return this.edges.containsKey(e.hashCode());
    }

    public Edge removeEdge(Edge e){
       e.getOne().removeNeighbor(e);
       e.getTwo().removeNeighbor(e);
       return this.edges.remove(e.hashCode());
    }

    public boolean containsVertex(Vertex vertex){
        return this.vertices.get(vertex.getLabel()) != null;
    }

    public Vertex getVertex(String label){
        return vertices.get(label);
    }

    public boolean addVertex(Vertex vertex){
        Vertex current = this.vertices.get(vertex.getLabel());
        if(current != null){ 
            while(current.getNeighborCount() > 0){
                this.removeEdge(current.getNeighbor(0));
            }
        }
        
        
        vertices.put(vertex.getLabel(), vertex);
        return true;
    }

    public Vertex removeVertex(String label){
        Vertex v = vertices.remove(label);
        
        while(v.getNeighborCount() > 0){
            this.removeEdge(v.getNeighbor((0)));
        }
        
        return v;
    }

    public Set<String> vertexKeys(){
        return this.vertices.keySet();
    }

    public Set<Edge> getEdges(){
        return new HashSet<Edge>(this.edges.values());
    }
    
    
    public int[] getDegreeSequence(){
    	int[] degSeq = new int[this.vertices.size()];
    	Iterator V = this.vertices.keySet().iterator();
    	int i=0;
    	
    	while (V.hasNext() && i<this.vertices.size()){
    		degSeq[i] = this.vertices.get(V.next()).getNeighborCount();
    		i++;
    	}
    	
    	return degSeq;
    }
    
    
}
