package nodes;

import java.util.HashMap;
import java.util.Stack;

public class Context {

	HashMap<String, Object> vars = new HashMap<>();

	Stack<HashMap<String, Object>> varStack = new Stack<HashMap<String,Object>>();

	public void startFunction() {
		varStack.push(vars);
		vars = new HashMap<String, Object>();
	}

	public void endFunction() {
		vars = varStack.pop();
	}

	public HashMap<String, Object> getVars() {
		return vars;
	}




}
