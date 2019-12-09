package Model.Exp;

import Exceptions.MyException;
import Model.ADT.MyIDictionary;
import Model.ADT.MyIHeap;
import Model.Type.RefType;
import Model.Value.RefValue;
import Model.Value.Value;

public class rHExp implements Exp {
    private Exp exp;

    public rHExp(Exp e) {
        exp = e;
    }

    public Value eval(MyIDictionary<String,Value> tbl, MyIHeap<Integer,Value> hp) throws MyException {
        Value v = exp.eval(tbl, hp);
        if (!(v.getType() instanceof RefType))
            throw new MyException("Value should be of type Ref");
        int addr = ((RefValue) v).getAddress();
        if (!hp.isDefined(addr))
            throw new MyException("Address is not defined.");
        Value val = hp.lookup(addr);
        return val;
    }

    public String toString() {
        return "rH(" + exp.toString() + ")";
    }
}
