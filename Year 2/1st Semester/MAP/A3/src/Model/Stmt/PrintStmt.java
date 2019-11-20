package Model.Stmt;

import Exceptions.MyException;
import Model.ADT.MyIDictionary;
import Model.ADT.MyIList;
import Model.Exp.Exp;
import Model.PrgState;
import Model.Value.Value;

public class PrintStmt implements IStmt {
    Exp exp;

    public PrintStmt(Exp e) { exp = e; }
    public String toString(){ return "print("+exp.toString()+")";}

    public PrgState execute(PrgState state) throws MyException {
        MyIList<Value> list = state.getOutList();
        MyIDictionary<String, Value> symTbl = state.getSymTable();
        Value val = exp.eval(symTbl);
        list.add(val);
        return state;
    }
}
