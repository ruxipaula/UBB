package Model.Stmt;

import Exceptions.MyException;
import Model.PrgState;

public interface IStmt {
    PrgState execute(PrgState state) throws MyException;
    //which is the execution method for a statement.

    String toString();
}
