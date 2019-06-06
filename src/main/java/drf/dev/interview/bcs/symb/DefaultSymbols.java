package drf.dev.interview.bcs.symb;

public enum DefaultSymbols {
    AAPL("AAPL", 50),
    HOG("HOG", 10),
    MDSO("MDSO", 1),
    IDRA("IDRA", 1),
    MRSN("MRSN", 1);

    private final String defaultSymbol;
    private final long defaultVolume;

    private DefaultSymbols(String defaultSymbol, long defaultVolume) {
        this.defaultSymbol = defaultSymbol;
        this.defaultVolume = defaultVolume;
    }

    public String getDefaultSymbol() {
        return defaultSymbol;
    }

    public long getDefaultVolume() {
        return defaultVolume;
    }
}
