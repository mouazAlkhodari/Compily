package nodes;

public class NegationConditionNode extends ConditionTermNode {

    @Override
    public String toString(){  return "Negation Condition"; }

    @Override
    public Object execute(Context context) {

        boolean d = (boolean)children.get(0).execute(context);
        return !d;
    }

    @Override
    public Object convert(Context context) {
        return "!" + children.get(0).convert(context);
    }

}
