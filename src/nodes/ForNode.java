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

		Object val1 = children.get(0).execute(context);
		Object val2 = children.get(1).execute(context);

		if(val1 instanceof Integer && val2 instanceof Integer){
			int start = (int)val1;
			int end = (int)val2;
			int step = 1;
			if (children.size() > 3)
				step = (int)children.get(3).execute(context);
			double current = start;
			while(true){
				if (step < 0 && current < end)
					break;
				if (step > 0 && current > end)
					break;
				context.getVars().put(varName, current);
				children.get(2).execute(context);
				end = (int)children.get(1).execute(context);
				if (children.size() > 3)
					step = (int)children.get(3).execute(context);
				current += step;
			}
		}
		else if(val1 instanceof Double && val2 instanceof Double){
			double start = (Double)val1;
			double end = (Double)val2;
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
		}
		else{
			throw new RuntimeException("Invalid For iterator type (should be int/float) man !!!");
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
