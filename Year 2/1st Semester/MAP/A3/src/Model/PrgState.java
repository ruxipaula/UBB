package Model;

import Model.ADT.MyIDictionary;
import Model.ADT.MyIList;
import Model.ADT.MyIStack;
import Model.Stmt.IStmt;
import Model.Value.StringValue;
import Model.Value.Value;

import java.io.BufferedReader;

public class PrgState {
    private MyIStack<IStmt> exeStack;
    private MyIDictionary<String, Value> symTable;
    private MyIList<Value> out;
    private MyIDictionary<String, BufferedReader> fileTable;
    //IStmt originalProgram; //optional field, but good to have

    public MyIStack<IStmt> getStk() { return exeStack;}
    public void setMyIStack(MyIStack<IStmt> s) { exeStack = s;}

    public MyIDictionary<String, Value> getSymTable() { return symTable;}
    public void setMyIDictionary(MyIDictionary<String, Value> d) { symTable = d;}

    public MyIList<Value> getOutList() { return out;}
    public void setMyIList(MyIList<Value> l) { out = l;}

    public MyIDictionary<String, BufferedReader> getFileTable() {return fileTable;}

    public PrgState(MyIStack<IStmt> stk, MyIDictionary<String,Value> symtbl, MyIList<Value> ot, MyIDictionary<String, BufferedReader> fTable, IStmt prg){
        exeStack=stk;
        symTable=symtbl;
        out = ot;
        fileTable = fTable;
        //originalProgram = deepCopy(prg);//recreate the entire original prg
        exeStack.push(prg);
    }

    public String toString() {
        String s = "";
        s+="Exe Stack:\n";
        s+=exeStack.toString() + "\n";
        s+="Symb Table:\n";
        s+=symTable.toString() + "\n";
        s+="Out:\n";
        s+=out.toString() + "\n";
        return s;
    }

}
