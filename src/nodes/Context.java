package nodes;

import java.util.HashMap;
import java.util.Stack;

public class Context {

	HashMap<String, Double> vars = new HashMap<>();

	Stack<HashMap<String, Double>> varStack = new Stack<HashMap<String,Double>>();

	public void startFunction() {
		varStack.push(vars);
		vars = new HashMap<String, Double>();
	}

	public void endFunction() {
		vars = varStack.pop();
	}

	public HashMap<String, Double> getVars() {
		return vars;
	}




}
