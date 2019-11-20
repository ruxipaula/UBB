package View;

import Controller.Controller;
import Model.ADT.*;
import Model.Exp.ArithExp;
import Model.Exp.ValueExp;
import Model.Exp.VarExp;
import Model.PrgState;
import Model.Stmt.*;
import Model.Type.BoolType;
import Model.Type.IntType;
import Model.Type.StringType;
import Model.Value.BoolValue;
import Model.Value.IntValue;
import Model.Value.StringValue;
import Model.Value.Value;
import Repository.IRepository;
import Repository.Repository;

import java.io.BufferedReader;

public class Interpreter {

    private static Controller newController(IStmt e) {
        String filePath = "B:\\LabMAP\\A3\\repoLog.txt";
        MyIStack<IStmt> exeStack = new MyStack<IStmt>();
        MyIDictionary<String, Value> symbTable= new MyDictionary<String, Value>();
        MyIList<Value> outList = new MyList<Value>();
        MyIDictionary<String, BufferedReader> fileTable = new MyDictionary<String, BufferedReader>();
        PrgState progr = new PrgState(exeStack, symbTable, outList, fileTable, e);
        IRepository repo = new Repository(progr, filePath);
        Controller ctr = new Controller(repo);
        return ctr;
    }

    public static void main(String[] args) {
        //  int v; v=2; Print(v)
        IStmt ex1= new CompStmt(new VarDeclStmt("v",new IntType()),
                        new CompStmt(new AssignStmt("v",new ValueExp(new IntValue(2))),
                        new PrintStmt(new VarExp("v"))));

        // int a; int b; a=2+3*5 ; b=a+1 ; Print(b)
        IStmt ex2 = new CompStmt( new VarDeclStmt("a",new IntType()),
                    new CompStmt(new VarDeclStmt("b",new IntType()),
                    new CompStmt(new AssignStmt("a", new ArithExp('+',new ValueExp(new IntValue(2)),
                    new ArithExp('*',new ValueExp(new IntValue(3)), new ValueExp(new IntValue(5))))),
                    new CompStmt(new AssignStmt("b",new ArithExp('+',new VarExp("a"),
                    new ValueExp(new IntValue(1)))), new PrintStmt(new VarExp("b"))))));

        // bool a; int v; a=true; (If a Then v=2 Else v=3); Print(v)
        IStmt ex3 = new CompStmt(new VarDeclStmt("a",new BoolType()),
                    new CompStmt(new VarDeclStmt("v", new IntType()),
                    new CompStmt(new AssignStmt("a", new ValueExp(new BoolValue(true))),
                    new CompStmt(new IfStmt(new VarExp("a"),new AssignStmt("v",new ValueExp(new IntValue(2))),
                    new AssignStmt("v", new ValueExp(new IntValue(3)))), new PrintStmt(new VarExp("v"))))));

        IStmt ex4 = new CompStmt(new VarDeclStmt("varf", new StringType()),
                    new CompStmt(new AssignStmt("varf", new ValueExp(new StringValue("test.txt"))),
                    new CompStmt(new OpenRFile(new VarExp("varf")), new CompStmt(new VarDeclStmt("varc", new IntType()),
                    new CompStmt(new ReadFileStmt(new VarExp("varf"),"varc"),
                    new CompStmt(new PrintStmt(new VarExp("varc")), new CompStmt(new ReadFileStmt(new VarExp("varf"), "varc"),
                    new CompStmt(new PrintStmt(new VarExp("varc")), new CloseRFileStmt(new VarExp("varf"))))))))));

        Controller ctr1 = newController(ex1);
        Controller ctr2 = newController(ex2);
        Controller ctr3 = newController(ex3);
        Controller ctr4 = newController(ex4);

        TextMenu menu = new TextMenu();
        menu.addCommand(new ExitCommand("0", "exit"));
        menu.addCommand(new RunExample("1",ex1.toString(),ctr1));
        menu.addCommand(new RunExample("2",ex2.toString(),ctr2));
        menu.addCommand(new RunExample("3",ex3.toString(),ctr3));
        menu.addCommand(new RunExample("4",ex3.toString(),ctr4));
        menu.show();

    }
}
