package hashmaps.tester;

import java.util.ArrayList;

public class HMapTestSet {
    public ArrayList<Test> testsPut;
    public ArrayList<Test> testsGet;
    public ArrayList<Test> testsRemove;

    public HMapTestSet() {
        this.testsPut = new ArrayList<Test>();
        this.testsGet = new ArrayList<Test>();
        this.testsRemove = new ArrayList<Test>();
    }

    public Test averagePut(String name) {
        Test test = new Test(name + ": Average Put of " + this.testsPut.size() + " elements");
        for (Test t : this.testsPut) {
            test.memoryAfter += t.memoryAfter;
            test.memoryBefore += t.memoryBefore;
            test.endTime += t.endTime;
            test.startTime += t.startTime;
        }
        test.memoryAfter /= this.testsPut.size();
        test.memoryBefore /= this.testsPut.size();
        test.endTime /= this.testsPut.size();
        test.startTime /= this.testsPut.size();
        return test;
    }

    public Test averageGet(String name) {
        Test test = new Test(name + ": Average Get of " + this.testsGet.size() + " elements");
        for (Test t : this.testsGet) {
            test.memoryAfter += t.memoryAfter;
            test.memoryBefore += t.memoryBefore;
            test.endTime += t.endTime;
            test.startTime += t.startTime;
        }
        test.memoryAfter /= this.testsGet.size();
        test.memoryBefore /= this.testsGet.size();
        test.endTime /= this.testsGet.size();
        test.startTime /= this.testsGet.size();
        return test;
    }

    public Test averageRemove(String name) {
        Test test = new Test(name + ": Average Remove of " + this.testsRemove.size() + " elements");
        for (Test t : this.testsRemove) {
            test.memoryAfter += t.memoryAfter;
            test.memoryBefore += t.memoryBefore;
            test.endTime += t.endTime;
            test.startTime += t.startTime;
        }
        test.memoryAfter /= this.testsRemove.size();
        test.memoryBefore /= this.testsRemove.size();
        test.endTime /= this.testsRemove.size();
        test.startTime /= this.testsRemove.size();
        return test;
    }
}
