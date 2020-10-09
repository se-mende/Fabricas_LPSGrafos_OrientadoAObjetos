package searchStrategy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import node.Node;

public class BFS implements SearchStrategy{

	@Override
	public List<Node> SearchRoute(Node source, Node target) {
		
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
                return routeNodes;
            }
            else{
                if(current.getAdjacentNodes().isEmpty()) {
                	System.out.println("Visited nodes (BFS)");
	            	for (Node node : visitedNodes) {
						System.out.println(node.getName());
					}
	            	System.out.println(target.getName());
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
	public boolean RouteExists(Node source, Node target) {
		if (SearchRoute(source, target) != null) {
			return true;
		}
		return false;
	}

}
