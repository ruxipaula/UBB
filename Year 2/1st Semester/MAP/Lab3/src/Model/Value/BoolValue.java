package Model.Value;

import Model.Type.BoolType;
import Model.Type.Type;

public class BoolValue implements Value {
    private boolean val;

    public BoolValue() { val = false;}
    public BoolValue(boolean v) { val = v;}

    public boolean getValue() { return val;}

    public String toString() {
        return String.valueOf(val);
    }

    public Type getType() {
        return new BoolType();
    }


}