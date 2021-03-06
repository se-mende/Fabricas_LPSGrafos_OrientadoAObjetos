package searchStrategy;

import java.util.List;

import node.Node;

public interface SearchStrategy {
	public List<Node> SearchRoute(Node source, Node target, boolean verbose);
	public boolean RouteExists(Node source, Node target, boolean verbose);
}
