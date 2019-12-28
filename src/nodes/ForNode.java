package nodes;

public class ForNode extends AbstractTreeNode {

	@Override
	public String toString()
	{
		return "For " + varName;
	}
	
	String varName;
	
	public String getVarName() {
		return varName;
	}

	public void setVarName(String varName) {
		this.varName = varName;
	}

	@Override
	public Object execute(Context context) {
		double start = (Double)children.get(0).execute(context);
		double end = (Double)children.get(1).execute(context);
		double step = 1;
		if (children.size() > 3)
			step = (Double)children.get(3).execute(context);
		double current = start;
		while(true){
			if (step < 0 && current < end)
				break;
			if (step > 0 && current > end)
				break;
			context.getVars().put(varName, current);
			children.get(2).execute(context);
			end = (Double)children.get(1).execute(context);
			if (children.size() > 3)
				step = (Double)children.get(3).execute(context);
			current += step;
		}
		return null;
	}

	@Override
	public Object convert(Context context) {
		
		return "for(" + varName + "=" + children.get(0).convert(context)
				+";" + varName + "<=" + children.get(1).convert(context)
				+ ";" + varName + "+=" + (children.size() > 3? children.get(3).convert(context) : "1")
				+ ")\r\n{" + children.get(2).convert(context) + "}" ;
	}

}
