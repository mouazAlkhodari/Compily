package nodes;

public class WhileNode extends AbstractTreeNode {

	@Override
	public String toString()
	{
		return "While";
	}
	
	@Override
	public Object execute(Context context) {
		while((Boolean)children.get(0).execute(context))
			children.get(1).execute(context);
		return null;
	}

	@Override
	public Object convert(Context context) {
		// TODO Auto-generated method stub
		return "while(" + children.get(0).convert(context)
				+ "){" + children.get(1).convert(context) + "}";
	}

}
