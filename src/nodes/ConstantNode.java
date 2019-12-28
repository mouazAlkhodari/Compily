package nodes;

public class ConstantNode extends ExpressionNode {

	@Override
	public String toString()
	{
		return value + "";
	}
	
	double value;
	
	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	@Override
	public Object execute(Context context) {
		
		return value;
	}

	@Override
	public Object convert(Context context) {
		// TODO Auto-generated method stub
		return value + "";
	}

}
