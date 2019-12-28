package nodes;

public class ConstantNode extends ExpressionNode {

	@Override
	public String toString()
	{
		return value + "";
	}
	
	Object value;
	
	public Object getValue() {
		return value;
	}

	public void setValue(String value)
	{
		try
		{
			int v = Integer.parseInt(value);
			this.value = v;
		}
		catch (NumberFormatException e)
		{
			try
			{
				float vv = Float.parseFloat(value);
				this.value = vv;
			}
			catch (NumberFormatException ee)
			{
				throw new RuntimeException("Invalid Number Type man !!!");
			}
		}
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
