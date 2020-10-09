package factory;

import java.io.FileReader;
import java.util.Properties;

import graph.Graph;
import graph.UnweightedGraph;
import graph.WeightedGraph;
import searchStrategy.BFS;
import searchStrategy.DFS;

public class GraphFactory {
	
	private static String getOpcionConfigurada() {
		// define un valor por defecto
		String opcionConfigurada = "DirectedGraph";  
		
		try {
			// lee el archivo de configuración
			Properties opciones = new Properties();
			opciones.load(new FileReader("config-if.properties"));
			
			boolean isDirected = opciones.getProperty("directed","false").equals("true");
			boolean isWeighted = opciones.getProperty("weighted","false").equals("true");
			boolean isSearch = opciones.getProperty("search","false").equals("true");
			boolean isDFS = opciones.getProperty("DFS","false").equals("true");
			boolean isBFS = opciones.getProperty("BFS","false").equals("true");
			
			if(isDirected) {
				if(isWeighted) {
					if(!isSearch) {
						opcionConfigurada = "DirectedWeightedGraph";
					}
					else {
						if(isDFS && !isBFS)
							opcionConfigurada = "DirectedWeightedGraphDFS";
						else if(!isDFS && isBFS)
							opcionConfigurada = "DirectedWeightedGraphBFS";
					}
				}
				else {
					if(!isSearch) {
						opcionConfigurada = "DirectedGraph";
					}
					else {
						if(isDFS && !isBFS)
							opcionConfigurada = "DirectedGraphDFS";
						else if(!isDFS && isBFS)
							opcionConfigurada = "DirectedGraphBFS";
					}
				}
			}
			else {
				if(isWeighted) {
					if(!isSearch) {
						opcionConfigurada = "UndirectedWeightedGraph";
					}
					else {
						if(isDFS && !isBFS)
							opcionConfigurada = "UndirectedWeightedGraphDFS";
						else if(!isDFS && isBFS)
							opcionConfigurada = "UndirectedWeightedGraphBFS";
					}
				}
				else {
					if(!isSearch) {
						opcionConfigurada = "UndirectedGraph";
					}
					else {
						if(isDFS && !isBFS)
							opcionConfigurada = "UndirectedGraphDFS";
						else if(!isDFS && isBFS)
							opcionConfigurada = "UndirectedGraphBFS";
					}
				}
			}
		} catch (Exception e) {
			// ignora cualquier error leyendo el archivo
		} 
		
		return opcionConfigurada;
	}

	public static Graph createGraph() {
		
		String option = getOpcionConfigurada();
		Graph graph;
		
		switch(option) {
			case "DirectedWeightedGraph":
				graph = new WeightedGraph();
				graph.setIsUndirected(false);
				graph.setSearchStrategy(null);
				return graph;
			case "DirectedWeightedGraphDFS":
				graph = new WeightedGraph();
				graph.setIsUndirected(false);
				graph.setSearchStrategy(new DFS());
				return graph;
			case "DirectedWeightedGraphBFS":
				graph = new WeightedGraph();
				graph.setIsUndirected(false);
				graph.setSearchStrategy(new BFS());
				return graph;
			case "DirectedGraph":
				graph = new UnweightedGraph();
				graph.setIsUndirected(false);
				graph.setSearchStrategy(null);
				return graph;
			case "DirectedGraphDFS":
				graph = new UnweightedGraph();
				graph.setIsUndirected(false);
				graph.setSearchStrategy(new DFS());
				return graph;
			case "DirectedGraphBFS":
				graph = new UnweightedGraph();
				graph.setIsUndirected(false);
				graph.setSearchStrategy(new BFS());
				return graph;
			case "UndirectedWeightedGraph":
				graph = new WeightedGraph();
				graph.setIsUndirected(true);
				graph.setSearchStrategy(null);
				return graph;
			case "UndirectedWeightedGraphDFS":
				graph = new WeightedGraph();
				graph.setIsUndirected(true);
				graph.setSearchStrategy(new DFS());
				return graph;
			case "UndirectedWeightedGraphBFS":
				graph = new WeightedGraph();
				graph.setIsUndirected(true);
				graph.setSearchStrategy(new BFS());
				return graph;
			case "UndirectedGraph":
				graph = new UnweightedGraph();
				graph.setIsUndirected(true);
				graph.setSearchStrategy(null);
				return graph;
			case "UndirectedGraphDFS":
				graph = new UnweightedGraph();
				graph.setIsUndirected(true);
				graph.setSearchStrategy(new DFS());
				return graph;
			case "UndirectedGraphBFS":
				graph = new UnweightedGraph();
				graph.setIsUndirected(true);
				graph.setSearchStrategy(new BFS());
				return graph;
		}
		
		return null;
	}

}
