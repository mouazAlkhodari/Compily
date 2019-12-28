package nodes;

import java.util.HashMap;

public class FuncCallNode extends ExpressionNode {

	String functionName;

	HashMap<String, FunctionDef> functions = new HashMap<String, FunctionDef>();



	public String getFunctionName() {
		return functionName;
	}

	public void setFunctionName(String functionName) {
		this.functionName = functionName;
	}

	public HashMap<String, FunctionDef> getFunctions() {
		return functions;
	}

	public void setFunctions(HashMap<String, FunctionDef> functions) {
		this.functions = functions;
	}

	@Override
	public Object execute(Context context) {

		if (!functions.containsKey(functionName))
			throw new RuntimeException("function not found");
		FunctionDef f = functions.get(functionName);
		if (f.getParams().size() != this.children.size())
			throw new RuntimeException("Invalid params");
		HashMap<String, Double> tmp = new HashMap<String, Double>();
		for(int i=0;i<f.getParams().size();i++)
			tmp.put(f.getParams().get(i), (Double)this.getChildren().get(i).execute(context));
		context.startFunction();
		context.getVars().putAll(tmp);
		f.root.execute(context);
		double res = context.getVars().get("ret");
		context.endFunction();
		return res;
	}

	@Override
	public Object convert(Context context) {
		// TODO Auto-generated method stub
		return null;
	}

}
