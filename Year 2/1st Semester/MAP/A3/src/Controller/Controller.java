package Controller;

import Exceptions.MyException;
import Model.ADT.MyIStack;
import Model.PrgState;
import Model.Stmt.IStmt;
import Repository.IRepository;

public class Controller {
    private IRepository repo;

    public Controller(IRepository r) {
        repo = r;
    }

    public PrgState oneStep(PrgState state) throws MyException {
        MyIStack<IStmt> stk = state.getStk();
        if (stk.isEmpty())
             throw new MyException("Prgstate stack is empty");
        IStmt currentStmt = stk.pop();
        return currentStmt.execute(state);
    }

    public void allSteps() throws MyException {
        PrgState prg = repo.getCrtPrg();
        repo.logPrgStateExec();
        //here you can display the prg state
        while (!prg.getStk().isEmpty()) {
            oneStep(prg);
            System.out.println(prg.toString());
            repo.logPrgStateExec();
        }
    }

}
