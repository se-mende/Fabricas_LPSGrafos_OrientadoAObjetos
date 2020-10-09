package arch;

import node.Node;

public interface Arch {
	
	public Node getSource();
	public void setSource(Node source);
	public Node getTarget();
	public void setTarget(Node target);
	public int getWeight() throws Exception;
	public void setWeight(int weight) throws Exception;
}
