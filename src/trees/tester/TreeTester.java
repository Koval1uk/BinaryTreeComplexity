package trees.tester;

import trees.avl.AVLTree;

import trees.splay.SplayTree;

import java.lang.Math;

public class TreeTester {

    public TreeTester() {}

    private Integer randomInt(int min, int max) {
        return (int) (Math.random() * (max - min + 1) + min);
    }

    private AVLTree<Integer> newTreeAvl() {
        return new AVLTree<Integer>();
    }

    private SplayTree<Integer> newTreeSplay() {
        return new SplayTree<Integer>();
    }

    private void fillTreeRandom(SplayTree<Integer> tree, int count) {
        for (int i = 0; i < count; i++) 
        {
            tree.insert(tree.getRoot(), randomInt(0, 10000000), 1);
        }
    }

    private void fillTreeRandom(AVLTree<Integer> tree, int count) {
        for (int i = 0; i < count; i++) 
        {
            tree.insert(tree.getRoot(), randomInt(0, 10000000), 1);
        }
    }


    public TreeTestSet testAVLTree(
        int testsCount,
        int elementsCount
    )
    {
        Runtime runtime = Runtime.getRuntime();
        TreeTestSet testSet = new TreeTestSet();

        System.gc();
        AVLTree<Integer> tree;
        Test test;

        // Insert
        for (int i = 0; i < testsCount; i++) 
        {
            System.gc();
            test = new Test("AVLTree Fill " + i);
            test.startTime = System.nanoTime();
            test.memoryBefore = 0;
            ///
            tree = newTreeAvl();
            fillTreeRandom(tree, elementsCount);
            ///
            test.endTime = System.nanoTime();
            test.memoryAfter = (runtime.totalMemory() - runtime.freeMemory()-test.memoryBefore)/(1024);
            testSet.testsInsert.add(test);
        }

        // Search
        for (int i = 0; i < testsCount; i++) 
        {
            System.gc();
            test = new Test("AVLTree Search " + i);
            test.startTime = System.nanoTime();
            test.memoryBefore = 0;
            ///
            tree = newTreeAvl();
            fillTreeRandom(tree, elementsCount);
            tree.search(tree.getRoot(), randomInt(0, 10000000));
            ///
            test.endTime = System.nanoTime();
            test.memoryAfter = (runtime.totalMemory() - runtime.freeMemory()-test.memoryBefore)/(1024);
            testSet.testsSearch.add(test);
        }
        
        // Delete
        for (int i = 0; i < testsCount; i++) 
        {
            System.gc();
            test = new Test("AVLTree Delete " + i);
            test.startTime = System.nanoTime();
            test.memoryBefore = 0;
            ///
            tree = newTreeAvl();
            fillTreeRandom(tree, elementsCount);
            tree.delete(tree.getRoot(), randomInt(0, 10000000));
            ///
            test.endTime = System.nanoTime();
            test.memoryAfter = (runtime.totalMemory() - runtime.freeMemory()-test.memoryBefore)/(1024);
            testSet.testsDelete.add(test);
        }

        return testSet;
    }

    public TreeTestSet testSplayTree(
        int testsCount,
        int elementsCount
    )
    {
        Runtime runtime = Runtime.getRuntime();

        TreeTestSet testSet = new TreeTestSet();
        System.gc();
        SplayTree<Integer> tree;
        Test test;

        // Insert
        for (int i = 0; i < testsCount; i++) 
        {
            System.gc();
            test = new Test("SPLAYTree Fill " + i);
            test.startTime = System.nanoTime();
            test.memoryBefore = 0;
            ///
            tree = newTreeSplay();
            fillTreeRandom(tree, elementsCount);
            ///
            test.endTime = System.nanoTime();
            test.memoryAfter = (runtime.totalMemory() - runtime.freeMemory()-test.memoryBefore)/(1024);
            testSet.testsInsert.add(test);
        }

        // Search
        for (int i = 0; i < testsCount; i++) 
        {
            System.gc();
            test = new Test("SPLAYTree Search " + i);
            test.startTime = System.nanoTime();
            test.memoryBefore = 0;
            ///
            tree = newTreeSplay();
            fillTreeRandom(tree, elementsCount);
            tree.search(tree.getRoot(), randomInt(0, 10000000));
            ///
            test.endTime = System.nanoTime();
            test.memoryAfter = (runtime.totalMemory() - runtime.freeMemory()-test.memoryBefore)/(1024);
            testSet.testsSearch.add(test);
        }
        
        // Delete
        for (int i = 0; i < testsCount; i++) 
        {
            System.gc();
            test = new Test("SPLAYTree Delete " + i);
            test.startTime = System.nanoTime();
            test.memoryBefore = 0;
            ///
            tree = newTreeSplay();
            fillTreeRandom(tree, elementsCount);
            tree.delete(tree.getRoot(), randomInt(0, 10000000));
            ///
            test.endTime = System.nanoTime();
            test.memoryAfter = (runtime.totalMemory() - runtime.freeMemory()-test.memoryBefore)/(1024);
            testSet.testsDelete.add(test);
        }

        return testSet;
    }

}
