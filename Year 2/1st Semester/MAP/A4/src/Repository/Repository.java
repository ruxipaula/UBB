package Repository;

import Exceptions.MyException;
import Model.ADT.*;
import Model.PrgState;
import Model.Stmt.IStmt;
import Model.Value.Value;

import java.io.*;

public class Repository implements IRepository{
    MyIList<PrgState> programs;
    int current;
    String logFilePath;

    public Repository(PrgState program, String filePath) {
        current = 0;
        programs = new MyList<PrgState>();
        logFilePath = filePath;
        programs.add(program);
    }

    public void add(PrgState p) {
        programs.add(p);
    }

    public PrgState getCrtPrg() {
        return programs.get(current);
    }

    public void logPrgStateExec() throws MyException {
        PrintWriter logFile;
        try {
            logFile = new PrintWriter(new BufferedWriter(new FileWriter(logFilePath, true)));
        }
        catch(IOException ex) {
            throw new MyException("File can't be opened or inexistent file.");
        }

        MyIStack<IStmt> stk = getCrtPrg().getStk();
        MyIDictionary<String, Value> symTable = getCrtPrg().getSymTable();
        MyIList<Value> out = getCrtPrg().getOutList();
        MyIDictionary<String, BufferedReader> fileTable = getCrtPrg().getFileTable();
        MyIHeap<Integer, Value> heap = getCrtPrg().getHeap();

        logFile.print("Exe stack:\n");
        logFile.print(stk.toString());
        logFile.print("\n");
        logFile.print("Sym Table:\n");
        logFile.print(symTable.toString());
        logFile.print("\n");
        logFile.print("Out:\n");
        logFile.print(out.toString());
        logFile.print("\n");
        logFile.print("\n");
        logFile.print("FileTable:\n");
        logFile.print(fileTable.toString());
        logFile.print("\n");
        logFile.print("\n");
        logFile.print("Heap:\n");
        logFile.print(heap.toString());
        logFile.print("\n");
        logFile.print("\n");


        logFile.close();
    }
}
