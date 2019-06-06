package drf.dev.interview.bcs.domain;

public class Stock {
    private final String symbol;
    private final long volume;

//    private Quote quote;

//    private double assetValue;
//    private String sector;

    public Stock(String symbol, long volume) {
        this.symbol = symbol;
        this.volume = volume;
    }

    public String getSymbol() {
        return symbol;
    }

    public long getVolume() {
        return volume;
    }

    /*public double getAssetValue() {
        return assetValue;
    }

    public void setAssetValue(double assetValue) {
        this.assetValue = assetValue;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public Quote getQuote() {
        return quote;
    }

    public void setQuote(Quote quote) {
        this.quote = quote;
    }*/
}
