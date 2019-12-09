package Model.Stmt;

import Exceptions.MyException;
import Model.ADT.MyIDictionary;
import Model.ADT.MyIHeap;
import Model.ADT.MyIStack;
import Model.Exp.Exp;
import Model.PrgState;
import Model.Type.BoolType;
import Model.Value.BoolValue;
import Model.Value.Value;

public class WhileStmt implements IStmt {
    private Exp exp;
    private IStmt s;

    public WhileStmt(Exp e, IStmt stmt) {
        exp = e;
        s = stmt;
    }

    public PrgState execute(PrgState state) throws MyException {
        MyIDictionary<String, Value> symTable = state.getSymTable();
        MyIStack<IStmt> stk = state.getStk();
        MyIHeap<Integer, Value> heap = state.getHeap();
        Value v = exp.eval(symTable, heap);
        if (v.getType() instanceof BoolType) {
            BoolValue bv = (BoolValue)v;
            boolean val = bv.getVal();
            if (val) {
                stk.push(new WhileStmt(exp, s));
                stk.push(s);
            }
        }
        else
            throw new MyException("Type should be bool");
        return state;
    }

    public String toString() {
        return "while(" + exp.toString() + ") " + s.toString();
    }
}
