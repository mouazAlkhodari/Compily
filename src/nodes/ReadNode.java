package nodes;

import java.util.Scanner;

public class ReadNode extends AbstractTreeNode {

	
	@Override
	public String toString()
	{
		return "Read " + varName;
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
		Scanner s = new Scanner(System.in);
		context.getVars().put(varName, s.nextDouble());
		return null;
	}

	@Override
	public Object convert(Context context) {
		// TODO Auto-generated method stub
		return "cin >> " + varName + ";";
	}

}
