package Controller;

import Exceptions.MyException;
import Model.ADT.MyIStack;
import Model.PrgState;
import Model.Stmt.IStmt;
import Model.Value.RefValue;
import Model.Value.Value;
import Repository.IRepository;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Controller {
    private IRepository repo;

    public Controller(IRepository r) {
        repo = r;
    }

    Map<Integer, Value> unsafeGarbageCollector(List<Integer> symTableAddr, Map<Integer, Value> heap) {
        return heap.entrySet().stream()
                .filter(e->symTableAddr.contains(e.getKey()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    List<Integer> getAddrFromSymTable(Collection<Value> symTableValues, Collection<Value> heapValues) {
        return Stream.concat(
                heapValues.stream()
                    .filter(v->v instanceof RefValue)
                    .map(v-> {RefValue v1 = (RefValue)v; return v1.getAddress();}),
                symTableValues.stream()
                    .filter(v->v instanceof RefValue)
                    .map(v-> {RefValue v1 = (RefValue)v; return v1.getAddress();})
        ).collect(Collectors.toList());
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
        try {
            while (!prg.getStk().isEmpty()) {
                oneStep(prg);
                System.out.println(prg.toString());
                repo.logPrgStateExec();
                prg.getHeap().setContent(unsafeGarbageCollector(getAddrFromSymTable(prg.getSymTable().getContent().values(), prg.getHeap().getContent().values()), prg.getHeap().getContent()));
                repo.logPrgStateExec();
            }
        } catch(MyException e) {
            System.out.println(e.getMessage());
        }

    }

}
