package searchStrategy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import node.Node;

public class BFS implements SearchStrategy{

	@Override
	public List<Node> SearchRoute(Node source, Node target, boolean verbose) {
		
		List<Node> routeNodes = new ArrayList<>();
		
		// Are source and target the same?
		if(source.getName().equals(target.getName())){
			System.err.println("target node found in the same source");
			routeNodes.add(source);
		    return routeNodes;
		}
		
		Queue<Node> queue = new LinkedList<>();
		ArrayList<Node> visitedNodes = new ArrayList<>();
		queue.add(source);
		while(!queue.isEmpty()) {
			Node current = queue.remove();
			visitedNodes.add(current);
            if(current.equals(target)) {
            	routeNodes.add(current);
            	if(verbose) {
            		System.out.println("Visited nodes (BFS)");
	            	for (Node node : visitedNodes) {
						System.out.println(node.getName());
					}
            	}
                return routeNodes;
            }
            else{
                if(current.getAdjacentNodes().isEmpty()) {
                    return null;
                }
                else {
                	for (Node node: current.getAdjacentNodes()) {
                		if (!visitedNodes.contains(node))
                			queue.add(node);
                	}
                }
                    
            }
            if (!routeNodes.contains(current))
            	routeNodes.add(current);
		}

		return null; 
	}

	@Override
	public boolean RouteExists(Node source, Node target, boolean verbose) {
		if (SearchRoute(source, target, verbose) != null) {
			return true;
		}
		return false;
	}

}
