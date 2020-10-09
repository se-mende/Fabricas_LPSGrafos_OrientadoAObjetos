package graph;

import java.util.List;

import node.Node;
import searchStrategy.SearchStrategy;

public interface Graph {
	
	public void addNode(Node node);
	public List<Node> getNodes();
	
	public void setIsUndirected(boolean isUndirected);
	public boolean getIsUndirected();
	
	public void addArch(Node source, Node target) throws Exception;
	public void addArch(Node source, Node target, int weight) throws Exception;
	
	public void setSearchStrategy(SearchStrategy strategy);
	public SearchStrategy getSearchStrategy();
}
