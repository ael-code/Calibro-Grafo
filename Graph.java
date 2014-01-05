import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Graph {
	private HashMap<Integer, List<Edge>> incidence; 
	private ArrayList<Edge> edges;

	public Graph() {
		incidence = new HashMap<Integer, List<Edge>>();
		edges = new ArrayList<Edge>();
	}
	public Graph(int numNodes, int numEdges) {
		incidence = new HashMap<Integer, List<Edge>>(numNodes);
		edges = new ArrayList<Edge>(numEdges);
	}
	
	public int getNodes() {
		return incidence.size();
	}
	
	public Collection<Edge> getEdges() {
		return edges;
	}
	
	public Collection<Edge> getIncidentEdges(Integer n) {
		return incidence.get(n);
	}
	
	public void addNode(Integer n) {
		if (! incidence.containsKey(n))
			incidence.put(n, new LinkedList<Edge>());
	}
	public void addEdge(Integer node1, Integer node2) throws RuntimeException {
		if (! (incidence.containsKey(node1) &&
			   incidence.containsKey(node2)) )
			throw new RuntimeException("Edge Not Valid");
		
		Edge tmpEdge = new Edge(node1,node2);
		incidence.get(node1).add(tmpEdge);
		incidence.get(node2).add(tmpEdge);
		edges.add(tmpEdge); 
	}
}
