package Model.Value;

import Model.Type.IntType;
import Model.Type.Type;

public class IntValue implements Value {
    private int val;

    public IntValue() { val = 0;}
    public IntValue(int v){val = v;}

    public int getVal() {return val;}
    public String toString() { return String.valueOf(val); }
    public Type getType() { return new IntType();}

}
