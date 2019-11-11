package Model.ADT;

import Exceptions.MyException;
import Model.ADT.MyIDictionary;

import java.util.HashMap;
import java.util.Iterator;

public class MyDictionary<K, V> implements MyIDictionary<K, V> {
    private HashMap<K, V> dict;

    public MyDictionary() {
        dict = new HashMap<K, V>();
    }

    @Override
    public boolean isDefined(K key) {
        return dict.containsKey(key);
    }

    @Override
    public V lookup(K key) throws MyException {
        V value = dict.get(key);
        if (value == null)
            throw new MyException("Variable is not defined!");
        else
            return value;
    }

    @Override
    public void update(K key, V value) {
        dict.replace(key, value);
    }

    @Override
    public void put(K key, V value) {
        dict.put(key, value);
    }

    public String toString() {
        String s = "";
        Iterator it = dict.keySet().iterator();
        while(it.hasNext()) {
            K key = (K)it.next();
            s += key.toString() + ":";
            V value = dict.get(key);
            s += value.toString() + "\n";
        }
        return s;
    }

    @Override
    public boolean isEmpty() {
        return dict.isEmpty();
    }
}
