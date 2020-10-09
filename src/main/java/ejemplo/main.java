package ejemplo;

import java.util.List;

import factory.GraphFactory;
import graph.Graph;
import node.Node;

public class main {

	public static void main(String[] args) {
		
		int exampleType = 2;//0 (Normal), 1 (weighted), 2 (variaciones busqueda)
		
		switch (exampleType) {
			case 0:
				ejemploNormal();
				break;
			case 1:
				ejemploPesos();
				break;
			case 2:
				variacionesBusqueda();
		}
	}

	private static void ejemploNormal() {
		// usa la fábrica para obtener una instancia de Grafo 
		// de acuerdo con la configuración
		Graph g = GraphFactory.createGraph();
				
		Node a = new Node("A");
		Node b = new Node("B");
		Node c = new Node("C");
		Node d = new Node("D");
		g.addNode(a);
		g.addNode(b);
		g.addNode(c);
		g.addNode(d);

		try {
			g.addArch(a, b);
			g.addArch(b, c);
			g.addArch(a, d);
		} catch (Exception e) {
			System.out.println("Funcion no soportada. Revisar configuracion del grafo.");
		}
						
		System.out.println(g.getSearchStrategy().RouteExists(a, c));
		System.out.println(g.getSearchStrategy().RouteExists(c, a));
	}
	
	private static void ejemploPesos() {
		// usa la fábrica para obtener una instancia de Grafo 
		// de acuerdo con la configuración
		Graph g = GraphFactory.createGraph();
						
		Node a = new Node("A");
		Node b = new Node("B");
		Node c = new Node("C");
		Node d = new Node("D");
		g.addNode(a);
		g.addNode(b);
		g.addNode(c);
		g.addNode(d);

		try {
			g.addArch(a, b, 10);
			g.addArch(b, c, 20);
			g.addArch(a, d, 30);
		} catch (Exception e) {
			System.out.println("Funcion no soportada. Revisar configuracion del grafo.");
		}
								
		System.out.println(g.getSearchStrategy().RouteExists(a, c));
		System.out.println(g.getSearchStrategy().RouteExists(c, a));
	}
	
	private static void variacionesBusqueda() {
		// usa la fábrica para obtener una instancia de Grafo 
		// de acuerdo con la configuración
		Graph g = GraphFactory.createGraph();
		
		Node a = new Node("A");
		Node b = new Node("B");
		Node c = new Node("C");
		Node d = new Node("D");
		g.addNode(a);
		g.addNode(b);
		g.addNode(c);
		g.addNode(d);
		
		try {
			g.addArch(a, b);
			g.addArch(b, c);
			g.addArch(a, d);
		} catch (Exception e) {
			System.out.println("Funcion no soportada. Revisar configuracion del grafo.");
		}

		List<Node> nodes = g.getSearchStrategy().SearchRoute(a, c);
	}

}
