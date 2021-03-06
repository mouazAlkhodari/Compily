package nodes;

public class ConditionTermNode extends ConditionNode {

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

		Object val1 = children.get(0).execute(context);
		Object val2 = children.get(1).execute(context);
		if(val1 instanceof Double && val2 instanceof Double)
		{
			double d1 = (Double)val1;
			double d2 = (Double)val2;
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
		}
		else if(val1 instanceof Float && val2 instanceof Float)
		{
			float d1 = (float)val1;
			float d2 = (float)val2;
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
		}
		else if(val1 instanceof Integer && val2 instanceof Integer)
		{
			int d1 = (int)val1;
			int d2 = (int)val2;
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
		}
		else if(val1 instanceof String && val2 instanceof String)
		{
			String d1 = (String)val1;
			String d2 = (String)val2;
			switch(operator) {
				case ">":
					return d1.length() > d2.length();
				case "<":
					return d1.length() < d2.length();
				case ">=":
					return d1.length() >= d2.length();
				case "<=":
					return d1.length() <= d2.length();
				case "<>":
					return d1 != d2;
				case "=":
					return d1 == d2;
			}
		}
		else if(val1 instanceof Character && val2 instanceof Character)
		{
			char d1 = (char)val1;
			char d2 = (char)val2;
			switch(operator) {
				case ">":
					return d1 > d2;
				case "<":
					return d1< d2;
				case ">=":
					return d1 >= d2;
				case "<=":
					return d1 <= d2;
				case "<>":
					return d1 != d2;
				case "=":
					return d1 == d2;
			}
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
