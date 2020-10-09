package arch;

import node.Node;

public class NormalArch implements Arch {

	private Node source;
	private Node target;
	
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

	@Override
	public int getWeight() throws Exception {
		throw new RuntimeException("Unsupported Operation");
	}

	@Override
	public void setWeight(int weight) throws Exception {
		throw new RuntimeException("Unsupported Operation");
	}
}
