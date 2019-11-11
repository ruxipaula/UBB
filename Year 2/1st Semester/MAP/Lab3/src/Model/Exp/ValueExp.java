package Model.Exp;

import Exceptions.MyException;
import Model.ADT.MyIDictionary;
import Model.Exp.Exp;
import Model.Value.IntValue;
import Model.Value.Value;

public class ValueExp implements Exp {
    private Value e;

    public ValueExp(Value exp) { e = exp;}

    @Override
    public Value eval(MyIDictionary<String,Value> tbl) throws MyException {return e;}

    public String toString() {
        return e.toString();
    }
}
