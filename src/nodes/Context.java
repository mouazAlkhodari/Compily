package nodes;

import java.util.HashMap;
import java.util.Stack;

public class Context {

	HashMap<String, Object> vars = new HashMap<>();

	Stack<HashMap<String, Object>> varStack = new Stack<HashMap<String,Object>>();

	public void startFunction(HashMap<String,Object> tmp) {
		HashMap<String,Object> tempvars = new HashMap<String,Object>(vars);
		varStack.push(vars);
		vars = tempvars;
		tmp.forEach((key,value)->{
			vars.put(key,value);
		});
	}

	public void endFunction() {
		vars = varStack.pop();
	}

	public HashMap<String, Object> getVars() {
		return vars;
	}




}
