package Model.Type;

import Model.Type.Type;

public class BoolType implements Type {
    public boolean equals(Object another) {
        if (another instanceof BoolType)
            return true;
        else
            return false;
    }

    public String toString() {
        return "boolean ";
    }
}
