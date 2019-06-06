package drf.dev.interview.bcs.domain;

public class Result {
    private final double value;
    private final Allocation[] allocations;

    public Result(double value, Allocation[] allocations) {
        this.value = value;
        this.allocations = allocations;
    }

    public double getValue() {
        return value;
    }

    public Allocation[] getAllocations() {
        return allocations;
    }
}
