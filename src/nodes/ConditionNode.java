package nodes;

public class ConditionNode extends AbstractTreeNode {

	@Override
	public String toString()
	{
		return "Condition " + operator;
	}
	
	
	String operator;
	
	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	@Override
	public Object execute(Context context) {
		
		double d1 = (Double)children.get(0).execute(context);
		double d2 = (Double)children.get(1).execute(context);
		switch(operator) {
		case ">":
			return d1 > d2;
		case "<":
			return d1 < d2;
		case ">=":
			return d1 >= d2;
		case "<=":
			return d1 <= d2;
		case "<>":
			return d1 != d2;
		case "=":
			return d1 == d2;
		}
		return null;
	}

	@Override
	public Object convert(Context context) {
		String op = operator;
		if (op.equals("="))
			op = "==";
		if (op.equals("<>"))
			op = "!=";
		return children.get(0).convert(context) + op 
				+ children.get(1).convert(context);
	}

}
