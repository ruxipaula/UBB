package Model.Exp;

import Exceptions.MyException;
import Model.ADT.MyIDictionary;
import Model.Value.Value;

public interface Exp {
    Value eval(MyIDictionary<String,Value> tbl) throws MyException;
}
