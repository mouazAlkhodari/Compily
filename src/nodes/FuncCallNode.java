package nodes;

import java.util.HashMap;

public class FuncCallNode extends ExpressionNode {

	String functionName;

//	HashMap<String, FunctionDefNode> functions = new HashMap<String, FunctionDefNode>();



	public String getFunctionName() {
		return functionName;
	}

	public void setFunctionName(String functionName) {
		this.functionName = functionName;
	}

//	public HashMap<String, FunctionDefNode> getFunctions() {
//		return functions;
//	}

//	public void setFunctions(HashMap<String, FunctionDefNode> functions) {
//		this.functions = functions;
//	}

	@Override
	public Object execute(Context context) {

		if (!context.getVars().containsKey(functionName))
			throw new RuntimeException("function not found");
		if (!(context.getVars().get(functionName) instanceof FunctionDefNode))
			throw new RuntimeException("function not found");

		FunctionDefNode f = (FunctionDefNode) context.getVars().get(functionName);
		if (f.getParams().size() != this.children.size())
			throw new RuntimeException("Invalid params");
		HashMap<String, Object> tmp = new HashMap<String, Object>();
		for(int i=0;i<f.getParams().size();i++)
			tmp.put(f.getParams().get(i), this.getChildren().get(i).execute(context));
		context.startFunction(tmp);
		context.getVars().putAll(tmp);
		f.root.execute(context);
		Object res = context.getVars().get("ret");
		context.endFunction();
		return res;
	}

	@Override
	public Object convert(Context context) {
		// TODO Auto-generated method stub
		String [] res = new String[children.size()];
		for(int i=0;i<res.length;i++)
			res[i] = (String)children.get(i).convert(context);

		return functionName + "(" +
				String.join(", ", res) +
				")";
	}

}
