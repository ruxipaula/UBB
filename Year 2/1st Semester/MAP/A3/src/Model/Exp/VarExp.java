package Model.Exp;

import Exceptions.MyException;
import Model.ADT.MyIDictionary;
import Model.Exp.Exp;
import Model.Value.Value;

public class VarExp implements Exp {
    String id;

    public VarExp(String name) {
        id = name;
    }

    @Override
    public Value eval(MyIDictionary<String,Value> tbl) throws MyException {
        return tbl.lookup(id);
    }

    public String toString() {
        return id;
    }
}
