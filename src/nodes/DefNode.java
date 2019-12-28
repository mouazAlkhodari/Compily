package nodes;

public class DefNode extends AbstractTreeNode{

    @Override
    public String toString()
    {
        return "Def " + varName;
    }

    String varName;
    String type_num;

    public String getVarName() {
        return varName;
    }

//    public void setVarName(String varName) {
//        this.varName = varName;
//    }

    // Overloaded func
    public void setVarName(String varName, String type) {
        this.varName = varName;
        this.type_num = type;
    }


    @Override
    public Object execute(Context context) {
        if(type_num.equals("int")){int a=0; context.getVars().put(varName, a);}
        else if(type_num.equals("float")){float a=0.0f; context.getVars().put(varName, a);}
        else if(type_num.equals("char")){char a=' '; context.getVars().put(varName, a);}
        else if(type_num.equals("string")){String a=""; context.getVars().put(varName, a);}
        else if(type_num.equals("double")){double a=0; context.getVars().put(varName, a);}

        return null;
    }

    @Override
    public Object convert(Context context) {
        // TODO Auto-generated method stub
        if(type_num.equals("int")){return "int " + varName + "=0;";}
        else if(type_num.equals("float")){return "float " + varName + "=0;";}
        else if(type_num.equals("char")){return "char " + varName + "=' ';";}
        else if(type_num.equals("string")){return "string " + varName + "=\"\";";}
        else if(type_num.equals("double")){return "double " + varName + "=0;";}

        return "dataType " + varName + "=0;";
    }
}
