package searchStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import node.Node;

public class DFS implements SearchStrategy {

	@Override
	public List<Node> SearchRoute(Node source, Node target, boolean verbose) {
		
		List<Node> routeNodes = new ArrayList<>();
		
		// adds source
		routeNodes.add(source);
		
		// Are source and target the same?
		if(source.getName().equals(target.getName())) {
			return routeNodes;	
		}
		
		// Otherwise
		Stack<Node> nodeStack = new Stack<>();
		ArrayList<Node> visitedNodes = new ArrayList<>();
		nodeStack.add(source);

        while(!nodeStack.isEmpty()){
            Node current = nodeStack.pop();

            // Ignore visited nodes
            if (visitedNodes.contains(current))
            	continue;
            
            // Is it the node we are searching for?
            if (current.equals(target)) {
            	routeNodes.addAll(nodeStack);
            	routeNodes.add(target);
            	
            	if(verbose) {
            		System.out.println("Visited nodes (DFS)");
                	for (Node node : visitedNodes) {
    					System.out.println(node.getName());
    				}
                	System.out.println(target.getName());
            	}
                return routeNodes;
            }
            else {
                // keep searching
            	visitedNodes.add(current);
            	for(Node node: current.getAdjacentNodes()) {
            		if (!nodeStack.contains(node))
            			nodeStack.add(node);
            	}
            }
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
