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

		if(context.getVars().get(varName) instanceof Integer){
			context.getVars().put(varName, s.nextInt());
		}
		if(context.getVars().get(varName) instanceof Double){
			context.getVars().put(varName, s.nextDouble());
		}
		if(context.getVars().get(varName) instanceof Float){
			context.getVars().put(varName, s.nextFloat());
		}
		if(context.getVars().get(varName) instanceof String){
			context.getVars().put(varName, s.next());
		}
		if(context.getVars().get(varName) instanceof Character){
			context.getVars().put(varName, s.next().toCharArray()[0] );
		}
		return null;
	}

	@Override
	public Object convert(Context context) {
		// TODO Auto-generated method stub
		return "cin >> " + varName + ";";
	}

}
