package nodes;

import java.util.ArrayList;

public abstract class AbstractTreeNode {
	
	protected String name;
	
	public String getName() {
		return name;
	}
	
	protected ArrayList<AbstractTreeNode> children = new ArrayList<AbstractTreeNode>();
	
	public ArrayList<AbstractTreeNode> getChildren() {
		return children;
	}
	
	public void addChild(AbstractTreeNode child) {
		children.add(child);
	}

	public abstract Object execute(Context context);
	
	public abstract Object convert(Context context);
	
	public void print(String prefix) {
		System.out.println(prefix + this);
		for(AbstractTreeNode n : children)
			n.print(prefix + "---"); 
	}
	
}
