package Model.ADT;

import Model.ADT.MyIList;

import java.util.List;
import java.util.ArrayList;

public class MyList<T> implements MyIList<T> {
    private List<T> list;

    public MyList() {
        list = new ArrayList<T>();
    }

    @Override
    public void add(T element) {
        list.add(element);
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public T get(int i) {
        return list.get(i);
    }

    public String toString() {
        return list.toString();
    }

}
