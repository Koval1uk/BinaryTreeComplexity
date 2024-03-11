package hashmaps.chaining;

import interfaces.IHashMapBase;

public class HashMapChaining<K, V> implements IHashMapBase<K, V>
{
    private int size;
    private int count;
    private HashItemChaining<K, V>[] hashTable;

    public HashMapChaining(int size)
    {
        this.count = 0;
        this.size = size;
        hashTable = new HashItemChaining[size];
    }

    private void collision(K key, V value, int index)
    {
        HashItemChaining<K, V> item = hashTable[index];

        while (item.getNext() != null)
        {
            if (item.getKey().equals(key))
            {
                item.setValue(value);
                return;
            }
            item = item.getNext();
        }
        if (item.getKey().equals(key))
        {
            item.setValue(value);
            return;
        }
        item.setNext(new HashItemChaining<>(key, value));
        count++;
    }

    @Override
    public void put(K key, V value)
    {
       if(count == (int)(size * 0.5))
       {
           size *= 2;
           HashItemChaining<K, V>[] newHashTable = new HashItemChaining[size];

           for (HashItemChaining<K, V> kvHashItemChaining : hashTable)
           {
               HashItemChaining<K, V> item = kvHashItemChaining;
               while (item != null)
               {
                   int index = hash(item.getKey());

                   if (newHashTable[index] == null)
                       newHashTable[index] = new HashItemChaining<>(item.getKey(), item.getValue());

                   else
                   {
                       HashItemChaining<K, V> newItem = newHashTable[index];

                       while (newItem.getNext() != null)
                           newItem = newItem.getNext();

                       newItem.setNext(new HashItemChaining<>(item.getKey(), item.getValue()));
                   }
                   item = item.getNext();
               }
           }
           hashTable = newHashTable;
       }

       int index = hash(key);
       if (hashTable[index] == null)
       {
           hashTable[index] = new HashItemChaining<>(key, value);
           count++;
           return;
       }
       collision(key, value, index);
    }

    @Override
    public V get(K key)
    {
        int index = hash(key);
        HashItemChaining<K, V> item = hashTable[index];

        while (item != null)
        {
            if (item.getKey().equals(key))
                return item.getValue();

            item = item.getNext();
        }
        return null;
    }

    @Override
    public void remove(K key)
    {
        int index = hash(key);
        HashItemChaining<K, V> prev = null;
        HashItemChaining<K, V> item = hashTable[index];

        while (item != null)
        {
            if (item.getKey().equals(key))
            {
                if (prev == null)
                {
                    hashTable[index] = item.getNext();
                    count--;
                    return;
                }
                prev.setNext(item.getNext());
                count--;
                return;
            }
            prev = item;
            item = item.getNext();
        }
    }

    @Override
    public void printTable()
    {
        for (int i = 0; i < size; i++)
        {
            System.out.print("Index " + i + ": ");
            HashItemChaining<K, V> item = hashTable[i];
            while (item != null)
            {
                System.out.print(item.getKey() + " ");
                item = item.getNext();
            }
            System.out.println();
        }
    }

    @Override
    public int hash(K key) { return key.hashCode() % size; }
}
