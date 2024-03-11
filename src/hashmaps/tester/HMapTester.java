package hashmaps.tester;

import hashmaps.chaining.HashMapChaining;
import hashmaps.closedhash.HashTableClosedHashing;
import interfaces.IHashMapBase;

import java.lang.Math;

// HashMapChaining
// HashTableClosedHashing


public class HMapTester {
    final int HASH_MAP_SIZE = 1_024;
    final int DEFAULT_VALUE = 1;

    public HMapTester() {}

    private Integer randomInt(int min, int max) {
        return (int) (Math.random() * (max - min + 1) + min);
    }

    private HashMapChaining<Integer, Integer> newHashMapChaining() {
        return new HashMapChaining<Integer, Integer>(HASH_MAP_SIZE);
    }

    private HashTableClosedHashing<Integer, Integer> newHashTableClosedHashing() {
        return new HashTableClosedHashing<Integer, Integer>(HASH_MAP_SIZE);
    }

    private void fillTreeRandom(IHashMapBase<Integer, Integer> hmap, int count) {
        for (int i = 0; i < count; i++) 
        {
            hmap.put(randomInt(0, 10000000), DEFAULT_VALUE);
        }
    }


    public HMapTestSet testHashMapChaining(
        int testsCount,
        int elementsCount
    )
    {
        Runtime runtime = Runtime.getRuntime();
        HMapTestSet testSet = new HMapTestSet();

        System.gc();
        HashMapChaining<Integer, Integer> hmap;
        Test test;

        // Put
        for (int i = 0; i < testsCount; i++) 
        {
            System.gc();
            test = new Test("HashMapChaining Put " + i);
            test.startTime = System.nanoTime();
            test.memoryBefore = 0;
            ///
            hmap = newHashMapChaining();
            fillTreeRandom(hmap, elementsCount);
            ///
            test.endTime = System.nanoTime();
            test.memoryAfter = (runtime.totalMemory() - runtime.freeMemory()-test.memoryBefore)/(1024);
            testSet.testsPut.add(test);
        }

        // Get
        for (int i = 0; i < testsCount; i++) 
        {
            System.gc();
            test = new Test("HashMapChaining Search " + i);
            test.startTime = System.nanoTime();
            test.memoryBefore = 0;
            ///
            hmap = newHashMapChaining();
            fillTreeRandom(hmap, elementsCount);
            hmap.get(randomInt(0, 10000000));
            ///
            test.endTime = System.nanoTime();
            test.memoryAfter = (runtime.totalMemory() - runtime.freeMemory()-test.memoryBefore)/(1024);
            testSet.testsGet.add(test);
        }
        
        // Remove
        for (int i = 0; i < testsCount; i++) 
        {
            System.gc();
            test = new Test("HashMapChaining Delete " + i);
            test.startTime = System.nanoTime();
            test.memoryBefore = 0;
            ///
            hmap = newHashMapChaining();
            fillTreeRandom(hmap, elementsCount);
            hmap.remove(randomInt(0, 10000000));
            ///
            test.endTime = System.nanoTime();
            test.memoryAfter = (runtime.totalMemory() - runtime.freeMemory()-test.memoryBefore)/(1024);
            testSet.testsRemove.add(test);
        }

        return testSet;
    }

    public HMapTestSet testHashTableClosedHashing(
        int testsCount,
        int elementsCount
    )
    {
        Runtime runtime = Runtime.getRuntime();
        HMapTestSet testSet = new HMapTestSet();

        System.gc();
        HashTableClosedHashing<Integer, Integer> hmap;
        Test test;

        // Put
        for (int i = 0; i < testsCount; i++) 
        {
            System.gc();
            test = new Test("HashTableClosedHashing Put " + i);
            test.startTime = System.nanoTime();
            test.memoryBefore = 0;
            ///
            hmap = newHashTableClosedHashing();
            fillTreeRandom(hmap, elementsCount);
            ///
            test.endTime = System.nanoTime();
            test.memoryAfter = (runtime.totalMemory() - runtime.freeMemory()-test.memoryBefore)/(1024);
            testSet.testsPut.add(test);
        }

        // Get
        for (int i = 0; i < testsCount; i++) 
        {
            System.gc();
            test = new Test("HashTableClosedHashing Search " + i);
            test.startTime = System.nanoTime();
            test.memoryBefore = 0;
            ///
            hmap = newHashTableClosedHashing();
            fillTreeRandom(hmap, elementsCount);
            hmap.get(randomInt(0, 10000000));
            ///
            test.endTime = System.nanoTime();
            test.memoryAfter = (runtime.totalMemory() - runtime.freeMemory()-test.memoryBefore)/(1024);
            testSet.testsGet.add(test);
        }
        
        // Remove
        for (int i = 0; i < testsCount; i++) 
        {
            System.gc();
            test = new Test("HashTableClosedHashing Delete " + i);
            test.startTime = System.nanoTime();
            test.memoryBefore = 0;
            ///
            hmap = newHashTableClosedHashing();
            fillTreeRandom(hmap, elementsCount);
            hmap.remove(randomInt(0, 10000000));
            ///
            test.endTime = System.nanoTime();
            test.memoryAfter = (runtime.totalMemory() - runtime.freeMemory()-test.memoryBefore)/(1024);
            testSet.testsRemove.add(test);
        }

        return testSet;
    }

}
