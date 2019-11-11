package Repository;

import Model.ADT.MyIList;
import Model.ADT.MyList;
import Model.PrgState;

public class Repository implements IRepository{
    MyIList<PrgState> programs;
    int current;

    public Repository(PrgState program) {
        current = 0;
        programs = new MyList<PrgState>();
        programs.add(program);
    }

    public void add(PrgState p) {
        programs.add(p);
    }

    public PrgState getCrtPrg() {
        return programs.get(current);
    }
}
