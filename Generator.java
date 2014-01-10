import java.util.HashSet;
import java.util.Set;

public class Generator {
	
	public static void main(String[] args){
		generateGraphMatrix(100, 0.0145);
	}
	
	public static void genSquare(int max, int inCircle, int outCircle){
		int minCircle = inCircle;
		int square = outCircle;
		int squareN = (max-minCircle)/square;
		int edgesN = squareN *(square+1) + minCircle;
		int firstMinSquare=(max-minCircle)+1;
		
		System.out.println(max+" "+edgesN);
		
		for (int i= 1; i+square-1 <firstMinSquare; i++) {
			int temp = i;
			//collego il quadrato
			for(int j = 0; j<square-1; j++){
				System.out.println(i+" "+(++i));
			}
			//chiudo il quadrato
			System.out.println(i+" "+temp);
			//collego al centro
			System.out.println(i+" "+firstMinSquare);
		}

		
		for (int x=firstMinSquare; x<max ; x++){
			System.out.println(x+" "+(x+1));
		}
		System.out.println(firstMinSquare+" "+max);
	}
	
	//il metodo del 10 Genn by Vincenzino tacata
	public static void generateGraphMatrix(int maxNodes,double percentage){
		Set<Edge> edges = new HashSet<Edge>();
		for (int x = 1; x <= maxNodes; x++){
			for (int y = 1; y <= maxNodes; y++ ){
				if(y >= x) continue;
				//if(Math.random()<((double)percentage/(double)100))
				if(Math.random()<percentage)
				
					edges.add(new Edge(x,y));
			}
		}
		
		//stampa output
		System.out.println(maxNodes+" "+edges.size());
		for(Edge e: edges){
			System.out.println(e.cleanToString());
		}		
	}
}
