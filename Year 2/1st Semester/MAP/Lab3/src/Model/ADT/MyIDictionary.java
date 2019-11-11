package Model.ADT;

import Exceptions.MyException;

public interface MyIDictionary<K, V> {
    public boolean isDefined(K key);
    public V lookup (K key) throws MyException;
    public void update(K key, V value);
    public void put(K key, V value);
    public boolean isEmpty();
}
