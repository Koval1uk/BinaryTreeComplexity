package trees.tester;

import java.util.ArrayList;

public class TreeTestSet {
    public ArrayList<Test> testsInsert;
    public ArrayList<Test> testsSearch;
    public ArrayList<Test> testsDelete;

    public TreeTestSet() {
        this.testsInsert = new ArrayList<Test>();
        this.testsSearch = new ArrayList<Test>();
        this.testsDelete = new ArrayList<Test>();
    }

    public Test averageInsert(String name) {
        Test test = new Test(name + ": Average Insert of " + this.testsInsert.size() + " elements");
        for (Test t : this.testsInsert) {
            test.memoryAfter += t.memoryAfter;
            test.memoryBefore += t.memoryBefore;
            test.endTime += t.endTime;
            test.startTime += t.startTime;
        }
        test.memoryAfter /= this.testsInsert.size();
        test.memoryBefore /= this.testsInsert.size();
        test.endTime /= this.testsInsert.size();
        test.startTime /= this.testsInsert.size();
        return test;
    }

    public Test averageSearch(String name) {
        Test test = new Test(name + ": Average Search of " + this.testsSearch.size() + " elements");
        for (Test t : this.testsSearch) {
            test.memoryAfter += t.memoryAfter;
            test.memoryBefore += t.memoryBefore;
            test.endTime += t.endTime;
            test.startTime += t.startTime;
        }
        test.memoryAfter /= this.testsSearch.size();
        test.memoryBefore /= this.testsSearch.size();
        test.endTime /= this.testsSearch.size();
        test.startTime /= this.testsSearch.size();
        return test;
    }

    public Test averageDelete(String name) {
        Test test = new Test(name + ": Average Delete of " + this.testsDelete.size() + " elements");
        for (Test t : this.testsDelete) {
            test.memoryAfter += t.memoryAfter;
            test.memoryBefore += t.memoryBefore;
            test.endTime += t.endTime;
            test.startTime += t.startTime;
        }
        test.memoryAfter /= this.testsDelete.size();
        test.memoryBefore /= this.testsDelete.size();
        test.endTime /= this.testsDelete.size();
        test.startTime /= this.testsDelete.size();
        return test;
    }
}
