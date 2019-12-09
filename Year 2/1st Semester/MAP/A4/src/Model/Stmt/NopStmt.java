package Model.Stmt;

import Exceptions.MyException;
import Model.PrgState;
import Model.Stmt.IStmt;

public class NopStmt implements IStmt {
    public NopStmt() {
    }

    public String toString() {
        return "nop";
    }

    @Override
    public PrgState execute(PrgState state) throws MyException {
        return state;
    }

}
