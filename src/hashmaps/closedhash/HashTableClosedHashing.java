package hashmaps.closedhash;

import hashmaps.chaining.HashItemChaining;
import interfaces.IHashMapBase;

public class HashTableClosedHashing<K, V> implements IHashMapBase<K, V>
{

    private int size;
    private int count;
    private HashItemClosedHashing<K, V>[] table;

    public HashTableClosedHashing(int size)
    {
        this.count = 0;
        this.size = size;
        this.table = new HashItemClosedHashing[size];
    }

    @Override
    public V get(K key)
    {
        int index = hash(key);
        HashItemClosedHashing<K, V> item = table[index];

        if(item == null)
            return null;

        if(item.getKey().equals(key))
            return item.getValue();

        for(int i = index; i < table.length; i++)
        {
            if(table[i] == null)
                continue;

            if(table[i].getKey().equals(key))
                return table[i].getValue();
        }

        for(int i = 0; i < index; i++)
        {
            if(table[i] == null)
                continue;

            if(table[i].getKey().equals(key))
                return table[i].getValue();
        }

        return null;
    }

    @Override
    public void remove(K key)
    {
        int index = hash(key);
        HashItemClosedHashing<K, V> item = table[index];

        if(item == null)
            return;

        if(item.getKey().equals(key))
        {
            table[index] = null;
            count--;
            return;
        }

        for(int i = index; i < table.length; i++)
        {
            if(table[i] == null)
                continue;

            if(table[i].getKey().equals(key))
            {
                table[i] = null;
                count--;
                return;
            }
        }

        for(int i = 0; i < index; i++)
        {
            if(table[i] == null)
                continue;

            if(table[i].getKey().equals(key))
            {
                table[i] = null;
                count--;
                return;
            }
        }
    }

    @Override
    public void put(K key, V value)
    {
        if(count == (size/2))
        {
            size *= 2;
            HashItemClosedHashing<K, V>[] newHashTable = new HashItemClosedHashing[size];

            for(HashItemClosedHashing<K, V> item : table)
            {
                if(item == null)
                    continue;

                int index = hash(item.getKey());
                HashItemClosedHashing<K, V> newItem = item;

                if (newHashTable[index] == null)
                    newHashTable[index] = new HashItemClosedHashing<>(item.getKey(), item.getValue());
                else
                {
                    boolean flag = false;
                    for(int i = index; i < newHashTable.length; i++)
                    {
                        if(newHashTable[i] == null)
                        {
                            flag = true;
                            newHashTable[i] = new HashItemClosedHashing<>(item.getKey(), item.getValue());
                            break;
                        }
                    }
                    if(!flag)
                    {
                        for(int i = 0; i < index; i++)
                        {
                            if(newHashTable[i] == null)
                            {
                                newHashTable[i] = new HashItemClosedHashing<>(item.getKey(), item.getValue());
                                break;
                            }
                        }
                    }
                }
            }
            table = newHashTable;
        }

        int index = hash(key);

        if(table[index] == null)
            table[index] = new HashItemClosedHashing<>(key, value);
        else
        {
            boolean flag = false;
            for(int i = index; i < table.length; i++)
            {
                if(table[i] == null)
                {
                    flag = true;
                    table[i] = new HashItemClosedHashing<>(key, value);
                    break;
                }
            }
            if(!flag)
            {
                for(int i = 0; i < index; i++)
                {
                    if(table[i] == null)
                    {
                        table[i] = new HashItemClosedHashing<>(key, value);
                        break;
                    }
                }
            }
        }
        count++;
    }
    @Override
    public void printTable()
    {
        for (int i = 0; i < size; i++)
        {
            System.out.print("Index " + i + ": ");
            HashItemClosedHashing<K, V> item = table[i];
            if(item != null)
                System.out.print(item.getKey() + " ");
            System.out.println();
        }
    }

    @Override
    public int hash(K key) { return key.hashCode() % size; }
}
