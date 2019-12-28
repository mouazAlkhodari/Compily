package nodes;

public class AssignNode extends AbstractTreeNode {

	@Override
	public String toString()
	{
		return "Assign " + varName;
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
		
		context.getVars().put(varName, children.get(0).execute(context));
		
		return null;
	}

	@Override
	public Object convert(Context context) {
		// TODO Auto-generated method stub
		return varName + "=" + children.get(0).convert(context) + ";";
	}

}
