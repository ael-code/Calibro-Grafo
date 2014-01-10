import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	public static void main(String args[]){

		Scanner in = new Scanner(System.in);
		
		//leggi numero nodi
		int numNodes = in.nextInt();
		int numEdges = in.nextInt();
		
		//crea grafo
		Graph g = new Graph(numNodes,numEdges);
		//aggiungi nodi
		for (int i = 1; i <= numNodes; i++) {
			g.addNode(i);
		}
		//aggiungi vertici
		for (int i = 0; i < numEdges; i++){
			g.addEdge(in.nextInt(), in.nextInt());
		}
		
		// stampa vertici
		// datGraph(g);
		
		int result = girth(g);
		if(result == Integer.MAX_VALUE )
			System.out.println("INF");
		else
			System.out.println(result);
	}
	
	public static int girth(Graph g){
		int minCycle = Integer.MAX_VALUE;
		int[] nodesDepth = new int[g.getNodes()+1]; // memorizza la profondita dei nodi durante ogni scansione
		boolean foundCycle;
		
		//cicla su tutti i vertici
		for(int actRoot = 1; actRoot <= g.getNodes(); actRoot++){
			//reset flag
			foundCycle = false;
			//pulisci il grafo
			resetDepth(nodesDepth);
			for(Edge e: g.getEdges())
				e.discovery = false;
			
			//imposta la profondita per il nodo attuale
			nodesDepth[actRoot] = 0;
			LinkedList<Integer> actL = new LinkedList<>(); // nodi al livello attuale
			actL.add(actRoot);
			LinkedList<Integer> nextL = new LinkedList<>(); // nodi al prossimo livello
			
			//cicla fino a che non sono finiti i nodi 
			while(!actL.isEmpty()){
				if(foundCycle == true)
					break;
				// cicla su tutti i nodi di questo livello
				for(Integer actNode: actL ){
					if(foundCycle == true)
						break;
					//cicla su tutti i vertici
					for(Edge e: g.getIncidentEdges(actNode)){
						if(!e.discovery){
							e.discovery = true;
							Integer son = e.getOpposite(actNode);
							//se il nodo non è stato ancora esplorato
							if(nodesDepth[son] == -1){
								nodesDepth[son] = nodesDepth[actNode]+1;
								nextL.add(son);
							}else{
								if(nodesDepth[actNode]+nodesDepth[son]+1 < minCycle){
									minCycle = nodesDepth[actNode]+nodesDepth[son]+1;
									foundCycle = true;
									break;
								}
								
							}
						}
					}
				}
				actL = nextL;
				nextL = new LinkedList<>();
			}

		}
		
		return minCycle;
	};
	
	public static void resetDepth(int[] vect){
		for (int i = 0; i < vect.length; i++) {
			vect[i] = -1;
		}
	}
	
	public static void datGraph(Graph g){
		System.out.println("num nodi: "+g.getNodes());
		for(Edge e: g.getEdges()){
			System.out.println(e.toString());
		}
	}
}
