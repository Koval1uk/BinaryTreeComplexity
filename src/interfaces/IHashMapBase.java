package interfaces;

public interface IHashMapBase<K, V>
{
    V get(K key);
    void remove(K key);
    void put(K key, V value);

    int hash(K key);

    void printTable();
}
