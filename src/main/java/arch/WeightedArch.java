package arch;

import node.Node;

public class WeightedArch implements Arch {
	
	private Node source;
	private Node target;
	private int weight;
	
	public WeightedArch() {}
	
	@Override
	public Node getSource() {
		return source;
	}

	@Override
	public void setSource(Node source) {
		this.source = source;
	}

	@Override
	public Node getTarget() {
		return target;
	}

	@Override
	public void setTarget(Node target) {
		this.target = target;
	}
	
	public int getWeight() {
		return weight;
	}
	
	public void setWeight(int weight) {
		this.weight = weight;
	}

}
