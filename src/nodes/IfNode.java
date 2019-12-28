package nodes;

public class IfNode extends AbstractTreeNode {

	@Override
	public String toString()
	{
		return "If";
	}
	
	
	@Override
	public Object execute(Context context) {
		if ((Boolean)children.get(0).execute(context))
			children.get(1).execute(context);
		else if (children.size() > 2)
			children.get(2).execute(context);
		return null;
	}

	@Override
	public Object convert(Context context) {
		
		return "if(" + children.get(0).convert(context) + "){"
				+ children.get(1).convert(context) + 
				"}" + (children.size() > 2? "else{" + children.get(2).convert(context) + "}" : "");
	}

}
