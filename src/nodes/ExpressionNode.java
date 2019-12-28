package nodes;

public class ExpressionNode extends AbstractTreeNode {

	@Override
	public String toString()
	{
		return "Expression " + operator;
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
		case "+":
			return d1 + d2;
		case "-":
			return d1 - d2;
		case "*":
			return d1 * d2;
		case "/":
			return d1 / d2;
		}
		return null;
	}

	@Override
	public Object convert(Context context) {
		// TODO Auto-generated method stub
		return children.get(0).convert(context) + operator
				+ children.get(1).convert(context);
	}

}
