public class Edge{
	private Integer node1,node2;
	public boolean discovery;
		
	public Edge(Integer node1, Integer node2) {
		this.node1 = node1;
		this.node2 = node2;
		discovery = false;
	}

	public String toString() {
		return "(" + node1 + "," + node2 + ")";
	}
	
	public Integer getOpposite(Integer n){
		if(n== node1) return node2;
		else if(n == node2) return node1;
		else throw new RuntimeException("invalid opposite node request");
	}
	
	public boolean equals(Object other){
		if(other != null && other.getClass().equals(this.getClass())){
			Edge o = (Edge) other;
			if( (o.node1 == this.node1 && o.node2 == this.node2) ||
				(o.node1 == this.node2 && o.node2 == this.node1))
				return true;
		}
		return false;
	}
	
	public int hashCode(){
		return node1.hashCode() + node2.hashCode();
	}
}