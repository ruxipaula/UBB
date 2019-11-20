package Model.Stmt;

import Exceptions.MyException;
import Model.ADT.MyIStack;
import Model.PrgState;

public class CompStmt implements IStmt {
    private IStmt first;
    private IStmt second;

    public CompStmt(IStmt f, IStmt s) {
        first = f;
        second = s;
    }

    public IStmt getFirst() { return first;}
    public IStmt getSecond() { return second;}

    public String toString() {
        return "("+first.toString() + ";" + second.toString()+")";
    }

    public PrgState execute(PrgState state) throws MyException {
        MyIStack<IStmt> stk = state.getStk();
        stk.push(second);
        stk.push(first);
        return state;
    }

}
