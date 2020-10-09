package node;

import java.util.ArrayList;
import java.util.List;

import arch.Arch;

public class Node {
	
	private String name;
	private List<Arch> archs = new ArrayList<>();
	
	public Node(String name) 
	{
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public void addArch(Arch arch) {
		archs.add(arch);
	}

	public List<Arch> getArchs() {
		return archs;
	}
	
	public List<Node> getAdjacentNodes() {
		List<Node> nodes = new ArrayList<>();
		
		// For each arch where the origin is the node
		for (Arch arch : archs) {
			// if arch is not reflexive
			if (arch.getTarget() != this)
				// add target node to the list of adyacent nodes
				nodes.add(arch.getTarget());
		}
		
		// retorna la lista de nodos adyacentes
		return nodes;
	}

}
