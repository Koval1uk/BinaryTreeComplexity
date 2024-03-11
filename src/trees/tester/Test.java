package trees.tester;

public class Test {
    public String name;

    public long startTime;
    public long endTime;

    public long memoryBefore;
    public long memoryAfter;

    public Test(String name) {
        this.name = name;
        this.startTime = 0;
        this.endTime = 0;
        this.memoryBefore = 0;
        this.memoryAfter = 0;
    }

    public String toString() {
        return String.format(
            "%s: %d ms, %d kb", 
            this.name, 
            (this.endTime - this.startTime) / 1000000, 
            (this.memoryAfter - this.memoryBefore)
        );
    }
}
