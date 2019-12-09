package Model.Stmt;

import Exceptions.MyException;
import Model.ADT.MyIDictionary;
import Model.ADT.MyIHeap;
import Model.Exp.Exp;
import Model.PrgState;
import Model.Type.RefType;
import Model.Value.RefValue;
import Model.Value.Value;

public class wHStmt implements IStmt {
    private Exp exp;
    private String varName;

    public wHStmt(String var, Exp e) {
        varName = var;
        exp = e;
    }

    @Override
    public PrgState execute(PrgState state) throws MyException {
        MyIDictionary<String, Value> symTable = state.getSymTable();
        MyIHeap<Integer, Value> heap = state.getHeap();
        if (!symTable.isDefined(varName))
            throw new MyException("Variable is not defined.");
        Value v = symTable.lookup(varName);
        if (!(v.getType() instanceof RefType))
            throw new MyException("Variable type should be Ref");
        RefValue val = (RefValue) v;
        int addr = val.getAddress();
        if (!heap.isDefined(addr))
            throw new MyException("Address is not defined in the heap");

        Value vexp = exp.eval(symTable, heap);
        if (!vexp.getType().equals(val.getLocationType()))
            throw new MyException("Types are not equal.");
        heap.update(addr, vexp);

        return state;
    }

    public String toString() {
        return "wH(" + varName + ", " + exp.toString() + ")";
    }
}
