package nodes;

public class BlockNode extends AbstractTreeNode {

	@Override
	public String toString()
	{
		return "Block";
	}

	@Override
	public Object execute(Context context) {
		children.forEach((n)->{
			if(n instanceof FunctionDefNode)n.execute(context);
		});
		children.forEach((n)->{
			if(!(n instanceof FunctionDefNode))n.execute(context);
		});
		return null;
	}

	@Override
	public Object convert(Context context) {
		String [] res = new String[children.size()];
		for(int i=0;i<res.length;i++)
			res[i] = (String)children.get(i).convert(context);
		return String.join("\r\n", res);
	}

}
