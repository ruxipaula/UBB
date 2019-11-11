package Model.Stmt;

import Exceptions.MyException;
import Model.ADT.MyIStack;
import Model.Exp.Exp;
import Model.PrgState;
import Model.Type.BoolType;
import Model.Value.BoolValue;
import Model.Value.Value;

public class IfStmt implements IStmt {
    Exp exp;
    IStmt thenS;
    IStmt elseS;

    public IfStmt(Exp e, IStmt t, IStmt el) {exp=e; thenS=t;elseS=el;}
    public String toString(){ return "(IF("+ exp.toString()+") THEN(" +thenS.toString() +")ELSE("+elseS.toString()+"))";}

    @Override
    public PrgState execute(PrgState state) throws MyException{
        MyIStack<IStmt> stk = state.getStk();
        Value cond = exp.eval(state.getSymTable());

        if (!(cond.getType() instanceof BoolType))
            throw new MyException("Condition " + cond + "is not of boolean type!");
        else {
            BoolValue condBool = (BoolValue)cond;
            if (condBool.getValue())
                stk.push(thenS);
            else
                stk.push(elseS);
        }
        return state;
    }
}
