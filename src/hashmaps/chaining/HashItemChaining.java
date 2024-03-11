package hashmaps.chaining;

import hashmaps.HashItemBase;

public class HashItemChaining<K, V> extends HashItemBase<K, V>
{
    private HashItemChaining<K, V> next;

    public HashItemChaining(K key, V value)
    {
        super(key, value);
        next = null;
    }
    public HashItemChaining<K, V> getNext() { return next; }
    public void setNext(HashItemChaining<K, V> next) { this.next = next; }
}
