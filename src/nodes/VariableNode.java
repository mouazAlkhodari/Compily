package nodes;

public class VariableNode extends ExpressionNode {
	
	@Override
	public String toString()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	@Override
	public Object execute(Context context) {
		if (context.getVars().containsKey(name))
			return context.getVars().get(name);
		else {
			System.out.println(name + " does not exist assuming value of 0");
			return 0;
		}
	}

	@Override
	public Object convert(Context context) {
		// TODO Auto-generated method stub
		return name;
	}

}
