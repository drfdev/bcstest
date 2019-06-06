package drf.dev.interview.bcs.domain;

public class Allocation {
    private final String sector;
    private final double assetValue;
    private final double proportion;

    public Allocation(String sector, double assetValue, double proportion) {
        this.sector = sector;
        this.assetValue = assetValue;
        this.proportion = proportion;
    }

    public String getSector() {
        return sector;
    }

    public double getAssetValue() {
        return assetValue;
    }

    public double getProportion() {
        return proportion;
    }
}
