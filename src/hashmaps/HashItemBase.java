package hashmaps;

public abstract class HashItemBase<K, V>
{
    protected final K key;
    protected V value;

    public HashItemBase(K key, V value)
    {
        this.key = key;
        this.value = value;
    }

    public K getKey() { return key; }
    public V getValue() { return value; }

    public void setValue(V value) { this.value = value; }
}
