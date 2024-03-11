

import trees.tester.TreeTester;
import trees.tester.TreeTestSet;


import hashmaps.tester.HMapTester;
import hashmaps.tester.HMapTestSet;

public class Main
{
    public static void main(String[] args)
    {
        for (int i = 1; i < 10; i++) {
            TreeTester tester = new TreeTester();
            TreeTestSet avlTree = tester.testAVLTree(10, 10_000*i);
            TreeTestSet splayTree = tester.testSplayTree(10, 10_000*i);
            
            System.out.println(">     ElementsCount: " + 10_000*i);
            System.out.println("|" + "-------------------------------");
            System.out.println("|" + "AVL");
            System.out.println("|" + "-------------------------------");
            System.out.println("|" + avlTree.averageInsert("AVL"));
            System.out.println("|" + avlTree.averageSearch("AVL"));
            System.out.println("|" + avlTree.averageDelete("AVL"));
            System.out.println("|" + "-------------------------------");
            System.out.println("|" + "SPLAY");
            System.out.println("|" + "-------------------------------");
            System.out.println("|" + splayTree.averageInsert("Splay"));
            System.out.println("|" + splayTree.averageSearch("Splay"));
            System.out.println("|" + splayTree.averageDelete("Splay"));
            System.out.println("|" + "-------------------------------");
        }

        for (int i = 1; i < 10; i++)
        {
            HMapTester tester = new HMapTester();
            HMapTestSet hashMapChaining = tester.testHashMapChaining(50, 10*i);
            HMapTestSet hashTableClosedHashing = tester.testHashTableClosedHashing(50, 10*i);
            
            System.out.println(">     ElementsCount: " + 10*i);
            System.out.println("|" + "-------------------------------");
            System.out.println("|" + "HashMapChaining");
            System.out.println("|" + "-------------------------------");
            System.out.println("|" + hashMapChaining.averageGet("HashMapChaining"));
            System.out.println("|" + hashMapChaining.averagePut("HashMapChaining"));
            System.out.println("|" + hashMapChaining.averageRemove("HashMapChaining"));
            System.out.println("|" + "-------------------------------");
            System.out.println("|" + "HashTableClosedHashing");
            System.out.println("|" + "-------------------------------");
            System.out.println("|" + hashTableClosedHashing.averageGet("HashTableClosedHashing"));
            System.out.println("|" + hashTableClosedHashing.averagePut("HashTableClosedHashing"));
            System.out.println("|" + hashTableClosedHashing.averageRemove("HashTableClosedHashing"));
            System.out.println("|" + "-------------------------------");
        }
    }
}
