package graph;

import java.util.ArrayList;
import java.util.List;

import arch.Arch;
import arch.WeightedArch;
import node.Node;
import searchStrategy.SearchStrategy;

public class WeightedGraph implements Graph {
	
	private List<Node> nodes = new ArrayList<>();
	private List<Arch> archs = new ArrayList<>();
	private boolean isUndirected;
	SearchStrategy searchStrategy;

	@Override
	public void addNode(Node node) {
		nodes.add(node);
	}

	@Override
	public List<Node> getNodes() {
		return nodes;
	}
	
	@Override
	public void setIsUndirected(boolean isUndirected) {
		this.isUndirected = isUndirected;
	}

	@Override
	public boolean getIsUndirected() {
		return isUndirected;
	}

	@Override
	public void addArch(Node source, Node target) throws Exception {
		throw new RuntimeException("Unsupported Operation");
	}

	@Override
	public void addArch(Node source, Node target, int weight) {
		Arch arch = new WeightedArch();
		arch.setSource(source);
		arch.setTarget(target);
		try {
			arch.setWeight(weight);
		} catch (Exception e) {
			e.printStackTrace();
		}
		archs.add(arch);
		source.addArch(arch);
		
		if(isUndirected) {
			Arch arch2 = new WeightedArch();
			arch2.setSource(target);
			arch2.setTarget(source);
			try {
				arch2.setWeight(weight);
			} catch (Exception e) {
				e.printStackTrace();
			}
			archs.add(arch2);
			target.addArch(arch2);
		}
	}

	@Override
	public void setSearchStrategy(SearchStrategy strategy) {
		this.searchStrategy = strategy;
	}

	@Override
	public SearchStrategy getSearchStrategy() {
		return searchStrategy;
	}
}
